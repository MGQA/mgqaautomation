package com.motionglobal.testcases.sbg.desktop.smoke.cart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com Test £º cart add and del
 * 
 */
public class TestAddCartAndDelCart extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public String[][] bd() {
        return new String[][] { { "http://www.smartbuyglasses.co.uk/designer-sunglasses/Maui-Jim/Maui-Jim-Hookipa-Polarized-407-02-27194.html" },
                { "http://www.smartbuyglasses.dk/designer-sunglasses/Maui-Jim/Maui-Jim-Hookipa-Polarized-407-02-27194.html" },
                { "http://www.smartbuyglasses.com/designer-sunglasses/Maui-Jim/Maui-Jim-Hookipa-Polarized-407-02-27194.html" } };
    }

    @Test(dataProvider = "bd", groups = { "smoke", "debug" })
    public void addAndDel(String url) {
        getURL(url);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }
        ProductDetailPage detailPage = new ProductDetailPage();
        new Header().inputSearch.click();
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
            cartpage.productNum.get(0).sendKeys("2");
            cartpage.productRefresh.get(0).click();
            // driver.navigate().refresh();
            new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("td_title"), 1));
            CartPage page = new CartPage();
            Assert.assertEquals(page.productName.size(), 2);
            page.waitForVisibility(page.productRemove.get(0), 5);
            try {
                page.productRemove.get(0).click();
            }
            catch (Exception e) {
            }
            page.acceptAlert();
            new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("td_title"), 2));
            Assert.assertEquals(page.productName.size(), 1);
        }
        else {
            // new cart
            NewCartPage newCartPage = new NewCartPage();
            newCartPage.waitForVisibility(newCartPage.selectQuantity, 5);
            double priceNum1 = newCartPage.regexGetDouble(newCartPage.priceOnlyFrame.get(0).getText());
            newCartPage.selectValue(newCartPage.selectQuantity.get(0), "2");
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(newCartPage.priceOnlyFrame.get(0)));
            // driver.navigate().refresh();
            newCartPage.waitForVisibility(newCartPage.priceOnlyFrame, 5);
            double priceNum3 = newCartPage.regexGetDouble(newCartPage.priceOnlyFrame.get(0).getText());
            newCartPage.AsssetEquals(priceNum3, newCartPage.mathAdd(priceNum1, priceNum1));
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
