package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestProductMultiAngleIcon extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickLeftIcon(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        String src1 = detailPage.displayIcon.getAttribute("src");
        detailPage.clickIcon(1);
        String src2 = detailPage.displayIcon.getAttribute("src");
        Assert.assertNotEquals(src1, src2);
        detailPage.clickIcon(0);
        String src3 = detailPage.displayIcon.getAttribute("src");
        Assert.assertEquals(src3, src1);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
