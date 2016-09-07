package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
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
        Double framePrice = productGridPage.regexGetDouble(productGridPage.framePrice.getText());
        header.waitForVisibility(productGridPage.cartBtn, 10);
        productGridPage.deluxe.click();
        header.waitForVisibility(productGridPage.deluxeVery, 2);
        productGridPage.deluxeVery.click();
        Double lensePrice = productGridPage.regexGetDouble(productGridPage.lenses_price.getText());
        Assert.assertEquals(productGridPage.regexGetDouble(productGridPage.frame_price.getText()), framePrice);
        Assert.assertEquals(productGridPage.regexGetDouble(productGridPage.deluxeVeryPriece.getText()), lensePrice);
        double price = productGridPage.mathAdd(lensePrice, framePrice);
        Assert.assertEquals(productGridPage.regexGetDouble(productGridPage.total_price.getText()), price);
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
