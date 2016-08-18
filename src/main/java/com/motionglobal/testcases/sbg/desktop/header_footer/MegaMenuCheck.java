package com.motionglobal.testcases.sbg.desktop.header_footer;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test£º ²Ëµ¥ men£»
 * 
 */
public class MegaMenuCheck extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "smoke", "debug" })
    public void mencheck() {
        getURL("http://www.smartbuyglasses.com/");
        HomePage homepage = new HomePage();
        Actions action = new Actions(driver);
        action.moveToElement(homepage.menu().getMegaMenuMainElement(1)).perform();
        homepage.waitForVisibility(homepage.header().men, 5);
        homepage.header().men.click();
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.isTextPresent("Gender: Men"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
