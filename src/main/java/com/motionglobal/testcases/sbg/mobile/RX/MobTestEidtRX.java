package com.motionglobal.testcases.sbg.mobile.RX;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobNewOpticianPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestEidtRX extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

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

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }
}
