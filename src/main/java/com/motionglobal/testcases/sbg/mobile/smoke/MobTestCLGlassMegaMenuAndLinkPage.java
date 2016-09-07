package com.motionglobal.testcases.sbg.mobile.smoke;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * m.10 main domain Test £º Header menu of m.CL¡£ click section menu link(random 1)
 * 
 */
public class MobTestCLGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.com" },
                { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.ca" }, { "http://m.smartbuyglasses.com.hk" }, { "http://m.smartbuyglasses.se" },
                { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" } };
    }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk" } };
    // }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuCLBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(3, 1); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(4, 1));
        header.menuBtn.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.CL), 2);
        header.getMainMenuElement(MegaMenu.CL).click();
        header.mouseAndClick(header.getSubMenuElement(4, 1));
        String menuBrankName = header.getDetailLinkElement(4, 1, (num + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(4, 1, (num + 1)));
        header.getDetailLinkElement(4, 1, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        String productBrankName = "";
        for (int j = 0; j < productPage.productList.size(); j++) {
            productBrankName += productPage.getProductName(j);
            if (productBrankName.contains("SofLens"))
                productBrankName = "Soflens";
            if (productBrankName.contains("Expression"))
                productBrankName = "Expressions";
            if (url.equals("http://m.smartbuyglasses.com.hk") && productBrankName.contains("Dailies AquaComfort"))
                productBrankName = "Focus";
        }
        Assert.assertTrue(productBrankName.contains(menuBrankName), "FAIL i IS :" + (num + 1) + " !!! productBrankName IS :" + menuBrankName);
        // }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    // Miss Assert
    public void menuCLType(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(3, 2); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(4, 2));
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.CL).click();
        header.mouseAndClick(header.getSubMenuElement(4, 2));
        // String brankName = header.getDetailLinkElement(3, 2, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(4, 2, (num + 1)));
        header.getDetailLinkElement(4, 2, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    // Miss Assert
    public void menuCLFrequency(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(3, 3); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(4, 3));
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.CL).click();
        header.mouseAndClick(header.getSubMenuElement(4, 3));
        // String brankName = header.getDetailLinkElement(3, 2, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(4, 3, (num + 1)));
        header.getDetailLinkElement(4, 3, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
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
