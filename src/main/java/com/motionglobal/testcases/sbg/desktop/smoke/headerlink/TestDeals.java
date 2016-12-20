package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
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
        Menu menu = new Menu();

        // deal showNow
        menu.mouseOverMainMenu(7);
        menu.waitForVisibility(menu.dealShowNow, 1);
        menu.dealShowNow.click();
        ProductGridPage page1 = new ProductGridPage();
        Assert.assertEquals(page1.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page1.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");

        // deal BuyNow
        menu.mouseOverMainMenu(7);
        menu.waitForVisibility(menu.dealBuyNow, 1);
        menu.dealBuyNow.click();
        ProductGridPage page2 = new ProductGridPage();
        Assert.assertEquals(page2.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page2.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");

        // deal SunGlass
        menu.mouseOverMainMenu(7);
        menu.waitForVisibility(menu.dealSunGlass, 1);
        menu.dealSunGlass.click();
        ProductGridPage page3 = new ProductGridPage();
        Assert.assertEquals(page3.proInfo.size() > 1, true, "expect product Num > 1£¬but no ! ");
        Assert.assertTrue(page3.productNum.getText().contains("1"), "expect product Num > 1, but no ! ");

        // deal EyeGlass
        menu.mouseOverMainMenu(7);
        menu.waitForVisibility(menu.dealEyeGlass, 1);
        menu.dealEyeGlass.click();
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
        Menu header = new Menu();
        header.displayMenu(7);
        String imgSrc = header.dealIMG.get(0).getAttribute("src").toString();
        Assert.assertEquals(imgSrc, "http://cdn3.smartbuyglasses.com/GDR2016/GDR497/mega_menu_q4_1.jpg");
        // multi picture
        // String handle = "";
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // for (int i = 0; i < 2; i++) {
        // handle = driver.getWindowHandle();
        // String imgSrc = header.dealIMG.get(i).getAttribute("src").toString();
        // js.executeScript("window.open('" + imgSrc + "')");
        // Set<String> handles = driver.getWindowHandles();
        // // check img is display
        // for (String window : handles) {
        // if (!(window.equals(handle))) {
        // driver.switchTo().window(window);
        // Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
        // driver.close();
        // }
        // }
        // driver.switchTo().window(handle);
        // }
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
