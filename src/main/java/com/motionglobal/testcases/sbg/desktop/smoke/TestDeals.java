package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestDeals extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void Deals() {
        String url = "http://www.smartbuyglasses.com/";
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(6);
        header.waitForVisibility(header.dealShowNow, 1);
        header.dealShowNow.click();
        ProductGridPage page1 = new ProductGridPage();
        header.mouseOverMainMenu(6);
        header.waitForVisibility(header.dealBuyNow, 1);
        header.dealBuyNow.click();
        ProductGridPage page2 = new ProductGridPage();
        header.mouseOverMainMenu(6);
        header.waitForVisibility(header.dealSunGlass, 1);
        header.dealSunGlass.click();
        ProductGridPage page3 = new ProductGridPage();
        header.mouseOverMainMenu(6);
        header.waitForVisibility(header.dealEyeGlass, 1);
        header.dealEyeGlass.click();
        ProductGridPage page4 = new ProductGridPage();

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
