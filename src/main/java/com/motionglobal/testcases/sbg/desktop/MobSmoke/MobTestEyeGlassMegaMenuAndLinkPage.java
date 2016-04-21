package com.motionglobal.testcases.sbg.desktop.MobSmoke;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.MobHeader;
import com.motionglobal.pages.sbg.desktop.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestEyeGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.com" },
                { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.ca" }, { "http://m.smartbuyglasses.com.hk" }, { "http://m.smartbuyglasses.se" },
                { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" }, { "http://m.smartbuyglasses.cn" } };
    }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    // }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassGender(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(2, 1); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(2).click();
            header.getSubMenuElement(2, 1).click();
            // String brankName = header.getDetailLinkElement(2, 1, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 1, (i + 1)));
            header.getDetailLinkElement(2, 1, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassBrank(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(2, 2) - 1; i++) {
            header.menuBtn.click();
            header.getMainMenuElement(2).click();
            header.getSubMenuElement(2, 2).click();
            // String brankName = header.getDetailLinkElement(2, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 2, (i + 1)));
            header.getDetailLinkElement(2, 2, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
        header.menuBtn.click();
        header.getMainMenuElement(2).click();
        header.getSubMenuElement(2, 2).click();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 2, (header.getSubMenuElementSize(2, 2))));
        header.getDetailLinkElement(2, 2, header.getSubMenuElementSize(2, 2)).click();
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassShape(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(2, 3); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(2).click();
            header.getSubMenuElement(2, 3).click();
            // String brankName = header.getDetailLinkElement(2, 3, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 3, (i + 1)));
            header.getDetailLinkElement(2, 3, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassStyle(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(2, 4); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(2).click();
            header.getSubMenuElement(2, 4).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 4, (i + 1)));
            header.getDetailLinkElement(2, 4, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
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
