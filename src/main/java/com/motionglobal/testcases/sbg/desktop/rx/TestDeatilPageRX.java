package com.motionglobal.testcases.sbg.desktop.rx;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestDeatilPageRX extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" },
                { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunRX(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.header().inputSearch.click();
        detailPage.waitForVisibility(detailPage.btnSunRX, 2);
        detailPage.btnSunRX.click();
        RX3Page rx3Page = new RX3Page();
        detailPage.getRXType();
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
        if (detailPage.getCartType().equals("old")) {
            cart = true;
        }
        if (detailPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");

    }

    @DataProvider
    public Object[][] eye() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" },
                { "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" },
                { "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug", "smoke" })
    public void eyeRX(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.header().inputSearch.click();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 2);
        detailPage.btnBuyNow.click();
        RX3Page rx3Page = new RX3Page();
        detailPage.getRXType();
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
        if (detailPage.getCartType().equals("old")) {
            cart = true;
        }
        if (detailPage.getCartType().equals("new")) {
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
