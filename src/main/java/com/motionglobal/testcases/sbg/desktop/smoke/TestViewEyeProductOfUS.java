package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage.Label;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestViewEyeProductOfUS extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com/" } };
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void clickBrank(String url) {
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(2);
        header.mouseOver(header.getMegaMenuBrandInitialElement(2, "Q"));
        header.TomFordBrank.click();
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.brands).getText(), "Tom Ford");
        header.mouseOver(productGridPage.proInfo.get(0));
        productGridPage.quickView.click();
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
        header.waitForVisibility(productGridPage.cartBtn, 2);
        productGridPage.cartBtn.click();
        CartPage cartPage = new CartPage();
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void searchPro(String url) {
        getURL(url);
        Header header = new Header();
        String searchContent = "Tom Ford FT5146 003";
        header.inputSearch.sendKeys(searchContent);
        header.iconSearch.click();
        SearchResultPage searchResultPage = new SearchResultPage();
        String Band = searchResultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(searchContent.contains(Band), "Expected product displayed");
        //
        header.mouseOver(searchResultPage.proInfo.get(0));
        searchResultPage.quickView.click();
        //
        searchResultPage.eyeproSize.get(1).click();
        Assert.assertTrue(searchResultPage.sizeClicked.isDisplayed(), "size button don't click");
        searchResultPage.eyeproSize.get(0).click();
        Assert.assertTrue(searchResultPage.sizeClicked.isDisplayed(), "size button don't click");
        searchResultPage.frameOrAdd.get(1).click();
        Assert.assertTrue(searchResultPage.frameOrAddClicked.isDisplayed(), "Frame with Lenses button don't click");
        searchResultPage.frameOrAdd.get(0).click();
        Assert.assertTrue(searchResultPage.frameOrAddClicked.isDisplayed(), "Frame Only button don't click");
        header.waitForVisibility(searchResultPage.buyNowButton, 2);
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(searchResultPage.buyNowButton));
        searchResultPage.buyNowButton.click();
        header.waitForVisibility(searchResultPage.carBtn, 2);
        searchResultPage.carBtn.click();
        CartPage cartPage = new CartPage();
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
