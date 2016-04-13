package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class ContactLens extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com.hk/", 18 } };
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke" })
    public void Daily(String url, int num) {
        driver.get(url);
        // driver.navigate().refresh();
        Header header = new Header();
        header.mouseOverMainMenu(5);
        header.dailyglass.click();
        CLProductGridPage productGridPage = new CLProductGridPage();
        // List<WebElement> dailyglassEles = driver.findElements(By.className("pho"));
        Assert.assertEquals(productGridPage.lenseDailyEles.size(), num, "daily contact lens count : disagree");
        // System.out.println(header.dailyglassEles.size());
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
