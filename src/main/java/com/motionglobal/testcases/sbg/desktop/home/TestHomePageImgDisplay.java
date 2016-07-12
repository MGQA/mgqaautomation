package com.motionglobal.testcases.sbg.desktop.home;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage.Label;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * enable = false ¡£ test HomePage 6 img
 * 
 */
public class TestHomePageImgDisplay extends AbstractBaseSbgDesktopTestCase {
    @DataProvider
    public Object[][] dp() {
        // return new Object[][] { new Object[] { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.co.uk" },
        // { "http://www.smartbuyglasses.com" }, { "http://www.smartbuyglasses.de" }, { "http://www.smartbuyglasses.ca" },
        // { "http://www.smartbuyglasses.com.hk" }, { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.dk" },
        // { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.nz" }, { "http://www.smartbuyglasses.cn" } };
        return new Object[][] { new Object[] { "http://www.smartbuyglasses.com/" } };
    }

    @Test(enabled = false, dataProvider = "dp", groups = { "debug", "smoke", "fastsmoke" })
    public void imgDisplayAnd(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        String handle = "";
        String DesignerSun = "Designer Sunglasses";
        String DesignerEye = "Designer Glasses";
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
        homePage.waitForVisibility(homePage.LinkSunGleas.get(0), 2);
        for (int i = 0; i < homePage.LinkSunGleas.size(); i++) {
            Assert.assertTrue(homePage.LinkSunGleas.get(i).getAttribute("href").contains("designer-sunglasses"));
            Assert.assertTrue(homePage.LinkEyeGleas.get(i).getAttribute("href").contains("designer-eyeglasses"));
        }
        Random random = new Random();
        int index = random.nextInt(6) + 1;
        homePage.LinkSunGleas.get(index).click();
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.waitForVisibility(gridPage.submenuPageLabelElement(Label.designer), 2);
        Assert.assertEquals(gridPage.submenuPageLabelElement(Label.designer), DesignerSun);
        homePage.LinkEyeGleas.get(index).click();
        ProductGridPage gridPage2 = new ProductGridPage();
        gridPage.waitForVisibility(gridPage2.submenuPageLabelElement(Label.designer), 2);
        Assert.assertEquals(gridPage2.submenuPageLabelElement(Label.designer), DesignerEye);

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
