package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Granify extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "au" })
    public void testHomepage() {
        logger().info("started...");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isTextPresent("{ page_type: \"home\" }"));
    }

    @Override
    protected void initialize() {
        driver.get("http://www.visiondirect.com.au/");
    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
