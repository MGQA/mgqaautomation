package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.VirtualPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSunGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

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

    // return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
    // { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.ca" }, { "http://www.smartbuyglasses.com.hk" },
    // { "http://www.smartbuyglasses.com.hk" }, };
    // }

    @Test(dataProvider = "dp", groups = "debug")
    public void leftSubmenuSection1(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        String men = header.getLeftSubMenuElement(1, 1, 1).getText();
        String women = header.getLeftSubMenuElement(1, 1, 2).getText();
        String kid = header.getLeftSubMenuElement(1, 1, 3).getText();
        header.clickLeftSubMenu(1, 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        String url1 = header.getURL();
        Assert.assertEquals(productGridPage.submenuGenderClickedLabel.getText(), men);
        header.clickLeftSubMenu(1, 1, 2);
        String url2 = header.getURL();
        header.confirmPage(url1);
        Assert.assertEquals(productGridPage.submenuGenderClickedLabel.getText(), women);
        header.clickLeftSubMenu(1, 1, 3);
        header.confirmPage(url2);
        Assert.assertEquals(productGridPage.submenuGenderClickedLabel.getText(), kid);
    }

    @Test(dataProvider = "dp", groups = "debug")
    public void leftSubmenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        // header.clickLeftSubMenu(1, 2, 1);
        // header.getStyleUserGenderElement(2).click();
        // header.styleNextButton.click();
        // header.getStyleSunOrSportOrFrameElement(1).click();
        // header.styleNextButton.click();
        // header.getStyleSunGlassStyleElement(3).click();
        // header.styleNextButton.click();
        // header.getStyleFrameShapeElement(4).click();
        // header.styleNextButton.click();
        // header.getStyleFrameColorElement(5).click();
        // header.styleRecommend.click();
        header.clickLeftSubMenu(1, 2, 2);
        VirtualPage virtualPage = new VirtualPage();
        Assert.assertTrue(virtualPage.VirtualClickPage.getAttribute("id").contains("virtual"), "don't virtual page");
        header.clickLeftSubMenu(1, 2, 3);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
        header.clickLeftSubMenu(1, 2, 4);
    }

    @Test(dataProvider = "dp", groups = "debug")
    public void leftSubmenusubLeftMenuSectionNum3(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        String prescription = header.getLeftSubMenuElement(1, 3, 1).getText();
        String polarized = header.getLeftSubMenuElement(1, 3, 2).getText();
        String sports = header.getLeftSubMenuElement(1, 3, 3).getText();
        String skiGoggles = header.getLeftSubMenuElement(1, 3, 4).getText();
        header.clickLeftSubMenu(1, 3, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.submenuCategoryPrescriptionClickedLabel.getText().contains(prescription), "Page disagree");
        header.clickLeftSubMenu(1, 3, 2);
        String url1 = header.getURL();
        Assert.assertTrue(productGridPage.submenuCategoryPolarizedClickedLabel.getText().contains(polarized), "Page disagree");
        header.clickLeftSubMenu(1, 3, 3);
        String url2 = header.getURL();
        header.confirmPage(url1);
        header.clickLeftSubMenu(1, 3, 4);
        header.confirmPage(url2);
        Assert.assertTrue(productGridPage.submenuSkiClickedLabel.getText().contains(skiGoggles), "Page disagree");
    }

    @Test(dataProvider = "dp", groups = "debug")
    public void subMidMenuSectionNum1(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        String pilot = header.getMiddleSubmenuElement(1, 1, 1).getText();
        String square = header.getMiddleSubmenuElement(1, 1, 2).getText();
        String rectangle = header.getMiddleSubmenuElement(1, 1, 3).getText();
        String oversized = header.getMiddleSubmenuElement(1, 1, 4).getText();
        String singleLens = header.getMiddleSubmenuElement(1, 1, 5).getText();
        header.clickMiddleSubMenu(1, 1, 1);
        String url1 = header.getURL();
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), pilot);
        header.clickMiddleSubMenu(1, 1, 2);
        String url2 = header.getURL();
        header.confirmPage(url1);
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), square);
        header.clickMiddleSubMenu(1, 1, 3);
        String url3 = header.getURL();
        header.confirmPage(url2);
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), rectangle);
        header.clickMiddleSubMenu(1, 1, 4);
        String url4 = header.getURL();
        header.confirmPage(url3);
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), oversized);
        header.clickMiddleSubMenu(1, 1, 5);
        header.confirmPage(url4);
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), singleLens);
    }

    @Test(dataProvider = "dp", groups = "debug")
    public void subMidMenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        String price1 = header.getMiddleSubmenuElement(1, 2, 1).getText();
        String price2 = header.getMiddleSubmenuElement(1, 2, 2).getText();
        String price3 = header.getMiddleSubmenuElement(1, 2, 3).getText();
        String price4 = header.getMiddleSubmenuElement(1, 2, 4).getText();
        header.clickMiddleSubMenu(1, 2, 1);
        String url1 = header.getURL();
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), productGridPage.regexPage(price1));
        header.clickMiddleSubMenu(1, 2, 2);
        String url2 = header.getURL();
        header.confirmPage(url1);
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), productGridPage.regexPage(price2));
        header.clickMiddleSubMenu(1, 2, 3);
        header.confirmPage(url2);
        Assert.assertEquals(productGridPage.submenuMidClickedLabel.getText(), productGridPage.regexPage(price3));
        header.clickMiddleSubMenu(1, 2, 4);
    }

    @Test(dataProvider = "dp", groups = "debug")
    public void subRightMenu(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        String BrandsA = header.getMegaMenuBrandsNameElement(1, "A", 1, 1).getText();
        String BrandsQ = header.getMegaMenuBrandsNameElement(1, "Q", 2, 2).getText();
        header.clickGlassImg(1, 2);
        header.clickBrands(1, "A", 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.submenuBrandsClickedLabel.getText().contains(BrandsA), "Page disagree");
        header.clickBrands(1, "Q", 2, 2);
        Assert.assertTrue(productGridPage.submenuBrandsClickedLabel.getText().contains(BrandsQ), "Page disagree");

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
