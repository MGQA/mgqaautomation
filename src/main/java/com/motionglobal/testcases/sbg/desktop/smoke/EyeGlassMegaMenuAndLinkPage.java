package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.VirtualPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class EyeGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

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
        header.mouseOverMainMenu(2);
        String name1 = header.getLeftSubMenuElement(2, 1, 1).getText();
        String name2 = header.getLeftSubMenuElement(2, 1, 2).getText();
        String name3 = header.getLeftSubMenuElement(2, 1, 3).getText();
        header.clickLeftSubMenu(2, 1, 1);
        String url1 = driver.getCurrentUrl();
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.assertGenderMaterialSubMidMenuPage(name1);
        header.clickLeftSubMenu(2, 1, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        productGridPage.assertGenderMaterialSubMidMenuPage(name2);
        header.clickLeftSubMenu(2, 1, 3);
        header.confirmPage(url2);
        productGridPage.assertGenderMaterialSubMidMenuPage(name3);
    }

    @Test(dataProvider = "dp", groups = "debug")
    public void subLeftMenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        // header.clickLeftSubMenu(2, 2, 1);
        // header.waitForVisibility(header.getStyleUserGenderElement(2), 1);
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
        header.clickLeftSubMenu(2, 2, 2);
        VirtualPage virtualPage = new VirtualPage();
        virtualPage.assertVirtualPage();
        header.clickLeftSubMenu(2, 2, 3);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
        header.clickLeftSubMenu(2, 2, 4);
        header.clickLeftSubMenu(2, 2, 5);
        header.mouseOverMainMenu(2);
        String name1 = header.getLeftSubMenuElement(2, 2, 5).getText();
        productGridPage.assertGenderMaterialSubMidMenuPage(name1);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subLeftMenuSectionNum3(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(2);
        String name1 = header.getLeftSubMenuElement(2, 3, 1).getText();
        String name2 = header.getLeftSubMenuElement(2, 3, 2).getText();
        String name3 = header.getLeftSubMenuElement(2, 3, 3).getText();
        header.clickLeftSubMenu(2, 3, 1);
        String url1 = driver.getCurrentUrl();
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.assertGenderMaterialSubMidMenuPage(name1);
        header.clickLeftSubMenu(2, 3, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        productGridPage.assertGenderMaterialSubMidMenuPage(name2);
        header.clickLeftSubMenu(2, 3, 3);
        header.confirmPage(url2);
        productGridPage.assertGenderMaterialSubMidMenuPage(name3);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subMidMenuSectionNum1(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(2);
        String name1 = header.getMiddleSubmenuElement(2, 1, 1).getText();
        String name2 = header.getMiddleSubmenuElement(2, 1, 2).getText();
        String name3 = header.getMiddleSubmenuElement(2, 1, 3).getText();
        String name4 = header.getMiddleSubmenuElement(2, 1, 4).getText();
        header.clickMiddleSubMenu(2, 1, 1);
        String url1 = driver.getCurrentUrl();
        ProductGridPage productGridPage = new ProductGridPage();
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        productGridPage.assertGenderMaterialSubMidMenuPage(name1);
        header.clickMiddleSubMenu(2, 1, 2);
        String url3 = driver.getCurrentUrl();
        header.confirmPage(url2);
        productGridPage.assertGenderMaterialSubMidMenuPage(name2);
        header.clickMiddleSubMenu(2, 1, 3);
        String url4 = driver.getCurrentUrl();
        header.confirmPage(url3);
        productGridPage.assertGenderMaterialSubMidMenuPage(name3);
        header.clickMiddleSubMenu(2, 1, 4);
        header.confirmPage(url4);
        productGridPage.assertGenderMaterialSubMidMenuPage(name4);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subMidMenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(2);
        String name1 = header.getMiddleSubmenuElement(2, 2, 1).getText();
        String name2 = header.getMiddleSubmenuElement(2, 2, 2).getText();
        String name3 = header.getMiddleSubmenuElement(2, 2, 3).getText();
        header.clickMiddleSubMenu(2, 2, 1);
        String url1 = driver.getCurrentUrl();
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.assertGenderMaterialSubMidMenuPage(name1);
        header.clickMiddleSubMenu(2, 2, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        productGridPage.assertGenderMaterialSubMidMenuPage(name2);
        header.clickMiddleSubMenu(2, 2, 3);
        header.confirmPage(url2);
        productGridPage.assertGenderMaterialSubMidMenuPage(name3);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subMidMenuSectionNum3(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(2);
        String name1 = header.getMiddleSubmenuElement(2, 3, 1).getText();
        String name2 = header.getMiddleSubmenuElement(2, 3, 2).getText();
        String name3 = header.getMiddleSubmenuElement(2, 3, 3).getText();
        String name4 = header.getMiddleSubmenuElement(2, 3, 4).getText();
        header.clickMiddleSubMenu(2, 3, 1);
        String url1 = driver.getCurrentUrl();
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.assertGenderMaterialSubMidMenuPage(productGridPage.regexPage(name1));
        header.clickMiddleSubMenu(2, 3, 2);
        String url2 = driver.getCurrentUrl();
        header.confirmPage(url1);
        productGridPage.assertGenderMaterialSubMidMenuPage(productGridPage.regexPage(name2));
        header.clickMiddleSubMenu(2, 3, 3);
        String url3 = driver.getCurrentUrl();
        header.confirmPage(url2);
        productGridPage.assertGenderMaterialSubMidMenuPage(productGridPage.regexPage(name3));
        header.clickMiddleSubMenu(2, 3, 4);
        header.confirmPage(url3);
    }

    @Test(dataProvider = "dp", groups = "debug111")
    public void subRightMenu(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        String name1 = header.getMegaMenuBrandsNameElement(2, "A", 1, 1).getText();
        String name2 = header.getMegaMenuBrandsNameElement(2, "A", 2, 2).getText();
        header.clickGlassImg(2, 2);
        header.clickBrands(2, "A", 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        productGridPage.assertBrandAndSkiPage(name1);
        header.clickBrands(2, "Q", 2, 2);
        productGridPage.assertBrandAndSkiPage(name2);
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
