package com.motionglobal.testcases.sbg.mobile.cart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage.Prescription;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.pages.sbg.mobile.product.MobRX3Page;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestCart extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.co.uk/" } };
    }

    // XXX case1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void emptyCart(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.waitForVisibility(header.cartBox, 5);
        String cartNum = header.cartNum.getText();
        Assert.assertEquals(cartNum, "");
        header.cartBox.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.cartIsEmpty, 5);
    }

    // XXX case2
    @Test(skipFailedInvocations = true, groups = { "debug2", "smoke" })
    public void addDeleteProduct() throws InterruptedException {
        String url = "http://m.smartbuyglasses.com/cart/";
        getURL(url);
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.cartIsEmpty, 5);
        cartPage.btnSun.click();
        MobProductPage productPage = new MobProductPage();
        String productName = productPage.regexGetLetterLow(productPage.productTitle.getText());
        Assert.assertEquals(productName, "sunglasses");
        productPage.productList.get(1).click();
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage2 = new MobCartPage();
        cartPage2.productRemove.get(0).click();
        cartPage2.acceptAlert();
        cartPage2.waitForVisibility(cartPage2.cartIsEmpty, 5);
    }

    // XXX case3 Add product then into cart and delete product
    @Test(skipFailedInvocations = true, groups = { "debug2", "smoke" })
    public void intoCart() throws InterruptedException {
        String url = "http://m.smartbuyglasses.com/designer-sunglasses/Maui-Jim/Maui-Jim-Baby-Beach-Polarized-HS245-16-164380.html";
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.product, 5);
        MobHeader header = new MobHeader();
        header.logo.click();
        header.waitForVisibility(header.cartBox, 5);
        header.cartBox.click();
        MobCartPage cartPage2 = new MobCartPage();
        cartPage2.productRemove.get(0).click();
        cartPage2.acceptAlert();
        cartPage2.waitForVisibility(cartPage2.cartIsEmpty, 5);
    }

    // XXX case4 Add 2 different product,then delete 1
    @Test(skipFailedInvocations = true, groups = { "debug2", "smoke" })
    public void twoProductAddDelete() throws InterruptedException {
        String url1 = "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html";
        String url2 = "http://m.smartbuyglasses.com/designer-sunglasses/Tom-Ford/Tom-Ford-FT0008-JENNIFER-692-8152.html";
        getURL(url1);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage2 = new MobCartPage();
        cartPage2.waitForVisibility(cartPage2.product, 5);
        getURL(url2);
        MobProductDetailPage detailPage2 = new MobProductDetailPage();
        detailPage2.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.product, 5);
        Assert.assertEquals(cartPage.product.size(), 2);
        Double price1 = cartPage.regexGetDouble(cartPage.priceProduct.get(0).getText());
        Double price2 = cartPage.regexGetDouble(cartPage.priceProduct.get(1).getText());
        Double actualtotal = cartPage.regexGetDouble(cartPage.priceTotal.getText());
        Double expectTotal = cartPage.mathAdd(price1, price2);
        Assert.assertEquals(actualtotal, expectTotal);
        //
        cartPage.productRemove.get(0).click();
        cartPage.acceptAlert();
        driver.navigate().refresh();
        Assert.assertEquals(cartPage.product.size(), 1);
    }

    // XXX case 5 pimcore into empty cart page
    @Test(skipFailedInvocations = true, groups = { "debug2", "smoke" })
    public void pimcoreEmptyCart() throws InterruptedException {
        String url = "http://m.smartbuyglasses.com/optical-center/";
        getURL(url);
        MobHeader header = new MobHeader();
        header.waitForVisibility(header.cartBox, 5);
        // TODO need fix ,it is error ; actual is 0,but display is 2;
        // String cartNum = header.cartNum.getText();
        // Assert.assertEquals(cartNum, "0");
        header.cartBox.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.cartIsEmpty, 5);
    }

    // XXX case6 Add product then into cart and delete product
    @Test(skipFailedInvocations = true, groups = { "debug2", "smoke" })
    public void addCL() throws InterruptedException {
        String url = "http://m.smartbuyglasses.co.uk/contact-lenses/daily-disposable-lenses/1-Day-Acuvue-Moist-30-Pack/442.html";
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.selectPreValue(Prescription.RIGHTQTY, "2");
        detailPage.selectPreValue(Prescription.LEFTQTY, "2");
        detailPage.selectPreValue(Prescription.RIGHTPOWER, "-5.00");
        detailPage.selectPreValue(Prescription.LEFTPOWER, "-5.25");
        detailPage.selectPreValue(Prescription.RIGHTBC, "8.5");
        detailPage.selectPreValue(Prescription.LEFTBC, "9");
        detailPage.waitForVisibility(detailPage.buyCL, 5);
        detailPage.buyCL.click();
    }

    // XXX
    @DataProvider
    public Object[][] sun() {
        return new Object[][] {
                new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ralph-by-Ralph-Lauren/Ralph-by-Ralph-Lauren-RA4004-101/13-23260.html" },
                { "http://m.smartbuyglasses.dk/designer-sunglasses/Ralph-by-Ralph-Lauren/Ralph-by-Ralph-Lauren-RA4004-101/13-23260.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "sun", groups = { "debug2", "smoke" })
    public void addSun(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.fastCheckOut, 5);
    }

    @Test(skipFailedInvocations = true, dataProvider = "sun", groups = { "debug2", "smoke" })
    public void addRXSun(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobRX3Page rx3Page = new MobRX3Page();
        rx3Page.btnContinue.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.fastCheckOut, 5);
    }

    // XXX
    @DataProvider
    public Object[][] eye() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" },
                { "http://m.smartbuyglasses.dk/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug2", "smoke" })
    public void addFrame(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.fastCheckOut, 5);
    }

    @Test(skipFailedInvocations = true, dataProvider = "eye", groups = { "debug2", "smoke" })
    public void addEye(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobRX3Page rx3Page = new MobRX3Page();
        rx3Page.btnContinue.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.waitForVisibility(cartPage.fastCheckOut, 5);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
