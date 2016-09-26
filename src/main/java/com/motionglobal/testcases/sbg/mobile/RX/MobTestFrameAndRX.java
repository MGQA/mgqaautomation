package com.motionglobal.testcases.sbg.mobile.RX;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.pages.sbg.mobile.product.MobRX3Page;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestFrameAndRX extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    // XXX case RX in cart
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void firstRX(String url) throws InterruptedException {
        // frame
        getURL(url);
        MobProductDetailPage detailPage2 = new MobProductDetailPage();
        Double priceFrame = detailPage2.regexGetDouble(detailPage2.price.getText());
        detailPage2.buyNow.click();
        MobCartPage cartPage2 = new MobCartPage();
        Double priceCart2 = getPrice(cartPage2.priceTotal);
        Assert.assertEquals(priceCart2, priceFrame);
        // RX
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobRX3Page opticianPage = new MobRX3Page();
        opticianPage.waitForVisibility(opticianPage.btnContinue, 5);
        Double priceTotal = getPrice(opticianPage.priceTotal);
        opticianPage.btnContinue.click();
        MobCartPage cartPage = new MobCartPage();
        Double priceCart = getPrice(cartPage.priceTotal);
        Assert.assertEquals(priceCart, priceTotal + priceFrame);

    }

    private Double getPrice(WebElement element) {
        Header header = new Header();
        header.JsMouse(element);
        double price = header.regexGetDouble(element.getText());
        return price;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
