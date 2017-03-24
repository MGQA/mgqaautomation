package com.motionglobal.testcases.sbg.desktop.home.ServiceList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestReturns extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "https://www.smartbuyglasses.co.uk/" } };
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke" })
    public void listReturns(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.click();
        WebElement returns = homePage.listServiceItem.get(2);
        homePage.waitForVisibility(returns, 5);
        returns.click();
        homePage.switch2NewWindow();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = url + "returns";
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
