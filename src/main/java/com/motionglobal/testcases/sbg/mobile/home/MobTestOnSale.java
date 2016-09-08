package com.motionglobal.testcases.sbg.mobile.home;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestOnSale extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/" }, { "http://m.smartbuyglasses.co.uk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void intoOnSalePage(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.menuBtn.click();
        header.deleteLetTalk();
        header.getMainMenuElement(MegaMenu.DEALS).click();
        header.waitForVisibility(header.dealsSun, 2);
        header.dealsSun.click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertTrue(productPage.dealsIcon.size() > 18, "NO ! NO'T ON-SALE PAGE !!!");
        header.menuBtn.click();
        header.deleteLetTalk();
        header.getMainMenuElement(MegaMenu.DEALS).click();
        header.waitForVisibility(header.dealsSun, 2);
        header.dealsEye.click();
        MobProductPage productPage2 = new MobProductPage();
        Assert.assertTrue(productPage2.dealsIcon.size() > 18, "NO ! NO'T ON-SALE PAGE !!!");
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
