package com.motionglobal.testcases.sbg.desktop.trackingcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;

public class tracking extends AbstractTrackingCodeTestCase {

    @DataProvider
    public Object[][] home() {
        return new Object[][] { { "https://www.visiondirect.com.au/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "home", groups = { "debug", "smoke" })
    public void homePage(String url) {
        getURL(url);
        checkTracking("criteo", "doubleclick", "facebookPixel", "googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "optimizely");
    }

    @DataProvider
    public Object[][] brand() {
        return new Object[][] { { "https://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "brand", groups = { "debug", "smoke" })
    public void brandPage(String url) {
        getURL(url);
        checkTracking("criteo", "doubleclick", "facebookPixel", "googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "optimizely");
    }

    @DataProvider
    public Object[][] product() {
        return new Object[][] { { "https://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB3025-Aviator-Gradient-001/51-52178.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "product", groups = { "debug", "smoke" })
    public void productPage(String url) {
        getURL(url);
        checkTracking("criteo", "doubleclick", "facebookPixel", "googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "optimizely");
    }

    @DataProvider
    public Object[][] pimcore() {
        return new Object[][] { { "https://www.visiondirect.com.au/optical-centre" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "pimcore", groups = { "debug", "smoke" })
    public void pimcorePage(String url) {
        getURL(url);
        checkTracking("googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "optimizely");
    }

    //
    @Test(skipFailedInvocations = true, dataProvider = "product", groups = { "debug", "smoke" })
    public void cartPage(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.btnBuyNow.click();
        checkTracking("criteo", "doubleclick", "facebookPixel", "googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "kenshoo", "optimizely");
    }

    @Test(skipFailedInvocations = true, dataProvider = "product", groups = { "debug", "smoke" })
    public void checkoutPage(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.btnBuyNow.click();
        NewCartPage cartPage = new NewCartPage();
        cartPage.btnCheckout.click();
        checkTracking("doubleclick", "facebookPixel", "googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "optimizely");
    }

    @DataProvider
    public Object[][] thank() {
        return new Object[][] { { "https://www.smartbuyglasses.ie/thank-you/index/pay_type/gc/orderId/IE0386157803G/paymentproductid/1/pay_method/card/payment_id/000000577940000000340000100001" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "thank", groups = { "debug", "smoke" })
    public void thankPage(String url) {
        getURL(url);
        checkTracking("criteo", "doubleclick", "facebookPixel", "googleAnalysis", "googleAds", "googleManager", "googleRemarketing", "optimizely");
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
