package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.CLProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestCLGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

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

    // return new Object[][] { new Object[] { "http://www.smartbuyglasses.nl" } };
    // }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum1(String url) {
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(5);
        header.waitForVisibility(header.getLeftSubMenuElement(5, 1, 1), 2);
        String spherical = header.getLeftSubMenuElement(5, 1, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 1, 2), 2);
        String toric = header.getLeftSubMenuElement(5, 1, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 1, 3), 2);
        String multifocal = header.getLeftSubMenuElement(5, 1, 3).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 1, 4), 2);
        String aspherical = header.getLeftSubMenuElement(5, 1, 4).getText();
        header.clickLeftSubMenu(5, 1, 1);
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel1(1).getText(), spherical);
        header.clickLeftSubMenu(5, 1, 2);
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel1(2).getText(), toric);
        header.clickLeftSubMenu(5, 1, 3);
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel1(3).getText(), multifocal);
        header.clickLeftSubMenu(5, 1, 4);
        if (!(url.equals("http://www.smartbuyglasses.dk")))
            Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel1(4).getText(), aspherical);
        else
            Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel1(4).getText(), "Asfæriske");

    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum2(String url) {
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(5);
        header.waitForVisibility(header.getLeftSubMenuElement(5, 2, 1), 2);
        String extendedWear = header.getLeftSubMenuElement(5, 2, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 2, 2), 2);
        String siliconeHydrogel = header.getLeftSubMenuElement(5, 2, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 2, 3), 2);
        String coloured = header.getLeftSubMenuElement(5, 2, 3).getText();
        header.clickLeftSubMenu(5, 2, 1);
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        if (!(url.equals("http://www.smartbuyglasses.dk")))
            Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel2(1).getText(), extendedWear);
        else
            Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel2(1).getText(), "Langtidsbrug");
        header.clickLeftSubMenu(5, 2, 2);
        if (!(url.equals("http://www.smartbuyglasses.dk")))
            Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel2(2).getText(), siliconeHydrogel);
        else
            Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel2(2).getText(), "Silikone Hydrogel");
        header.clickLeftSubMenu(5, 2, 3);
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel2(3).getText(), coloured);
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum3(String url) {
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(5);
        header.waitForVisibility(header.getLeftSubMenuElement(5, 3, 1), 2);
        String bausch = header.getLeftSubMenuElement(5, 3, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 3, 2), 2);
        String ciba = header.getLeftSubMenuElement(5, 3, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 3, 3), 2);
        String coopervision = header.getLeftSubMenuElement(5, 3, 3).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(5, 3, 4), 2);
        String johnson = header.getLeftSubMenuElement(5, 3, 4).getText();
        header.clickLeftSubMenu(5, 3, 1);
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel3(1).getText(), bausch);
        header.clickLeftSubMenu(5, 3, 2);
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel3(2).getText(), ciba);
        header.clickLeftSubMenu(5, 3, 3);
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel3(3).getText(), coopervision);
        header.clickLeftSubMenu(5, 3, 4);
        Assert.assertEquals(clProductGridPage.submenuCLLeftClickedLabel3(4).getText(), johnson);
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum1(String url) {
        getURL(url);
        Header header = new Header();
        header.clickMiddleSubMenu(5, 1, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 2);
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 1, 3);
        Assert.assertTrue(id.contains("information"));
        if (!(url.equals("http://www.smartbuyglasses.com.hk"))) {
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
            if (!(url.equals("http://www.smartbuyglasses.co.nz"))) {
                header.clickMiddleSubMenu(5, 1, 13);
                Assert.assertTrue(id.contains("information"));
            }
        }
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum2(String url) {
        getURL(url);
        Header header = new Header();
        header.clickMiddleSubMenu(5, 2, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 2, 2);
        Assert.assertTrue(id.contains("information"));
        if (!(url.equals("http://www.smartbuyglasses.com.hk") | url.equals("http://www.smartbuyglasses.se"))) {
            header.clickMiddleSubMenu(5, 2, 3);
            Assert.assertTrue(id.contains("information"));
            if (!(url.equals("http://www.smartbuyglasses.dk"))) {
                header.clickMiddleSubMenu(5, 2, 4);
                Assert.assertTrue(id.contains("information"));
                if (!(url.equals("http://www.smartbuyglasses.co.uk") | url.equals("http://www.smartbuyglasses.de") | url
                        .equals("http://www.smartbuyglasses.nl"))) {
                    header.clickMiddleSubMenu(5, 2, 5);
                    Assert.assertTrue(id.contains("information"));
                    header.clickMiddleSubMenu(5, 2, 6);
                    Assert.assertTrue(id.contains("information"));
                }
            }
        }
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum3(String url) {
        getURL(url);
        Header header = new Header();
        header.clickMiddleSubMenu(5, 3, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        header.clickMiddleSubMenu(5, 3, 2);
        Assert.assertTrue(id.contains("information"));
        if (!(url.equals("http://www.smartbuyglasses.com.hk"))) {
            header.clickMiddleSubMenu(5, 3, 3);
            Assert.assertTrue(id.contains("information"));
            header.clickMiddleSubMenu(5, 3, 4);
            Assert.assertTrue(id.contains("information"));
        }
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void subRightMenu(String url) {
        getURL(url);
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
