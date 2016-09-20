package com.motionglobal.testcases.sbg.desktop.smoke.bug;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Test2BuyNowBtn extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { {} };
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke", "fastsmoke" })
    public void buyNow() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/Carrera/Carrera-INTERCHANGEABLE-5022COV-D28-293188.html/";
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.BUG2BuyNow, 5);
        System.out.println(detailPage.BUG2BuyNow.size());
        Assert.assertEquals(detailPage.BUG2BuyNow.size(), 1);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
