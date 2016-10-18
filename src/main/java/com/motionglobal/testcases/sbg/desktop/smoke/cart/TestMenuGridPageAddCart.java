package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestMenuGridPageAddCart extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/" }, { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void quickViewBuyNow(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.header().inputSearch.click();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buyNowSun, 2);
        gridPage.buyNowSun.click();
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
