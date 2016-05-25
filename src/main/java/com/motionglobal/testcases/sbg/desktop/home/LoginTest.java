package com.motionglobal.testcases.sbg.desktop.home;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class LoginTest extends AbstractBaseSbgDesktopTestCase {
    static Random random = new Random();
    static int randomInt = random.nextInt(99999);
    static String email = "motionglobal@" + randomInt + ".com";
    static String url = "http://www.smartbuyglasses.com/";
    static String passWord = "helloworld123";

    @Test(priority = 1, groups = { "debug111", "smoke", "fastsmoke" })
    public void testRegister() {
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.loginlable, 3);
        try {
            header.mouseOver(header.loginlable);
            header.waitForVisibility(header.register, 1);
        }
        catch (Exception e) {
            header.mouseOver(header.Help);
            header.waitForVisibility(header.getHelpLinkElement(1), 2);
            header.mouseOver(header.loginlable);
            header.waitForVisibility(header.register, 1);
        }
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
        header.waitForVisibility(header.registerSuccess, 10);
        header.registerSuccess.click();
        driver.quit();
    }

    @Test(dependsOnMethods = "testRegister", groups = { "debug111", "smoke", "fastsmoke" })
    public void testLogin() {
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.loginlable, 5);
        header.mouseOver(header.loginlable);
        try {
            header.waitForVisibility(header.signin, 1);
        }
        catch (Exception e) {
            header.mouseOver(header.Help);
            header.waitForVisibility(header.getHelpLinkElement(1), 2);
            header.mouseOver(header.loginlable);
            header.waitForVisibility(header.signin, 1);
        }
        header.signin.click();
        header.username.clear();
        header.username.sendKeys(email);
        header.password.clear();
        header.password.sendKeys(passWord);
        header.signInButton.click();
        header.waitForVisibility(header.yourAccount, 10);
        header.mouseOver(header.yourAccount);
        header.waitForVisibility(header.signout, 5);
        Assert.assertTrue(header.isTextPresent("Hi jack!"));
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
