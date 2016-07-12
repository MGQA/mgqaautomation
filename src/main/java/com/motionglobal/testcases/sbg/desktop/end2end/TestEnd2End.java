package com.motionglobal.testcases.sbg.desktop.end2end;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.GcPaymentPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * HK Test: ËÑË÷ ray ban µ½Ö§¸¶Ò³Ãæ
 */
public class TestEnd2End extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "smoke", "debug", "fastsmoke" })
    public void testSearchItemAndPayByGC() {
        logger().info("started...");
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.sendKeys("ray ban");
        homePage.header().iconSearch.click();
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.resultGrid().getItem(0).click();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();
        new CartPage().btnCheckout.click();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.inputBillingFirstName("automationFirst").inputBillingLastName("automationLast");
        checkoutPage.inputBillingEmail("testautomation@automation.com").inputBillingTelephone("automationTel");
        checkoutPage.selectBillingCountry("HK").inputBillingAddress1("automationAddress1");
        checkoutPage.clickVISA().btnGcPayment.click();
        Assert.assertTrue(new GcPaymentPage().inputORB.isDisplayed());
    }

    @Override
    protected void initialize() {
        getURL(CONFIG.getProperty("sbgDesktopURL"));
    }

    @Override
    protected void tearDown() {
    }

}
