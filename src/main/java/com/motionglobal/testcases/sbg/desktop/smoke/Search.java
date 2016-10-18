package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * 10 main domain Test �� search ray-ban and acuvue , check search accuracy and product number > 4
 * 
 * 
 */
public class Search extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
                { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
                { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
                { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" } };
    }

    // return new Object[][] { new Object[] { "http://www.smartbuyglasses.com" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void TestSearchRayBan(String url) {
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("ray ban");
        header.waitForVisibility(header.iconSearch, 2);
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.brandName, 5);
        String raybanBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(raybanBand.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
        Assert.assertTrue(resultPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void TestSearchLC(String url) {
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("acuvue");
        header.waitForVisibility(header.iconSearch, 2);
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.brandName, 5);
        String acuvueBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(acuvueBand.contains("Acuvue"), "Expected acuvue displayed, but no");
        Assert.assertTrue(resultPage.proInfo.size() > 4, "daily contact lens Number <5");
    }

    // XXX
    @DataProvider
    public Object[][] db() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/search?keywords=rayban&searchHashcode=1476343310695814#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1476343324597876#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.dk/search?keywords=rayban&searchHashcode=14763433297272#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickBrankIntoDetail(String url) {
        getURL(url);
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.waitForVisibility(searchPage.brandName, 5);
        searchPage.deleteHead();
        searchPage.waitForVisibility(searchPage.proInfo.get(0), 2);
        searchPage.JsMouse(searchPage.proInfo.get(0));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        new Actions(driver).moveToElement(searchPage.proInfo.get(0)).build().perform();
        searchPage.waitForVisibility(searchPage.quickView.get(0), 5);
        searchPage.brandName.click();
        ProductDetailPage detailPage = new ProductDetailPage();
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickDetail(String url) {
        getURL(url);
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.deleteHead();
        //
        searchPage.matcherQuickViewClickOpen(1);
        //
        searchPage.waitForVisibility(searchPage.detailBtn, 15);
        searchPage.detailBtn.click();
        searchPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
    }

    // ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @DataProvider
    public Object[][] dp2() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp2", groups = { "fastsmoke" })
    public void fastsmokeSearchRayBan(String url) {
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("ray ban");
        header.waitForVisibility(header.iconSearch, 2);
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        String raybanBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(raybanBand.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
        Assert.assertTrue(resultPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, groups = { "fastsmoke" })
    public void fastsmokeSearchLC() {
        String url = "http://www.smartbuyglasses.com";
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("acuvue");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        String acuvueBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(acuvueBand.contains("Acuvue"), "Expected acuvue displayed, but no");
        Assert.assertTrue(resultPage.proInfo.size() > 4, "daily contact lens count : disagree");
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
