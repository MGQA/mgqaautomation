package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.CLProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * HK Test £º CL lenseDaily is 18 product
 * 
 */
public class ContactLens extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] daily() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/" }, { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "daily", groups = { "debug", "smoke" })
    public void Daily(String url) {
        int productNum = 18;
        getURL(url);
        // driver.navigate().refresh();
        Menu menu = new Menu();
        menu.mouseOverMainMenu(5);
        menu.dailyglass.click();
        CLProductGridPage productGridPage = new CLProductGridPage();
        // List<WebElement> dailyglassEles = driver.findElements(By.className("pho"));
        productGridPage.waitForVisibility(productGridPage.product1, 10);
        Assert.assertEquals(productGridPage.lenseDailyEles.size(), productNum, "daily contact lens count : disagree");
        // System.out.println(header.dailyglassEles.size());
    }

    @DataProvider
    public Object[][] db() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/contact-lenses/f/daily-disposable-lenses#!&s=popularity&tb=0&f=daily-disposable-lenses&p=1" },
                { "http://www.smartbuyglasses.dk/kontaktlinser/f/endagslinser#!&s=popularitet&tb=0&f=endagslinser&p=1" },
                { "http://www.smartbuyglasses.com/contact-lenses/f/daily-disposable-lenses#!&s=popularity&tb=0&f=daily-disposable-lenses&p=1" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void DailyDisplay(String url) {
        int productNum = 18;
        getURL(url);
        CLProductGridPage productGridPage = new CLProductGridPage();
        productGridPage.waitForVisibility(productGridPage.product1, 10);
        Assert.assertEquals(productGridPage.lenseDailyEles.size(), productNum, "daily contact lens count : disagree");
    }

    // XXX
    @DataProvider
    public Object[][] acuvue() {
        return new Object[][] { { "http://www.smartbuyglasses.dk/kontaktlinser/b/Acuvue#!&s=popularitet&tb=0&b=Acuvue&p=1" },
                { "http://www.smartbuyglasses.co.uk/contact-lenses/b/Acuvue#!&s=popularity&tb=0&b=Acuvue&p=1" },
                { "http://www.smartbuyglasses.com/contact-lenses/b/Acuvue#!&s=popularity&tb=0&b=Acuvue&p=1" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "acuvue", groups = { "debug", "smoke" })
    public void AcuvueDisplay(String url) {
        int productNum = 4;
        getURL(url);
        CLProductGridPage productGridPage = new CLProductGridPage();
        productGridPage.waitForVisibility(productGridPage.product1, 10);
        Assert.assertTrue(productGridPage.lenseDailyEles.size() > productNum, "daily contact lens count : disagree");
    }

    //
    @Test(skipFailedInvocations = true, dataProvider = "acuvue", groups = { "debug", "smoke" })
    public void AcuvueIntoDetail(String url) {
        getURL(url);
        CLProductGridPage productGridPage = new CLProductGridPage();
        new Header().inputSearch.click();
        productGridPage.waitForVisibility(productGridPage.product1, 10);
        String name = productGridPage.regexGetLetterLow(productGridPage.productDetailName.getText());
        productGridPage.product1.click();
        CLProductDetailPage detailPage = new CLProductDetailPage();
        String actual = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actual.contains(name), "Product no't matcher !!!");
    }

    // XXX
    @DataProvider
    public Object[][] search() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/search?keywords=acuvue&searchHashcode=1476345019340715#q=acuvue&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.com/search?keywords=acuvue&searchHashcode=147634513217983#q=acuvue&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" },
                { "http://www.smartbuyglasses.dk/search?keywords=acuvue&searchHashcode=1476345029221176#q=acuvue&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "search", groups = { "debug", "smoke" })
    public void searchIntoDetail(String url) {
        getURL(url);
        SearchResultPage resultPage = new SearchResultPage();
        new Header().inputSearch.click();
        resultPage.waitForVisibility(resultPage.bandNameDetail, 5);
        Assert.assertTrue(resultPage.proInfo.size() > 4, "daily contact lens Number <5");
        String name = resultPage.regexGetLetterLow(resultPage.bandNameDetail.getText());
        resultPage.brandName.click();
        CLProductDetailPage detailPage = new CLProductDetailPage();
        String actual = detailPage.regexGetLetterLow(detailPage.productName.getText());
        Assert.assertTrue(actual.contains(name), "Product no't matcher !!!");
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
