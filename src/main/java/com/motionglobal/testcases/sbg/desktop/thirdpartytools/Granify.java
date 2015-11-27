package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Granify extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "au" })
    public void testHomepage() {
        logger().info("started...");
        driver.get("http://www.visiondirect.com.au/");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isTextPresent("{ page_type: \"home\" } \n         );"));
        Assert.assertFalse(homePage.isTextPresent("{ page_type: \"cart\" } \n         );"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
