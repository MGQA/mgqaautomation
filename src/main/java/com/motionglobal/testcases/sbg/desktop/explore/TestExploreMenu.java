package com.motionglobal.testcases.sbg.desktop.explore;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
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
        String handle = driver.getWindowHandle();
        //
        menu.mouseOver(menu.subMenu6Right.get(0));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/i/celebrity-sunglasses-glasses");
        String imgSrc1 = menu.subMenu6LeftIMG.getAttribute("src").toString();
        judgeIMG(handle, imgSrc1);
        //
        menu.mouseOver(menu.subMenu6Right.get(2));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/happy-customers");
        String imgSrc3 = menu.subMenu6LeftIMG.getAttribute("src").toString();
        judgeIMG(handle, imgSrc3);
        //
        menu.mouseOver(menu.subMenu6Right.get(3));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://blog.smartbuyglasses.co.uk/");
        String imgSrc4 = menu.subMenu6LeftIMG.getAttribute("src").toString();
        judgeIMG(handle, imgSrc4);
        //
        menu.mouseOver(menu.subMenu6Right.get(4));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/optical-centre");
        String imgSrc5 = menu.subMenu6LeftIMG.getAttribute("src").toString();
        judgeIMG(handle, imgSrc5);
        //
        menu.mouseOver(menu.subMenu6Right.get(1));
        menu.AsssetEquals(menu.subMenu6LeftLink.getAttribute("href"), "http://www.smartbuyglasses.co.uk/face-shape");
        String imgSrc2 = menu.subMenu6LeftIMG.getAttribute("src").toString();
        judgeIMG(handle, imgSrc2);
        //
        menu.subMenu6LeftLink.click();
        FaceShapePage faceShapePage = new FaceShapePage();
    }

    private void judgeIMG(String handle, String imgSrc) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + imgSrc + "')");
        Set<String> handles = driver.getWindowHandles();
        for (String window : handles) {
            if (!(window.equals(handle))) {
                driver.switchTo().window(window);
                Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
                driver.close();
            }
        }
        driver.switchTo().window(handle);
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
