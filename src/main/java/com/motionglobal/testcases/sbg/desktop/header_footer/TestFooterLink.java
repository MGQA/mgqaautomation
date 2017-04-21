package com.motionglobal.testcases.sbg.desktop.header_footer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestFooterLink extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "https://www.smartbuyglasses.co.uk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void homePageFooter(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        //
        String actualUrlHelp = homePage.linkFooterS.get(0).getAttribute("href");
        Assert.assertEquals(actualUrlHelp, url + "help");
        //
        String actualUrlFAQ = homePage.linkFooterS.get(1).getAttribute("href");
        Assert.assertEquals(actualUrlFAQ, url + "faq");
        //
        String actualUrlOrder = homePage.linkFooterS.get(2).getAttribute("href");
        Assert.assertEquals(actualUrlOrder, url + "order");
        //
        String actualUrlFastShipping = homePage.linkFooterS.get(3).getAttribute("href");
        Assert.assertEquals(actualUrlFastShipping, url + "fast-shipping");
        //
        String actualUrlReturns = homePage.linkFooterS.get(4).getAttribute("href");
        Assert.assertEquals(actualUrlReturns, url + "returns");
        //
        String actualUrlOpticalCentre = homePage.linkFooterS.get(5).getAttribute("href");
        Assert.assertEquals(actualUrlOpticalCentre, url + "optical-centre");
        //
        String actualUrlStyle = homePage.linkFooterS.get(6).getAttribute("onclick");
        Assert.assertEquals(actualUrlStyle, "dataLayer.push({'event':'GAEvent', 'eventCategory':'Footer', 'eventAction':'click', 'eventLabel':'Style Finder'");
        //
        String actualUrlShoppingGuides = homePage.linkFooterS.get(7).getAttribute("href");
        Assert.assertEquals(actualUrlShoppingGuides, url + "shopping-guides");
        //
        String actualUrlLookBook = homePage.linkFooterS.get(8).getAttribute("href");
        Assert.assertEquals(actualUrlLookBook, url + "shopping-guides/shop-by-personality-sunglasses-lookbook");
        //
        String actualUrlCelebrity = homePage.linkFooterS.get(9).getAttribute("href");
        Assert.assertEquals(actualUrlCelebrity, url + "i/celebrity-sunglasses-glasses");
        //
        String actualUrlTryOn = homePage.linkFooterS.get(10).getAttribute("href");
        // Assert.assertEquals(actualUrlTryOn, url + "virtual-try-on");
        Assert.assertEquals(actualUrlTryOn, url + "designer-sunglasses/general/----------1----1---------");

        //
        String actualUrlBestPrice = homePage.linkFooterS.get(11).getAttribute("href");
        Assert.assertEquals(actualUrlBestPrice, url + "best-price-guarantee");
        //
        String actualUrlStudentsDiscount = homePage.linkFooterS.get(12).getAttribute("href");
        Assert.assertEquals(actualUrlStudentsDiscount, url + "i/partners/students");
        //
        String actualUrlAboutUs = homePage.linkFooterS.get(13).getAttribute("href");
        Assert.assertEquals(actualUrlAboutUs, url + "about-us");
        //
        String actualUrlSecure = homePage.linkFooterS.get(14).getAttribute("href");
        Assert.assertEquals(actualUrlSecure, url + "secure");
        //
        String actualUrlBuyOneGiveOne = homePage.linkFooterS.get(15).getAttribute("href");
        Assert.assertEquals(actualUrlBuyOneGiveOne, url + "community");
        //
        String actualUrlNews = homePage.linkFooterS.get(16).getAttribute("href");
        Assert.assertEquals(actualUrlNews, url + "in-the-news");

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