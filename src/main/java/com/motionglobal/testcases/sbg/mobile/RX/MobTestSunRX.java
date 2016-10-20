package com.motionglobal.testcases.sbg.mobile.RX;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.product.MobRX3Page;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestSunRX extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    // XXX case
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void editAndCheckPrice(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobRX3Page opticianPage = new MobRX3Page();
        opticianPage.waitForVisibility(opticianPage.btnContinue, 5);
        opticianPage.btnContinue.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.btnViewPre.click();
        cartPage.waitForVisibility(cartPage.btnEditPre, 2);
        cartPage.btnEditPre.click();
        // price
        MobRX3Page opticianPage2 = new MobRX3Page();
        opticianPage2.JsMouse(opticianPage2.priceTotal);
        double priceFrame1 = getPrice(opticianPage2.priceFrame);
        double priceLens1 = getPrice(opticianPage2.priceLens);
        String strPrice = opticianPage2.priceLens.getText();
        double priceTotal1 = getPrice(opticianPage2.priceTotal);
        Assert.assertEquals(priceTotal1, opticianPage2.mathAdd(priceFrame1, priceLens1));
        // edit rx
        opticianPage2.btnLens.click();
        opticianPage2.waitForVisibility(opticianPage2.optionDisplay, 2);
        double priceLens3 = getPrice(opticianPage2.lenPrice.get(2));
        opticianPage2.lenOption.get(2).click();
        opticianPage2.optionChecked(opticianPage2.lenOption.get(2));
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(opticianPage2.priceLens, strPrice)));
        // price
        double priceFrame2 = getPrice(opticianPage2.priceFrame);
        double priceLens2 = getPrice(opticianPage2.priceLens);
        double priceTotal2 = getPrice(opticianPage2.priceTotal);
        Assert.assertEquals(priceLens2, priceLens3 + 19.0);
        Assert.assertEquals(priceTotal2, opticianPage2.mathAdd(priceFrame2, priceLens2));
        //
        opticianPage2.JsMouse(opticianPage2.btnContinue);
        opticianPage2.btnContinue.click();
        MobCartPage cartPage2 = new MobCartPage();
        Double priceCart = getPrice(cartPage.priceTotal);
        Assert.assertEquals(priceCart, priceTotal2);
    }

    private Double getPrice(WebElement element) {
        Header header = new Header();
        header.JsMouse(element);
        double price = header.regexGetDouble(element.getText());
        return price;
    }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void sunDetailPageRX(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        detailPage.getRXType();
        MobRX3Page rx3Page = new MobRX3Page();
        rx3Page.elementClick(rx3Page.btnContinue);
        MobCartPage cartPage = new MobCartPage();
        Assert.assertTrue(cartPage.RXed.isDisplayed(), " RX no't Add !!!");
    }

    // XXX case 2
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void sunCartPageRX(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.RXadd.click();
        MobRX3Page rx3Page = new MobRX3Page();
        rx3Page.elementClick(rx3Page.btnContinue);
        MobCartPage cartPage2 = new MobCartPage();
        Assert.assertTrue(cartPage2.RXed.isDisplayed(), " RX No't Add !!!");
    }

    // XXX case 3
    /**
     * @Step1 : select Sun glass that can RX.
     * @Step2 : Add it to cart then click RX.
     * @Step3 : And open new window ,add eye glass and RX.
     * @BUG : EyeGlass RX Price cover SunGlass RX Price
     */
    @Test(groups = { "debug2", "smoke" })
    public void BUGCoverRX() throws InterruptedException {
        String sunUrl = "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html";
        String eyeUrl = "http://m.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html";

        // Add sun glass to cart page ,then click RX
        getURL(sunUrl);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.RXadd.click();
        MobRX3Page rx3Page = new MobRX3Page();

        // open new window
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + eyeUrl + "')");
        rx3Page.switch2NewWindow();

        // Add eye RX
        MobProductDetailPage detailPage2 = new MobProductDetailPage();
        detailPage2.waitForVisibility(detailPage2.addLens, 2);
        detailPage2.addLens.click();
        MobRX3Page rx3Page2 = new MobRX3Page();
        rx3Page2.elementClick(rx3Page.btnContinue);

        //
        MobCartPage cartPage2 = new MobCartPage();
        double price = cartPage2.regexGetDouble(cartPage2.priceTotal.getText());
        Assert.assertFalse(price == 189.95, "_OMG! EyeGlass RX Price cover SunGlass RX Price !!!");
        Assert.assertEquals(cartPage2.priceProduct.size(), 2);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
