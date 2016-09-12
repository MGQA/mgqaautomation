package com.motionglobal.testcases.sbg.mobile.RX;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobNewOpticianPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestBuyFarmeOnly extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    // XXX case buyFrameOnly
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void buyFrameOnly(String url) throws InterruptedException {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.addLens.click();
        MobNewOpticianPage opticianPage = new MobNewOpticianPage();
        opticianPage.waitForVisibility(opticianPage.buyFrame, 5);
        Double priceFrame = getPrice(opticianPage.buyFrame);
        opticianPage.buyFrame.click();
        MobCartPage cartPage = new MobCartPage();
        Double priceCart = getPrice(cartPage.priceTotal);
        Assert.assertEquals(priceCart, priceFrame);
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
