package com.motionglobal.testcases.sbg.desktop.login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestHomePgaeLogin extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" }, { "http://www.smartbuyglasses.com/" } };
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke", "fastsmoke" })
    public void testLogin(String url) {
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
        header.username.sendKeys("felix.ma@motionglobal.com");
        header.password.clear();
        header.password.sendKeys("motion888");
        header.signInButton.click();
        header.waitForVisibility(header.yourAccount, 10);
        Assert.assertTrue(header.isTextPresent("Hi test!"));
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