package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestAddCartAndDelCart extends AbstractBaseSbgDesktopTestCase {
    static String url = "http://www.smartbuyglasses.com/";

    @Test(groups = { "smoke", "debug" })
    public void addCart() {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.waitForVisibility(homePage.TopSell2, 2);
        homePage.TopSell2.click();
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
        page.productRemove.get(1).click();
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
