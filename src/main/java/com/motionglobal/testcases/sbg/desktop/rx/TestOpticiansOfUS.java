package com.motionglobal.testcases.sbg.desktop.rx;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * ���������侵
 * 
 */
public class TestOpticiansOfUS extends AbstractBaseTestCase {

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void OpticiansOfUS() {
        String url = "http://www.smartbuyglasses.com/designer-eyeglasses/Tom-Ford/";
        getURL(url);
        Header header = new Header();
        header.inputSearch.click();
        header.deleteHead();
        ProductGridPage productGridPage = new ProductGridPage();
        //
        productGridPage.waitForVisibility(productGridPage.proInfo.get(0), 2);
        productGridPage.JsMouse(productGridPage.proInfo.get(0));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        new Actions(driver).moveToElement(productGridPage.proInfo.get(0)).build().perform();
        productGridPage.waitForVisibility(productGridPage.quickView.get(0), 5);
        productGridPage.quickView.get(0).click();
        //
        productGridPage.waitForVisibility(productGridPage.buyRX, 20);
        productGridPage.buyRX.click();
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.rx3Frame, 5);
        rx3Page.JsScale(rx3Page.rx3Frame, 0.5);
        Double framePrice = productGridPage.regexGetDouble(rx3Page.framePrice.getText());
        header.waitForVisibility(productGridPage.cartBtn, 10);
        rx3Page.deluxe.click();
        header.waitForVisibility(rx3Page.deluxeVery, 2);
        rx3Page.deluxeVery.click();
        Double lensePrice = productGridPage.regexGetDouble(rx3Page.lenses_price.getText());
        Assert.assertEquals(productGridPage.regexGetDouble(rx3Page.frame_price.getText()), framePrice);
        Assert.assertEquals(productGridPage.regexGetDouble(rx3Page.deluxeVeryPriece.getText()), lensePrice);
        double price = productGridPage.mathAdd(lensePrice, framePrice);
        Assert.assertEquals(productGridPage.regexGetDouble(rx3Page.total_price.getText()), price);
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
