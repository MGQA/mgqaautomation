package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * Hk Test : sunglass Top 100£»
 * 
 */
public class TestSunGlassesMenus extends AbstractBaseTestCase {

    @Test(groups = { "debug", "smoke" })
    public void top100() {
        String url = "http://www.smartbuyglasses.com.hk/";
        int productNum = 103;
        getURL(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.sunTop100.click();
        ProductGridPage productGridPage = new ProductGridPage();
        // List<WebElement> sunTop100Eles = driver.findElements(By.className("proCell_click"));
        Assert.assertEquals(productGridPage.sunTop100Eles.size(), productNum, "sunglasses Top100 count : disagree");
        // p(header.sunTop100Eles.size());
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
