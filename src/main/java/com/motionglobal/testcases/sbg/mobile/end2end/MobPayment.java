package com.motionglobal.testcases.sbg.mobile.end2end;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.checkout.MobCheckOutPage;
import com.motionglobal.pages.sbg.mobile.checkout.MobThankYouPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobPayment extends AbstractBaseTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[] { "http://m.smartbuyglasses.co.uk/designer-eyeglasses/Dolce-Gabbana/Dolce-Gabbana-DG3205-Urban-Kids-1871-234919.html/" },
                { "http://m.smartbuyglasses.dk/designer-sunglasses/Tom-Ford/Tom-Ford-FT0008-JENNIFER-692-8152.html/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void payment(String url) throws InterruptedException {
        getURL(url);
        driver.manage().window().setSize(new Dimension(360, 640));
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.fastCheckOut, 5);
        try {
            cartPage.fastCheckOut.click();
        }
        catch (Exception e) {
            cartPage.JsClick(cartPage.fastCheckOut);
        }
        MobCheckOutPage checkOutPage = new MobCheckOutPage();
        checkOutPage.clearInput(checkOutPage.inputFistName, "automationFirst");
        checkOutPage.clearInput(checkOutPage.inputLastName, "automationLast");
        checkOutPage.clearInput(checkOutPage.inputEmail, "testautomation@automation.com");
        checkOutPage.clearInput(checkOutPage.inputAddress1, "automationAddress1");
        checkOutPage.clearInput(checkOutPage.inputPhone, "automationTel");
        checkOutPage.clearInput(checkOutPage.inputPostAddress, "200000");
        checkOutPage.clearInput(checkOutPage.inputCity, "shanghai");
        try {
            checkOutPage.selectStateGA();
        }
        catch (Exception e) {
            checkOutPage.inputState.sendKeys("jinganqu");
        }
        checkOutPage.continueBtn.click();
        checkOutPage.waitForVisibility(checkOutPage.VISA, 10);
        checkOutPage.VISA.click();
        Thread.sleep(2000);
        checkOutPage.waitForVisibility(By.cssSelector("img[src*='bigVisa'][style='opacity: 1;']"), 15);
        for (int i = 0; i < 40; i++) {
            try {
                checkOutPage.waitForVisibility(checkOutPage.inputCard, 1);
                new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(checkOutPage.inputCard));
                break;
            }
            catch (Exception e) {
                try {
                    // new WebDriverWait(driver, 1).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(checkOutPage.iframe));
                    driver.switchTo().frame(checkOutPage.iframe);
                }
                catch (Exception e2) {
                }
                Thread.sleep(200);
            }
        }
        checkOutPage.inputCard.click();
        checkOutPage.inputCard.sendKeys("4111111111111111");
        checkOutPage.selectDate();
        checkOutPage.inputInsuanceCard.sendKeys("1111");
        checkOutPage.btnContinue.click();
        MobThankYouPage thankYouPage = new MobThankYouPage();
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
