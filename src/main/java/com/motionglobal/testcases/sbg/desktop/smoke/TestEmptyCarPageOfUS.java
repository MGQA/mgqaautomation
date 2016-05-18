package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestEmptyCarPageOfUS extends AbstractBaseSbgDesktopTestCase {

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
        header.waitForVisibility(header.cartBox, 2);
        header.cartBox.click();
        CartPage cartPage = new CartPage();
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
