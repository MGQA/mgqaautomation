package com.motionglobal.testcases.sbg.desktop.home.ServiceList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSecure extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" } };
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke" })
    public void listSecure(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        WebElement secure = homePage.listServiceItem.get(3);
        homePage.waitForVisibility(secure, 5);
        secure.click();
        homePage.switch2NewWindow();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = url + "secure";
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
