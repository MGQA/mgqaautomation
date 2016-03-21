package com.motionglobal.testcases.sbg.desktop.header_footer;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.FavoritePage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class HomePageLinkTest extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = "smoke")
    public void homePageLinkTest() throws InterruptedException {
        driver.get("http://www.smartbuyglasses.com/");
        HomePage homepage = new HomePage();
        // FREE SHIPPING
        Actions actions = new Actions(driver);
        actions.moveToElement(homepage.header().FREESHIPPING).perform();
        homepage.waitForVisibility(homepage.header().freeshipmoreinfo, 5);
        homepage.header().freeshipmoreinfo.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/fast-shipping"));
        homepage.header().logo.click();
        // 100 DAY RETURNS
        actions.moveToElement(homepage.header().DayReturns).perform();
        homepage.waitForVisibility(homepage.header().DayReturnsMoreInfo, 5);
        homepage.header().DayReturnsMoreInfo.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/returns"));
        homepage.header().logo.click();
        // Refrt A Friend
        homepage.header().referAFriend.click();
        homepage.waitForVisibility(homepage.header().shareByEmail, 5);
        // Assert.assertTrue(homepage.isTextPresent("free_afriend"));
        driver.navigate().refresh();
        // optical-center
        homepage.header().optical_center.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/optical-center"));
        homepage.header().logo.click();
        // Favourite Heart Button
        homepage.header().favHeartButtonLink.click();
        FavoritePage favoritePage = new FavoritePage();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/favs/"));
        homepage.header().logo.click();
        // Cart box
        homepage.header().cartBox.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("http://www.smartbuyglasses.com/cart"));
        homepage.header().logo.click();
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
