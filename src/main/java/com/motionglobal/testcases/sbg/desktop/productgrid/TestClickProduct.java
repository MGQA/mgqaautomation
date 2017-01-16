package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestClickProduct extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/" } };
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
                .replace("solbrillerhurtiglevering", "").substring(15);
        gridPage.brankOneIntoDetail.click();
        gridPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        System.out.println(actualName + "\t" + name);
        Assert.assertTrue(actualName.contains(name), "product no't matcher !!!");
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
                .replace("solbrillerhurtiglevering", "").substring(15);
        String detailName = gridPage.regexGetLetterLow(gridPage.quickViewName.getText());
        Assert.assertEquals(name, detailName, "quickViewName no't matcher !!!");
        gridPage.detail.click();
        gridPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actualName.contains(name), "product no't matcher !!!");
    }

    // XXX
    @DataProvider
    public Object[][] search() {
        return new Object[][] {

                { "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1476413355517711#q=rayan&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.dk/search?keywords=rayban&searchHashcode=1476413327702233#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "search", groups = { "debug", "smoke" })
    public void searchClickBrankIntoDetail(String url) {
        getURL(url);
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.header().inputSearch.click();
        //
        searchPage.deleteHead();
        searchPage.waitForVisibility(searchPage.proInfo.get(0), 2);
        searchPage.JsMouse(searchPage.proInfo.get(0));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        new Actions(driver).moveToElement(searchPage.proInfo.get(0)).build().perform();
        searchPage.waitForVisibility(searchPage.productDetailName, 5);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(searchPage.productDetailName));
        //
        String name = searchPage.regexGetLetterLow(searchPage.productDetailName.getText());
        searchPage.productDetailName.click();
        searchPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertEquals(actualName, name, "product no't matcher !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "search", groups = { "debug", "smoke" })
    public void searchClickDetail(String url) {
        getURL(url);
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.header().inputSearch.click();
        searchPage.deleteHead();
        //
        searchPage.matcherQuickViewClickOpen(1);
        //
        searchPage.waitForVisibility(searchPage.detailBtn, 15);
        String name = searchPage.regexGetLetterLow(searchPage.productDetailName.getText());
        String detailName = searchPage.regexGetLetterLow(searchPage.quickViewName.getText());
        Assert.assertTrue(name.contains(detailName), "quickViewName no't matcher !!!");
        searchPage.detailBtn.click();
        searchPage.acceptAlert();
        ProductDetailPage detailPage = new ProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertEquals(actualName, name, "product no't matcher !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
