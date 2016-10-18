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
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com/search?keywords=prada&searchHashcode=1475048189562530#q=prada&page=0&minReviewsCount=0&refinements=%5B%7B%22for_sale%22%3A%221%22%7D%5D" }, };
    }

    @Test(dataProvider = "dp", groups = { "debug111", "smoke", "fastsmoke" })
    public void bebeClickText(String url) {
        getURL(url);
        Header header = new Header();
        SearchResultPage resultPage = new SearchResultPage();
        header.inputSearch.click();
        header.deleteHead();
        header.waitForVisibility(resultPage.BebeBrank, 10);
        resultPage.BebeBrank.click();
        header.waitForVisibility(resultPage.BebeBrankChecked, 15);
        resultPage.matcherQuickViewClickOpen(1);
        header.waitForVisibility(resultPage.detailBtn, 5);
        resultPage.detailBtn.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        Assert.assertTrue(detailPage.glassName.getText().replace("b", "B").contains("BeBe BB"), "Page mismatching !!!");
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void bebeClickDetail(String url) throws InterruptedException {
        getURL(url);
        Header header = new Header();
        SearchResultPage resultPage = new SearchResultPage();
        header.deleteHead();
        header.waitForVisibility(resultPage.BebeBrank, 10);
        resultPage.BebeBrank.click();
        header.waitForVisibility(resultPage.BebeBrankChecked, 15);
        resultPage.matcherQuickViewClickOpen(1);
        header.waitForVisibility(resultPage.detailBtn, 5);
        resultPage.detailBtn.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        System.out.println(detailPage.glassName.getText());
        Assert.assertTrue(detailPage.glassName.getText().replace("b", "B").contains("BeBe BB"), "Page Mismatcher");
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
