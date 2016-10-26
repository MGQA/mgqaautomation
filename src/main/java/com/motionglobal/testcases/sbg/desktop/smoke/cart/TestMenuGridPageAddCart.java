package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestMenuGridPageAddCart extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/" }, { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunGlass(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.header().inputSearch.click();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buySun, 15);
        gridPage.buySun.click();
        boolean cart = false;
        if (gridPage.getCartType().equals("old")) {
            cart = true;
        }
        if (gridPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunRX(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.header().inputSearch.click();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buyRX, 15);
        gridPage.buyRX.click();
        RX3Page rx3Page = new RX3Page();
        gridPage.getRXType();
        try {
            for (int i = 0; i < 33; i++) {
                driver.findElement(By.className("xubox_shade"));
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(rx3Page.addToCart));
        rx3Page.addToCart.click();
        boolean cart = false;
        if (gridPage.getCartType().equals("old")) {
            cart = true;
        }
        if (gridPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @DataProvider
    public Object[][] eye() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/" }, { "http://www.smartbuyglasses.dk/designer-eyeglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug", "smoke" })
    public void eyeGlass(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.header().inputSearch.click();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buyRX, 2);
        gridPage.buyRX.click();
        RX3Page rx3Page = new RX3Page();
        gridPage.getRXType();
        try {
            for (int i = 0; i < 33; i++) {
                driver.findElement(By.className("xubox_shade"));
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(rx3Page.addToCart));
        rx3Page.addToCart.click();
        boolean cart = false;
        if (gridPage.getCartType().equals("old")) {
            cart = true;
        }
        if (gridPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug", "smoke" })
    public void eyeFrame(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.header().inputSearch.click();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buyRX, 2);
        gridPage.frameOrAdd.get(1).click();
        gridPage.waitForVisibility(gridPage.buySun, 2);
        gridPage.buySun.click();
        boolean cart = false;
        if (gridPage.getCartType().equals("old")) {
            cart = true;
        }
        if (gridPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
