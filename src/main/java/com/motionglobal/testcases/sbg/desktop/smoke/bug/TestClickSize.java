package com.motionglobal.testcases.sbg.desktop.smoke.bug;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestClickSize extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB3016-Clubmaster-W0365-52167.html" } };
    }

    /**
     * a BUG is double click size,then price will change
     */
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void doubleClickSize(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.deleteHead();
        double price1 = detailPage.regexGetDouble(detailPage.price.getText());
        detailPage.clickSizeNum(0);
        double price2 = detailPage.regexGetDouble(detailPage.price.getText());
        Assert.assertEquals(price2, price1);
        detailPage.clickSizeNum(0);
        double price3 = detailPage.regexGetDouble(detailPage.price.getText());
        Assert.assertEquals(price3, price2);
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
