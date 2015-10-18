package com.motionglobal.testcases.sbg.desktop.end2end;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestHeaderMenu extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug" })
    public void testSunGlassesHeaderMenus() {
        logger().info("started...");
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.sendKeys("test");
        homePage.header().iconSearch.click();
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
