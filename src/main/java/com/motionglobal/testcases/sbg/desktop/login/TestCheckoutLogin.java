package com.motionglobal.testcases.sbg.desktop.login;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestCheckoutLogin extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html/" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html/" },
                { "http://www.smartbuyglasses.jp/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug111", "smoke" })
    public void CheckoutLogin(String url) {
        getURL(url);
        Header header = new Header();
        header.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        header.inputSearch.click();
        detailPage.btnBuyNow.click();
        String cart = detailPage.getCartType();
        if (cart.equals("new")) {
            NewCartPage cartPage = new NewCartPage();
            cartPage.btnCheckout.click();
            NewCheckoutPage checkoutPage = new NewCheckoutPage();
            checkoutPage.waitForVisibility(checkoutPage.login, 5);
            checkoutPage.login.click();
            try {
                header.signInButton.get(1).click();
                header.username.clear();
                header.username.get(1).sendKeys("felix.ma@motionglobal.com");
                header.password.clear();
                header.password.get(1).sendKeys("motion888");
                header.signInButton.get(1).click();
            }
            catch (Exception e) {
                header.signInButton.get(0).click();
                header.username.clear();
                header.username.get(0).sendKeys("felix.ma@motionglobal.com");
                header.password.clear();
                header.password.get(0).sendKeys("motion888");
                header.signInButton.get(0).click();
            }
            try {
                new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
            }
            catch (Exception e) {
            }
            header.acceptAlert();
            String text = driver.getPageSource();
            System.out.println(text);
            Assert.assertTrue(text.contains("felix.ma@motionglobal.com"));
        }
        else {
            CartPage cartPage = new CartPage();
            cartPage.btnCheckout.click();
            CheckoutPage checkoutPage = new CheckoutPage();
            checkoutPage.login.click();
            try {
                header.signInButton.get(1).click();
                header.username.clear();
                header.username.get(1).sendKeys("felix.ma@motionglobal.com");
                header.password.clear();
                header.password.get(1).sendKeys("motion888");
                header.signInButton.get(1).click();
            }
            catch (Exception e) {
                header.signInButton.get(0).click();
                header.username.clear();
                header.username.get(0).sendKeys("felix.ma@motionglobal.com");
                header.password.clear();
                header.password.get(0).sendKeys("motion888");
                header.signInButton.get(0).click();
            }
            try {
                new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
            }
            catch (Exception e) {
            }
            header.acceptAlert();
            String text = driver.getPageSource();
            System.out.println(text);
            Assert.assertTrue(text.contains("test test - test"));
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
