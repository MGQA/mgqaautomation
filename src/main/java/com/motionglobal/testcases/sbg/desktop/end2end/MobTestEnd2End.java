package com.motionglobal.testcases.sbg.desktop.end2end;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.MobHeader;
import com.motionglobal.pages.sbg.desktop.cart.MobCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.MobCheckOutPage;
import com.motionglobal.pages.sbg.desktop.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.MobSearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestEnd2End extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "smoke", "debug2" })
    public void mobSearchItemAndPayByGC() {
        driver.get("http://m.smartbuyglasses.com/");
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
        cartPage.fastCheckOut.click();
        MobCheckOutPage checkOutPage = new MobCheckOutPage();
        checkOutPage.clearInput(checkOutPage.inputFistName, "automationFirst");
        checkOutPage.clearInput(checkOutPage.inputLastName, "automationLast");
        checkOutPage.clearInput(checkOutPage.inputEmail, "testautomation@automation.com");
        checkOutPage.clearInput(checkOutPage.inputAddress1, "automationAddress1");
        checkOutPage.clearInput(checkOutPage.inputPhone, "automationTel");
        checkOutPage.clearInput(checkOutPage.inputPostAddress, "200000");
        checkOutPage.clearInput(checkOutPage.inputCity, "shanghai");
        checkOutPage.VISA.click();
        checkOutPage.waitForVisibility(checkOutPage.CardDiv, 10);
        Assert.assertTrue(checkOutPage.CardDiv.isDisplayed());
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
