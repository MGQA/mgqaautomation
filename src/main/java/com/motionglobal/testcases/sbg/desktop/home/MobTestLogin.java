package com.motionglobal.testcases.sbg.desktop.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.MobHeader;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestLogin extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug2", "smoke" })
    public void testLogin() {
        driver.get("http://m.smartbuyglasses.com");
        MobHeader header = new MobHeader();
        header.menuBtn.click();
        header.loginBtn.click();
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
