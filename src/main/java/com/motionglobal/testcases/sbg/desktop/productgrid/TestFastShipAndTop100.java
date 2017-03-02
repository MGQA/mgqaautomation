package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestFastShipAndTop100 extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.dk/designer-sunglasses/general/--------------1---------" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/general/---------------1-1-------" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void clickBrankIntoDetail(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
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
        gridPage.waitForVisibility(gridPage.quickView.get(0), 5);
        gridPage.waitForVisibility(gridPage.brankOneIntoDetail, 5);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(gridPage.brankOneIntoDetail));
        //
        String name = gridPage.regexGetLetterLow(gridPage.productDetailName.getText()).replace("sunglasses", "").replace("fast", "").replace("shipping", "")
                .replace("solbrillerhurtiglevering", "");
        gridPage.brankOneIntoDetail.click();
        gridPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText().split(" ")[0] + detailPage.productName.getText().split(" ")[1]
                + detailPage.productName.getText().split(" ")[2]);
        System.out.println(actualName + "\t" + name);
        Assert.assertTrue(name.contains(actualName), "product no't matcher !!!");
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
        String name = gridPage.regexGetLetterLow(gridPage.productDetailName.getText()).replace("sunglasses", "").replace("fast", "").replace("shipping", "")
                .replace("solbrillerhurtiglevering", "");
        String detailName = gridPage.regexGetLetterLow(gridPage.quickViewName.getText());
        // Assert.assertTrue(name.contains(detailName), "quickViewName no't matcher !!!");
        gridPage.detail.click();
        gridPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        System.out.println(actualName + " " + detailName);
        Assert.assertTrue(actualName.contains(detailName), "product no't matcher !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunGlass(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.header().inputSearch.click();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buySun, 15);
        gridPage.buySun.click();
        boolean cart = false;
        if (gridPage.getCartType().equals("old")) {
            cart = true;
        }
        if (gridPage.getCartType().equals("new")) {
            cart = true;
        }
        Assert.assertTrue(cart, " Don't Into Cart Page !!!");
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
