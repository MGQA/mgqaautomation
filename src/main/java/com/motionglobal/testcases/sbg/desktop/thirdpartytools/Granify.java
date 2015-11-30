package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.footer.aboutus.AboutUsPage;
import com.motionglobal.pages.sbg.desktop.footer.customercare.FaqPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Granify extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "acceptance", "au" })
    public void testHomepage() {
        driver.get("http://www.visiondirect.com.au/");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(homePage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(homePage.isTextPresent("{ page_type: \"home\" }"));
        Assert.assertFalse(homePage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
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

    @Test(groups = { "acceptance", "au" })
    public void testProductGridPage() {
        driver.get("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/");
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productGridPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productGridPage.isTextPresent("{ page_type: \"collection\" }"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));

        driver.get("http://www.visiondirect.com.au/designer-sunglasses/general/-Men----------------------");
        Assert.assertTrue(productGridPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productGridPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productGridPage.isTextPresent("{ page_type: \"collection\" }"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));

        driver.get("http://www.visiondirect.com.au/designer-sunglasses/on-sale/");
        Assert.assertTrue(productGridPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productGridPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productGridPage.isTextPresent("{ page_type: \"collection\" }"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));

        driver.get("http://www.visiondirect.com.au/contact-lenses/b/Acuvue-contact-lenses#!&s=popularity&tb=0&b=Acuvue&p=1");
        Assert.assertTrue(productGridPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(productGridPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(productGridPage.isTextPresent("{ page_type: \"collection\" }"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testSearchResultPage() {
        driver.get(
                "http://www.visiondirect.com.au/search?keywords=rayban&searchHashcode=1445407688101619#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]");
        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertTrue(searchResultPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(searchResultPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(searchResultPage.isTextPresent("{ page_type: \"search\" }"));
        Assert.assertFalse(searchResultPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "debug", "au" })
    public void testOtherPage() {
        driver.get("http://www.visiondirect.com.au/faq");
        FaqPage faqPage = new FaqPage();
        Assert.assertTrue(faqPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(faqPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(faqPage.isTextPresent("{ page_type: \"other\" }"));
        Assert.assertFalse(faqPage.isTextPresent("{ page_type: \"cart\" }"));

        driver.get("http://www.visiondirect.com.au/about-us");
        AboutUsPage aboutUsPage = new AboutUsPage();
        Assert.assertTrue(aboutUsPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(aboutUsPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(aboutUsPage.isTextPresent("{ page_type: \"other\" }"));
        Assert.assertFalse(aboutUsPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
