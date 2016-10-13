package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * HK Test £º CL lenseDaily is 18 product
 * 
 */
public class ContactLens extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] daily() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/" }, { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "daily", groups = { "debug", "smoke" })
    public void Daily(String url) {
        int productNum = 18;
        getURL(url);
        // driver.navigate().refresh();
        Menu menu = new Menu();
        menu.mouseOverMainMenu(5);
        menu.dailyglass.click();
        CLProductGridPage productGridPage = new CLProductGridPage();
        // List<WebElement> dailyglassEles = driver.findElements(By.className("pho"));
        productGridPage.waitForVisibility(productGridPage.lenseDailyEles, 10);
        Assert.assertEquals(productGridPage.lenseDailyEles.size(), productNum, "daily contact lens count : disagree");
        // System.out.println(header.dailyglassEles.size());
    }

    @DataProvider
    public Object[][] db() {
        return new Object[][] {
                { "http://www.smartbuyglasses.co.uk/contact-lenses/f/daily-disposable-lenses#!&s=popularity&tb=0&f=daily-disposable-lenses&p=1" },
                { "http://www.smartbuyglasses.dk/kontaktlinser/f/endagslinser#!&s=popularitet&tb=0&f=endagslinser&p=1" },
                { "http://www.smartbuyglasses.com/contact-lenses/f/daily-disposable-lenses#!&s=popularity&tb=0&f=daily-disposable-lenses&p=1" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void DailyDisplay(String url) {
        int productNum = 18;
        getURL(url);
        CLProductGridPage productGridPage = new CLProductGridPage();
        productGridPage.waitForVisibility(productGridPage.lenseDailyEles, 10);
        Assert.assertEquals(productGridPage.lenseDailyEles.size(), productNum, "daily contact lens count : disagree");
    }

    // XXX
    @DataProvider
    public Object[][] acuvue() {
        return new Object[][] { { "http://www.smartbuyglasses.dk/kontaktlinser/b/Acuvue#!&s=popularitet&tb=0&b=Acuvue&p=1" },
                { "http://www.smartbuyglasses.co.uk/contact-lenses/b/Acuvue#!&s=popularity&tb=0&b=Acuvue&p=1" },
                { "http://www.smartbuyglasses.com/contact-lenses/b/Acuvue#!&s=popularity&tb=0&b=Acuvue&p=1" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "acuvue", groups = { "debug", "smoke" })
    public void AcuvueDisplay(String url) {
        int productNum = 4;
        getURL(url);
        CLProductGridPage productGridPage = new CLProductGridPage();
        productGridPage.waitForVisibility(productGridPage.lenseDailyEles, 10);
        Assert.assertTrue(productGridPage.lenseDailyEles.size() > productNum, "daily contact lens count : disagree");
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
