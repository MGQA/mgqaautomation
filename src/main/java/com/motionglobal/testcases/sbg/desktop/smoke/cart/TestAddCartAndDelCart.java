package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test £º cart add and del
 * 
 */
public class TestAddCartAndDelCart extends AbstractBaseSbgDesktopTestCase {
    static String url = "http://www.smartbuyglasses.com/designer-sunglasses/Gucci/Gucci-GG-3500/S-WNQ/02-108457.html/";

    @Test(groups = { "smoke", "debug" })
    public void addAndDel() {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 2);
        detailPage.btnBuyNow.click();
        CartPage cartPage = new CartPage();
        Assert.assertEquals(cartPage.header().cartProductNum.getText(), "1");
        cartPage.productNum.get(0).clear();
        cartPage.productNum.get(0).sendKeys("3");
        cartPage.productRefresh.get(0).click();
        driver.navigate().refresh();
        CartPage page = new CartPage();
        Assert.assertEquals(page.productName.size(), 3);
        page.productRemove.get(0).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.navigate().refresh();
        Assert.assertEquals(page.productName.size(), 2);
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
