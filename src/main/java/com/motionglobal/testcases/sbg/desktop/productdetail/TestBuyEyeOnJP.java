package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestBuyEyeOnJP extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.jp/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5154-Clubmaster-2000-79766.html/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void onlyBuyFrame(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        double price1 = detailPage.regexGetDouble(detailPage.price.getText());
        detailPage.btnBuyNow.click();
        detailPage.getRXType();
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.buyOnlyFrame, 2);
        rx3Page.JsScale(rx3Page.rx3Frame, 0.5);
        rx3Page.buyOnlyFrame.click();
        NewCartPage newCartPage = new NewCartPage();
        double price2 = detailPage.regexGetDouble(newCartPage.priceTotal.getText());
        Assert.assertEquals(price1, price2);
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void buyWithLens(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.btnBuyNow.click();
        detailPage.getRXType();
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.addToCart, 2);
        rx3Page.JsScale(rx3Page.rx3Frame, 0.5);
        double price1 = detailPage.regexGetDouble(rx3Page.total_price.getText());
        rx3Page.addToCart.click();
        NewCartPage newCartPage = new NewCartPage();
        double price2 = detailPage.regexGetDouble(newCartPage.priceTotal.getText());
        Assert.assertEquals(price1, price2);
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
