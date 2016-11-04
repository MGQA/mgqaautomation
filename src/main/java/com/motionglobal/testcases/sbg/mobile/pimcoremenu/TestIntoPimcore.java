package com.motionglobal.testcases.sbg.mobile.pimcoremenu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.pimcore.PimcorePage;
import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * US pimcore page blank
 * 
 */
public class TestIntoPimcore extends AbstractBaseTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk/" }, { "http://m.smartbuyglasses.com/" }, { "http://m.smartbuyglasses.dk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void IntoPimcorePage(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.PIMCORE), 2);
        header.getMainMenuElement(MegaMenu.PIMCORE).click();
        PimcorePage pimcorePage = new PimcorePage();
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
