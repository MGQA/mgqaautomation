package com.motionglobal.testcases.sbg.mobile.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * m.com and m.cn Test :empty cartBox
 * 
 */
public class MobTestEmptyCarPage extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { { "http://m.smartbuyglasses.com" }, { "http://m.smartbuyglasses.cn" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke", "fastsmoke" })
    public void mobCartBoxEmptyPage(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Assert.assertFalse(header.cartNum.isDisplayed());
        header.cartBox.click();
        MobCartPage cartPage = new MobCartPage();
        Assert.assertTrue(cartPage.cartIsEmpty.isDisplayed());
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
