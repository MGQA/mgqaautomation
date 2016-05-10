package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

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

    @Test(dataProvider = "dp", groups = { "debug3", "smoke" })
    public void TestSearchRayBan(String url) {
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("ray ban");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        String raybanBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(raybanBand.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void TestSearchLC(String url) {
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("acuvue");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        String acuvueBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(acuvueBand.contains("Acuvue"), "Expected acuvue displayed, but no");
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
