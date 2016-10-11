package com.motionglobal.testcases.sbg.desktop.smoke.bug;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestMenuMaxPrice extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.jp/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void maxPrice(String url) {
        getURL(url);
        Menu menu = new Menu();
        menu.displayMenu(1);
        menu.clickMiddleSubMenu(1, 2, 4);
        ProductGridPage gridPage = new ProductGridPage();
        Assert.assertTrue(gridPage.proInfo.size() > 0, "_Product Number Is 0 !!!");
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
