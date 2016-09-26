package com.motionglobal.testcases.sbg.desktop.rx;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSunglassRX extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { { "http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.co.nz/designer-sunglasses/Ray-Ban/" } };
    }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void addPrescription(String url) throws InterruptedException {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.matcherQuickViewSunCanRX();
        gridPage.waitForVisibility(gridPage.buyPre, 5);
        gridPage.buyPre.click();

        // RX
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.addToCart, 5);
        rx3Page.addToCart.click();
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(rx3Page.addToCart)));
        }
        catch (Exception e) {

        }
        String cart = gridPage.getCartType();
        try {
            Assert.assertEquals(cart, "new");
        }
        catch (Error e) {
            Assert.assertEquals(cart, "old");
        }
        if (cart.equals("old")) {
            CartPage cartPage = new CartPage();
            Assert.assertTrue(cartPage.priceLens.isDisplayed(), " RX Fail !!!");
        }
        else {
            NewCartPage cartPage = new NewCartPage();
            Assert.assertEquals(cartPage.priceRx.size(), 3);
        }
    }

    // XXX case 2
    @Test(groups = { "debug", "smoke" })
    public void searchAndPXThenCart() throws InterruptedException {
        String url = "http://www.smartbuyglasses.co.uk/search?keywords=rayban&searchHashcode=1474615793789590#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.matcherQuickSunCanRX();
        searchPage.waitForVisibility(searchPage.buyPre, 5);
        searchPage.buyPre.click();

        // RX
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.addToCart, 5);
        rx3Page.addToCart.click();
        String cart = searchPage.getCartType();
        try {
            Assert.assertEquals(cart, "new");
        }
        catch (Error e) {
            Assert.assertEquals(cart, "old");
        }
        if (cart.equals("old")) {
            CartPage cartPage = new CartPage();
            Assert.assertTrue(cartPage.priceLens.isDisplayed(), " RX Fail !!!");
        }
        else {
            NewCartPage cartPage = new NewCartPage();
            Assert.assertEquals(cartPage.priceRx.size(), 3);
        }
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
