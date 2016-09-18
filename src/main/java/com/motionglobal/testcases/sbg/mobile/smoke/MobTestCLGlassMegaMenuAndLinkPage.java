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
        return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" }, { "http://www.smartbuyglasses.de" },
                { "http://www.smartbuyglasses.nl" } };
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

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
