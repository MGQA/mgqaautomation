package com.motionglobal.testcases.sbg.desktop.explore;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.explore.FaceShapePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestExploreMenu extends AbstractBaseSbgDesktopTestCase {

    // FIXME sub menu
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void moveAndImgDisplay() {
        String url = "http://www.smartbuyglasses.co.uk/";
        getURL(url);
        Menu menu = new Menu();
        menu.mouseOverMainMenu(6);
        int size = menu.subMenu6Right.size();
        //
        menu.mouseOver(menu.subMenu6Right.get(size - 5));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/i/celebrity-sunglasses-glasses");
        //
        menu.mouseOver(menu.subMenu6Right.get(size - 3));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/happy-customers");
        //
        menu.mouseOver(menu.subMenu6Right.get(size - 2));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://blog.smartbuyglasses.co.uk/");
        //
        menu.mouseOver(menu.subMenu6Right.get(size - 1));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/optical-centre");
        //
        menu.mouseOver(menu.subMenu6Right.get(size - 4));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/face-shape");
        //
        menu.subMenu6LeftLink.click();
        menu.switch2NewWindow();
        FaceShapePage faceShapePage = new FaceShapePage();
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
