package com.motionglobal.testcases.sbg.mobile.home;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.home.MobHomePage;
import com.motionglobal.pages.sbg.mobile.home.MobHomePage.Sell;
import com.motionglobal.pages.sbg.mobile.product.MobProductAllCLPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestHomePage extends AbstractBaseTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/" }, { "http://m.smartbuyglasses.co.uk/" } };
    }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void sunTopSell(String url) throws InterruptedException {
        getURL(url);
        Actions actions = new Actions(driver);
        MobHomePage homePage = new MobHomePage();
        homePage.JsMouse(homePage.getTopSell(Sell.SUNIMG));
        String price1 = homePage.getTopSell(Sell.SUNPRICE).getText();
        String homeBrank = homePage.regexGetLetterLow(homePage.getTopSell(Sell.SUNBRANK).getText());
        actions.dragAndDropBy(homePage.getTopSell(Sell.SUNIMG), 100, 0).perform();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(homePage.getTopSell(Sell.SUNBRANK), homeBrank)));
        String price2 = homePage.getTopSell(Sell.SUNPRICE).getText();
        String homeBrank2 = homePage.regexGetLetterLow(homePage.getTopSell(Sell.SUNBRANK).getText());
        homePage.getTopSell(Sell.SUNIMG).click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        Assert.assertEquals(detailPage.price.getText(), price2);
        Assert.assertTrue(detailPage.regexGetLetterLow(detailPage.productName.getText()).contains(homeBrank2), " PAGE NO'T MATCH !!!");

        //
        detailPage.mobHeader().logo.click();
        homePage.JsMouse(homePage.getTopSell(Sell.SUNIMG));
        actions.dragAndDropBy(homePage.getTopSell(Sell.SUNIMG), -100, 0).perform();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(homePage.getTopSell(Sell.SUNBRANK), homeBrank)));
        String price3 = homePage.getTopSell(Sell.SUNPRICE).getText();
        String homeBrank3 = homePage.regexGetLetterLow(homePage.getTopSell(Sell.SUNBRANK).getText());
        homePage.getTopSell(Sell.SUNIMG).click();
        MobProductDetailPage detailPage2 = new MobProductDetailPage();
        Assert.assertEquals(detailPage2.price.getText(), price3);
        Assert.assertTrue(detailPage.regexGetLetterLow(detailPage.productName.getText()).contains(homeBrank3), " PAGE NO'T MATCH !!!");

        //
        detailPage.mobHeader().logo.click();
        homePage.JsMouse(homePage.getTopSell(Sell.SUNIMG));
        homePage.waitForVisibility(homePage.getTopSell(Sell.SUNIMG), 5);
        homePage.getTopSell(Sell.SUNIMG).click();
        MobProductDetailPage detailPage3 = new MobProductDetailPage();
        Assert.assertEquals(detailPage.price.getText(), price1);
        Assert.assertTrue(detailPage.regexGetLetterLow(detailPage.productName.getText()).contains(homeBrank), " PAGE NO'T MATCH !!!");
    }

    // XXX case 2
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void eyeTopSell(String url) throws InterruptedException {
        getURL(url);
        Actions actions = new Actions(driver);
        MobHomePage homePage = new MobHomePage();
        homePage.JsMouse(homePage.getTopSell(Sell.EYEIMG));
        String price1 = homePage.getTopSell(Sell.EYEPRICE).getText();
        String homeBrank = homePage.regexGetLetterLow(homePage.getTopSell(Sell.EYEBRANK).getText());
        actions.dragAndDropBy(homePage.getTopSell(Sell.EYEIMG), 100, 0).perform();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(homePage.getTopSell(Sell.EYEBRANK), homeBrank)));
        String price2 = homePage.getTopSell(Sell.EYEPRICE).getText();
        String homeBrank2 = homePage.regexGetLetterLow(homePage.getTopSell(Sell.EYEBRANK).getText());
        homePage.getTopSell(Sell.EYEIMG).click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        Assert.assertEquals(detailPage.price.getText(), price2);
        Assert.assertTrue(detailPage.regexGetLetterLow(detailPage.productName.getText()).contains(homeBrank2), " PAGE NO'T MATCH !!!");

        //
        detailPage.mobHeader().logo.click();
        homePage.JsMouse(homePage.getTopSell(Sell.EYEIMG));
        actions.dragAndDropBy(homePage.getTopSell(Sell.EYEIMG), -100, 0).perform();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(homePage.getTopSell(Sell.EYEBRANK), homeBrank)));
        String price3 = homePage.getTopSell(Sell.EYEPRICE).getText();
        String homeBrank3 = homePage.regexGetLetterLow(homePage.getTopSell(Sell.EYEBRANK).getText());
        homePage.getTopSell(Sell.EYEIMG).click();
        MobProductDetailPage detailPage2 = new MobProductDetailPage();
        Assert.assertEquals(detailPage2.price.getText(), price3);
        Assert.assertTrue(detailPage.regexGetLetterLow(detailPage.productName.getText()).contains(homeBrank3), " PAGE NO'T MATCH !!!");

        //
        detailPage.mobHeader().logo.click();
        homePage.JsMouse(homePage.getTopSell(Sell.EYEIMG));
        homePage.waitForVisibility(homePage.getTopSell(Sell.EYEIMG), 5);
        homePage.getTopSell(Sell.EYEIMG).click();
        MobProductDetailPage detailPage3 = new MobProductDetailPage();
        Assert.assertEquals(detailPage.price.getText(), price1);
        Assert.assertTrue(detailPage.regexGetLetterLow(detailPage.productName.getText()).contains(homeBrank), " PAGE NO'T MATCH !!!");

    }

    // XXX case 3
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void topBrank(String url) throws InterruptedException {
        getURL(url);
        MobHomePage homePage = new MobHomePage();
        homePage.waitForVisibility(homePage.topBrank2Img, 5);
        homePage.JsMouse(homePage.topBrank2Img);
        //
        Pattern pattern = Pattern.compile("brand_.*\\.gif");
        Matcher matcher = pattern.matcher(homePage.topBrank2Img.getAttribute("src"));
        String brank = null;
        if (matcher.find()) {
            brank = matcher.group();
        }
        String expectBrank = homePage.regexGetLetterLow(brank).replace("brand", "").replace("gif", "");
        System.out.println(expectBrank);
        //
        homePage.topBrank2Img.click();
        homePage.waitForVisibility(homePage.topBrank2Sun, 5);
        homePage.topBrank2Sun.click();
        MobProductPage productPage = new MobProductPage();
        String brankName = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(brankName, expectBrank + "sunglasses");

        //
        homePage.mobHeader().logo.click();
        homePage.waitForVisibility(homePage.topBrank2Img, 5);
        homePage.JsMouse(homePage.topBrank2Img);
        Pattern pattern2 = Pattern.compile("brand_.*\\.gif");
        Matcher matcher2 = pattern2.matcher(homePage.topBrank2Img.getAttribute("src"));
        String brank2 = null;
        if (matcher2.find()) {
            brank2 = matcher2.group();
        }
        String expectBrank2 = homePage.regexGetLetterLow(brank2).replace("brand", "").replace("gif", "");
        homePage.topBrank2Img.click();
        homePage.waitForVisibility(homePage.topBrank2Eye, 5);
        homePage.topBrank2Eye.click();
        MobProductPage productPage2 = new MobProductPage();
        String brankName2 = productPage2.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(brankName2, expectBrank2 + "glasses");
    }

    // XXX case 4
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void indexMenuSun(String url) throws InterruptedException {
        getURL(url);
        MobHomePage homePage = new MobHomePage();
        homePage.JsMouse(homePage.indexMenuSun);
        homePage.indexMenuSun.click();
        homePage.elementClick(homePage.indexSubMenu.get(0));
        MobProductPage productPage = new MobProductPage();
        String productTitle = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productTitle, "sunglasses");
        Assert.assertEquals(productPage.productList.size(), 100);

        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuSun);
        homePage.indexMenuSun.click();
        homePage.elementClick(homePage.indexSubMenu.get(1));
        MobProductPage productPage2 = new MobProductPage();
        String productTitle2 = productPage2.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productTitle2, "menssunglasses");
        Assert.assertEquals(productPage.productList.size(), 20);

        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuSun);
        homePage.indexMenuSun.click();
        homePage.elementClick(homePage.indexSubMenu.get(2));
        MobProductPage productPage3 = new MobProductPage();
        String productTitle3 = productPage3.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productTitle3, "womenssunglasses");
        Assert.assertEquals(productPage.productList.size(), 20);
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void indexMenuEye(String url) throws InterruptedException {
        getURL(url);
        MobHomePage homePage = new MobHomePage();
        homePage.JsMouse(homePage.indexMenuEye);
        homePage.indexMenuEye.click();
        homePage.elementClick(homePage.indexSubMenu.get(0));
        MobProductPage productPage = new MobProductPage();
        String productTitle = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productTitle, "glasses");
        Assert.assertEquals(productPage.productList.size(), 100);

        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuEye);
        homePage.indexMenuEye.click();
        homePage.elementClick(homePage.indexSubMenu.get(1));
        MobProductPage productPage2 = new MobProductPage();
        String productTitle2 = productPage2.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productTitle2, "mensglasses");
        Assert.assertEquals(productPage.productList.size(), 20);

        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuEye);
        homePage.indexMenuEye.click();
        homePage.elementClick(homePage.indexSubMenu.get(2));
        MobProductPage productPage3 = new MobProductPage();
        String productTitle3 = productPage3.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productTitle3, "womensglasses");
        Assert.assertEquals(productPage.productList.size(), 20);
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void indexMenuCL(String url) throws InterruptedException {
        getURL(url);
        MobHomePage homePage = new MobHomePage();
        homePage.JsMouse(homePage.indexMenuCL);
        homePage.indexMenuCL.click();
        homePage.elementClick(homePage.indexSubMenu.get(0));
        MobProductAllCLPage allCLPage = new MobProductAllCLPage();
        Assert.assertTrue(allCLPage.productImg.size() > 5, " PRODUCT NUMBER LOWER !!!");
        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuCL);
        homePage.indexMenuCL.click();
        homePage.elementClick(homePage.indexSubMenu.get(1));
        MobProductPage productPage = new MobProductPage();
        String productTitle2 = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertTrue(productTitle2.contains("contactlenses"));
        Assert.assertTrue(productPage.productList.size() > 1);

        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuCL);
        homePage.indexMenuCL.click();
        homePage.elementClick(homePage.indexSubMenu.get(2));
        MobProductPage productPage3 = new MobProductPage();
        String productTitle3 = productPage3.regexGetLetterLow(productPage.productTitle.getText());
        // Assert.assertEquals(productTitle3, "contactlenses");
        Assert.assertTrue(productTitle3.contains("contactlenses"), " Page No't Contains contactlenses !!!");
        Assert.assertTrue(productPage.productList.size() > 1);

        //
        homePage.mobHeader().logo.click();
        homePage.JsMouse(homePage.indexMenuCL);
        homePage.indexMenuCL.click();
        homePage.elementClick(homePage.indexSubMenu.get(3));
        MobProductPage productPage4 = new MobProductPage();
        String productTitle4 = productPage4.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertTrue(productTitle4.contains("contactlenses"), " Page No't Contact Lense Page !!!");
        Assert.assertTrue(productPage.productList.size() > 1);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
