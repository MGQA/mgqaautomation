package com.motionglobal.testcases.sbg.desktop.smoke;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.CLProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class CLGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    // @DataProvider(name = "DesktopTestData")
    // public static Object[][] Words() throws IOException {
    // return ExcelDataUtil.getExcelData("src/main/resources/", "DesktopTestData.xlsx", "");
    // }dataProvider = "DesktopTestData",

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
                { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
                { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
                { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" } };
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subLeftMenuSectionNum1(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(5);
        String name1 = header.getLeftSubMenuElement(5, 1, 1).getText();
        String name2 = header.getLeftSubMenuElement(5, 1, 2).getText();
        String name3 = header.getLeftSubMenuElement(5, 1, 3).getText();
        String name4 = header.getLeftSubMenuElement(5, 1, 4).getText();
        header.clickLeftSubMenu(5, 1, 1);
        String url1 = driver.getCurrentUrl();
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        clProductGridPage.assertCLGridPage(name1);
        header.clickLeftSubMenu(5, 1, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        clProductGridPage.assertCLGridPage(name2);
        header.clickLeftSubMenu(5, 1, 3);
        String url3 = driver.getCurrentUrl();
        header.confirmPage(url2);
        clProductGridPage.assertCLGridPage(name3);
        header.clickLeftSubMenu(5, 1, 4);
        header.confirmPage(url3);
        clProductGridPage.assertCLGridPage(name4);
    }

    @Test(dataProvider = "dp", groups = "debug3")
    public void subLeftMenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(5);
        String name1 = header.getLeftSubMenuElement(5, 2, 1).getText();
        String name2 = header.getLeftSubMenuElement(5, 2, 2).getText();
        String name3 = header.getLeftSubMenuElement(5, 2, 3).getText();
        header.clickLeftSubMenu(5, 2, 1);
        String url1 = driver.getCurrentUrl();
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        clProductGridPage.assertCLGridPage(name1);
        header.clickLeftSubMenu(5, 2, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        clProductGridPage.assertCLGridPage(name2);
        header.clickLeftSubMenu(5, 2, 3);
        header.confirmPage(url2);
        clProductGridPage.assertCLGridPage(name3);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subLeftMenuSectionNum3(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(5);
        String name1 = header.getLeftSubMenuElement(5, 3, 1).getText();
        String name2 = header.getLeftSubMenuElement(5, 3, 2).getText();
        String name3 = header.getLeftSubMenuElement(5, 3, 3).getText();
        String name4 = header.getLeftSubMenuElement(5, 3, 4).getText();
        header.clickLeftSubMenu(5, 3, 1);
        String url1 = driver.getCurrentUrl();
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        clProductGridPage.assertCLGridPage(name1);
        header.clickLeftSubMenu(5, 3, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        clProductGridPage.assertCLGridPage(name2);
        header.clickLeftSubMenu(5, 3, 3);
        String url3 = driver.getCurrentUrl();
        header.confirmPage(url2);
        clProductGridPage.assertCLGridPage(name3);
        header.clickLeftSubMenu(5, 3, 4);
        header.confirmPage(url3);
        clProductGridPage.assertCLGridPage(name4);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subMidMenuSectionNum1(String url) {
        driver.get(url);
        Header header = new Header();
        header.clickMiddleSubMenu(5, 1, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 2);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 3);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 4);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 5);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 6);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 7);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 8);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 9);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 10);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 11);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 12);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 13);
        Assert.assertTrue(id.contains("information"));
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subMidMenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        header.clickMiddleSubMenu(5, 2, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 2, 2);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 2, 3);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 2, 4);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 2, 5);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 2, 6);
        Assert.assertTrue(id.contains("information"));
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subMidMenuSectionNum3(String url) {
        driver.get(url);
        Header header = new Header();
        header.clickMiddleSubMenu(5, 3, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 3, 2);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 3, 3);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 3, 4);
        Assert.assertTrue(id.contains("information"));
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subRightMenu(String url) {
        driver.get(url);
        Header header = new Header();
        header.clickGlassImg(5, 2);
        header.mouseOverMainMenu(5);
        header.mouseOver(header.clViewAllBrands);
        header.getCLBrandsElement(2).click();
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
