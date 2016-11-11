package com.motionglobal.testcases.sbg.desktop.stylefinder;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.ProductStyleFinderPage;
import com.motionglobal.pages.sbg.desktop.stylefinder.StyleFinderPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestStyleFinder extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] { { "http://www.smartbuyglasses.com/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void menuStyleFinder(String url) throws InterruptedException {
        getURL(url);
        Menu menu = new Menu();
        menu.displayMenu(1);
        menu.clickLeftSubMenu(1, 2, 1);
        StyleFinderPage finderPage = new StyleFinderPage();
        finderPage.clickAndSelectStyle(2);
        finderPage.clickAndSelectStyle(1);
        finderPage.clickAndSelectStyle(3);
        finderPage.clickAndSelectStyle(4);
        finderPage.clickAndSelectStyle(8);
        ProductStyleFinderPage gridPage = new ProductStyleFinderPage();
        Assert.assertTrue(gridPage.proInfo.size() > 0, " Product Page Is Empty !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug", "smoke" })
    public void helpStyleFinder(String url) throws InterruptedException {
        getURL(url);
        Header header = new Header();
        new Actions(driver).moveToElement(header.Help).build().perform();
        header.waitForVisibility(header.helpStyleFinder, 2);
        header.helpStyleFinder.click();
        StyleFinderPage finderPage = new StyleFinderPage();
        finderPage.clickAndSelectStyle(2);
        finderPage.clickAndSelectStyle(1);
        finderPage.clickAndSelectStyle(3);
        finderPage.clickAndSelectStyle(4);
        finderPage.clickAndSelectStyle(8);
        ProductStyleFinderPage gridPage = new ProductStyleFinderPage();
        Assert.assertTrue(gridPage.proInfo.size() > 0, " Product Page Is Empty !!!");
    }

    /**
     * @enabled=false, beacuse findStyle became pimcore
     */
    @Test(enabled = false, skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void headerStyleFinder() throws InterruptedException {
        String url = "http://www.smartbuyglasses.jp/";
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.headerStyleFinder, 2);
        header.headerStyleFinder.click();
        StyleFinderPage finderPage = new StyleFinderPage();
        finderPage.clickAndSelectStyle(2);
        finderPage.clickAndSelectStyle(1);
        finderPage.clickAndSelectStyle(3);
        finderPage.clickAndSelectStyle(4);
        finderPage.clickAndSelectStyle(8);
        ProductStyleFinderPage gridPage = new ProductStyleFinderPage();
        Assert.assertTrue(gridPage.proInfo.size() > 0, " Product Page Is Empty !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
