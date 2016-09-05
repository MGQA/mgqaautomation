package com.motionglobal.testcases.sbg.mobile.cart;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestCart extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/" }, { "http://m.smartbuyglasses.co.uk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void emptyCart(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        // header.waitForVisibility(header.cartBox, 5);
        // header.cartBox.click();
        // MobCartPage cartPage = new MobCartPage();
        // cartPage.waitForVisibility(cartPage.cartIsEmpty, 5);
        Actions actions = new Actions(driver);
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
