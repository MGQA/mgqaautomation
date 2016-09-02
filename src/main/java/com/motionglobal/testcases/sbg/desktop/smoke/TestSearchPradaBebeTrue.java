package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * com Test : click brands(prada) detail(Bebe)
 * 
 */
public class TestSearchPradaBebeTrue extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com" }, };
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void bebeClickText(String url) {
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.inputSearch, 5);
        header.inputSearch.sendKeys("Prada");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.JsDisplayNone(resultPage.header().letTalk);
        header.waitForVisibility(resultPage.BebeBrank, 10);
        resultPage.BebeBrank.click();
        header.waitForVisibility(resultPage.BebeBrankChecked, 10);
        try {
            header.waitForVisibility(resultPage.proInfo.get(0), 2);
            resultPage.mouseOver(resultPage.proInfo.get(0));
            header.waitForVisibility(resultPage.quickView, 2);
            resultPage.resultGrid().getItem(0).click();
        }
        catch (Exception e) {
            header.waitForVisibility(resultPage.brandName, 2);
            resultPage.mouseOver(resultPage.brandName);
            header.waitForVisibility(resultPage.proInfo.get(0), 2);
            resultPage.mouseOver(resultPage.proInfo.get(0));
            header.waitForVisibility(resultPage.quickView, 2);
            resultPage.resultGrid().getItem(0).click();
        }
        ProductDetailPage detailPage = new ProductDetailPage();
        System.out.println(detailPage.glassName.getText());
        Assert.assertTrue(detailPage.glassName.getText().replace("b", "B").contains("BeBe BB5051 Flattering 045"), "Page mismatching !!!");
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void bebeClickDetail(String url) throws InterruptedException {
        getURL(url);
        Header header = new Header();
        header.inputSearch.sendKeys("Prada");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        resultPage.JsDisplayNone(resultPage.header().letTalk);
        header.waitForVisibility(resultPage.BebeBrank, 10);
        resultPage.BebeBrank.click();
        header.waitForVisibility(resultPage.BebeBrankChecked, 10);
        try {
            header.waitForVisibility(resultPage.proInfo.get(0), 2);
            resultPage.mouseOver(resultPage.proInfo.get(0));
            header.waitForVisibility(resultPage.quickView, 2);
            resultPage.quickView.click();
        }
        catch (Exception e) {
            header.waitForVisibility(resultPage.brandName, 2);
            resultPage.mouseOver(resultPage.brandName);
            header.waitForVisibility(resultPage.proInfo.get(0), 2);
            resultPage.mouseOver(resultPage.proInfo.get(0));
            header.waitForVisibility(resultPage.quickView, 2);
            resultPage.quickView.click();
        }
        header.waitForVisibility(resultPage.detailBtn, 5);
        resultPage.detailBtn.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        System.out.println(detailPage.glassName.getText());
        Assert.assertTrue(detailPage.glassName.getText().replace("b", "B").contains("BeBe BB5051 Flattering 045"), "Page Mismatcher");
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
