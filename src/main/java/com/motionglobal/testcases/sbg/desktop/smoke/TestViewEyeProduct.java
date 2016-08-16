package com.motionglobal.testcases.sbg.desktop.smoke;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.BuyNowPage;
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
        header.mouseOver(productGridPage.proInfo.get(0));
        productGridPage.quickView.click();
        waitSize(productGridPage.eyeproSize);
        productGridPage.eyeproSize.get(1).click();
        Assert.assertTrue(productGridPage.sizeClicked.isDisplayed(), "size button don't click");
        productGridPage.eyeproSize.get(0).click();
        Assert.assertTrue(productGridPage.sizeClicked.isDisplayed(), "size button don't click");
        productGridPage.frameOrAdd.get(1).click();
        Assert.assertTrue(productGridPage.frameOrAddClicked.isDisplayed(), "Frame with Lenses button don't click");
        productGridPage.frameOrAdd.get(0).click();
        Assert.assertTrue(productGridPage.frameOrAddClicked.isDisplayed(), "Frame Only button don't click");
        header.waitForVisibility(productGridPage.buyNowButton, 2);
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(productGridPage.buyNowButton));
        productGridPage.buyNowButton.click();
        try {
            // new RX
            header.waitForVisibility(productGridPage.cartBtn, 2);
        }
        catch (Exception e) {
            // old RX
            BuyNowPage buyNowPage = new BuyNowPage();
        }
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
        searchResultPage.mouseOver(searchResultPage.proInfo.get(0));
        searchResultPage.waitForVisibility(searchResultPage.quickView, 5);
        searchResultPage.quickView.click();
        //
        waitSize(searchResultPage.eyeproSize);
        searchResultPage.eyeproSize.get(1).click();
        Assert.assertTrue(searchResultPage.sizeClicked.isDisplayed(), "size button don't click");
        searchResultPage.eyeproSize.get(0).click();
        Assert.assertTrue(searchResultPage.sizeClicked.isDisplayed(), "size button don't click");
        searchResultPage.frameOrAdd.get(1).click();
        Assert.assertTrue(searchResultPage.frameOrAddClicked.isDisplayed(), "Frame with Lenses button don't click");
        searchResultPage.frameOrAdd.get(0).click();
        Assert.assertTrue(searchResultPage.frameOrAddClicked.isDisplayed(), "Frame Only button don't click");
        searchResultPage.waitForVisibility(searchResultPage.buyNowButton, 2);
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(searchResultPage.buyNowButton));
        searchResultPage.buyNowButton.click();
        try {
            searchResultPage.waitForVisibility(searchResultPage.carBtn, 2);
            searchResultPage.carBtn.click();
        }
        catch (Exception e) {
            BuyNowPage buyNowPage = new BuyNowPage();
        }
    }

    private void waitSize(List<WebElement> element) {
        for (int i = 0; i < 50; i++) {
            if (element.size() <= 1) {
                try {
                    Thread.sleep(100);
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
