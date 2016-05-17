package com.motionglobal.testcases.sbg.mobile.smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

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
        for (int i = 0; i < header.getSubMenuElementSize(3, 1); i++) {
            header.menuBtn.click();
            header.waitForVisibility(header.getMainMenuElement(3), 2);
            header.getMainMenuElement(3).click();
            header.getSubMenuElement(3, 1).click();
            String menuBrankName = header.getDetailLinkElement(3, 1, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(3, 1, (i + 1)));
            header.getDetailLinkElement(3, 1, (i + 1)).click();
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
            Assert.assertTrue(productBrankName.contains(menuBrankName));
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    // Miss Assert
    public void menuCLType(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(3, 2); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(3).click();
            header.getSubMenuElement(3, 2).click();
            // String brankName = header.getDetailLinkElement(3, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(3, 2, (i + 1)));
            header.getDetailLinkElement(3, 2, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    // Miss Assert
    public void menuCLFrequency(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < header.getSubMenuElementSize(3, 3); i++) {
            header.menuBtn.click();
            header.getMainMenuElement(3).click();
            header.waitForVisibility(header.getSubMenuElement(3, 3), 2);
            header.getSubMenuElement(3, 3).click();
            // String brankName = header.getDetailLinkElement(3, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(3, 3, (i + 1)));
            header.getDetailLinkElement(3, 3, (i + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
        }
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
