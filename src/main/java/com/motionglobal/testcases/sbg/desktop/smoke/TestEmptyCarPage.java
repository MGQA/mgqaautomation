package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CN_CartPage;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestEmptyCarPage extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void US_CartBoxEmptyPage() {
        String url = "http://www.smartbuyglasses.com";
        getURL(url);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }
        Header header = new Header();
        Assert.assertEquals(header.cartProductNum.getText(), "0");
        header.cartBox.click();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.cartEmptyIcon.isDisplayed());
    }

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void CN_CartBoxEmptyPage() {
        String url = "http://www.smartbuyglasses.cn";
        getURL(url);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }
        Header header = new Header();
        header.waitForVisibility(header.cartProductNum, 5);
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
