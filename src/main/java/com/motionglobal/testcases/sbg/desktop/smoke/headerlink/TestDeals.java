package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test : click Deals section(ShowNow¡¢BuyNow¡¢SunGlass¡¢EyeGlass)
 * 
 */
public class TestDeals extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void Deals() {
        String url = "http://www.smartbuyglasses.com/";
        getURL(url);
        Header header = new Header();

        // deal showNow
        header.mouseOverMainMenu(7);
        header.waitForVisibility(header.dealShowNow, 1);
        header.dealShowNow.click();
        ProductGridPage page1 = new ProductGridPage();
        Assert.assertEquals(page1.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page1.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");

        // deal BuyNow
        header.mouseOverMainMenu(7);
        header.waitForVisibility(header.dealBuyNow, 1);
        header.dealBuyNow.click();
        ProductGridPage page2 = new ProductGridPage();
        Assert.assertEquals(page2.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page2.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");

        // deal SunGlass
        header.mouseOverMainMenu(7);
        header.waitForVisibility(header.dealSunGlass, 1);
        header.dealSunGlass.click();
        ProductGridPage page3 = new ProductGridPage();
        Assert.assertEquals(page3.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page3.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");

        // deal EyeGlass
        header.mouseOverMainMenu(7);
        header.waitForVisibility(header.dealEyeGlass, 1);
        header.dealEyeGlass.click();
        ProductGridPage page4 = new ProductGridPage();
        Assert.assertEquals(page4.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page4.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");
        //
    }

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void DealsIMG() {
        String url = "http://www.smartbuyglasses.com/";
        //
        getURL(url);
        Header header = new Header();
        String handle = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            handle = driver.getWindowHandle();
            String imgSrc = header.dealIMG.get(i).getAttribute("src").toString();
            js.executeScript("window.open('" + imgSrc + "')");
            Set<String> handles = driver.getWindowHandles();
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
