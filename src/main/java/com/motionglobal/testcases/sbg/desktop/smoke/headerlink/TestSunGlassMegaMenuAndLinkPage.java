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
 * 10 main domain Test ： menu menu of SunGlass。 click section menu link(1 and other)
 * 
 */
public class TestSunGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

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
    public void leftSubmenuSection1(String url) {
        getURL(url);
        Menu menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        menu.mouseOverMainMenu(1);
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 1, 1), 2);
        String men = menu.getLeftSubMenuElement(1, 1, 1).getText();
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 1, 2), 2);
        String women = menu.getLeftSubMenuElement(1, 1, 2).getText();
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 1, 3), 2);
        String kid = menu.getLeftSubMenuElement(1, 1, 3).getText();
        ProductGridPage productGridPage;
        switch (dice) {
        case 0:
            menu.clickLeftSubMenu(1, 1, 1);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.gender), men);
            break;
        case 1:
            menu.clickLeftSubMenu(1, 1, 2);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.gender), women);
            break;
        default:
            menu.clickLeftSubMenu(1, 1, 3);
            productGridPage = new ProductGridPage();
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.gender), kid);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void leftSubmenuSectionNum2(String url) {
        getURL(url);
        Menu menu = new Menu();
        menu.clickLeftSubMenu(1, 2, 2);
        VirtualPage virtualPage = new VirtualPage();
        Assert.assertTrue(virtualPage.VirtualClickPage.getAttribute("id").contains("virtual"), "don't virtual page");
        menu.clickLeftSubMenu(1, 2, 3);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.sunTop100Eles.size(), 103, "sunglasses Top100 count : disagree");
        menu.clickLeftSubMenu(1, 2, 4);
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void leftSubmenusubLeftMenuSectionNum3(String url) {
        getURL(url);
        Menu menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        menu.mouseOverMainMenu(1);
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 3, 1), 2);
        String prescription = menu.getLeftSubMenuElement(1, 3, 1).getText();
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 3, 2), 2);
        String polarized = menu.getLeftSubMenuElement(1, 3, 2).getText();
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 3, 3), 2);
        String sports = menu.getLeftSubMenuElement(1, 3, 3).getText();
        menu.waitForVisibility(menu.getLeftSubMenuElement(1, 3, 4), 2);
        String skiGoggles = menu.getLeftSubMenuElement(1, 3, 4).getText();
        menu.clickLeftSubMenu(1, 3, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        //
        if (!(url.equals("http://www.smartbuyglasses.de") | url.equals("http://www.smartbuyglasses.dk") | url.equals("http://www.smartbuyglasses.se")
                | url.equals("http://www.smartbuyglasses.cn") | url.equals("http://www.smartbuyglasses.nl")))
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.pre), prescription);
        else {
            switch (url) {
            case "http://www.smartbuyglasses.de":
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.pre), "Verschreibung");
                break;
            case "http://www.smartbuyglasses.dk":
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.pre), "Med styrke");
                break;
            case "http://www.smartbuyglasses.se":
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.pre), "Receptbelagda");
                break;
            case "http://www.smartbuyglasses.nl":
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.pre), "Op Sterkte");
                break;
            case "http://www.smartbuyglasses.cn":
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.pre), "度数处方");
                break;
            default:
                break;
            }
        }
        switch (dice) {
        case 0:
            menu.clickLeftSubMenu(1, 3, 2);
            if (!(url.equals("http://www.smartbuyglasses.se") | url.equals("http://www.smartbuyglasses.co.nz") | url.equals("http://www.smartbuyglasses.co.uk") | url
                    .equals("http://www.smartbuyglasses.cn")))
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.polarized), polarized);
            else {
                switch (url) {
                case "http://www.smartbuyglasses.cn":
                    Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.polarized), "偏光系列");
                    break;
                case "http://www.smartbuyglasses.se":
                    Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.polarized), "Polariserade");
                    break;
                case "http://www.smartbuyglasses.co.nz":
                    Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.polarized), "Polarized");
                    break;
                case "http://www.smartbuyglasses.co.uk":
                    Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.polarized), "Polarised");
                    break;
                default:
                    break;
                }
            }
            break;
        case 1:
            menu.clickLeftSubMenu(1, 3, 3);
            if (!(url.equals("http://www.smartbuyglasses.com.hk")))
                Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.sports).contains(sports));
            else
                Assert.assertTrue(driver.getCurrentUrl().contains("http://www.smartbuyglasses.com.hk/sports-sunglasses/general/---------------------"));
            break;
        default:
            menu.clickLeftSubMenu(1, 3, 4);
            Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.ski).contains(skiGoggles), "mismatch ski page");
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum1(String url) {
        getURL(url);
        Menu menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(4);
        menu.mouseOverMainMenu(1);
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 1, 1), 2);
        String pilot = menu.getMiddleSubmenuElement(1, 1, 1).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 1, 2), 2);
        String square = menu.getMiddleSubmenuElement(1, 1, 2).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 1, 3), 2);
        String rectangle = menu.getMiddleSubmenuElement(1, 1, 3).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 1, 4), 2);
        String oversized = menu.getMiddleSubmenuElement(1, 1, 4).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 1, 5), 2);
        String singleLens = menu.getMiddleSubmenuElement(1, 1, 5).getText();
        menu.clickMiddleSubMenu(1, 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), pilot);
        switch (dice) {
        case 0:
            menu.clickMiddleSubMenu(1, 1, 2);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), square);
            break;
        case 1:
            menu.clickMiddleSubMenu(1, 1, 3);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), rectangle);
            break;
        case 2:
            menu.clickMiddleSubMenu(1, 1, 4);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), oversized);
            break;
        default:
            menu.clickMiddleSubMenu(1, 1, 5);
            if (!(url.equals("http://www.smartbuyglasses.nl")))
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), singleLens);
            else
                Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), "Enkele Lens");
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum2(String url) {
        getURL(url);
        Menu menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        menu.mouseOverMainMenu(1);
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 2, 1), 2);
        String price1 = menu.getMiddleSubmenuElement(1, 2, 1).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 2, 2), 2);
        String price2 = menu.getMiddleSubmenuElement(1, 2, 2).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 2, 3), 2);
        String price3 = menu.getMiddleSubmenuElement(1, 2, 3).getText();
        menu.clickMiddleSubMenu(1, 2, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), productGridPage.regexPage(price1));
        switch (dice) {
        case 0:
            menu.clickMiddleSubMenu(1, 2, 2);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), productGridPage.regexPage(price2));
            break;
        case 1:
            menu.clickMiddleSubMenu(1, 2, 3);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.mid), productGridPage.regexPage(price3));
            break;
        default:
            menu.clickMiddleSubMenu(1, 2, 4);
            Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.mid).contains("999"));
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subMidMenuSectionNum3(String url) {
        getURL(url);
        Menu menu = new Menu();
        Random random = new Random();
        int dice = random.nextInt(3);
        menu.mouseOverMainMenu(1);
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 3, 1), 2);
        String Plastic = menu.getMiddleSubmenuElement(1, 3, 1).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 3, 2), 2);
        String Metal = menu.getMiddleSubmenuElement(1, 3, 2).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 3, 3), 2);
        String Titanium = menu.getMiddleSubmenuElement(1, 3, 3).getText();
        menu.waitForVisibility(menu.getMiddleSubmenuElement(1, 3, 4), 2);
        String Wood = menu.getMiddleSubmenuElement(1, 3, 4).getText();
        menu.clickMiddleSubMenu(1, 3, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), Plastic);
        switch (dice) {
        case 0:
            menu.clickMiddleSubMenu(1, 3, 2);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), Metal);
            break;
        case 1:
            menu.clickMiddleSubMenu(1, 3, 3);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), Titanium);
            break;
        default:
            menu.clickMiddleSubMenu(1, 3, 4);
            Assert.assertEquals(productGridPage.getSubmenuPageLabelText(Label.material), Wood);
            break;
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void subRightMenu(String url) {
        getURL(url);
        Menu menu = new Menu();
        menu.mouseOverMainMenu(1);
        // String[] ImgName = menu.getMegaMenuBrandLogoImage(2, 2).findElement(By.xpath("..")).getAttribute("onclick").split(" - ");
        // System.out.println(ImgName[2].replace("')", ""));
        menu.mouseOver(menu.getMegaMenuBrandInitialElement(1, "A"));
        String BrandsA = menu.getMegaMenuBrandsNameElement(1, "A", 1, 1).getText();
        menu.mouseOver(menu.getMegaMenuBrandInitialElement(1, "Q"));
        String BrandsQ = menu.getMegaMenuBrandsNameElement(1, "Q", 2, 2).getText();
        menu.clickGlassImg(1, 2);
        menu.clickBrands(1, "A", 1, 1);
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.brands).contains(BrandsA.replace(" NEW !", "")), "Page disagree");
        menu.clickBrands(1, "Q", 2, 2);
        Assert.assertTrue(productGridPage.getSubmenuPageLabelText(Label.brands).contains(BrandsQ.replace(" NEW !", "")), "Page disagree");

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
