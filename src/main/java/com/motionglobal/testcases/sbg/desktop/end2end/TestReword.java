package com.motionglobal.testcases.sbg.desktop.end2end;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.GcPaymentPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.thankyou.ThankYouPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test : coupon pay(cash coupon ¡¢coupon and discount)
 * 
 */
public class TestReword extends AbstractBaseSbgDesktopTestCase {
    static String url = "http://www.visiondirect.com.au/";

    /**
     * Test : cash coupon ¡¢coupon and discount . back page then forward in pay page.
     */
    @Test(groups = { "debug", "smoke" })
    public void couponPageBackThenForward() {
        try {
            MysqlConnect219Util
                    .updateSQL("UPDATE om_pay_rewards_log SET member_id='775310',currency_code='AUD' WHERE currency_code='EUR' and is_active=1 and `status`=1 LIMIT 1;");
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
        getURL(AbstractBasePage.getLoginRequest(url));
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.yourAccount, 10);
        header.mouseOver(header.yourAccount);
        header.waitForVisibility(header.signout, 5);
        Assert.assertTrue(header.isTextPresent("Hi test!"));

        // get Double of coupon price TODO
        header.waitForVisibility(header.priceCoupon, 5);
        Double couponTotal = header.regexGetMath(header.priceCoupon.getText());
        System.out.println(couponTotal + " BO");

        // into product details page
        getURL("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4171-Erika-865/13-117665.html");
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();

        // into cart page then get glass price and shipping price
        CartPage cartPage = new CartPage();
        cartPage.waitForVisibility(cartPage.priceGlassTotal, 5);
        Double priceGlass = cartPage.regexGetMath(cartPage.priceGlassTotal.getText());
        Double priceShipping;
        try {
            priceShipping = cartPage.regexGetMath(cartPage.priceShipping.getText());
        }
        catch (Exception e) {
            priceShipping = 0.0;
        }

        // sum discount and assert and select
        Double priceExpectCoupon = cartPage.couponPrice(couponTotal);
        System.out.println(priceExpectCoupon);
        Double PriceActualCoupon = cartPage.regexGetMath(cartPage.priceCoupon.getText());
        Assert.assertEquals(PriceActualCoupon, priceExpectCoupon);
        cartPage.JsMouse(cartPage.kit);
        cartPage.InputUseReWard.click();

        // get Insuance price
        cartPage.selectInsurance1();
        Double priceInsuance;
        try {
            priceInsuance = cartPage.regexGetMath(cartPage.priceInsurance.getText());
        }
        catch (Exception e) {
            priceInsuance = 0.0;
        }

        // total price
        Double priceActualTotal = cartPage.regexGetMath(cartPage.priceTotal.getText());

        // sum total(glass + shipping + insuance -coupon) and assert
        // Double priceExpectTotal = priceGlass + priceShipping + priceInsuance - PriceActualCoupon;
        Double priceExpectTotal = CartPage.mathAdd(CartPage.mathAdd(priceGlass, priceShipping), CartPage.mathSub(priceInsuance, PriceActualCoupon));

        System.out.println(priceGlass + " _ " + priceShipping + " _ " + priceInsuance + " _ " + PriceActualCoupon);
        Assert.assertEquals(priceActualTotal, priceExpectTotal);

        // FIXME wait pay
        cartPage.waitForVisibility(cartPage.checkOut, 2);
        cartPage.checkOut.click();

        // into checkout page then input message
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.waitForVisibility(checkoutPage.priceTotal, 2);
        Double PriceCheckOut = checkoutPage.regexGetMath(checkoutPage.priceTotal.getText());
        Assert.assertEquals(PriceCheckOut, priceActualTotal);

        // select VISA click payBtn
        checkoutPage.clickVISA();
        checkoutPage.btnGcPayment.click();

        // pay
        GcPaymentPage paymentPage = new GcPaymentPage();
        paymentPage.inputCard.sendKeys("4111111111111111");
        paymentPage.inputInsuanceCard.sendKeys("1234");
        paymentPage.selectDate();
        paymentPage.btnContinue.click();

        // thank you page
        ThankYouPage thankYouPage = new ThankYouPage();
        String order = thankYouPage.order.getText();
        Assert.assertTrue(order.contains("VD"));
        String sMoneyReward = thankYouPage.reWard.getText().replace("$", "");
        Double moneyReward = Double.parseDouble(sMoneyReward);
        System.out.println(moneyReward);
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
