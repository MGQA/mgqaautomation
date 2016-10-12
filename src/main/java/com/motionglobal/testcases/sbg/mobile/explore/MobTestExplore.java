package com.motionglobal.testcases.sbg.mobile.explore;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestExplore extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void faceShape(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.btnMenu.click();
        header.waitForVisibility(header.getMainMenuElement(MegaMenu.EXPLORE), 3);
        header.JsMouse(header.getMainMenuElement(MegaMenu.EXPLORE));
        header.getMainMenuElement(MegaMenu.EXPLORE).click();
        //
        // header.waitForVisibility(header.subMenuS.get(1), 2);
        // header.JsMouse(header.subMenuS.get(1));
        header.waitForVisibility(header.faceShape, 2);
        header.faceShape.click();
        header.switch2NewWindow();
        Assert.assertEquals(driver.getCurrentUrl(), url + "/face-shape");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
