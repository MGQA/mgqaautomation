package com.motionglobal.testcases.sbg.desktop.header_footer;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MegaMenuCheck extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = "smoke")
    public void mencheck() {
        driver.get("http://www.smartbuyglasses.com/");
        HomePage homepage = new HomePage();
        Actions action = new Actions(driver);
        action.moveToElement(homepage.header().getMegaMenuMainElement(1)).perform();
        homepage.waitForVisibility(homepage.header().men, 5);
        homepage.header().men.click();
        ProductGridPage productGridPage = new ProductGridPage();
        Assert.assertTrue(productGridPage.isTextPresent("Gender: Men"));
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
