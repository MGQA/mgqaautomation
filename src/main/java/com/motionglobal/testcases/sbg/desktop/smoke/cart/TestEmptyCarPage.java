package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * US Test £ºempty cartBox
 * 
 */
public class TestEmptyCarPage extends AbstractBaseSbgDesktopTestCase {

    /**
     * old Cart
     */
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void AU_CartBoxEmptyPage() {
        String url = "http://www.visiondirecta.cl/";
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

    /**
     * new cart
     */
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void NZ_CartBoxEmptyPage() {
        String url = "http://www.smartbuyglasses.co.nz/";
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
        NewCartPage cartPage = new NewCartPage();
        Assert.assertTrue(cartPage.newCartEmptyIcon.isDisplayed());
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
