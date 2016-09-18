package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.CLProductDetailPage;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * 10 main domain Test: Menu menu of CL. click section menu link(1 and other)
 */
public class TestCLGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    // @DataProvider(name = "DesktopTestData")
    // public static Object[][] Words() throws IOException {
    // return ExcelDataUtil.getExcelData("src/main/resources/", "DesktopTestData.xlsx", "");
    // }dataProvider = "DesktopTestData",

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" }, { "http://www.smartbuyglasses.de" },
                { "http://www.smartbuyglasses.nl" } };
    }

    // return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
    // { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
    // { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
    // { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" } };
    // }

    // return new Object[][] { new Object[] { "http://www.smartbuyglasses.nl" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum1(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        Menu.mouseOverMainMenu(5);
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 1, 1), 2);
        String spherical = Menu.getLeftSubMenuElement(5, 1, 1).getText();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 1, 2), 2);
        String toric = Menu.getLeftSubMenuElement(5, 1, 2).getText();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 1, 3), 2);
        String multifocal = Menu.getLeftSubMenuElement(5, 1, 3).getText();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 1, 4), 2);
        String aspherical = Menu.getLeftSubMenuElement(5, 1, 4).getText();
        Menu.clickLeftSubMenu(5, 1, 1);
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), spherical);
        switch (dice) {
        case 0:
            Menu.clickLeftSubMenu(5, 1, 2);
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), toric);
            break;
        case 1:
            Menu.clickLeftSubMenu(5, 1, 3);
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), multifocal);
            break;
        default:
            Menu.clickLeftSubMenu(5, 1, 4);
            if (!(url.equals("http://www.smartbuyglasses.dk")))
                Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), aspherical);
            else
                Assert.assertEquals(
                        driver.getCurrentUrl(),
                        "http://www.smartbuyglasses.dk/kontaktlinser/t/asfaeriske-linser#!&s=popularitet&tb=0&t=aspherical&p=1");
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum2(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(2);
        Menu.clickLeftSubMenu(5, 2, 1);
        Menu.mouseOverMainMenu(5);
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 2, 1), 2);
        String extendedWear = Menu.getLeftSubMenuElement(5, 2, 1).getText();
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), extendedWear);
        switch (dice) {
        case 0:
            Menu.clickLeftSubMenu(5, 2, 2);
            Menu.mouseOverMainMenu(5);
            Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 2, 2), 2);
            String siliconeHydrogel = Menu.getLeftSubMenuElement(5, 2, 2).getText();
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), siliconeHydrogel);
            break;
        default:
            Menu.clickLeftSubMenu(5, 2, 3);
            Menu.mouseOverMainMenu(5);
            Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 2, 3), 2);
            String coloured = Menu.getLeftSubMenuElement(5, 2, 3).getText();
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), coloured);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum3(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        Menu.mouseOverMainMenu(5);

        // 531 change to 541 because add a <ul/> .but seem it is excess;
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 4, 1), 2);
        String bausch = Menu.getLeftSubMenuElement(5, 4, 1).getText();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 4, 2), 2);
        String ciba = Menu.getLeftSubMenuElement(5, 4, 2).getText();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 4, 3), 2);
        String coopervision = Menu.getLeftSubMenuElement(5, 4, 3).getText();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(5, 4, 4), 2);
        String johnson = Menu.getLeftSubMenuElement(5, 4, 4).getText();
        Menu.clickLeftSubMenu(5, 4, 1);
        CLProductGridPage clProductGridPage = new CLProductGridPage();
        Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), bausch);
        switch (dice) {
        case 0:
            Menu.clickLeftSubMenu(5, 4, 2);
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), ciba);
            break;
        case 1:
            Menu.clickLeftSubMenu(5, 4, 3);
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), coopervision);
            break;
        default:
            Menu.clickLeftSubMenu(5, 4, 4);
            Assert.assertEquals(clProductGridPage.checkedLeftSubmenuElement.getText(), johnson);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum1(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(2);
        Menu.clickMiddleSubMenu(5, 1, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        switch (dice) {
        case 0:
            Menu.clickMiddleSubMenu(5, 1, 2);
            Assert.assertTrue(id.contains("information"));
            break;
        default:
            Menu.clickMiddleSubMenu(5, 1, 3);
            Assert.assertTrue(id.contains("information"));
            break;
        }
        // if (!(url.equals("http://www.smartbuyglasses.com.hk"))) {
        // Menu.clickMiddleSubMenu(5, 1, 4);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 5);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 6);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 7);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 8);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 9);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 10);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 11);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 1, 12);
        // Assert.assertTrue(id.contains("information"));
        // if (!(url.equals("http://www.smartbuyglasses.co.nz"))) {
        // Menu.clickMiddleSubMenu(5, 1, 13);
        // Assert.assertTrue(id.contains("information"));
        // }
        // }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum2(String url) {
        getURL(url);
        Menu Menu = new Menu();
        boolean subMenuDispaly = false;
        try {
            Menu.displayMenu(5);
            Menu.getCLWeeklyElement(1);
            subMenuDispaly = true;
        }
        catch (Exception e) {
        }
        System.out.println(subMenuDispaly);
        if (subMenuDispaly) {
            Menu.clickMiddleSubMenu(5, 2, 1);
            CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
            String id = clProductDetailPage.information.getAttribute("id");
            Assert.assertTrue(id.contains("information"));
            Menu.clickMiddleSubMenu(5, 2, 2);
            Assert.assertTrue(id.contains("information"));
            // if (!(url.equals("http://www.smartbuyglasses.com.hk") | url.equals("http://www.smartbuyglasses.se"))) {
            // Menu.clickMiddleSubMenu(5, 2, 3);
            // Assert.assertTrue(id.contains("information"));
            // if (!(url.equals("http://www.smartbuyglasses.dk"))) {
            // Menu.clickMiddleSubMenu(5, 2, 4);
            // Assert.assertTrue(id.contains("information"));
            // if (!(url.equals("http://www.smartbuyglasses.co.uk") | url.equals("http://www.smartbuyglasses.de") | url
            // .equals("http://www.smartbuyglasses.nl"))) {
            // Menu.clickMiddleSubMenu(5, 2, 5);
            // Assert.assertTrue(id.contains("information"));
            // Menu.clickMiddleSubMenu(5, 2, 6);
            // Assert.assertTrue(id.contains("information"));
            // }
            // }
            // }
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum3(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.clickMiddleSubMenu(5, 3, 1);
        CLProductDetailPage clProductDetailPage = new CLProductDetailPage();
        String id = clProductDetailPage.information.getAttribute("id");
        Assert.assertTrue(id.contains("information"));
        Menu.clickMiddleSubMenu(5, 3, 2);
        Assert.assertTrue(id.contains("information"));
        // if (!(url.equals("http://www.smartbuyglasses.com.hk"))) {
        // Menu.clickMiddleSubMenu(5, 3, 3);
        // Assert.assertTrue(id.contains("information"));
        // Menu.clickMiddleSubMenu(5, 3, 4);
        // Assert.assertTrue(id.contains("information"));
        // }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subRightMenu(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.clickGlassImg(5, 2);
        Menu.mouseOverMainMenu(5);
        Menu.mouseOver(Menu.clViewAllBrands);
        Menu.getCLBrandsElement(2).click();
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
