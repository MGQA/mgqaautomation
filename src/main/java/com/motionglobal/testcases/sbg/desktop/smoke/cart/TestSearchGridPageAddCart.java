package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSearchGridPageAddCart extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/search?keywords=rayban&searchHashcode=1476672393283425#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.dk/search?keywords=rayban&searchHashcode=1476672393283425#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunGlass(String url) {
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.header().inputSearch.click();
        resultPage.matcherQuickViewClickOpen(1);
        resultPage.waitForVisibility(resultPage.buyNoRX, 15);
        resultPage.buyNoRX.click();
        boolean cart = false;
        if (resultPage.getCartType().equals("old")) {
            cart = true;
        }
        if (resultPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunRX(String url) {
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.header().inputSearch.click();
        resultPage.matcherQuickViewClickOpen(1);
        resultPage.waitForVisibility(resultPage.buyRX, 15);
        resultPage.buyRX.click();
        RX3Page rx3Page = new RX3Page();
        resultPage.getRXType();
        try {
            for (int i = 0; i < 33; i++) {
                driver.findElement(By.className("xubox_shade"));
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(rx3Page.addToCart));
        rx3Page.addToCart.click();
        boolean cart = false;
        if (resultPage.getCartType().equals("old")) {
            cart = true;
        }
        if (resultPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @DataProvider
    public Object[][] eye() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/search?keywords=rayban+rx5228+High&searchHashcode=1476946229225267#q=rayban%20rx5228%20High&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.de/search?keywords=rayban+rx5228+High&searchHashcode=1476946229225267#q=rayban%20rx5228%20High&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug", "smoke" })
    public void eyeFrame(String url) {
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.header().inputSearch.click();
        resultPage.matcherQuickViewClickOpen(1);
        resultPage.waitForVisibility(resultPage.buyRX, 15);
        resultPage.frameOrAdd.get(1).click();
        resultPage.waitForVisibility(resultPage.buyNoRX, 5);
        resultPage.buyNoRX.click();
        boolean cart = false;
        if (resultPage.getCartType().equals("old")) {
            cart = true;
        }
        if (resultPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug", "smoke" })
    public void eyeGlass(String url) {
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.header().inputSearch.click();
        resultPage.matcherQuickViewClickOpen(1);
        resultPage.waitForVisibility(resultPage.buyRX, 15);
        resultPage.buyRX.click();
        RX3Page rx3Page = new RX3Page();
        resultPage.getRXType();
        try {
            for (int i = 0; i < 33; i++) {
                driver.findElement(By.className("xubox_shade"));
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(rx3Page.addToCart));
        rx3Page.addToCart.click();
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
