package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage.Label;
import com.motionglobal.pages.sbg.desktop.product.VirtualPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * 10 main domain Test : Menu menu of EyeGlass. click section menu link(1 and other)
 * 
 */
public class TestEyeGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    // @DataProvider(name = "DesktopTestData")
    // public static Object[][] Words() throws IOException {
    // return ExcelDataUtil.getExcelData("src/main/resources/", "DesktopTestData.xlsx", "");
    // }dataProvider = "DesktopTestData",

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" }, { "http://www.smartbuyglasses.nl" } };
    }

    // return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
    // { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
    // { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
    // { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" } };
    // }

    // return new Object[][] { new Object[] { "http://www.smartbuyglasses.se" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum1(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        Menu.mouseOverMainMenu(2);
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 1, 1), 2);
        String men = Menu.getLeftSubMenuElement(2, 1, 1).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 1, 2), 2);
        String women = Menu.getLeftSubMenuElement(2, 1, 2).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 1, 3), 2);
        String kid = Menu.getLeftSubMenuElement(2, 1, 3).getText().toLowerCase();
        ProductGridPage productGridPage = null;
        switch (dice) {
        case 1:
            Menu.clickLeftSubMenu(2, 1, 1);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.gender), men);
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        case 0:
            Menu.clickLeftSubMenu(2, 1, 2);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.gender), women);
            break;
        default:
            Menu.clickLeftSubMenu(2, 1, 3);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.gender), kid);
            break;
        }
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum2(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.clickLeftSubMenu(2, 2, 2);
        VirtualPage virtualPage = new VirtualPage();
        Assert.assertTrue(virtualPage.VirtualClickPage.getAttribute("id").contains("virtual"), "don't virtual page");
        Menu.clickLeftSubMenu(2, 2, 3);
        ProductGridPage productGridPage = new ProductGridPage();
        try {
            Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
        }
        catch (Error e) {
            Assert.assertEquals(productGridPage.sunTop100Eles.size(), 100, "sunglasses Top100 count : disagree");
        }
        Menu.clickLeftSubMenu(2, 2, 4);
        Menu.clickLeftSubMenu(2, 2, 5);
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subLeftMenuSectionNum3(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        Menu.mouseOverMainMenu(2);
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 3, 1), 2);
        String plastic = Menu.getLeftSubMenuElement(2, 3, 1).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 3, 2), 2);
        String metal = Menu.getLeftSubMenuElement(2, 3, 2).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 3, 3), 2);
        String titanium = Menu.getLeftSubMenuElement(2, 3, 3).getText().toLowerCase();
        // Menu.waitForVisibility(Menu.getLeftSubMenuElement(2, 3, 4), 2);
        // String wood = Menu.getLeftSubMenuElement(2, 3, 4).getText().toLowerCase();
        ProductGridPage productGridPage = null;
        switch (dice) {
        case 1:
            Menu.clickLeftSubMenu(2, 3, 1);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), plastic);
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        case 0:
            Menu.clickLeftSubMenu(2, 3, 2);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), metal);
            break;
        default:
            Menu.clickLeftSubMenu(2, 3, 3);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), titanium);
            break;
        // case 1:
        // Menu.clickLeftSubMenu(2, 3, 4);
        // Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material).getText(), wood);
        // break;
        }
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum1(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(4);
        Menu.mouseOverMainMenu(2);
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 1, 1), 2);
        String pilot = Menu.getMiddleSubmenuElement(2, 1, 1).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 1, 2), 2);
        String square = Menu.getMiddleSubmenuElement(2, 1, 2).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 1, 3), 2);
        String oval = Menu.getMiddleSubmenuElement(2, 1, 3).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 1, 4), 2);
        String rectangle = Menu.getMiddleSubmenuElement(2, 1, 4).getText().toLowerCase();
        ProductGridPage productGridPage = null;
        switch (dice) {
        case 2:
            Menu.clickMiddleSubMenu(2, 1, 1);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), pilot);
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        case 0:
            Menu.clickMiddleSubMenu(2, 1, 2);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), square);
            break;
        case 1:
            Menu.clickMiddleSubMenu(2, 1, 3);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), oval);
            break;
        default:
            Menu.clickMiddleSubMenu(2, 1, 4);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), rectangle);
            break;
        }
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum2(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        Menu.mouseOverMainMenu(2);
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 2, 1), 2);
        String fullRim = Menu.getMiddleSubmenuElement(2, 2, 1).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 2, 2), 2);
        String semiRim = Menu.getMiddleSubmenuElement(2, 2, 2).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 2, 3), 2);
        String rimless = Menu.getMiddleSubmenuElement(2, 2, 3).getText().toLowerCase();
        ProductGridPage productGridPage = null;
        switch (dice) {
        case 1:
            Menu.clickMiddleSubMenu(2, 2, 1);
            productGridPage = new ProductGridPage();
            if (!(url.equals("http://www.smartbuyglasses.nl") | url.equals("http://www.smartbuyglasses.se")))
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), fullRim);
            if (url.equals("http://www.smartbuyglasses.nl"))
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), "volledig omrand");
            if (url.equals("http://www.smartbuyglasses.se"))
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), "hel ram");
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        case 0:
            Menu.clickMiddleSubMenu(2, 2, 2);
            productGridPage = new ProductGridPage();
            if (!(url.equals("http://www.smartbuyglasses.se")))
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), semiRim);
            else
                Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.se/glas%C3%B6gon/general/---Semi+Rimless--------------------");
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        default:
            Menu.clickMiddleSubMenu(2, 2, 3);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), rimless);
            break;
        }
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum3(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(4);
        Menu.mouseOverMainMenu(2);
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 3, 1), 2);
        String price1 = Menu.getMiddleSubmenuElement(2, 3, 1).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 3, 2), 2);
        String price2 = Menu.getMiddleSubmenuElement(2, 3, 2).getText().toLowerCase();
        Menu.waitForVisibility(Menu.getMiddleSubmenuElement(2, 3, 3), 2);
        String price3 = Menu.getMiddleSubmenuElement(2, 3, 3).getText().toLowerCase();
        ProductGridPage productGridPage = null;
        switch (dice) {
        case 2:
            Menu.clickMiddleSubMenu(2, 3, 1);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), productGridPage.regexPage(price1));
            break;
        case 0:
            Menu.clickMiddleSubMenu(2, 3, 2);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), productGridPage.regexPage(price2));
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        case 1:
            Menu.clickMiddleSubMenu(2, 3, 3);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), productGridPage.regexPage(price3));
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        default:
            Menu.clickMiddleSubMenu(2, 3, 4);
            productGridPage = new ProductGridPage();
            Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.mid).contains("999"), "mismatch: price 999 page ");
            Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subRightMenu(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.mouseOverMainMenu(2);
        // String[] ImgName = Menu.getMegaMenuBrandLogoImage(2, 2).findElement(By.xpath("..")).getAttribute("onclick").split(" - ");
        // System.out.println(ImgName[2].replace("')", ""));
        Menu.mouseOver(Menu.getMegaMenuBrandInitialElement(2, "A"));
        String BrandsA = Menu.getMegaMenuBrandsNameElement(2, "A", 1, 1).getText().toLowerCase();
        Menu.mouseOver(Menu.getMegaMenuBrandInitialElement(2, "Q"));
        String BrandsQ = Menu.getMegaMenuBrandsNameElement(2, "Q", 2, 2).getText().toLowerCase();
        Menu.clickGlassImg(2, 2);
        Menu.clickBrands(2, "A", 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.brands).contains(BrandsA.replace(" NEW !", "")), "Page disagree");
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
        Menu.clickBrands(2, "Q", 2, 2);
        Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.brands).contains(BrandsQ.replace(" NEW !", "")), "Page disagree");
        Assert.assertTrue(productGridPage.proInfo.size() > 4, "product Number < 5");
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
