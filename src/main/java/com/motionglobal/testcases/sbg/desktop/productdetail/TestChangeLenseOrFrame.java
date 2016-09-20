package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestChangeLenseOrFrame extends AbstractBaseSbgDesktopTestCase {

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void changeLense() throws InterruptedException {
        String url = "http://www.smartbuyglasses.com/designer-eyeglasses/Ray-Ban/Ray-Ban-RX5228-Highstreet-2000-93357.html";
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.deleteHead();
        detailPage.deleteLetTalk();
        detailPage.clickFrameRadio(1);
        detailPage.clickFrameRadio(0);
        detailPage.btnBuyNow.click();
        if (detailPage.getRXType().equals("new")) {
            // true
        }
        else {
            detailPage.getCartType();
        }
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
