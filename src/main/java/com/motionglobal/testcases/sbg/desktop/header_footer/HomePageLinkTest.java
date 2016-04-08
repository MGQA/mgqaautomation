package com.motionglobal.testcases.sbg.desktop.header_footer;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.home.FavoritePage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class HomePageLinkTest extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke" })
    public void homePageLinkTest() throws InterruptedException {
        String url = "http://www.smartbuyglasses.com/";
        driver.get(url);
        HomePage homepage = new HomePage();
        Header header = new Header();
        // FREE SHIPPING
        homepage.mouseOver(header.FREESHIPPING);
        header.freeshipmoreinfo.click();
        switchPage();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/fast-shipping"));
        header.logo.click();
        // 100 DAY RETURNS
        homepage.mouseOver(header.DayReturns);
        homepage.waitForVisibility(header.DayReturnsMoreInfo, 2);
        header.DayReturnsMoreInfo.click();
        switchPage();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/returns"));
        header.logo.click();
        // Refrt A Friend
        header.referAFriend.click();
        homepage.waitForVisibility(header.shareByEmail, 5);
        // Assert.assertTrue(homepage.isTextPresent("free_afriend"));
        driver.navigate().refresh();
        // optical-center
        header.optical_center.click();
        switchPage();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/optical-center"));
        header.logo.click();
        // Favourite Heart Button
        header.favHeartButtonLink.click();
        FavoritePage favoritePage = new FavoritePage();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/favs/"));
        header.logo.click();
        // Cart box
        header.cartBox.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/cart"));
        header.logo.click();
    }

    private void switchPage() {
        driver.close();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.iterator().next());
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
