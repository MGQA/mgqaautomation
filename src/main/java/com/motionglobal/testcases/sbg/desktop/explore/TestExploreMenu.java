package com.motionglobal.testcases.sbg.desktop.explore;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.footer.aboutus.AboutUsPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestExploreMenu extends AbstractBaseSbgDesktopTestCase {

    // FIXME sub menu
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void moveAndImgDisplay() {
        String url = "http://www.smartbuyglasses.co.uk/";
        getURL(url);
        Menu menu = new Menu();
        menu.mouseOverMainMenu(6);
        //
        menu.displayMenu(6);
        menu.AboutUs.click();
        menu.switch2NewWindow();
        AboutUsPage aboutUs = new AboutUsPage();
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
