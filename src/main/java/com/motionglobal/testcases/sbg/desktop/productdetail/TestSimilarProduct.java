package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSimilarProduct extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickSimilarProduct(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.deleteHead();
        String productName = detailPage.glassName.getText();
        detailPage.JsMouse(detailPage.similarProduct);
        detailPage.similarProduct.click();
        String similarName = detailPage.glassName.getText();
        Assert.assertNotEquals(similarName, productName);
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickRecommendProduct(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        try {
            detailPage.deleteHead();
        }
        catch (Exception e) {
        }
        String productName = detailPage.glassName.getText();
        detailPage.JsMouse(detailPage.recommendProduct);
        detailPage.recommendProduct.click();
        String similarName = detailPage.glassName.getText();
        Assert.assertNotEquals(similarName, productName);
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
