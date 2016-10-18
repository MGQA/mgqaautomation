package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSearchGridPageAddCart extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/search?keywords=rayban&searchHashcode=1476672393283425#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1476672393283425#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.dk/search?keywords=rayban&searchHashcode=1476672393283425#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void quickViewBuyNow(String url) {
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.header().inputSearch.click();
        resultPage.matcherQuickViewClickOpen(1);
        resultPage.waitForVisibility(resultPage.buyNowSun, 2);
        resultPage.buyNowSun.click();
        boolean cart = false;
        if (resultPage.getCartType().equals("old")) {
            cart = true;
        }
        if (resultPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
