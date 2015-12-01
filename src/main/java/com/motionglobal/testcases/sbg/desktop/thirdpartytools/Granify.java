package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
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
        driver.get("http://www.visiondirect.com.au/");
        Header header = new Header();
        header.acceptAlert();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(homePage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(homePage.isTextPresent("{ page_type: \"home\" }"));
        Assert.assertFalse(homePage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testProductPage() {
        driver.get("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        Header header = new Header();
        header.acceptAlert();
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
        Header header = new Header();
        header.acceptAlert();
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
        Header header = new Header();
        header.acceptAlert();
        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertTrue(searchResultPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(searchResultPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(searchResultPage.isTextPresent("{ page_type: \"search\" }"));
        Assert.assertFalse(searchResultPage.isTextPresent("{ page_type: \"cart\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testOtherPage() {
        driver.get("http://www.visiondirect.com.au/faq");
        Header header = new Header();
        header.acceptAlert();
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

    @Test(groups = { "acceptance", "au" })
    public void testEmptyCartPage() {
        driver.get("http://www.visiondirect.com.au/cart");
        Header header = new Header();
        header.acceptAlert();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(cartPage.isTextPresent("{ page_type: \"cart\" }"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackCart(false);"));
        Assert.assertFalse(cartPage.isTextPresent("0, // Number of items"));
        Assert.assertFalse(cartPage.isTextPresent("0.00 // Total price"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Test(groups = { "debug", "au" })
    public void testNonEmptyCartPage() {
        driver.get("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();

        CartPage cartPage = new CartPage();
        logger().info(driver.getPageSource());
        Assert.assertTrue(cartPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(cartPage.isTextPresent("{ page_type: \"cart\" }"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackCart({"));
        Assert.assertTrue(cartPage.isTextPresent("{\"id\":\"110094\",\"quantity\":1,\"price\":\"127.95\",\"title\":\"Ray-Ban RB4165 Justin\"}"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));

        driver.get("http://www.visiondirect.com.au/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html");
        cartPage.acceptAlert();
        productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();
        productDetailPage.btnFrameOnly.click();

        cartPage = new CartPage();
        Assert.assertTrue(cartPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(cartPage.isTextPresent("{ page_type: \"cart\" }"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackCart({"));
        Assert.assertTrue(cartPage.isTextPresent("{\"id\":\"93357\",\"quantity\":1,\"price\":\"146.95\",\"title\":\"Ray-Ban RX5228 Highstreet\"}"));
        Assert.assertTrue(cartPage.isTextPresent("{\"id\":\"110094\",\"quantity\":1,\"price\":\"127.95\",\"title\":\"Ray-Ban RB4165 Justin\"}"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));

        driver.get("http://www.visiondirect.com.au/contact-lenses/daily-disposable/1-Day-Acuvue-Moist-for-Astigmatism-90-Pack/246.html");
        cartPage.acceptAlert();
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        clProductDetailPage.setRightPrescription(true, "1", "-4.50", "-1.25", "20.00");
        clProductDetailPage.setLeftPrescription(true, "1", "-4.50", "-1.25", "20.00");
        clProductDetailPage.clickAddToCart();

        cartPage = new CartPage();
        Assert.assertTrue(cartPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(cartPage.isTextPresent("{ page_type: \"cart\" }"));
        Assert.assertTrue(cartPage.isTextPresent("Granify.trackCart({"));
        Assert.assertTrue(cartPage.isTextPresent("{\"id\":\"93357\",\"quantity\":1,\"price\":\"146.95\",\"title\":\"Ray-Ban RX5228 Highstreet\"}"));
        Assert.assertTrue(cartPage.isTextPresent("{\"id\":\"110094\",\"quantity\":1,\"price\":\"127.95\",\"title\":\"Ray-Ban RB4165 Justin\"}"));
        Assert.assertTrue(
                cartPage.isTextPresent("{\"id\":\"246\",\"quantity\":2,\"price\":\"81.95\",\"title\":\"1-Day Acuvue Moist for Astigmatism 90 Pack\"}"));
        Assert.assertFalse(cartPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Test(groups = { "acceptance", "au" })
    public void testGCCheckoutPage() {
        driver.get("http://www.visiondirect.com.au/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();

        CartPage cartPage = new CartPage();
        cartPage.btnCheckout.click();
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(checkoutPage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(checkoutPage.isTextPresent("{ page_type: \"checkout\" }"));
        Assert.assertFalse(checkoutPage.isTextPresent("{ page_type: \"product\" }"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
