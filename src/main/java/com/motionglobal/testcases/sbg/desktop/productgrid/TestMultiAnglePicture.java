package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestMultiAnglePicture extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "" } };
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void SearchThenQuickviewPicture() {
        String url = "http://www.smartbuyglasses.com/search?keywords=Ray-Ban+RB4165+Justin&searchHashcode=1475983407082593#q=Ray-Ban%20RB4165%20Justin&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.matcherQuickViewClickOpen(1);
        resultPage.waitForVisibility(resultPage.quickViewMainPicture, 15);
        String img1 = resultPage.quickViewMainPicture.getAttribute("src");
        resultPage.deleteHead();
        resultPage.JsMouse(resultPage.multiPucture.get(1));
        resultPage.multiPucture.get(1).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(resultPage.quickViewMainPicture, "src", img1)));
        System.out.println(resultPage.quickViewMainPicture.getAttribute("src"));
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void naviMenuThenQuickViewPicture() {
        String url = "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/";
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.quickViewMainPicture, 15);
        String img1 = gridPage.quickViewMainPicture.getAttribute("src");
        gridPage.deleteHead();
        gridPage.JsMouse(gridPage.multiPucture.get(1));
        gridPage.multiPucture.get(1).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(gridPage.quickViewMainPicture, "src", img1)));
        System.out.println(gridPage.quickViewMainPicture.getAttribute("src"));
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
