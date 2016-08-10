package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test : Filter product
 * 
 */
public class TestFilterAndProductCountTure extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke" })
    public void algoliaGenderAndFrame() {
        String url = "http://www.smartbuyglasses.com/search?keywords=burberry&searchHashcode=1463977020526497#q=burberry&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.filterMen, 2);
        int procuctCount = Integer.parseInt(resultPage.productCount.getText());
        try {
            resultPage.deleteHead();
            resultPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        resultPage.filterMen.click();
        resultPage.waitForVisibility(resultPage.filterMenChecked, 10);
        int procuctMenCount = Integer.parseInt(resultPage.productCount.getText());
        Assert.assertNotEquals(procuctCount, procuctMenCount);
        resultPage.waitForVisibility(resultPage.filterWayfarer, 5);
        resultPage.waitForVisibility(resultPage.filterWayfarer, 3);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(resultPage.filterWayfarer));
        try {
            resultPage.deleteHead();
            resultPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        resultPage.filterWayfarer.click();
        resultPage.waitForVisibility(resultPage.filterWayfarerChecked, 10);
        int procuctWayfarerCount = Integer.parseInt(resultPage.productCount.getText());
        Assert.assertNotEquals(procuctWayfarerCount, procuctMenCount);
    }

    @Test(groups = { "debug", "smoke" })
    public void SunGlass() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/general/-Men----------------------";
        getURL(url);
        driver.manage().window().maximize();
        ProductGridPage gridPage = new ProductGridPage();
        Assert.assertTrue(gridPage.filterSide.getText().contains("Men"), " fiter fail ");
        Assert.assertTrue(gridPage.proInfo.size() > 0);
        gridPage.waitForVisibility(gridPage.filterArnette, 2);
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.filterArnette.click();
        Assert.assertTrue(gridPage.proInfo.get(0).getText().contains("Arnette"));
        gridPage.waitForVisibility(gridPage.filterAviator, 5);
        // gridPage.JsMouse(gridPage.filterWayfarer);
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.filterAviator.click();
        Assert.assertTrue(gridPage.filterSide.getText().contains("Aviator"), " fiter fail ");
    }

    @Test(groups = { "debug", "smoke" })
    public void CL() {
        String url = "http://www.smartbuyglasses.com/contact-lenses/b/Acuvue#!&s=popularity&tb=0&b=Acuvue&p=1";
        getURL(url);
        CLProductGridPage gridPage = new CLProductGridPage();
        Assert.assertEquals(gridPage.checkedLeftSubmenuElement.getText(), "Acuvue");
        gridPage.waitForVisibility(gridPage.filterDaily, 2);
        gridPage.waitForVisibility(gridPage.productCountString, 2);
        String productCount = gridPage.productCountString.getText();
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.filterDaily.click();
        gridPage.waitProductChange(productCount);
        gridPage.waitForVisibility(gridPage.filterDaily, 2);
        gridPage.waitForVisibility(gridPage.productCountString, 2);
        String productCountDaily = gridPage.productCountString.getText();
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.filterSpherical.click();
        gridPage.waitProductChange(productCountDaily);
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());

    }

    @Test(groups = { "debug", "smoke" })
    public void frameType() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/";
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.waitForVisibility(gridPage.filterFrameType, 5);
        // gridPage.filterFrameType.click();
        gridPage.click(gridPage.filterFrameType);
        gridPage.waitForVisibility(gridPage.filterSide, 5);
        String currentUrl = gridPage.getCurrentUrl();
        gridPage.AsssetTrue(gridPage.filterSide.getText().contains("Frame Type: Full Rim"), " Full Rim Page Ture");
        gridPage.AsssetEquals(currentUrl, "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/--Full%20Rim----------------");
    }

    @Test(groups = { "debug", "smoke" })
    public void priceSort() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/";
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.waitForVisibility(gridPage.filterFrameType, 5);
        gridPage.filterPriceNo2.click();
        gridPage.waitForVisibility(gridPage.productPriceS, 5);
        for (int j = 0; j < gridPage.productPriceS.size(); j++) {
            Double price = gridPage.regexGetMath(gridPage.productPriceS.get(j).getText());
            gridPage.AsssetTrue(100 <= price && 150 >= price, " PRICE IS " + price + " NOT BELONG 100-150 !!!");
        }
        //
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.waitForVisibility(gridPage.filterFrameType, 5);
        gridPage.filterPriceNo3.click();
        gridPage.waitForVisibility(gridPage.productPriceS, 5);
        for (int j = 0; j < gridPage.productPriceS.size(); j++) {
            Double price = gridPage.regexGetMath(gridPage.productPriceS.get(j).getText());
            gridPage.AsssetTrue(150 <= price && 200 >= price, " PRICE IS " + price + " NOT BELONG 150-200 !!!");
        }
    }

    // FIXME algolia
    @Test(groups = { "debug", "smoke" })
    public void algoliaEyeOrSun() {
        String url = "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1470715095524430#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.filterGlasses, 5);
        resultPage.filterGlasses.get(0).click();
        driver.navigate().refresh();
        resultPage.waitForVisibility(resultPage.filterEyeChecked, 10);
        resultPage.waitForVisibility(resultPage.proInfo, 5);
        for (int i = 0; i < resultPage.proInfo.size(); i++) {
            String cid = resultPage.proInfo.get(i).getAttribute("data-cid");
            resultPage.AsssetEquals(cid, "2");
        }
        getURL(url);
        resultPage.waitForVisibility(resultPage.filterGlasses, 5);
        resultPage.filterGlasses.get(1).click();
        resultPage.waitForVisibility(resultPage.filterSunCkecked, 5);
        resultPage.waitForVisibility(resultPage.proInfo, 5);
        for (int i = 0; i < resultPage.proInfo.size(); i++) {
            String cid = resultPage.proInfo.get(i).getAttribute("data-cid");
            resultPage.AsssetEquals(cid, "1");
        }
    }

    @Test(groups = { "debug", "smoke" })
    public void algoliaFeature() {
        String url = "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1470715095524430#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        try {
            resultPage.deleteHead();
            resultPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        resultPage.waitForVisibility(resultPage.filterFeature, 5);
        resultPage.filterFeature.get(1).click();
        resultPage.waitForVisibility(resultPage.filterFeatureChecked, 10);
        Assert.assertEquals(resultPage.filterFeature.get(1).getAttribute("class"), "refined list-group-item");
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
