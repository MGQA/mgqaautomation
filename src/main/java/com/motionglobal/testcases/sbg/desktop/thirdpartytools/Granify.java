package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.footer.aboutus.AboutUsPage;
import com.motionglobal.pages.sbg.desktop.footer.customercare.FaqPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.CLProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Granify extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "acceptance", "au" })
    public void testHomepage() {
        getURL("http://www.visiondirect.com.au/");
        Header header = new Header();
        header.acceptAlert();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isTextPresent("var ua_product_categories"));
        Assert.assertTrue(homePage.isTextPresent("var searchOptions"));
        Assert.assertTrue(homePage.isTextPresent("productIdList.push"));
        Assert.assertFalse(homePage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testProductPage() {
        getURL("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage productPage = new ProductDetailPage();
        Assert.assertTrue(productPage.isTextPresent("var ActionName"));
        Assert.assertTrue(productPage.isTextPresent("dataLayer.push"));
        Assert.assertTrue(productPage.isTextPresent("var searchOptions"));
        Assert.assertFalse(productPage.isTextPresent("{ page_type: \"cart\" }"));

        getURL("http://www.visiondirect.com.au/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html");
        Assert.assertTrue(productPage.isTextPresent("dataLayer"));
        Assert.assertTrue(productPage.isTextPresent("dataLayer.push"));
        Assert.assertTrue(productPage.isTextPresent("var glasses_item_obj"));
        Assert.assertFalse(productPage.isTextPresent("{ page_type: \"cart\" }"));

        getURL("http://www.visiondirect.com.au/contact-lenses/1-2-weeks-disposable/Acuvue-Oasys-for-Astigmatism-6-Pack/449.html");
        Assert.assertTrue(productPage.isTextPresent("var ControllerName"));
        Assert.assertTrue(productPage.isTextPresent("dataLayer.push"));
        Assert.assertTrue(productPage.isTextPresent("validator.addMethod"));
        Assert.assertFalse(productPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testProductGridPage() {
        getURL("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/");
        Header header = new Header();
        header.acceptAlert();
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.isTextPresent("viewbrand"));
        Assert.assertTrue(productGridPage.isTextPresent("noSmallImage"));
        Assert.assertTrue(productGridPage.isTextPresent("ProductList"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));

        getURL("http://www.visiondirect.com.au/designer-sunglasses/general/-Men----------------------");
        Assert.assertTrue(productGridPage.isTextPresent("general"));
        Assert.assertTrue(productGridPage.isTextPresent("var base_style_image_url"));
        Assert.assertTrue(productGridPage.isTextPresent("ListingPage"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));

        getURL("http://www.visiondirect.com.au/designer-sunglasses/on-sale/");
        Assert.assertTrue(productGridPage.isTextPresent("ControllerName=\"on-sale\""));
        Assert.assertTrue(productGridPage.isTextPresent("currencySymbol"));
        Assert.assertTrue(productGridPage.isTextPresent("qick_view_do"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));

        getURL("http://www.visiondirect.com.au/contact-lenses/b/Acuvue-contact-lenses#!&s=popularity&tb=0&b=Acuvue&p=1");
        Assert.assertTrue(productGridPage.isTextPresent("ActionName = \"filter-category\";"));
        Assert.assertTrue(productGridPage.isTextPresent("searchOptions"));
        Assert.assertTrue(productGridPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(productGridPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testSearchResultPage() {
        getURL("http://www.visiondirect.com.au/search?keywords=rayban&searchHashcode=1445407688101619#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]");
        Header header = new Header();
        header.acceptAlert();
        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertTrue(searchResultPage.isTextPresent("ControllerName=\"search\";"));
        Assert.assertTrue(searchResultPage.isTextPresent("searchOptions"));
        Assert.assertTrue(searchResultPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(searchResultPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testOtherPage() {
        getURL("http://www.visiondirect.com.au/faq");
        Header header = new Header();
        header.acceptAlert();
        FaqPage faqPage = new FaqPage();
        Assert.assertTrue(faqPage.isTextPresent("ControllerName=\"faq\";"));
        Assert.assertTrue(faqPage.isTextPresent("searchOptions"));
        Assert.assertTrue(faqPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(faqPage.isTextPresent("{ page_type: \"cart\" }"));

        getURL("http://www.visiondirect.com.au/about-us");
        AboutUsPage aboutUsPage = new AboutUsPage();
        // Assert.assertTrue(aboutUsPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        // Assert.assertTrue(aboutUsPage.isTextPresent("Granify.trackPageView("));
        // Assert.assertTrue(aboutUsPage.isTextPresent("{ page_type: \"other\" }"));
        Assert.assertFalse(aboutUsPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testEmptyCartPage() {
        getURL("http://www.visiondirect.com.au/cart");
        Header header = new Header();
        header.acceptAlert();
        NewCartPage cartPage = new NewCartPage();
        Assert.assertTrue(cartPage.isTextPresent("ControllerName=\"cart\";"));
        Assert.assertTrue(cartPage.isTextPresent("searchOptions"));
        Assert.assertTrue(cartPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(cartPage.isTextPresent("0, // Number of items"));
        Assert.assertFalse(cartPage.isTextPresent("0.00 // Total price"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testSunGlassCartPage() {
        getURL("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();
        NewCartPage cartPage = new NewCartPage();
        Assert.assertTrue(cartPage.isTextPresent("ControllerName=\"cart\";"));
        Assert.assertTrue(cartPage.isTextPresent("var currencyCode"));
        Assert.assertTrue(cartPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testEyeGlassCartPage() {
        getURL("http://www.visiondirect.com.au/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html");
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.radioFrameOnly.click();
        productDetailPage.btnBuyNow.click();
        // productDetailPage.btnFrameOnly.click(); // now RX radio box.

        NewCartPage cartPage = new NewCartPage();
        Assert.assertTrue(cartPage.isTextPresent("ControllerName=\"cart\";"));
        Assert.assertTrue(cartPage.isTextPresent("var currencyCode"));
        Assert.assertTrue(cartPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testCLCartPage() {
        getURL("http://www.visiondirect.com.au/contact-lenses/daily-disposable/1-Day-Acuvue-Moist-for-Astigmatism-90-Pack/246.html");
        Header header = new Header();
        header.acceptAlert();
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        try {
            // old CL pre
            clProductDetailPage.setRightPrescription(true, "1", "-4.50", "-1.25", "20.00");
            clProductDetailPage.setLeftPrescription(true, "1", "-4.50", "-1.25", "20.00");
        }
        catch (Exception e) {
            // new CL pre
            clProductDetailPage.CLNewPreL(0, 2, 1, 3);
            clProductDetailPage.CLNewPreR(0, 2, 1, 3);
        }
        clProductDetailPage.clickAddToCart();

        NewCartPage cartPage = new NewCartPage();
        Assert.assertTrue(cartPage.isTextPresent("ControllerName=\"cart\";"));
        Assert.assertTrue(cartPage.isTextPresent("var currencyCode"));
        Assert.assertTrue(cartPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Test(groups = { "acceptance", "au", "debug111" })
    public void testGCCheckoutPage() {
        getURL("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();

        NewCartPage cartPage = new NewCartPage();
        try {
            new Header().JsScaleBody();
        }
        catch (Exception e) {
        }
        cartPage.btnCheckout.click();
        NewCheckoutPage checkoutPage = new NewCheckoutPage();
        Assert.assertTrue(checkoutPage.isTextPresent("ActionName=\"gc-checkout\";"));
        Assert.assertTrue(checkoutPage.isTextPresent("searchOptions"));
        Assert.assertTrue(checkoutPage.isTextPresent("dataLayer.push"));
        Assert.assertFalse(checkoutPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
