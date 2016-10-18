package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestQuickView extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void changeProductDetail(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.deleteHead();
        gridPage.waitForVisibility(gridPage.proInfo.get(0), 2);
        gridPage.JsMouse(gridPage.proInfo.get(0));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        new Actions(driver).moveToElement(gridPage.proInfo.get(0)).build().perform();
        gridPage.waitForVisibility(gridPage.quickView.get(0), 5);
        gridPage.quickView.get(0).click();
        gridPage.waitForVisibility(gridPage.eyeproSize, 10);
        //
        gridPage.waitForVisibility(gridPage.proInfo.get(1), 2);
        gridPage.JsMouse(gridPage.proInfo.get(1));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        new Actions(driver).moveToElement(gridPage.proInfo.get(1)).build().perform();
        gridPage.waitForVisibility(gridPage.quickView.get(0), 5);
        gridPage.quickView.get(0).click();
        gridPage.waitForVisibility(gridPage.eyeproSize, 10);
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
