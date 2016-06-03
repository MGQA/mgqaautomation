package com.motionglobal.testcases.sbg.mobile.smoke;

import java.util.Random;

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
                { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" } };
    }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassGender(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(1, 1); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(1, 1));
        header.menuBtn.click();
        header.getMainMenuElement(1).click();
        header.getSubMenuElement(1, 1).click();
        // String brankName = header.getDetailLinkElement(2, 1, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 1, (num + 1)));
        header.getDetailLinkElement(1, 1, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassBrank(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(1, 2) - 1; i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(1, 2));
        if (!(num == (header.getSubMenuElementSize(1, 2) - 1))) {
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            header.getSubMenuElement(1, 2).click();
            // String brankName = header.getDetailLinkElement(2, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 2, (num + 1)));
            header.getDetailLinkElement(1, 2, (num + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
            // }
            //
        }
        else {
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            header.getSubMenuElement(1, 2).click();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 2, (header.getSubMenuElementSize(1, 2))));
            header.getDetailLinkElement(1, 2, header.getSubMenuElementSize(1, 2)).click();
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassShape(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(1, 3); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(1, 3));
        header.menuBtn.click();
        header.getMainMenuElement(1).click();
        header.getSubMenuElement(1, 3).click();
        // String brankName = header.getDetailLinkElement(2, 3, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 3, (num + 1)));
        header.getDetailLinkElement(1, 3, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassOther(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Random random = new Random();
        int num = random.nextInt(3);
        switch (num) {
        case 0:
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.subMenuPolarized);
            header.subMenuPolarized.click();
            MobProductPage productPage1 = new MobProductPage();
            break;
        case 1:
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.subMenuPre);
            header.subMenuPre.click();
            MobProductPage productPage2 = new MobProductPage();
            break;
        default:
            header.menuBtn.click();
            header.getMainMenuElement(1).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.subMenuSki);
            header.subMenuSki.click();
            MobProductPage productPage3 = new MobProductPage();
            break;
        }
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
