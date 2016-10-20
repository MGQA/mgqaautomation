package com.motionglobal.testcases.sbg.desktop.rx;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
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
        boolean rx = false;
        if (detailPage.getRXType().equals("old")) {
            rx = true;
        }
        if (detailPage.getRXType().equals("new")) {
            rx = true;
        }
        Assert.assertTrue(rx, " Don't Into RX Page !!!");
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }

}
