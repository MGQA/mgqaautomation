package com.motionglobal.testcases.sbg.desktop.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * BUG
 * 
 */
public class TestCheckoutRegister extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html/" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html/" },
                { "http://www.smartbuyglasses.jp/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void CheckoutLogin(String url) {
        getURL(url);
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        header.inputSearch.click();
        detailPage.btnBuyNow.click();
        String cart = detailPage.getCartType();
        detailPage.deleteHead();
        if (cart.equals("new")) {
            NewCartPage cartPage = new NewCartPage();
            cartPage.btnCheckout.click();
            NewCheckoutPage checkoutPage = new NewCheckoutPage();
            checkoutPage.login.click();
            try {
                checkoutPage.waitForVisibility(checkoutPage.register.get(0), 2);
                checkoutPage.register.get(0).click();
            }
            catch (Exception e) {
                checkoutPage.waitForVisibility(checkoutPage.register.get(1), 2);
                checkoutPage.register.get(1).click();
            }
            header.waitForVisibility(header.registerBtn, 1);
        }
        else {
            CartPage cartPage = new CartPage();
            cartPage.btnCheckout.click();
            CheckoutPage checkoutPage = new CheckoutPage();
            checkoutPage.login.click();
            checkoutPage.waitForVisibility(checkoutPage.register, 5);
            try {
                checkoutPage.register.get(0).click();
            }
            catch (Exception e) {
                checkoutPage.register.get(1).click();
            }
            header.waitForVisibility(header.registerBtn, 1);
        }
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
