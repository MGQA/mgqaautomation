package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
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
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 2);
        detailPage.btnBuyNow.click();
        //
        String cart = detailPage.getCartType();
        //
        if (cart.equals("old")) {
            // old cart
            CartPage cartpage = new CartPage();
            Assert.assertEquals(cartpage.header().cartProductNum.getText(), "1");
            cartpage.productNum.get(0).clear();
            cartpage.productNum.get(0).sendKeys("3");
            cartpage.productRefresh.get(0).click();
            // driver.navigate().refresh();
            new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("td_title"), 1));
            CartPage page = new CartPage();
            Assert.assertEquals(page.productName.size(), 3);
            page.waitForVisibility(page.productRemove.get(0), 5);
            try {
                page.productRemove.get(0).click();
            }
            catch (Exception e) {
            }
            page.acceptAlert();
            new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("td_title"), 3));
            Assert.assertEquals(page.productName.size(), 2);
        }
        else {
            // new cart
            NewCartPage newCartPage = new NewCartPage();
            newCartPage.waitForVisibility(newCartPage.selectQuantity, 5);
            double priceNum1 = newCartPage.regexGetDouble(newCartPage.priceS.get(0).getText());
            newCartPage.selectValue(newCartPage.selectQuantity.get(0), "3");
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(newCartPage.priceS.get(0)));
            // driver.navigate().refresh();
            newCartPage.waitForVisibility(newCartPage.priceS, 5);
            double priceNum3 = newCartPage.regexGetDouble(newCartPage.priceS.get(0).getText());
            newCartPage.AsssetEquals(priceNum3, newCartPage.mathAdd(newCartPage.mathAdd(priceNum1, priceNum1), priceNum1));
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
