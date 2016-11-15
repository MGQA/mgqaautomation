package com.motionglobal.testcases.sbg.mobile.smoke;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.pages.sbg.mobile.product.MobProductAllPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * m.10 main domain Test £º Header menu of m.EyeGlass ¡£ click section menu link(random 1)
 * 
 */
public class MobTestEyeGlassMegaMenuAndLinkPage extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.nl" } };
    }

    // return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.com" },
    // { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.ca" }, { "http://m.smartbuyglasses.com.hk" }, { "http://m.smartbuyglasses.se" },
    // { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" } };
    // }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.com" } };
    // }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassGender(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.elementClick(header.subMenuS.get(0));
        header.waitForVisibility(header.subSubMenuS, 1);
        int num = random.nextInt(header.subSubMenuS.size());
        header.elementClick(header.subSubMenuS.get(num));
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 2
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void menuEyeGlassBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.elementClick(header.subMenuS.get(1));
        int num = random.nextInt(header.subSubMenuS.size() - 1);
        // header.elementClick(header.subSubMenuS.get(num));
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        header.JsMouse(header.subSubMenuS.get(num));
        String brank = header.regexGetLetterLow(header.subSubMenuS.get(num).getText());
        header.subSubMenuS.get(num).click();
        MobProductPage productPage = new MobProductPage();
        productPage.waitForVisibility(productPage.productName1, 5);
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
        String actualName = productPage.regexGetLetterLow(productPage.productName1.getText());
        System.out.println(actualName + "\t" + brank);
        Assert.assertEquals(actualName, brank);
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassMoreBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.elementClick(header.subMenuS.get(1));
        header.elementClick(header.subSubMenuS.get(header.subSubMenuS.size() - 1));
        MobProductAllPage allProduct = new MobProductAllPage();
    }

    // XXX case 3
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassShape(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.elementClick(header.subMenuS.get(2));
        int num = random.nextInt(header.subSubMenuS.size());
        header.elementClick(header.subSubMenuS.get(num));
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    // XXX case 4
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuEyeGlassStyle(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EYE), 2);
        header.getMainMenuElement(MegaMenu.EYE).click();
        header.elementClick(header.subMenuS.get(3));
        int num = random.nextInt(header.subSubMenuS.size());
        header.elementClick(header.subSubMenuS.get(num));
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.productList.size() > 0, " Product Number Is Empty !!! ");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
