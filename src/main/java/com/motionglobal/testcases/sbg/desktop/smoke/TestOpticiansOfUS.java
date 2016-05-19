package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

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
        productGridPage.waitForVisibility(productGridPage.buyNowButton, 5);
        header.waitForVisibility(productGridPage.buyNowButton, 2);
        String framePrice = productGridPage.framePrice.getText().replace("$", "").replace(".", "");
        productGridPage.buyNowButton.click();
        header.waitForVisibility(productGridPage.cartBtn, 2);
        productGridPage.deluxe.click();
        header.waitForVisibility(productGridPage.deluxeVery, 2);
        productGridPage.deluxeVery.click();
        String lensePrice = productGridPage.lenses_price.getText().replace("$", "").replace(".", "");
        Assert.assertEquals(productGridPage.frame_price.getText().replace("$", "").replace(".", ""), framePrice);
        Assert.assertEquals(productGridPage.deluxeVeryPriece.getText().replace("$", "").replace(".", "") + "00", lensePrice);
        String price = Integer.toString(Integer.parseInt(lensePrice) + Integer.parseInt(framePrice));
        Assert.assertEquals(productGridPage.total_price.getText().replace("$", "").replace(".", ""), price);
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
