package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test : click Deals section(ShowNow¡¢BuyNow¡¢SunGlass¡¢EyeGlass)
 * 
 */
public class DealImg extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void DealsIMG() {
        String url = "http://www.smartbuyglasses.com/";
        //
        getURL(url);
        Menu header = new Menu();
        header.inputSearch.click();
        header.mouseOverMainMenu(7);
        new WebDriverWait(driver, 2).until(ExpectedConditions.attributeToBe(
                header.dealIMG,
                "src",
                "http://cdn3.smartbuyglasses.com/GDR2016/GDR497/mega_menu_q4_1.jpg"));
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
