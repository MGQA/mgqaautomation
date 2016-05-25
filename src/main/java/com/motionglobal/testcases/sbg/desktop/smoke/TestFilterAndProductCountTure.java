package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestFilterAndProductCountTure extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug", "smoke" })
    public void Search() {
        String url = "http://www.smartbuyglasses.com/search?keywords=burberry&searchHashcode=1463977020526497#q=burberry&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.waitForVisibility(resultPage.filterMen, 2);
        int procuctCount = Integer.parseInt(resultPage.productCount.getText());
        resultPage.filterMen.click();
        resultPage.waitForVisibility(resultPage.filterMenChecked, 10);
        int procuctMenCount = Integer.parseInt(resultPage.productCount.getText());
        Assert.assertNotEquals(procuctCount, procuctMenCount);
        resultPage.waitForVisibility(resultPage.filterWayfarer, 5);
        resultPage.filterWayfarer.click();
        resultPage.waitForVisibility(resultPage.filterWayfarerChecked, 10);
        int procuctWayfarerCount = Integer.parseInt(resultPage.productCount.getText());
        Assert.assertNotEquals(procuctWayfarerCount, procuctMenCount);
    }

    @Test(groups = { "debug", "smoke" })
    public void SunGlass() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/general/-Men----------------------";
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        Assert.assertTrue(gridPage.filterSide.getText().contains("Men"), " fiter fail ");
        Assert.assertTrue(gridPage.proInfo.size() > 0);
        gridPage.waitForVisibility(gridPage.filterArnette, 2);
        gridPage.filterArnette.click();
        Assert.assertTrue(gridPage.proInfo.get(0).getText().contains("Arnette"));
        gridPage.waitForVisibility(gridPage.filterAviator, 5);
        gridPage.JsMouse(gridPage.filterAviator);
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
        gridPage.filterDaily.click();
        gridPage.waitProductChange(productCount);
        gridPage.waitForVisibility(gridPage.filterDaily, 2);
        gridPage.waitForVisibility(gridPage.productCountString, 2);
        String productCountDaily = gridPage.productCountString.getText();
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());
        gridPage.filterSpherical.click();
        gridPage.waitProductChange(productCountDaily);
        Assert.assertEquals(gridPage.ProInfo.size(), gridPage.getProductCount());

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