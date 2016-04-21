package com.motionglobal.testcases.sbg.desktop.MobSmoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.MobHeader;
import com.motionglobal.pages.sbg.desktop.cart.MobCartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestEmptyCarPage extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { { "http://m.smartbuyglasses.com" }, { "http://m.smartbuyglasses.cn" } };
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void mobCartBoxEmptyPage(String url) {
        driver.get(url);
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
