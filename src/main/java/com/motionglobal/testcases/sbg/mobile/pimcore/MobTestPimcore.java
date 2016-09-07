package com.motionglobal.testcases.sbg.mobile.pimcore;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * pimcore and sbg is different , so need it to check . and now ,it don't fixed.
 * 
 */
public class MobTestPimcore extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk/optical-centre" } };
    }

    // XXX case 1
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

    // XXX case 2
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

    // XXX case 3
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

    // XXX case 4
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassGender(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(2, 1); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(2, 1));
        System.out.println(num);
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.getSubMenuElement(2, 1).click();
        // String brankName = header.getDetailLinkElement(2, 1, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 1, (num + 1)));
        header.getDetailLinkElement(2, 1, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(2, 2) - 1; i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(2, 2));
        if (!(num == (header.getSubMenuElementSize(2, 2) - 1))) {
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.EYE).click();
            header.getSubMenuElement(2, 2).click();
            // String brankName = header.getDetailLinkElement(2, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 2, (num + 1)));
            header.getDetailLinkElement(2, 2, (num + 1)).click();
            MobProductPage productPage = new MobProductPage();
        }
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
        //
        else {
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.EYE).click();
            header.getSubMenuElement(2, 2).click();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 2, (header.getSubMenuElementSize(2, 2))));
            header.getDetailLinkElement(2, 2, header.getSubMenuElementSize(2, 2)).click();
        }
    }

    // XXX case 6
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassShape(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(2, 3); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(2, 3));
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.getSubMenuElement(2, 3).click();
        // String brankName = header.getDetailLinkElement(2, 3, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 3, (num + 1)));
        header.getDetailLinkElement(2, 3, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    // XXX case 7
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassStyle(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(2, 4); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(2, 4));
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.getSubMenuElement(2, 4).click();
        // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(2, 4, (num + 1)));
        header.getDetailLinkElement(2, 4, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    // XXX case 8
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassGender(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(1, 1); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(1, 1));
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.SUN).click();
        header.getSubMenuElement(1, 1).click();
        // String brankName = header.getDetailLinkElement(2, 1, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 1, (num + 1)));
        header.getDetailLinkElement(1, 1, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    // XXX case 9
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassBrank(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(1, 2) - 1; i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(1, 2));
        if (!(num == (header.getSubMenuElementSize(1, 2) - 1))) {
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.SUN).click();
            header.getSubMenuElement(1, 2).click();
            // String brankName = header.getDetailLinkElement(2, 2, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 2, (num + 1)));
            header.getDetailLinkElement(1, 2, (num + 1)).click();
            MobProductPage productPage = new MobProductPage();
            // String brankNameList = "";
            // for (int j = 0; j < productPage.productList.size(); j++) {
            // brankNameList += productPage.getProductName(j);
            // }
            // Assert.assertTrue(brankNameList.contains(brankName));
            // }
            //
        }
        else {
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.SUN).click();
            header.getSubMenuElement(1, 2).click();
            js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 2, (header.getSubMenuElementSize(1, 2))));
            header.getDetailLinkElement(1, 2, header.getSubMenuElementSize(1, 2)).click();
        }
    }

    // XXX case 10
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassShape(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < header.getSubMenuElementSize(1, 3); i++) {
        Random random = new Random();
        int num = random.nextInt(header.getSubMenuElementSize(1, 3));
        header.menuBtn.click();
        header.getMainMenuElement(MegaMenu.SUN).click();
        header.getSubMenuElement(1, 3).click();
        // String brankName = header.getDetailLinkElement(2, 3, (i + 1)).getText();
        js.executeScript("arguments[0].scrollIntoView();", header.getDetailLinkElement(1, 3, (num + 1)));
        header.getDetailLinkElement(1, 3, (num + 1)).click();
        MobProductPage productPage = new MobProductPage();
        // String brankNameList = "";
        // for (int j = 0; j < productPage.productList.size(); j++) {
        // brankNameList += productPage.getProductName(j);
        // }
        // Assert.assertTrue(brankNameList.contains(brankName));
        // }
    }

    // XXX case 11
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassOther(String url) {
        driver.get(url);
        MobHeader header = new MobHeader();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Random random = new Random();
        int num = random.nextInt(3);
        switch (num) {
        case 0:
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.SUN).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.subMenuPolarized);
            header.subMenuPolarized.click();
            MobProductPage productPage1 = new MobProductPage();
            break;
        case 1:
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.SUN).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.subMenuPre);
            header.subMenuPre.click();
            MobProductPage productPage2 = new MobProductPage();
            break;
        default:
            header.menuBtn.click();
            header.getMainMenuElement(MegaMenu.SUN).click();
            // String brankName = header.getDetailLinkElement(2, 4, (i + 1)).getText();
            js.executeScript("arguments[0].scrollIntoView();", header.subMenuSki);
            header.subMenuSki.click();
            MobProductPage productPage3 = new MobProductPage();
            break;
        }
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
