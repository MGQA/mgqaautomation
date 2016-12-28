package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test : click Deals section(ShowNow¡¢BuyNow¡¢SunGlass¡¢EyeGlass)
 * 
 */
public class DealSun extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void DealsSunGlass() {
        String url = "http://www.smartbuyglasses.com/";
        getURL(url);
        Menu menu = new Menu();
        // deal SunGlass
        menu.mouseOverMainMenu(7);
        menu.waitForVisibility(menu.dealSunGlass, 1);
        menu.dealSunGlass.click();
        menu.switch2NewWindow();
        ProductGridPage page3 = new ProductGridPage();
        Assert.assertEquals(page3.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page3.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");
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
