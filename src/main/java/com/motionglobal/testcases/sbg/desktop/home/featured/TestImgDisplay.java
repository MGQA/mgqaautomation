package com.motionglobal.testcases.sbg.desktop.home.featured;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * enable = false ¡£ test HomePage 6 img
 * 
 */
public class TestImgDisplay extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        // return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
        // { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
        // { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
        // { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" }, { "http://www.smartbuyglasses.cn" } };
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com/" } };
    }

    @Test(dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void imgDisplayAnd(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        String handle = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 6; i++) {
            handle = driver.getWindowHandle();
            String imgSrc = homePage.imgFeature.get(i).getAttribute("src").toString();
            js.executeScript("window.open('" + imgSrc + "')");
            Set<String> handles = driver.getWindowHandles();

            // check ImgUrl
            String textName = homePage.textBrandName.get(i).getText();
            String brandName = null;
            try {
                brandName = (textName.replace("-", " ").split(" "))[1];
            }
            catch (Exception e) {
                brandName = textName;
            }
            WebElement hrefEle = homePage.imgFeature.get(i).findElement(By.xpath(".."));
            String actualUrl = hrefEle.getAttribute("href").toString();
            Assert.assertTrue(actualUrl.contains(brandName));

            // check img is display
            for (String window : handles) {
                if (!(window.equals(handle))) {
                    driver.switchTo().window(window);
                    Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
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
