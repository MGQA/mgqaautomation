package com.motionglobal.testcases.sbg.mobile.deals;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestDeals extends AbstractBaseTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[]
        // { "http://m.smartbuyglasses.com/" },
        { "http://m.smartbuyglasses.dk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void sunDetail(String url) throws InterruptedException {
        getURL(url);

        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.getMainMenuElement(MegaMenu.DEALS).click();
        header.elementClick(header.subMenuS.get(0));
        // header.subMenuS.get(0).click();
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.productName1, 5);
        productPage.filter.click();
        productPage.subFilter.get(3).click();
        productPage.finalFilter.get(3).click();
        MobProductPage productPage2 = new MobProductPage();
        productPage2.waitForVisibility(productPage2.productName1, 5);
        double price1 = productPage2.regexGetDouble(productPage2.productPrice.get(0).getText());
        productPage2.productDeatilName1.click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        double price2 = detailPage.regexGetDouble(detailPage.price.getText());
        Assert.assertEquals(price1, price2);
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void eyeDetail(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.getMainMenuElement(MegaMenu.DEALS).click();
        header.elementClick(header.subMenuS.get(1));
        // header.subMenuS.get(1).click();
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.productName1, 5);
        productPage.filter.click();
        productPage.subFilter.get(3).click();
        productPage.finalFilter.get(3).click();
        MobProductPage productPage2 = new MobProductPage();
        productPage2.waitForVisibility(productPage2.productName1, 5);
        double price1 = productPage2.regexGetDouble(productPage2.productPrice.get(0).getText());
        productPage2.productDeatilName1.click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        double price2 = detailPage.regexGetDouble(detailPage.price.getText());
        Assert.assertEquals(price1, price2);
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
