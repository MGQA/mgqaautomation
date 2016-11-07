package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestBuyNoRX extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" },
                { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    @DataProvider
    public Object[][] eye() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" },
                { "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void buySun(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.header().inputSearch.click();
        detailPage.deleteHead();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();
        boolean cart = false;
        if (detailPage.getCartType().equals("old")) {
            cart = true;
        }
        if (detailPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug", "smoke" })
    public void buyEye(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.header().inputSearch.click();
        detailPage.deleteHead();
        detailPage.waitForVisibility(detailPage.btnFrameOnly, 5);
        detailPage.btnFrameOnly.click();
        detailPage.btnBuyNow.click();
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
        // TODO Auto-generated method stub

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
