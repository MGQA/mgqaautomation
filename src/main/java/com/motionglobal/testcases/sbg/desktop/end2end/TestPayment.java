package com.motionglobal.testcases.sbg.desktop.end2end;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.GcPaymentPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.thankyou.ThankYouPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestPayment extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Gucci/Gucci-GG-3500/S-WNQ/02-108457.html" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Gucci/Gucci-GG-3500/S-WNQ/02-108457.html" },
                { "http://www.smartbuyglasses.dk/designer-sunglasses/Gucci/Gucci-GG-3500/S-WNQ/02-108457.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void payment(String url) {
        getURL(url);
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();
        //
        String cart = productDetailPage.getCartType();
        if (cart.equals("old")) {
            new CartPage().btnCheckout.click();
            CheckoutPage checkoutPage = new CheckoutPage();
            checkoutPage.inputBillingFirstName("automationFirst").inputBillingLastName("automationLast");
            checkoutPage.inputBillingEmail("testautomation@automation.com").inputBillingTelephone("automationTel");
            checkoutPage.selectBillingCountry("HK").inputBillingAddress1("automationAddress1");
            checkoutPage.clickVISA().btnGcPayment.click();
            Assert.assertTrue(new GcPaymentPage().inputORB.isDisplayed());
            // GC payment
            GcPaymentPage paymentPage = new GcPaymentPage();
            paymentPage.inputCard.sendKeys("4111111111111111");
            paymentPage.inputInsuanceCard.sendKeys("1234");
            paymentPage.selectDate();
            paymentPage.btnContinue.click();
            // thank you page
            ThankYouPage thankYouPage = new ThankYouPage();
            String sMoneyReward = thankYouPage.reWard.getText().replace("$", "");
            Double moneyReward = Double.parseDouble(sMoneyReward);
            System.out.println(moneyReward);
        }
        else {
            new NewCartPage().btnCheckout.click();
            NewCheckoutPage checkoutPage = new NewCheckoutPage();
            checkoutPage.inputBillingFirstName.sendKeys("automationFirst");
            checkoutPage.inputBillingLastName.sendKeys("automationLast");
            checkoutPage.inputBillingEmail.sendKeys("testautomation@automation.com");
            checkoutPage.inputBillingTelephone.sendKeys("automationTel");
            checkoutPage.inputBillingPostCode.sendKeys("2000000");
            checkoutPage.inputBillingAddress1.sendKeys("automationAddress1");
            checkoutPage.inputBillingCity.sendKeys("automationFirst");
            checkoutPage.state.sendKeys("automationState");
            checkoutPage.btnPayment.click();
            checkoutPage.payPicture.get(0).click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(checkoutPage.orderIFrame));
            checkoutPage.waitForVisibility(checkoutPage.orderSubmit, 20);
            checkoutPage.orderCard.sendKeys("4111111111111111");
            Select selectMM = new Select(checkoutPage.orderMM);
            selectMM.selectByValue("10");
            Select selectYY = new Select(checkoutPage.orderYY);
            selectYY.selectByValue("20");
            checkoutPage.orderSecurity.sendKeys("1111");
            checkoutPage.orderSubmit.click();
            ThankYouPage thankYouPage = new ThankYouPage();
            String sMoneyReward = thankYouPage.reWard.getText().replace("$", "");
            Double moneyReward = Double.parseDouble(sMoneyReward);
            System.out.println(moneyReward);
        }
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }

}