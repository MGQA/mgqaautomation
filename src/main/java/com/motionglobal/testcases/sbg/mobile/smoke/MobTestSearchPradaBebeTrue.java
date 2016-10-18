package com.motionglobal.testcases.sbg.mobile.smoke;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.search.MobSearchResultPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * m.com Test : click product(prada) brand(Bebe)
 * 
 */
public class MobTestSearchPradaBebeTrue extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" }, };
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void bebeClickText(String url) throws InterruptedException {
        getURL(url);
        MobHeader mobHeader = new MobHeader();
        mobHeader.searchInput.click();
        mobHeader.searchInput.sendKeys("Prada");
        mobHeader.actionKey(Keys.ENTER);
        MobSearchResultPage searchResultPage = new MobSearchResultPage();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
        String name = searchResultPage.productName.get(0).getText();
        Assert.assertTrue(name.contains("Prada"), "Expected Ray-ban displayed, but no");
        searchResultPage.filter.click();
        searchResultPage.branksBtn.click();
        searchResultPage.JsMouse(searchResultPage.Bebe);
        searchResultPage.Bebe.click();
        searchResultPage.waitForVisibility(searchResultPage.productDetailName, 1);
        String detailName = searchResultPage.productDetailName.getText();
        for (int i = 0; i < 30; i++) {
            if (!(detailName.contains("Bebe"))) {
                Thread.sleep(100);
                searchResultPage.waitForVisibility(searchResultPage.productDetailName, 5);
                detailName = searchResultPage.productDetailName.getText();
            }
        }
        searchResultPage.waitForVisibility(searchResultPage.productName.get(0), 5);
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(searchResultPage.productName.get(0)));
        searchResultPage.productName.get(0).click();
        MobProductDetailPage productDetailPage = new MobProductDetailPage();
        Assert.assertEquals(detailName.replace("b", "B"), productDetailPage.productName.getText().replace("b", "B"));
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
