package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Search extends AbstractBaseSbgDesktopTestCase {

    @Test(dataProvider = "dp")
    public void SearchTest(String url) {
        driver.get(url);
        // driver.navigate().refresh();
        Header header = new Header();
        header.inputSearch.sendKeys("ray ban");
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        Assert.assertTrue(resultPage.rayPanEles.getText().contains("Ray-Ban"), "Expected Ray-ban displayed, but no");
        // System.out.println(resultPage.rayPanEles.getText());
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com.hk/" }, };
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
