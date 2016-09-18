package com.motionglobal.testcases.sbg.mobile.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * m.com test £º login
 * 
 */
public class MobTestLogin extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug2", "smoke", "fastsmoke" })
    public void testLogin() {
        driver.get("http://m.smartbuyglasses.com");
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.JsMouse(header.btnLogin);
        header.btnLogin.click();
        header.emailAddress.sendKeys("felix.ma@motionglobal.com");
        header.passWord.sendKeys("motion888");
        header.signIn.click();
        Assert.assertTrue(header.account.isEnabled());
    }

    @Test(groups = { "debug2", "smoke", "fastsmoke" })
    public void testLogout() {
        String url = "http://m.smartbuyglasses.com/";
        getURL(AbstractBasePage.getMobLoginRequest(url));
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.JsMouse(header.btnLogout);
        header.btnLogout.click();
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
        //
        header.btnMenu.click();
        header.JsMouse(header.btnLogin);
        header.btnLogin.click();
        header.emailAddress.sendKeys("felix.ma@motionglobal.com");
        header.passWord.sendKeys("motion888");
        header.signIn.click();
        Assert.assertTrue(header.account.isEnabled());
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
