package com.motionglobal.testcases.sbg.mobile.smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestSunGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    // @DataProvider(name = "DesktopTestData")
    // public static Object[][] Words() throws IOException {
    // return ExcelDataUtil.getExcelData("src/main/resources/", "DesktopTestData.xlsx", "");
    // }dataProvider = "DesktopTestData",

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.com" },
                { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.ca" }, { "http://m.smartbuyglasses.com.hk" }, { "http://m.smartbuyglasses.se" },
                { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" }, { "http://m.smartbuyglasses.cn" } };
    }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    // }

    @Test(dataProvider = "dp", groups = { "debug1", "smoke" })
    public void menuEyeGlassGender(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(1, 1); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            header.getSubMenuElement(1, 1).click();
            // String brankName = header.getDetailLinkElement(2, 1, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 1, (i + 1)));
            header.getDetailLinkElement(1, 1, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
    }

    @Test(dataProvider = "dp", groups = { "debug1", "smoke" })
    public void menuEyeGlassBrank(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(1, 2) - 1; i++) {
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            header.getSubMenuElement(1, 2).click();
            // String brankName = header.getDetailLinkElement(2, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 2, (i + 1)));
            header.getDetailLinkElement(1, 2, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
        header.menuBtn.click();
        header.getMainMenuElement(1).click();
        header.getSubMenuElement(1, 2).click();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 2, (header.getSubMenuElementSize(1, 2))));
        header.getDetailLinkElement(1, 2, header.getSubMenuElementSize(1, 2)).click();
    }

    @Test(dataProvider = "dp", groups = { "debug1", "smoke" })
    public void menuEyeGlassShape(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(1, 3); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            header.getSubMenuElement(1, 3).click();
            // String brankName = header.getDetailLinkElement(2, 3, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 3, (i + 1)));
            header.getDetailLinkElement(1, 3, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
    }

    @Test(dataProvider = "dp", groups = { "debug1", "smoke" })
    public void menuEyeGlassOther(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        header.menuBtn.click();
        header.getMainMenuElement(1).click();
        // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.subMenuPolarized);
        header.subMenuPolarized.click();
        MobProductPage productPage1 = new MobProductPage();
        header.menuBtn.click();
        header.getMainMenuElement(1).click();
        // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.subMenuPre);
        header.subMenuPolarized.click();
        MobProductPage productPage2 = new MobProductPage();
        header.menuBtn.click();
        header.getMainMenuElement(1).click();
        // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.subMenuSki);
        header.subMenuSki.click();
        MobProductPage productPage3 = new MobProductPage();
    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
    }
}
