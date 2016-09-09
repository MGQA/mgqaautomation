package com.motionglobal.testcases.sbg.mobile.product;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestProduct extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/" } };
    }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void filterGender(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        productPage.subFilter.get(0).click();
        //
        Random random = new Random();
        int Num = random.nextInt(3);
        //
        String fitlerName = productPage.regexGetLetterLow(productPage.finalFilter.get(Num).getText());
        productPage.finalFilter.get(Num).click();
        String actualName = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertTrue(actualName.contains(fitlerName), "PAGE IS " + actualName + "BUT EXPECT IS : " + fitlerName);
    }

    // XXX case 2
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void filterPrice(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        productPage.subFilter.get(1).click();
        //
        Random random = new Random();
        int Num = random.nextInt(3);
        double priceSmall = 0;
        double priceGreat = 0;
        double expectPrice = 0;
        try {
            String[] fitlerName = productPage.productPrice.get(Num).getText().split("~");
            priceSmall = productPage.regexGetDouble(fitlerName[0]);
            priceGreat = productPage.regexGetDouble(fitlerName[1]);
        }
        catch (Exception e) {
            expectPrice = productPage.regexGetDouble(productPage.productPrice.get(Num).getText());
        }
        //
        productPage.finalFilter.get(Num).click();
        double actualPrice = productPage.regexGetDouble(productPage.productPrice.get(Num).getText());
        if (priceSmall != 0 && priceGreat != 0) {
            Assert.assertTrue(priceSmall <= actualPrice, actualPrice + " NOT BETWEEN " + priceSmall + " AND " + priceGreat);
            Assert.assertTrue(priceGreat >= actualPrice, actualPrice + " NOT BETWEEN " + priceSmall + " AND " + priceGreat);
        }
        else {
            Assert.assertTrue(expectPrice <= actualPrice, actualPrice + " Price < " + expectPrice);
        }
    }

    // XXX case 3
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void filterShape(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        productPage.subFilter.get(2).click();
        //
        Random random = new Random();
        int Num = random.nextInt(productPage.finalFilter.size());
        String fitlerName = productPage.regexGetLetterLow(productPage.finalFilter.get(Num).getText());
        productPage.finalFilter.get(Num).click();
        String actualName = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertTrue(actualName.contains(fitlerName), "PAGE IS " + actualName + "BUT EXPECT IS : " + fitlerName);
    }

    // XXX case 4
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void filterType(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        productPage.subFilter.get(4).click();
        //
        Random random = new Random();
        int Num = random.nextInt(productPage.finalFilter.size());
        String fitlerName = productPage.regexGetLetterLow(productPage.finalFilter.get(Num).getText());
        productPage.finalFilter.get(Num).click();
        String actualName = productPage.regexGetLetterLow(driver.getCurrentUrl());
        Assert.assertTrue(actualName.contains(fitlerName), "PAGE IS " + actualName + "BUT EXPECT IS : " + fitlerName);
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void filterFrameColor(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        productPage.subFilter.get(4).click();
        //
        Random random = new Random();
        int Num = random.nextInt(productPage.finalFilter.size());
        String fitlerName = productPage.regexGetLetterLow(productPage.finalFilter.get(Num).getAttribute("value"));
        productPage.finalFilter.get(Num).click();
        String actualName = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertTrue(actualName.contains(fitlerName), "PAGE IS " + actualName + "BUT EXPECT IS : " + fitlerName);
    }

    // XXX case 6
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void filterlensColor(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        //
        productPage.subFilter.get(5).click();
        Random random = new Random();
        int Num = random.nextInt(productPage.subFilter.size());
        String fitlerName = productPage.regexGetLetterLow(productPage.finalFilter.get(Num).getAttribute("value"));
        productPage.subFilter.get(Num).click();
        String actualName = productPage.regexGetLetterLow(productPage.getCurrentUrl());
        Assert.assertTrue(actualName.contains(fitlerName), "PAGE IS " + actualName + "BUT EXPECT IS : " + fitlerName);
    }

    // XXX case 7
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void filterFeature(String url) throws InterruptedException {
        getURL(url);
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.filter, 5);
        productPage.filter.click();
        productPage.waitForVisibility(productPage.subFilter, 5);
        productPage.subFilter.get(6).click();
        //
        Random random = new Random();
        int Num = random.nextInt(3);
        String fitlerName = productPage.regexGetLetterLow(productPage.finalFilter.get(Num).getText());
        productPage.finalFilter.get(Num).click();
        String actualName = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertTrue(actualName.contains(fitlerName), "PAGE IS " + actualName + "BUT EXPECT IS : " + fitlerName);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
