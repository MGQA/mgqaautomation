package com.motionglobal.testcases.sbg.desktop.explore;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.explore.FaceShapePage;
import com.motionglobal.pages.sbg.desktop.explore.FaceShapePage.FaceShape;
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
        menu.faceShape.click();
        menu.switch2NewWindow();
        FaceShapePage faceShapePage = new FaceShapePage();
        Assert.assertTrue(faceShapePage.getListFaceEle(FaceShape.square).isDisplayed());
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
