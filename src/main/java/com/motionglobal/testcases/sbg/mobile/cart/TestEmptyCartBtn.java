package com.motionglobal.testcases.sbg.mobile.cart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductAllPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestEmptyCartBtn extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/" }, { "http://m.smartbuyglasses.co.uk/" } };
    }

    // XXX case1
    @Test(skipFailedInvocations = true, groups = { "debug2", "smoke" })
    public void emptyCart() throws InterruptedException {
        String url = "http://m.smartbuyglasses.com/cart/";
        getURL(url);
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.cartIsEmpty, 5);
        cartPage.btnSun.click();
        MobProductPage productPage = new MobProductPage();
        Assert.assertEquals(productPage.regexGetLetterLow(productPage.productTitle.getText()), "sunglasses");
        // eye
        productPage.mobHeader().cartBox.click();
        MobCartPage cartPage2 = new MobCartPage();
        cartPage.waitForVisibility(cartPage2.cartIsEmpty, 5);
        cartPage.btnEye.click();
        MobProductPage productPage2 = new MobProductPage();
        Assert.assertEquals(productPage2.regexGetLetterLow(productPage.productTitle.getText()), "glasses");
        // CL
        productPage.mobHeader().cartBox.click();
        MobCartPage cartPage3 = new MobCartPage();
        cartPage.waitForVisibility(cartPage3.cartIsEmpty, 5);
        cartPage.btnCL.click();
        MobProductAllPage productPage3 = new MobProductAllPage();
        Assert.assertEquals(productPage2.regexGetLetterLow(productPage3.productTitle.getText()), "contactlenses");
        // shop
        productPage.mobHeader().cartBox.click();
        MobCartPage cartPage4 = new MobCartPage();
        cartPage.waitForVisibility(cartPage4.cartIsEmpty, 5);
        cartPage.btnShop.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://m.smartbuyglasses.com/");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
