package com.motionglobal.testcases.sbg.mobile.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.pages.sbg.mobile.search.MobSearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestGridIntoDetail extends AbstractBaseSbgDesktopTestCase {
    // XXX
    @DataProvider
    public Object[][] search() {
        return new Object[][] {
                new Object[] { "http://m.smartbuyglasses.co.uk/search?keywords=rayban&searchHashcode=1476408471921291#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://m.smartbuyglasses.com/search?keywords=rayban&searchHashcode=1476408574091680#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://m.smartbuyglasses.dk/search?keywords=rayban&searchHashcode=1476408564513987#q=rayban&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "search", groups = { "debug2", "smoke" })
    public void intoDetail(String url) {
        getURL(url);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
        Assert.assertTrue(searchResultPage.productName.size() > 4, "product number <5");
        String detailName = searchResultPage.regexGetLetterLow(searchResultPage.productDetailName.getText());
        searchResultPage.productName.get(0).click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actualName.contains(detailName), " product name no't matcher !!!");
    }

    @DataProvider
    public Object[][] searchCL() {
        return new Object[][] {
                new Object[] { "http://m.smartbuyglasses.co.uk/search?keywords=acuvue&searchHashcode=147640906803966#q=acuvue&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://m.smartbuyglasses.com/search?keywords=acuvue&searchHashcode=1476409072440221#q=acuvue&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://m.smartbuyglasses.dk/search?keywords=acuvue&searchHashcode=1476409076357190#q=acuvue&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "searchCL", groups = { "debug", "smoke" })
    public void CLDetail(String url) {
        getURL(url);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Acuvue"), "Expected Ray-ban displayed, but no");
        Assert.assertTrue(searchResultPage.productName.size() > 4, "product number <5");
        String detailName = searchResultPage.regexGetLetterLow(searchResultPage.productDetailName.getText());
        searchResultPage.productName.get(0).click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actualName.contains(detailName), " product name no't matcher !!!");
    }

    @DataProvider
    public Object[][] rayban() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" },
                { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/" }, { "http://m.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "rayban", groups = { "debug", "smoke" })
    public void raybanIntoDetail(String url) {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.productName1, 5);
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
        String name = productPage.regexGetLetterLow(productPage.productDeatilName1.getText());
        productPage.productName1.click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actualName.contains(name), " product no't matcher !!!");
    }

    @DataProvider
    public Object[][] acuvue() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk/contact-lenses/b/Acuvue" },
                { "http://m.smartbuyglasses.com/contact-lenses/b/Acuvue" }, { "http://m.smartbuyglasses.dk/kontaktlinser/b/Acuvue" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "acuvue", groups = { "debug", "smoke" })
    public void acuvueIntoDetail(String url) {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.productDeatilName1, 5);
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
        String name = productPage.regexGetLetterLow(productPage.productDeatilName1.getText());
        productPage.productDeatilName1.click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        String actualName = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actualName.contains(name), " product no't matcher !!!");
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }

}
