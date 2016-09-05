package com.motionglobal.testcases.sbg.mobile.end2end;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.checkout.MobCheckOutPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.search.MobSearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * m.com Test £º search ray-ban µ½Ö§¸¶Ò³Ãæ
 * 
 */
public class MobTestEnd2End extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "smoke", "debug2", "fastsmoke" })
    public void mobSearchItemAndPayByGC() throws InterruptedException {
        getURL("http://m.smartbuyglasses.com/");
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("ray ban");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
        searchResultPage.productName.get(0).click();
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
        checkOutPage.selectStateGA();
        checkOutPage.continueBtn.click();
        checkOutPage.waitForVisibility(checkOutPage.VISA, 10);
        //
        for (int i = 0; i < 50; i++) {
            try {
                // element checkoutPage.VISAclicked
                driver.findElement(By.cssSelector("img[src*='visadebit'][style='opacity: 1;']"));
            }
            catch (Exception e) {
                Thread.sleep(200);
                checkOutPage.waitForVisibility(checkOutPage.VISA, 5);
                new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(checkOutPage.VISA));
                try {
                    checkOutPage.VISA.click();
                    Thread.sleep(100);
                }
                catch (InterruptedException b) {
                }
            }
        }
        checkOutPage.waitForVisibility(checkOutPage.payFrame, 20);
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
