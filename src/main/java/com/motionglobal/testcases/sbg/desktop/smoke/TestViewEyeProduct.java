package com.motionglobal.testcases.sbg.desktop.smoke;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * au Test £º product size clickable
 * 
 */
public class TestViewEyeProduct extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/" } };
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void clickBrank(String url) {
        getURL(url);
        Header header = new Header();
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.matcherQuickViewSize2();
        waitSize(productGridPage.eyeproSize);
        productGridPage.eyeproSize.get(1).click();
        Assert.assertTrue(productGridPage.sizeClicked.isDisplayed(), "size button don't click");
        productGridPage.waitShadow();
        productGridPage.eyeproSize.get(0).click();
        Assert.assertTrue(productGridPage.sizeClicked.isDisplayed(), "size button don't click");
        productGridPage.waitShadow();
        productGridPage.frameOrAdd.get(1).click();
        Assert.assertTrue(productGridPage.frameOrAddClicked.isDisplayed(), "Frame with Lenses button don't click");
        productGridPage.waitShadow();
        productGridPage.frameOrAdd.get(0).click();
        Assert.assertTrue(productGridPage.frameOrAddClicked.isDisplayed(), "Frame Only button don't click");
        header.waitForVisibility(productGridPage.buyRX, 2);
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(productGridPage.buyRX));
        productGridPage.buyRX.click();
        Assert.assertFalse(productGridPage.getRXType().contains("empty"), "Don't Into RX !!");
    }

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void searchPro() {
        String url = "http://www.smartbuyglasses.com/search?keywords=Tom+Ford+FT5146+003&searchHashcode=1471256007793346#q=Tom%20Ford%20FT5146%20003&page=0&minReviewsCount=0&refinements=[{%22for_sale%22%3A%221%22}]";
        getURL(url);
        String searchContent = "Tom Ford FT5146 003";
        SearchResultPage searchResultPage = new SearchResultPage();
        String Band = searchResultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(searchContent.contains(Band), "Expected product displayed");
        //
        searchResultPage.matcherQuickViewClickOpen(1);
        //
        waitSize(searchResultPage.eyeproSize);
        searchResultPage.eyeproSize.get(1).click();
        Assert.assertTrue(searchResultPage.sizeClicked.isDisplayed(), "size button don't click");
        searchResultPage.waitShadow();
        searchResultPage.eyeproSize.get(0).click();
        Assert.assertTrue(searchResultPage.sizeClicked.isDisplayed(), "size button don't click");
        searchResultPage.waitShadow();
        searchResultPage.frameOrAdd.get(1).click();
        Assert.assertTrue(searchResultPage.frameOrAddClicked.isDisplayed(), "Frame with Lenses button don't click");
        searchResultPage.waitShadow();
        searchResultPage.frameOrAdd.get(0).click();
        Assert.assertTrue(searchResultPage.frameOrAddClicked.isDisplayed(), "Frame Only button don't click");
        searchResultPage.waitForVisibility(searchResultPage.buyRX, 2);
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(searchResultPage.buyRX));
        searchResultPage.buyRX.click();
        searchResultPage.getRXType();
    }

    private void waitSize(List<WebElement> element) {
        for (int i = 0; i < 100; i++) {
            if (element.size() <= 1) {
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                }
            }
            else
                break;
        }
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
