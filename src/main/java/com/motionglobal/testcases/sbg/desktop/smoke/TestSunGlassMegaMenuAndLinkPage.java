package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage.Label;
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
                { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" }, { "http://www.smartbuyglasses.cn" } };
    }

    // return new Object[][] { new Object[] { "http://www.smartbuyglasses.nl" } };
    // }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void leftSubmenuSection1(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.waitForVisibility(header.getLeftSubMenuElement(1, 1, 1), 2);
        String men = header.getLeftSubMenuElement(1, 1, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(1, 1, 2), 2);
        String women = header.getLeftSubMenuElement(1, 1, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(1, 1, 3), 2);
        String kid = header.getLeftSubMenuElement(1, 1, 3).getText();
        header.clickLeftSubMenu(1, 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.gender).getText(), men);
        header.clickLeftSubMenu(1, 1, 2);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.gender).getText(), women);
        header.clickLeftSubMenu(1, 1, 3);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.gender).getText(), kid);
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
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
        // header.waitForVisibility(header.getLeftSubMenuElement(1, 2, 2), 10);
        if (!(url.equals("http://www.smartbuyglasses.cn"))) {
            header.clickLeftSubMenu(1, 2, 2);
            VirtualPage virtualPage = new VirtualPage();
            Assert.assertTrue(virtualPage.VirtualClickPage.getAttribute("id").contains("virtual"), "don't virtual page");
            header.clickLeftSubMenu(1, 2, 3);
            ProductGridPage productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
            header.clickLeftSubMenu(1, 2, 4);
        }
        else {
            header.clickLeftSubMenu(1, 2, 2);
            ProductGridPage productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
            header.clickLeftSubMenu(1, 2, 3);
        }
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void leftSubmenusubLeftMenuSectionNum3(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.waitForVisibility(header.getLeftSubMenuElement(1, 3, 1), 2);
        String prescription = header.getLeftSubMenuElement(1, 3, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(1, 3, 2), 2);
        String polarized = header.getLeftSubMenuElement(1, 3, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(1, 3, 3), 2);
        String sports = header.getLeftSubMenuElement(1, 3, 3).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(1, 3, 4), 2);
        String skiGoggles = header.getLeftSubMenuElement(1, 3, 4).getText();
        header.clickLeftSubMenu(1, 3, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        //
        if (!(url.equals("http://www.smartbuyglasses.de") | url.equals("http://www.smartbuyglasses.dk") | url.equals("http://www.smartbuyglasses.se")
                | url.equals("http://www.smartbuyglasses.cn") | url.equals("http://www.smartbuyglasses.nl")))
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.pre).getText(), prescription);
        else {
            switch (url) {
            case "http://www.smartbuyglasses.de":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.pre).getText(), "Verschreibung");
                break;
            case "http://www.smartbuyglasses.dk":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.pre).getText(), "Med styrke");
                break;
            case "http://www.smartbuyglasses.se":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.pre).getText(), "Receptbelagda");
                break;
            case "http://www.smartbuyglasses.nl":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.pre).getText(), "Op Sterkte");
                break;
            case "http://www.smartbuyglasses.cn":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.pre).getText(), "度数处方");
                break;
            default:
                break;
            }
        }
        header.clickLeftSubMenu(1, 3, 2);
        if (!(url.equals("http://www.smartbuyglasses.se") | url.equals("http://www.smartbuyglasses.co.nz") | url.equals("http://www.smartbuyglasses.co.uk") | url
                .equals("http://www.smartbuyglasses.cn")))
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.polarized).getText(), polarized);
        else {
            switch (url) {
            case "http://www.smartbuyglasses.cn":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.polarized).getText(), "偏光系列");
                break;
            case "http://www.smartbuyglasses.se":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.polarized).getText(), "Polariserade");
                break;
            case "http://www.smartbuyglasses.co.nz":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.polarized).getText(), "Polarized");
                break;
            case "http://www.smartbuyglasses.co.uk":
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.polarized).getText(), "Polarised");
                break;
            default:
                break;
            }
        }
        header.clickLeftSubMenu(1, 3, 3);
        if (!(url.equals("http://www.smartbuyglasses.com.hk")))
            Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.sports).getText().contains(sports));
        else
            Assert.assertTrue(driver.getCurrentUrl().contains("http://www.smartbuyglasses.com.hk/sports-sunglasses/general/---------------------"));
        header.clickLeftSubMenu(1, 3, 4);
        Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.ski).getText().contains(skiGoggles), "mismatch ski page");
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum1(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 1, 1), 2);
        String pilot = header.getMiddleSubmenuElement(1, 1, 1).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 1, 2), 2);
        String square = header.getMiddleSubmenuElement(1, 1, 2).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 1, 3), 2);
        String rectangle = header.getMiddleSubmenuElement(1, 1, 3).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 1, 4), 2);
        String oversized = header.getMiddleSubmenuElement(1, 1, 4).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 1, 5), 2);
        String singleLens = header.getMiddleSubmenuElement(1, 1, 5).getText();
        header.clickMiddleSubMenu(1, 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), pilot);
        header.clickMiddleSubMenu(1, 1, 2);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), square);
        header.clickMiddleSubMenu(1, 1, 3);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), rectangle);
        header.clickMiddleSubMenu(1, 1, 4);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), oversized);
        header.clickMiddleSubMenu(1, 1, 5);
        if (!(url.equals("http://www.smartbuyglasses.nl")))
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), singleLens);
        else
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), "Enkele Lens");
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum2(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 2, 1), 2);
        String price1 = header.getMiddleSubmenuElement(1, 2, 1).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 2, 2), 2);
        String price2 = header.getMiddleSubmenuElement(1, 2, 2).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(1, 2, 3), 2);
        String price3 = header.getMiddleSubmenuElement(1, 2, 3).getText();
        header.clickMiddleSubMenu(1, 2, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), productGridPage.regexPage(price1));
        header.clickMiddleSubMenu(1, 2, 2);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), productGridPage.regexPage(price2));
        header.clickMiddleSubMenu(1, 2, 3);
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), productGridPage.regexPage(price3));
        header.clickMiddleSubMenu(1, 2, 4);
        Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.mid).getText().contains("999"));
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subRightMenu(String url) {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.mouseOver(header.getMegaMenuBrandInitialElement(1, "A"));
        String BrandsA = header.getMegaMenuBrandsNameElement(1, "A", 1, 1).getText();
        header.mouseOver(header.getMegaMenuBrandInitialElement(1, "Q"));
        String BrandsQ = header.getMegaMenuBrandsNameElement(1, "Q", 2, 2).getText();
        header.clickGlassImg(1, 2);
        header.clickBrands(1, "A", 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.brands).getText().contains(BrandsA), "Page disagree");
        header.clickBrands(1, "Q", 2, 2);
        Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.brands).getText().contains(BrandsQ), "Page disagree");

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
