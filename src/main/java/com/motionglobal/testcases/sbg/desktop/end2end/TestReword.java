package com.motionglobal.testcases.sbg.desktop.end2end;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.GcPaymentPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
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
    @Test(groups = { "debug111", "smoke" })
    public void couponPageBackThenForward() {
        // FIXME login
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.loginlable, 5);
        header.mouseOver(header.loginlable);
        try {
            header.waitForVisibility(header.signin, 1);
        }
        catch (Exception e) {
            header.mouseOver(header.Help);
            header.waitForVisibility(header.getHelpLinkElement(1), 2);
            header.mouseOver(header.loginlable);
            header.waitForVisibility(header.signin, 1);
        }
        header.signin.click();
        header.username.clear();
        header.username.sendKeys("felix.ma@motionglobal.com");
        header.password.clear();
        header.password.sendKeys("motion888");
        header.signInButton.click();
        header.waitForVisibility(header.yourAccount, 10);
        header.mouseOver(header.yourAccount);
        header.waitForVisibility(header.signout, 5);
        Assert.assertTrue(header.isTextPresent("Hi test!"));

        // get Double of coupon price
        header.waitForVisibility(header.priceCoupon, 5);
        String StringcouponPrice = header.priceCoupon.getText().replace("$", "");
        Double couponTotal = Double.parseDouble(StringcouponPrice);

        // into 50% discount page then select product
        getURL("http://www.visiondirect.com.au/designer-sunglasses/on-sale/-----------------------50-/");
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.waitForVisibility(productGridPage.proInfo.get(0), 5);
        productGridPage.proInfo.get(0).click();

        // into product details page
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();

        // into cart page then get glass price and shipping price
        CartPage cartPage = new CartPage();
        cartPage.waitForVisibility(cartPage.priceGlassTotal, 5);
        String StringGlassPrice = cartPage.priceGlassTotal.getText().replace("$", "");
        Double priceGlass = Double.parseDouble(StringGlassPrice);
        Double priceShipping;
        try {
            String StringShippingPrice = cartPage.priceShipping.getText().replace("$", "");
            priceShipping = Double.parseDouble(StringShippingPrice);
        }
        catch (Exception e) {
            priceShipping = 0.0;
        }

        // sum discount and assert and select
        Double priceExpectCoupon = cartPage.couponPrice(couponTotal);
        String StringpriceActualCoupon = cartPage.priceCoupon.getText().replace("- $", "");
        Double PriceActualCoupon = Double.parseDouble(StringpriceActualCoupon);
        Assert.assertEquals(PriceActualCoupon, priceExpectCoupon);
        cartPage.JsMouse(cartPage.kit);
        cartPage.InputUseReWard.click();
        String sOldTotal = cartPage.priceTotal.getText().replace("$", "");
        Double dOldTotal = Double.parseDouble(sOldTotal);
        cartPage.waitPriceTotalChange(dOldTotal);

        // get Insuance price
        cartPage.selectInsurance1();
        Double priceInsuance;
        try {
            String StringInsurancePrice = cartPage.priceInsurance.getText().replace("$", "");
            priceInsuance = Double.parseDouble(StringInsurancePrice);
        }
        catch (Exception e) {
            priceInsuance = 0.0;
        }

        // total price
        cartPage.waitForVisibility(cartPage.priceTotal, 5);
        String StringTotal = cartPage.priceTotal.getText().replace("$", "");
        Double priceActualTotal = Double.parseDouble(StringTotal);

        // sum total(glass + shipping + insuance -coupon) and assert
        Double priceExpectTotal = priceGlass + priceShipping + priceInsuance - PriceActualCoupon;
        System.out.println(priceGlass + " _ " + priceShipping + " _ " + priceInsuance + " _ " + PriceActualCoupon);
        Assert.assertEquals(priceActualTotal, priceExpectTotal);

        // FIXME wait pay
        cartPage.waitForVisibility(cartPage.checkOut, 2);
        cartPage.checkOut.click();

        // into checkout page then input message
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.waitForVisibility(checkoutPage.priceTotal, 2);
        String sPriceCheckOut = checkoutPage.priceTotal.getText().replace("$", "");
        Double PriceCheckOut = Double.parseDouble(sPriceCheckOut);
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
