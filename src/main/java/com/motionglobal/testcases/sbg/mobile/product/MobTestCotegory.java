package com.motionglobal.testcases.sbg.mobile.product;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.search.MobSearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestCotegory extends AbstractBaseTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[] { "http://m.smartbuyglasses.co.uk/search?keywords=rayban&searchHashcode=147692997945955#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}%2C{%22category%22%3A%22Eyeglasses%22}]" },
                { "http://m.smartbuyglasses.com/search?keywords=rayban&searchHashcode=147692997945955#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void bebeClickText(String url) throws InterruptedException {
        getURL(url);
        MobSearchResultPage searchPage = new MobSearchResultPage();
        searchPage.waitForVisibility(searchPage.productDetailName, 5);
        searchPage.category.get(1).click();
        searchPage.waitForVisibility(searchPage.categoryChecked, 5);
        int eyeNum = searchPage.eyeGlass.size();
        Assert.assertEquals(eyeNum, 20);
        //
        searchPage.category.get(1).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.attributeToBe(searchPage.category.get(1), "class", "current")));
        searchPage.category.get(0).click();
        searchPage.waitForVisibility(searchPage.categoryChecked, 5);
        int sunNum = searchPage.sunGlass.size();
        Assert.assertEquals(sunNum, 20);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }
}
