package com.motionglobal.testcases.sbg.desktop.login;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestCartLogin extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/cart" } };
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke", "fastsmoke" })
    public void cartLogin(String url) {
        getURL(url);
        CartPage cartPage = new CartPage();
        cartPage.waitForVisibility(cartPage.loginCart, 2);
        cartPage.loginCart.click();
        Header header = new Header();
        header.username.get(0).clear();
        header.username.get(0).sendKeys("felix.ma@motionglobal.com");
        header.password.get(0).clear();
        header.password.get(0).sendKeys("motion888");
        header.signInButton.get(0).click();
        // #content>div[class*=cart_] is login in cart page
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#content>div[class*=cart_]"), 3));
        Assert.assertTrue(header.HKCartYourAccount.isDisplayed());
        driver.quit();
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
