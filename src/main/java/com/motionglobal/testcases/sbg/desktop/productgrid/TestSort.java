package com.motionglobal.testcases.sbg.desktop.productgrid;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSort extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Ray-Ban/" }, { "http://www.smartbuyglasses.dk/designer-sunglasses/Ray-Ban/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sort(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.waitForVisibility(gridPage.SortDrop, 5);
        gridPage.SortDrop.click();
        String dropUrl1 = gridPage.SortSection.get(0).getAttribute("href");
        gridPage.AsssetEquals(dropUrl1, url);
        String dropUrl2 = gridPage.SortSection.get(1).getAttribute("href");
        gridPage.AsssetEquals(dropUrl2, url + "-----------4-------");
        String dropUrl3 = gridPage.SortSection.get(2).getAttribute("href");
        gridPage.AsssetEquals(dropUrl3, url + "-----------5-------");
        String dropUrl4 = gridPage.SortSection.get(3).getAttribute("href");
        gridPage.AsssetEquals(dropUrl4, url + "-----------2-------");

        //
        for (int i = 2; i < gridPage.productPageNum.size() - 1; i++) {
            String productPageUrl = gridPage.productPageNum.get(i).getAttribute("href");
            gridPage.AsssetEquals(productPageUrl, url + "------------" + i + "------");
        }
        String rightUrl = gridPage.productPageNum.get(gridPage.productPageNum.size() - 1).getAttribute("href");
        gridPage.AsssetEquals(rightUrl, url + "------------2------");
        //
        Random random = new Random();
        int sortSectionNum = random.nextInt(2) + 1;
        if (sortSectionNum == 1) {
            gridPage.SortSection.get(1).click();
            for (int i = 0; i < gridPage.productPriceS.size() - 1; i++) {
                double beforePrice = gridPage.regexGetDouble(gridPage.productPriceS.get(i).getText());
                double lastPrice = gridPage.regexGetDouble(gridPage.productPriceS.get(i + 1).getText());
                gridPage.AsssetTrue(beforePrice <= lastPrice, " price sort fail !!!");
            }
        }
        else {
            gridPage.SortSection.get(2).click();
            for (int i = 0; i < gridPage.productPriceS.size() - 1; i++) {
                double beforePrice = gridPage.regexGetDouble(gridPage.productPriceS.get(i).getText());
                double lastPrice = gridPage.regexGetDouble(gridPage.productPriceS.get(i + 1).getText());
                gridPage.AsssetTrue(beforePrice >= lastPrice, " price sort fail !!!");
            }
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void popularStyle(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        // leftBtn
        gridPage.waitForVisibility(gridPage.popularRightBtn, 5);
        String popularBrandName1 = gridPage.popularBrands1.getText();
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.popularLeftBtn.click();
        gridPage.waitForVisibility(gridPage.popularBrands3, 5);
        String popularBrandName3 = gridPage.popularBrands3.getText();
        Assert.assertNotEquals(popularBrandName1, popularBrandName3);

        // rigthBtn
        gridPage.waitForVisibility(gridPage.popularRightBtn, 5);
        gridPage.popularRightBtn.click();
        gridPage.waitForVisibility(gridPage.popularBrands1, 2);
        Assert.assertNotEquals(popularBrandName1, popularBrandName3);

        // click IMG
        String popularBrand = gridPage.popularBrandIMG1.getText();
        gridPage.popularBrandIMG1.click();
        Pattern pattern = Pattern.compile("[^a-zA-z]");
        Matcher match = pattern.matcher(popularBrand);
        String getBrand = match.replaceAll("");
        String currentUrl = gridPage.getCurrentUrl();
        gridPage.AsssetEquals(currentUrl, url + getBrand + "/");

    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void selectFilterBrand(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        try {
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.waitForVisibility(gridPage.filterRayban2132, 2);
        gridPage.filterRayban2132.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        String glassName = detailPage.glassName.getText();
        detailPage.AsssetEquals(glassName, "Ray-Ban RB2132 New Wayfarer 710");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
