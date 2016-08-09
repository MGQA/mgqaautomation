package com.motionglobal.testcases.sbg.desktop.home;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestTopSell extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" }, { "http://www.smartbuyglasses.com/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunImgIsDisplay(String url) {
        getURL(url);
        String handle;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage homePage = new HomePage();
        for (int i = 5; i < 13; i++) {
            handle = driver.getWindowHandle();
            String imgSrc = homePage.linkTopSellImg.get(i).getAttribute("src").toString();
            js.executeScript("window.open('" + imgSrc + "')");
            Set<String> handles = driver.getWindowHandles();

            // check img is display
            for (String window : handles) {
                if (!(window.equals(handle))) {
                    driver.switchTo().window(window);
                    Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed(), "FAIL i IS :" + i + " !!!");
                    driver.close();
                }
            }
            driver.switchTo().window(handle);
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void eyeImgIsDisplay(String url) {
        getURL(url);
        String handle;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HomePage homePage = new HomePage();
        for (int i = 21; i < 29; i++) {
            handle = driver.getWindowHandle();
            String imgSrc = homePage.linkTopSellImg.get(i).getAttribute("src").toString();
            js.executeScript("window.open('" + imgSrc + "')");
            Set<String> handles = driver.getWindowHandles();

            // check img is display
            for (String window : handles) {
                if (!(window.equals(handle))) {
                    driver.switchTo().window(window);
                    Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed(), "FAIL i IS :" + i + " !!! ");
                    driver.close();
                }
            }
            driver.switchTo().window(handle);
        }
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sunUrl(String url) {
        getURL(url);
        HomePage homePage = new HomePage();

        // check url with brand is match
        for (int i = 5; i < 13; i++) {
            String textBrandName = homePage.textTopSellBrandName.get(i).getText().replace(" ", "-");
            String actualUrl = homePage.linkTopSellLabelA.get(i).getAttribute("href");
            Assert.assertTrue(actualUrl.contains(textBrandName), "FAIL i IS :" + i + " !!! BRAND IS:" + textBrandName);
        }

        // check label can clicked
        homePage.deleteHead();
        homePage.deleteLetTalk();
        homePage.waitForVisibility(homePage.linkSunNo1, 5);
        homePage.JsMouse(homePage.linkFeatureImgNo1);
        homePage.linkSunNo1.click();
        ProductDetailPage detailPage = new ProductDetailPage();
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void eyeUrl(String url) {
        getURL(url);
        HomePage homePage = new HomePage();

        // check url with brand is match
        for (int i = 21; i < 25; i++) {
            String textBrandName = homePage.textTopSellBrandName.get(i).getText().replace(" ", "-");
            String actualUrl = homePage.linkTopSellLabelA.get(i).getAttribute("href");
            Assert.assertTrue(actualUrl.contains(textBrandName), "FAIL i IS :" + i + " !!! BRAND IS:" + textBrandName);
        }
        // check label can clicked
        homePage.deleteHead();
        homePage.waitForVisibility(homePage.linkEyeNo1, 5);
        homePage.deleteLetTalk();
        homePage.JsMouse(homePage.linkSunNo1);
        homePage.linkEyeNo1.click();
        ProductDetailPage detailPage = new ProductDetailPage();
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
