package com.motionglobal.testcases.sbg.mobile.RX;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobNewOpticianPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestRX extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    // XXX case RX in cart
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void cartRX(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.addPre.click();
        MobNewOpticianPage opticianPage = new MobNewOpticianPage();
        opticianPage.JsMouse(opticianPage.btnContinue);
        Double totalPrice = opticianPage.regexGetDouble(opticianPage.priceTotal.getText());
        opticianPage.btnContinue.click();
        Double priceCart = cartPage.regexGetDouble(cartPage.priceTotal.getText());
        Assert.assertEquals(priceCart, totalPrice);
    }

    // XXX case editAndCheckPrice
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void editAndCheckPrice(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobNewOpticianPage opticianPage = new MobNewOpticianPage();
        opticianPage.waitForVisibility(opticianPage.btnContinue, 5);
        opticianPage.btnContinue.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.btnViewPre.click();
        cartPage.waitForVisibility(cartPage.btnEditPre, 2);
        cartPage.btnEditPre.click();
        // price
        MobNewOpticianPage opticianPage2 = new MobNewOpticianPage();
        double priceFrame1 = opticianPage2.regexGetDouble(opticianPage2.priceFrame.getText());
        double priceLens1 = opticianPage2.regexGetDouble(opticianPage2.priceLens.getText());
        String strPrice = opticianPage2.priceLens.getText();
        double priceTotal1 = opticianPage2.regexGetDouble(opticianPage2.priceTotal.getText());
        Assert.assertEquals(priceTotal1, opticianPage2.mathAdd(priceFrame1, priceLens1));
        // edit rx
        opticianPage2.btnLens.click();
        opticianPage2.waitForVisibility(opticianPage2.optionDisplay, 2);
        double priceLens3 = opticianPage2.regexGetDouble(opticianPage2.lenPrice.get(2).getText());
        opticianPage2.lenOption.get(2).click();
        opticianPage2.optionChecked(opticianPage2.lenOption.get(2));
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(opticianPage2.priceLens, strPrice)));
        // price
        double priceFrame2 = opticianPage2.regexGetDouble(opticianPage2.priceFrame.getText());
        double priceLens2 = opticianPage2.regexGetDouble(opticianPage2.priceLens.getText());
        double priceTotal2 = opticianPage2.regexGetDouble(opticianPage2.priceTotal.getText());
        Assert.assertEquals(priceLens2, priceLens3 + 19.0);
        Assert.assertEquals(priceTotal2, opticianPage2.mathAdd(priceFrame2, priceLens2));
        //
        opticianPage2.JsMouse(opticianPage2.btnContinue);
        opticianPage2.btnContinue.click();
        MobCartPage cartPage2 = new MobCartPage();
        Double priceCart = cartPage2.regexGetDouble(cartPage.priceTotal.getText());
        Assert.assertEquals(priceCart, priceTotal2);
    }

    // XXX case buyFrameOnly
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void buyFrameOnly(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobNewOpticianPage opticianPage = new MobNewOpticianPage();
        opticianPage.waitForVisibility(opticianPage.buyFrame, 5);
        Double priceFrame = opticianPage.regexGetDouble(opticianPage.buyFrame.getText());
        opticianPage.buyFrame.click();
        MobCartPage cartPage = new MobCartPage();
        Double priceCart = cartPage.regexGetDouble(cartPage.priceTotal.getText());
        Assert.assertEquals(priceCart, priceFrame);
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
