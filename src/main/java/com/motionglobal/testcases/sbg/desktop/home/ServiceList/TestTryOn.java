package com.motionglobal.testcases.sbg.desktop.home.ServiceList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestTryOn extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" } };
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke" })
    public void listTryOn(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.click();
        WebElement tryOn = homePage.listServiceItem.get(0);
        homePage.waitForVisibility(tryOn, 5);
        tryOn.click();
        homePage.switch2NewWindow();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = url + "virtual-try-on/";
        Assert.assertEquals(currentUrl, expectedUrl);
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
