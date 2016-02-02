package com.motionglobal.testcases.sbg.desktop.home;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class LoginTest extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = "smoke")
    public void testLogin() {
        driver.get("http://www.smartbuyglasses.com/");
        HomePage homepage = new HomePage();
        Actions actions = new Actions(driver);
        actions.moveToElement(homepage.header().loginlable).perform();
        homepage.waitForVisibility(homepage.header().signin, 5);
        homepage.header().signin.click();
        homepage.header().username.clear();
        homepage.header().username.sendKeys("felix.ma@motionglobal.com");
        homepage.header().password.clear();
        homepage.header().password.sendKeys("motion888");
        homepage.header().signInButton.click();
        actions.moveToElement(homepage.header().yourAccount).perform();
        homepage.waitForVisibility(homepage.header().signout, 5);
        Assert.assertTrue(homepage.isTextPresent("Hi test!"));
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
