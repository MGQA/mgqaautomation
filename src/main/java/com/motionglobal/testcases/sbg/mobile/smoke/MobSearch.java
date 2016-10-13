package com.motionglobal.testcases.sbg.mobile.smoke;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.search.MobSearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * m.10 main domain Test �� search ray-ban and acuvue
 * 
 */
public class MobSearch extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.com" },
                { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.ca" }, { "http://m.smartbuyglasses.com.hk" }, { "http://m.smartbuyglasses.se" },
                { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" } };
    }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void TestSearchRayBan(String url) {
        getURL(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("ray ban");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void TestSearchLC(String url) {
        getURL(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("acuvue");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Acuvue"), "Expected Ray-ban displayed, but no");
    }

    // ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @DataProvider
    public Object[][] dp2() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp2", groups = { "fastsmoke" })
    public void fastsmokeSearchRayBan(String url) {
        getURL(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("ray ban");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
    }

    @Test(skipFailedInvocations = true, groups = { "fastsmoke" })
    public void fastsmokeSearchLC() {
        String url = "http://m.smartbuyglasses.com";
        getURL(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("acuvue");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Acuvue"), "Expected Ray-ban displayed, but no");
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
