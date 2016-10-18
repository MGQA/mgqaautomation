package com.motionglobal.testcases.sbg.desktop.productgrid;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSimilarProduct extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { {} };
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
        resultPage.JsMouse(resultPage.multiColor);
        resultPage.multiColor.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(resultPage.quickViewMainPicture, "src", img1)));
        String img2 = resultPage.quickViewMainPicture.getAttribute("src");
        resultPage.detailBtn.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        String img3 = detailPage.displayIcon.getAttribute("src");
        Assert.assertEquals(img2, img3);
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
