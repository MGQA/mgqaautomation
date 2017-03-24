package com.motionglobal.testcases.sbg.desktop.header_footer;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.home.FavoritePage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test:header link £¬don't contains (menu¡¢search¡¢sign in¡¢help)
 * 
 */
public class HomePageLinkTest extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke" })
    public void homePageLinkTest() throws InterruptedException {
        String url = "https://www.smartbuyglasses.com/";
        getURL(url);
        HomePage homepage = new HomePage();
        Header header = new Header();

        // FREE SHIPPING
        homepage.mouseOver(header.FREESHIPPING);
        header.waitForVisibility(header.freeshipmoreinfo, 2);
        header.freeshipmoreinfo.click();
        switchPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.smartbuyglasses.com/fast-shipping");
        header.logo.click();

        // 100 DAY RETURNS
        homepage.mouseOver(header.DayReturns);
        homepage.waitForVisibility(header.DayReturnsMoreInfo, 2);
        header.DayReturnsMoreInfo.click();
        switchPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.smartbuyglasses.com/returns");
        header.logo.click();

        // Refrt A Friend
        header.referAFriend.click();
        homepage.waitForVisibility(header.shareByEmail, 5);
        // Assert.assertTrue(homepage.isTextPresent("free_afriend"));
        driver.navigate().refresh();
        // optical-center
        header.waitForVisibility(header.optical_center, 2);
        header.optical_center.click();
        //
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.smartbuyglasses.com/optical-center");
    }

    @Test(groups = { "debug", "smoke" })
    public void homePageHeartAndCartBox() throws InterruptedException {
        String url = "https://www.smartbuyglasses.com/";
        getURL(url);
        Header header = new Header();
        // Favourite Heart Button
        header.iHeart.click();
        FavoritePage favoritePage = new FavoritePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.smartbuyglasses.com/favs/");
        header.logo.click();

        // Cart box
        header.cartBox.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.smartbuyglasses.com/cart");
    }

    @Test(groups = { "debug", "smoke" })
    public void OtherPageLinkTest() throws InterruptedException {
        String url = "https://www.smartbuyglasses.com/designer-sunglasses/on-sale/";
        getURL(url);
        Header header = new Header();
        // FREE SHIPPING
        header.mouseOver(header.FREESHIPPING);
        header.waitForVisibility(header.freeshipmoreinfo, 2);
        header.freeshipmoreinfo.click();
        switchPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.smartbuyglasses.com/fast-shipping");
    }

    private void switchPage() {
        driver.close();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.iterator().next());
    }

    @Override
    protected void initialize() {
        // TODO
    }

    @Override
    protected void tearDown() {
        // TODO
    }

}
