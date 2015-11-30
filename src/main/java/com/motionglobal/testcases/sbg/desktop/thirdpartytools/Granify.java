package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Granify extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "au" })
    public void testHomepage() {
        driver.get("http://www.visiondirect.com.au/");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(homePage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(homePage.isTextPresent("{ page_type: \"home\" }"));
        Assert.assertFalse(homePage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "debug", "au" })
    public void testProductPage() {
        driver.get("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        ProductDetailPage productPage = new ProductDetailPage();
        Assert.assertTrue(productPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productPage.isTextPresent("{ page_type: \"product\" }"));
        Assert.assertFalse(productPage.isTextPresent("{ page_type: \"cart\" }"));

        driver.get("http://www.visiondirect.com.au/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html");
        Assert.assertTrue(productPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productPage.isTextPresent("{ page_type: \"product\" }"));
        Assert.assertFalse(productPage.isTextPresent("{ page_type: \"cart\" }"));

        driver.get("http://www.visiondirect.com.au/contact-lenses/1-2-weeks-disposable/Acuvue-Oasys-for-Astigmatism-6-Pack/449.html");
        Assert.assertTrue(productPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productPage.isTextPresent("{ page_type: \"product\" }"));
        Assert.assertFalse(productPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
