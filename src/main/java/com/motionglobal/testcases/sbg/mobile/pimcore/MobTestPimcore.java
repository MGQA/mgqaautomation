package com.motionglobal.testcases.sbg.mobile.pimcore;

import java.util.Random;

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
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" }, successPercentage = 0)
    public void menuCLBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.CL), 2);
        header.getMainMenuElement(MegaMenu.CL).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(0), 2);
        header.subMenuS.get(0).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 2
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    // Miss Assert
    public void menuCLType(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.CL), 2);
        header.getMainMenuElement(MegaMenu.CL).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(1), 2);
        header.subMenuS.get(1).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 3
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    // Miss Assert
    public void menuCLFrequency(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.CL), 2);
        header.getMainMenuElement(MegaMenu.CL).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(2), 2);
        header.subMenuS.get(2).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 4
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassGender(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(0), 2);
        header.subMenuS.get(0).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(1), 2);
        header.subMenuS.get(1).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 6
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassShape(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(2), 2);
        header.subMenuS.get(2).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 7
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassStyle(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(3), 2);
        header.subMenuS.get(3).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 8
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassGender(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.SUN), 2);
        header.getMainMenuElement(MegaMenu.SUN).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(0), 2);
        header.subMenuS.get(0).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 9
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.SUN), 2);
        header.getMainMenuElement(MegaMenu.SUN).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(1), 2);
        header.subMenuS.get(1).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 10
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassShape(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.SUN), 2);
        header.getMainMenuElement(MegaMenu.SUN).click();
        int num = random.nextInt(header.subMenuS.size());
        header.waitForVisibility(header.subMenuS.get(2), 2);
        header.subMenuS.get(2).click();
        header.waitForVisibility(header.subSubMenuS.get(num), 2);
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 11
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunGlassPolarised(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.SUN), 2);
        header.getMainMenuElement(MegaMenu.SUN).click();
        header.waitForVisibility(header.subMenuS.get(3), 2);
        header.subMenuS.get(3).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunPrescription(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.SUN), 2);
        header.getMainMenuElement(MegaMenu.SUN).click();
        header.waitForVisibility(header.subMenuS.get(4), 2);
        header.subMenuS.get(4).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 6
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuSunSki(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.SUN), 2);
        header.getMainMenuElement(MegaMenu.SUN).click();
        header.waitForVisibility(header.subMenuS.get(5), 2);
        header.subMenuS.get(5).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void intoOnSalePage(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.deleteLetTalk();
        header.getMainMenuElement(MegaMenu.DEALS).click();
        header.waitForVisibility(header.subMenuS.get(0), 2);
        header.subMenuS.get(0).click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.dealsIcon.size() > 18, "NO ! NO'T ON-SALE PAGE !!!");
        header.btnMenu.click();
        header.deleteLetTalk();
        header.getMainMenuElement(MegaMenu.DEALS).click();
        header.waitForVisibility(header.subMenuS.get(1), 2);
        header.subMenuS.get(1).click();
        MobProductPage productPage2 = new MobProductPage();
        Assert.assertTrue(productPage2.dealsIcon.size() > 18, "NO ! NO'T ON-SALE PAGE !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
