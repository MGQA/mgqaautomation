package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestClickProduct extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/" }, { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickBrankIntoDetail(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.waitForVisibility(gridPage.brankOneIntoDetail, 5);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(gridPage.brankOneIntoDetail));
        gridPage.deleteHead();
        //
        gridPage.deleteHead();
        gridPage.waitForVisibility(gridPage.proInfo.get(0), 2);
        gridPage.JsMouse(gridPage.proInfo.get(0));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        new Actions(driver).moveToElement(gridPage.proInfo.get(0)).build().perform();
        gridPage.waitForVisibility(gridPage.quickView, 5);
        //
        gridPage.brankOneIntoDetail.click();
        gridPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickDetail(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.deleteHead();
        //
        gridPage.matcherQuickViewClickOpen(1);
        //
        gridPage.waitForVisibility(gridPage.detail, 15);
        gridPage.detail.click();
        gridPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
