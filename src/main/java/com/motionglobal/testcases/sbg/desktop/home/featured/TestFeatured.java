package com.motionglobal.testcases.sbg.desktop.home.featured;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.AllProduct;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestFeatured extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "https://www.smartbuyglasses.co.uk/" }, { "https://www.smartbuyglasses.dk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void viewSun(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.click();
        String expectedUrl = url + "designer-sunglasses.htm";
        homePage.deleteHead();
        homePage.waitForVisibility(homePage.linkViewSun, 5);
        homePage.linkViewSun.click();

        // all product page
        AllProduct allProduct = new AllProduct();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        allProduct.waitForVisibility(allProduct.linkBrand.get(0), 5);
        Assert.assertTrue(allProduct.linkBrand.size() > 100);
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke" })
    public void viewEye(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.click();
        String expectedUrl = url + "designer-eyeglasses.htm";
        homePage.deleteHead();
        homePage.waitForVisibility(homePage.linkViewEye, 5);
        homePage.linkViewEye.click();

        // all product page
        AllProduct allProduct = new AllProduct();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        allProduct.waitForVisibility(allProduct.linkBrand.get(0), 5);
        Assert.assertTrue(allProduct.linkBrand.size() > 100);
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
