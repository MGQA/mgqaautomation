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
        resultPage.deleteHead();
        String brand4 = resultPage.brand4.getText();
        resultPage.filterMen.click();
        resultPage.waitForVisibility(resultPage.filterMenChecked, 10);
        int procuctMenCount = Integer.parseInt(resultPage.productCount.getText());
        Assert.assertNotEquals(procuctCount, procuctMenCount);
        resultPage.waitForVisibility(resultPage.filterWayfarer, 10);
        resultPage.deleteHead();
        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(resultPage.brand4, brand4)));
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
        gridPage.deleteHead();
        gridPage.filterArnette.click();
        Assert.assertTrue(gridPage.proInfo.get(0).getText().contains("Arnette"));
        gridPage.waitForVisibility(gridPage.shapesMostPopular, 5);
        // gridPage.JsMouse(gridPage.shapesMostPopular);
        gridPage.deleteHead();
        String type = gridPage.shapesMostPopular.getText();
        gridPage.shapesMostPopular.click();
        Assert.assertTrue(gridPage.filterSide.getText().contains(type), " fiter fail ");
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
        gridPage.deleteHead();
        gridPage.filterDaily.click();
        gridPage.waitProductChange(productCount);
        gridPage.waitForVisibility(gridPage.filterDaily, 2);
        gridPage.waitForVisibility(gridPage.productCountString, 2);
        String productCountDaily = gridPage.productCountString.getText();
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());
        gridPage.deleteHead();
        gridPage.filterSpherical.click();
        gridPage.waitProductChange(productCountDaily);
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());

    }

    @Test(groups = { "debug", "smoke" })
    public void frameType() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/";
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.deleteHead();
        gridPage.waitForVisibility(gridPage.filterFrameType, 5);
        gridPage.JsMouse(gridPage.filterFrameType);
        gridPage.filterFrameType.click();
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
        gridPage.deleteHead();
        gridPage.waitForVisibility(gridPage.filterFrameType, 5);
        gridPage.JsMouse(gridPage.filterPriceNo2);
        gridPage.filterPriceNo2.click();
        gridPage.waitForVisibility(gridPage.productPriceS, 5);
        for (int j = 0; j < gridPage.productPriceS.size(); j++) {
            Double price = gridPage.regexGetDouble(gridPage.productPriceS.get(j).getText());
            gridPage.AsssetTrue(100 <= price && 150 >= price, " PRICE IS " + price + " NOT BELONG 100-150 !!!");
        }
        //
        gridPage.deleteHead();
        gridPage.waitForVisibility(gridPage.filterFrameType, 5);
        gridPage.JsMouse(gridPage.filterPriceNo3);
        gridPage.filterPriceNo3.click();
        gridPage.waitForVisibility(gridPage.productPriceS, 5);
        for (int j = 0; j < gridPage.productPriceS.size(); j++) {
            Double price = gridPage.regexGetDouble(gridPage.productPriceS.get(j).getText());
            gridPage.AsssetTrue(150 <= price && 200 >= price, " PRICE IS " + price + " NOT BELONG 150-200 !!!");
        }
    }

    // FIXME algolia
    @Test(groups = { "debug", "smoke" })
    public void algoliaEye() {
        String url = "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1470715095524430#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        driver.navigate().refresh();
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.filterEye, 5);
        resultPage.filterEye.click();
        resultPage.waitForVisibility(resultPage.filterGlassChecked, 10);
        resultPage.waitForVisibility(resultPage.proInfo, 5);
        for (int i = 0; i < resultPage.proInfo.size(); i++) {
            String cid = resultPage.proInfo.get(i).getAttribute("data-cid");
            resultPage.AsssetEquals(cid, "2");
        }
    }

    @Test(groups = { "debug", "smoke" })
    public void algoliaSun() {
        String url = "http://www.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1470715095524430#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        driver.navigate().refresh();
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.filterSun, 5);
        resultPage.filterSun.click();
        resultPage.waitForVisibility(resultPage.filterGlassChecked, 5);
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
        resultPage.deleteHead();
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
