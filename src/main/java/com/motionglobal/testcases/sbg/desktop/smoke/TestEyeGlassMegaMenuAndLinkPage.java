package com.motionglobal.testcases.sbg.desktop.smoke;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage.Label;
import com.motionglobal.pages.sbg.desktop.product.VirtualPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestEyeGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

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

    // return new Object[][] { new Object[] { "http://www.smartbuyglasses.se" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum1(String url) {
        getURL(url);
        Header header = new Header();
        Random random = new Random();
        int dice = random.nextInt(2);
        header.mouseOverMainMenu(2);
        header.waitForVisibility(header.getLeftSubMenuElement(2, 1, 1), 2);
        String men = header.getLeftSubMenuElement(2, 1, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(2, 1, 2), 2);
        String women = header.getLeftSubMenuElement(2, 1, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(2, 1, 3), 2);
        String kid = header.getLeftSubMenuElement(2, 1, 3).getText();
        header.clickLeftSubMenu(2, 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.gender).getText(), men);
        switch (dice) {
        case 0:
            header.clickLeftSubMenu(2, 1, 2);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.gender).getText(), women);
            break;
        default:
            header.clickLeftSubMenu(2, 1, 3);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.gender).getText(), kid);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum2(String url) {
        getURL(url);
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
        // header.waitForVisibility(header.getLeftSubMenuElement(1, 2, 2), 10);
        if (!(url.equals("http://www.smartbuyglasses.cn"))) {
            header.clickLeftSubMenu(2, 2, 2);
            VirtualPage virtualPage = new VirtualPage();
            Assert.assertTrue(virtualPage.VirtualClickPage.getAttribute("id").contains("virtual"), "don't virtual page");
            header.clickLeftSubMenu(2, 2, 3);
            ProductGridPage productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
            header.clickLeftSubMenu(2, 2, 4);
            header.clickLeftSubMenu(2, 2, 5);
        }
        else {
            header.clickLeftSubMenu(2, 2, 2);
            ProductGridPage productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
            header.clickLeftSubMenu(2, 2, 3);
            header.clickLeftSubMenu(2, 2, 4);
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum3(String url) {
        getURL(url);
        Header header = new Header();
        Random random = new Random();
        int dice = random.nextInt(3);
        header.mouseOverMainMenu(2);
        header.waitForVisibility(header.getLeftSubMenuElement(2, 3, 1), 2);
        String plastic = header.getLeftSubMenuElement(2, 3, 1).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(2, 3, 2), 2);
        String metal = header.getLeftSubMenuElement(2, 3, 2).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(2, 3, 3), 2);
        String titanium = header.getLeftSubMenuElement(2, 3, 3).getText();
        header.waitForVisibility(header.getLeftSubMenuElement(2, 3, 4), 2);
        String wood = header.getLeftSubMenuElement(2, 3, 4).getText();
        header.clickLeftSubMenu(2, 3, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.material).getText(), plastic);
        switch (dice) {
        case 0:
            header.clickLeftSubMenu(2, 3, 2);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.material).getText(), metal);
            break;
        case 1:
            header.clickLeftSubMenu(2, 3, 3);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.material).getText(), titanium);
            break;
        default:
            header.clickLeftSubMenu(2, 3, 4);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.material).getText(), wood);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum1(String url) {
        getURL(url);
        Header header = new Header();
        Random random = new Random();
        int dice = random.nextInt(3);
        header.mouseOverMainMenu(2);
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 1, 1), 2);
        String pilot = header.getMiddleSubmenuElement(2, 1, 1).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 1, 2), 2);
        String square = header.getMiddleSubmenuElement(2, 1, 2).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 1, 3), 2);
        String oval = header.getMiddleSubmenuElement(2, 1, 3).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 1, 4), 2);
        String rectangle = header.getMiddleSubmenuElement(2, 1, 4).getText();
        header.clickMiddleSubMenu(2, 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), pilot);
        switch (dice) {
        case 0:
            header.clickMiddleSubMenu(2, 1, 2);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), square);
            break;
        case 1:
            header.clickMiddleSubMenu(2, 1, 3);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), oval);
            break;
        default:
            header.clickMiddleSubMenu(2, 1, 4);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), rectangle);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum2(String url) {
        getURL(url);
        Header header = new Header();
        Random random = new Random();
        int dice = random.nextInt(2);
        header.mouseOverMainMenu(2);
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 2, 1), 2);
        String fullRim = header.getMiddleSubmenuElement(2, 2, 1).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 2, 2), 2);
        String semiRim = header.getMiddleSubmenuElement(2, 2, 2).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 2, 3), 2);
        String rimless = header.getMiddleSubmenuElement(2, 2, 3).getText();
        header.clickMiddleSubMenu(2, 2, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        if (!(url.equals("http://www.smartbuyglasses.nl") | url.equals("http://www.smartbuyglasses.se")))
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), fullRim);
        if (url.equals("http://www.smartbuyglasses.nl"))
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), "Volledig Omrand");
        if (url.equals("http://www.smartbuyglasses.se"))
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), "Hel ram");
        switch (dice) {
        case 0:
            header.clickMiddleSubMenu(2, 2, 2);
            if (!(url.equals("http://www.smartbuyglasses.se")))
                Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), semiRim);
            else
                Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.se/glas%C3%B6gon/general/---Semi+Rimless--------------------");
            break;
        default:
            header.clickMiddleSubMenu(2, 2, 3);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), rimless);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum3(String url) {
        getURL(url);
        Header header = new Header();
        Random random = new Random();
        int dice = random.nextInt(3);
        header.mouseOverMainMenu(2);
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 3, 1), 2);
        String price1 = header.getMiddleSubmenuElement(2, 3, 1).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 3, 2), 2);
        String price2 = header.getMiddleSubmenuElement(2, 3, 2).getText();
        header.waitForVisibility(header.getMiddleSubmenuElement(2, 3, 3), 2);
        String price3 = header.getMiddleSubmenuElement(2, 3, 3).getText();
        header.clickMiddleSubMenu(2, 3, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), productGridPage.regexPage(price1));
        switch (dice) {
        case 0:
            header.clickMiddleSubMenu(2, 3, 2);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), productGridPage.regexPage(price2));
            break;
        case 1:
            header.clickMiddleSubMenu(2, 3, 3);
            Assert.assertEquals(productGridPage.submenuPageLabelElement(Label.mid).getText(), productGridPage.regexPage(price3));
            break;
        default:
            header.clickMiddleSubMenu(2, 3, 4);
            Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.mid).getText().contains("999"), "mismatch: price 999 page ");
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subRightMenu(String url) {
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(2);
        header.mouseOver(header.getMegaMenuBrandInitialElement(2, "A"));
        String BrandsA = header.getMegaMenuBrandsNameElement(2, "A", 1, 1).getText();
        header.mouseOver(header.getMegaMenuBrandInitialElement(2, "Q"));
        String BrandsQ = header.getMegaMenuBrandsNameElement(2, "Q", 2, 2).getText();
        header.clickGlassImg(2, 2);
        header.clickBrands(2, "A", 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.submenuPageLabelElement(Label.brands).getText().contains(BrandsA), "Page disagree");
        header.clickBrands(2, "Q", 2, 2);
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
