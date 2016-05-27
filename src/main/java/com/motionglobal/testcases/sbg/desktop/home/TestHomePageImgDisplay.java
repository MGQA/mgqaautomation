package com.motionglobal.testcases.sbg.desktop.home;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestHomePageImgDisplay extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        // return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
        // { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
        // { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
        // { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" }, { "http://www.smartbuyglasses.cn" } };
        // }

        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com.hk/" } };
    }

    @Test(enabled = false, dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void imgDisplay(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        String handle = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i < 7; i++) {
            handle = driver.getWindowHandle();
            String imgSrc = homePage.getFeaturedImgElement(i).getAttribute("src").toString();
            js.executeScript("window.open('" + imgSrc + "')");
            Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
            Set<String> handles = driver.getWindowHandles();
            for (String window : handles) {
                if (!(window.equals(handle))) {
                    driver.switchTo().window(window);
                    driver.close();
                }
            }
            driver.switchTo().window(handle);
        }
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
