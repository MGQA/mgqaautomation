package com.motionglobal.testcases.sbg.mobile.smoke;

import java.util.Random;

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
        return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.nl" } };
    }

    // return new Object[][] { new Object[] { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.com" },
    // { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.ca" }, { "http://m.smartbuyglasses.com.hk" }, { "http://m.smartbuyglasses.se" },
    // { "http://m.smartbuyglasses.dk" }, { "http://m.smartbuyglasses.nl" }, { "http://m.smartbuyglasses.co.nz" } };
    // }

    // return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk" } };
    // }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void menuCLBrank(String url) {
        getURL(url);
        MobHeader header = new MobHeader();
        Random random = new Random();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.CL), 2);
        header.getMainMenuElement(MegaMenu.CL).click();
        header.elementClick(header.subMenuS.get(0));
        int num = random.nextInt(header.subSubMenuS.size());
        header.elementClick(header.subSubMenuS.get(num));
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
        header.elementClick(header.subMenuS.get(1));
        int num = random.nextInt(header.subSubMenuS.size());
        header.elementClick(header.subSubMenuS.get(num));
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
        header.elementClick(header.subMenuS.get(2));
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
