package com.motionglobal.testcases.sbg.mobile.home;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.search.MobSearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestMenu extends AbstractBaseTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void closeMenu(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        Assert.assertEquals(header.mageMenu.getAttribute("class"), "push");
        header.waitForVisibility(header.closeMenu, 5);
        header.closeMenu.click();
        Assert.assertEquals(header.mageMenu.getAttribute("class"), "");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void searchRayBan(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.menuSearch.click();
        header.menuSearch.clear();
        header.menuSearch.sendKeys("rayban");
        header.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 2);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void searchCL(String url) {
        getURL(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.btnMenu.click();
        mobHeader.menuSearch.click();
        mobHeader.menuSearch.sendKeys("acuvue");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Acuvue"), "Expected Ray-ban displayed, but no");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {

    }
}
