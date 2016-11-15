package com.motionglobal.testcases.sbg.desktop.deals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestIntoDeals extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.dk/" }, { "http://www.smartbuyglasses.com/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunDeals(String url) {
        getURL(url);
        Menu menu = new Menu();
        menu.inputSearch.click();
        menu.displayMenu(7);
        menu.dealSunGlass.click();
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.waitForVisibility(gridPage.productDetailName, 2);
        String currentUrl = gridPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("on-sale"));
        menu.deleteHead();
        String price1 = String.valueOf(gridPage.regexGetDouble(gridPage.productPriceS.get(0).getText()));
        gridPage.productDetailName.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        String price2 = String.valueOf(detailPage.regexGetDouble(detailPage.price.getText()));
        Assert.assertTrue(price1.contains(price2));
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void eyeDeals(String url) {
        getURL(url);
        Menu menu = new Menu();
        menu.inputSearch.click();
        menu.displayMenu(7);
        menu.dealEyeGlass.click();
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.waitForVisibility(gridPage.productDetailName, 2);
        String currentUrl = gridPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("on-sale"));
        menu.deleteHead();
        String price1 = String.valueOf(gridPage.regexGetDouble(gridPage.productPriceS.get(0).getText()));
        gridPage.productDetailName.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        String price2 = String.valueOf(detailPage.regexGetDouble(detailPage.price.getText()));
        Assert.assertTrue(price1.contains(price2));
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
