package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestProductSize extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB3016-Clubmaster-W0365-52167.html" } };
    }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void changeSize(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.deleteHead();
        detailPage.deleteLetTalk();
        double price1 = detailPage.regexGetDouble(detailPage.price.getText());
        detailPage.clickSizeNum(1);
        double price2 = detailPage.regexGetDouble(detailPage.price.getText());
        Assert.assertEquals(price2, price1);
        detailPage.clickSizeNum(0);
        double price3 = detailPage.regexGetDouble(detailPage.price.getText());
        Assert.assertEquals(price3, price2);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
