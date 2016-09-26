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
        MobRX3Page opticianPage = new MobRX3Page();
        Double totalPrice = getPrice(opticianPage.priceTotal);
        opticianPage.JsMouse(opticianPage.btnContinue);
        opticianPage.btnContinue.click();
        Double priceCart = getPrice(cartPage.priceTotal);
        Assert.assertEquals(priceCart, totalPrice);
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
