package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CN_CartPage;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestEmptyCarPage extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke" })
    public void US_CartEmptyPAge() {
        String url = "http://www.smartbuyglasses.com";
        driver.get(url);
        Header header = new Header();
        Assert.assertEquals(header.cartProductNum.getText(), "0");
        header.cartBox.click();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.cartEmptyIcon.isDisplayed());
    }

    @Test(groups = { "debug", "smoke" })
    public void CN_CartEmptyPAge() {
        String url = "http://www.smartbuyglasses.cn";
        driver.get(url);
        Header header = new Header();
        Assert.assertEquals(header.cartProductNum.getText(), "0");
        header.cartBox.click();
        CN_CartPage cartPage = new CN_CartPage();
        Assert.assertTrue(cartPage.cartEmptyIcon.isDisplayed());
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
