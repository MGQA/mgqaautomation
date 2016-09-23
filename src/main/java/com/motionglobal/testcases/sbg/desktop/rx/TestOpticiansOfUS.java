package com.motionglobal.testcases.sbg.desktop.rx;

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
        ProductGridPage productGridPage = new ProductGridPage();
        header.mouseOver(productGridPage.proInfo.get(0));
        header.waitForVisibility(productGridPage.quickView, 2);
        productGridPage.quickView.click();
        productGridPage.waitForVisibility(productGridPage.buyNowButton, 20);
        productGridPage.buyNowButton.click();
        RX3Page rx3Page = new RX3Page();
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