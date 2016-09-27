package com.motionglobal.testcases.sbg.mobile.product;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestRankPrice extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://m.smartbuyglasses.com/designer-sunglasses/Gucci/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug2", "smoke" })
    public void priceHighToLow(String url) {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.Sort.click();
        productPage.subFilter.get(3).click();
        MobProductPage productPage2 = new MobProductPage();
        //
        for (int i = 0; i < productPage2.priceRegular.size() - 1; i++) {
            productPage2.JsMouse(productPage2.priceRegular.get(i));
            double price1 = productPage2.regexGetDouble(productPage2.priceRegular.get(i).getText());
            productPage2.JsMouse(productPage2.priceRegular.get(i + 1));
            double price2 = productPage2.regexGetDouble(productPage2.priceRegular.get(i + 1).getText());
            Assert.assertTrue(price2 <= price1, "_Rank Price Fail !!!");
        }

    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug2", "smoke" })
    public void priceLowToHigh(String url) {
        getURL(url);
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
