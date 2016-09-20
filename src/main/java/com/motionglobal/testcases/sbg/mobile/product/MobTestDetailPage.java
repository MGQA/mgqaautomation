package com.motionglobal.testcases.sbg.mobile.product;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestDetailPage extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void clickSimilarProduct(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        String productName = detailPage.productName.getText();
        detailPage.JsMouse(detailPage.similarProduct);
        detailPage.similarProduct.click();
        String similarName = detailPage.productName.getText();
        Assert.assertNotEquals(similarName, productName);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }
}
