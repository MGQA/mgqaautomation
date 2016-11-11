package com.motionglobal.testcases.sbg.desktop.login;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test £º register and sign in
 * 
 */
public class LoginTest extends AbstractBaseSbgDesktopTestCase {
    static Random random = new Random();
    static int randomInt = random.nextInt(999999999);
    static String email = "motionglobal@" + randomInt + ".com";
    static String url = "http://www.smartbuyglasses.com/";
    static String passWord = "helloworld123";

    @Test(priority = 1, groups = { "debug", "smoke", "fastsmoke" })
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
        // don't spend E-mail , so don't register
        // header.waitForVisibility(header.registerSuccess, 10);
        // header.registerSuccess.click();
        // getURL(url);
        // header.waitForVisibility(header.yourAccount, 10);
        // header.mouseOver(header.yourAccount);
        // header.waitForVisibility(header.signout, 5);
        // header.signout.click();
        // getURL(url);
        // header.waitForVisibility(header.loginlable, 5);
        // header.mouseOver(header.loginlable);
        // try {
        // header.waitForVisibility(header.signin, 1);
        // }
        // catch (Exception e) {
        // header.mouseOver(header.Help);
        // header.waitForVisibility(header.getHelpLinkElement(1), 2);
        // header.mouseOver(header.loginlable);
        // header.waitForVisibility(header.signin, 1);
        // }
        // header.signin.click();
        // header.username.clear();
        // header.username.sendKeys(email);
        // header.password.clear();
        // header.password.sendKeys(passWord);
        // header.signInButton.click();
        // header.waitForVisibility(header.yourAccount, 10);
        // header.mouseOver(header.yourAccount);
        // header.waitForVisibility(header.signout, 5);
        // Assert.assertTrue(header.isTextPresent("Hi jack!"));
    }

    // XXX
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void faceBookLogin() {
        String hkUrl = "http://www.smartbuyglasses.com.hk";
        getURL(hkUrl);
        Header header = new Header();
        header.displayLogin();
        header.waitForVisibility(header.signin, 2);
        header.signin.click();
        header.waitForVisibility(header.loginFaceBook, 2);
        header.loginFaceBook.click();
        header.waitForVisibility(header.faceBookEmail, 5);
        header.faceBookEmail.sendKeys("+8615200792931");
        header.faceBookPasswd.sendKeys("motion888");
        header.faceBookBtn.click();
        driver.navigate().refresh();
        // #content>div[class*=cart_] is login in cart page
        // new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#content>div[class*=cart_]"), 3));
        header.isTextPresent("Hi test!");
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
