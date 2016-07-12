package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * HK Test £º CL lenseDaily is 18 product
 * 
 */
public class ContactLens extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug", "smoke" })
    public void Daily() {
        String url = "http://www.smartbuyglasses.com.hk/";
        int productNum = 18;
        getURL(url);
        // driver.navigate().refresh();
        Header header = new Header();
        header.mouseOverMainMenu(5);
        header.dailyglass.click();
        CLProductGridPage productGridPage = new CLProductGridPage();
        // List<WebElement> dailyglassEles = driver.findElements(By.className("pho"));
        productGridPage.waitForVisibility(productGridPage.lenseDailyEles.get(0), 5);
        Assert.assertEquals(productGridPage.lenseDailyEles.size(), productNum, "daily contact lens count : disagree");
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
