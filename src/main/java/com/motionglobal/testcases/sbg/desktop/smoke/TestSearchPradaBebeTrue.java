package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestSearchPradaBebeTrue extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com" }, };
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void bebeClickText(String url) {
        driver.get(url);
        Header header = new Header();
        header.waitForVisibility(header.inputSearch, 5);
        header.inputSearch.sendKeys("Prada");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        header.waitForVisibility(resultPage.BebeBrank, 10);
        resultPage.BebeBrank.click();
        header.waitForVisibility(resultPage.BebeBrankChecked, 10);
        resultPage.mouseOver(resultPage.proInfo.get(0));
        resultPage.resultGrid().getItem(0).click();
        ProductDetailPage detailPage = new ProductDetailPage();
        Assert.assertTrue(detailPage.glassName.getText().contains("BeBe BB5051 Flattering 045"), "Page Mismatcher");
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void bebeClickDetail(String url) throws InterruptedException {
        driver.get(url);
        Header header = new Header();
        header.inputSearch.sendKeys("Prada");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        header.waitForVisibility(resultPage.BebeBrank, 10);
        resultPage.BebeBrank.click();
        header.waitForVisibility(resultPage.BebeBrankChecked, 10);
        resultPage.mouseOver(resultPage.proInfo.get(0));
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(resultPage.quickView));
        resultPage.quickView.click();
        resultPage.detailBtn.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        Assert.assertTrue(detailPage.glassName.getText().contains("BeBe BB5051 Flattering 045"), "Page Mismatcher");
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
