package com.motionglobal.testcases.sbg.desktop.login;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestCartregister extends AbstractBaseTestCase {

    static Random random = new Random();
    static int randomInt = random.nextInt(999999999);
    static String email = "motionglobal@" + randomInt + ".com";
    static String url = "http://www.smartbuyglasses.com/";
    static String passWord = "helloworld123";

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com.hk/cart" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug111", "smoke" })
    public void bebeClickText(String url) throws InterruptedException {
        getURL(url);
        CartPage cartPage = new CartPage();
        cartPage.waitForVisibility(cartPage.loginCart, 2);
        cartPage.loginCart.click();
        Header header = new Header();
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(header.register));
        header.register.click();
        header.waitForVisibility(header.registerBtn, 1);
        header.registerName.sendKeys(email);
        header.registerBtn.click();
        header.waitForVisibility(header.registerCompleterBtn, 2);
        header.registerFirstName.sendKeys("jack");
        header.registerWd.sendKeys(passWord);
        header.registerWdConfirm.sendKeys(passWord);
        header.registerCompleterBtn.click();
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
