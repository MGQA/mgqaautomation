package com.motionglobal.testcases.sbg.mobile.smoke;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.search.MobSearchResultPage;
import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestSearchPradaBebeTrue extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" }, };
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void bebeClickText(String url) throws InterruptedException {
        driver.get(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("Prada");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Prada"), "Expected Ray-ban displayed, but no");
        searchResultPage.filter.click();
        searchResultPage.branksBtn.click();
        searchResultPage.Bebe.click();
        String detailName = searchResultPage.productDetailName.getText();
        for (int i = 0; i < 30; i++) {
            if (!(detailName.contains("Bebe"))) {
                Thread.sleep(100);
                detailName = searchResultPage.productDetailName.getText();
            }
        }
        searchResultPage.productName.get(0).click();
        MobProductDetailPage productDetailPage = new MobProductDetailPage();
        Assert.assertEquals(detailName.replace("b", "B"), productDetailPage.productName.getText());
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
