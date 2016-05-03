package com.motionglobal.testcases.sbg.desktop.home;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class LoginTest extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug", "smoke" })
    public void testLogin() {
        driver.get("http://www.smartbuyglasses.com");
        HomePage homepage = new HomePage();
        homepage.mouseOver(homepage.header().loginlable);
        homepage.waitForVisibility(homepage.header().signin, 5);
        homepage.header().signin.click();
        homepage.header().username.clear();
        homepage.header().username.sendKeys("felix.ma@motionglobal.com");
        homepage.header().password.clear();
        homepage.header().password.sendKeys("motion888");
        homepage.header().signInButton.click();
        homepage.waitForVisibility(homepage.header().yourAccount, 5);
        homepage.mouseOver(homepage.header().yourAccount);
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
