package com.motionglobal.testcases.sbg.mobile.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestRXText extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.visiondirect.com.au/designer-eyeglasses/Gucci/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void topSellImg(String url) {
        getURL(url);
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.matcherQuickViewClickOpen(1);
        gridPage.waitForVisibility(gridPage.buyRX, 10);
        gridPage.buyRX.click();
        gridPage.getRXType();
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.rxList, 10);
        try {
            Thread.sleep(800);
        }
        catch (InterruptedException e) {
        }
        rx3Page.rxList.get(0).click();
        rx3Page.waitForVisibility(rx3Page.subList, 9);
        String text1 = rx3Page.subList.get(0).getText();
        Assert.assertTrue(text1.contains("from"));
        String text2 = rx3Page.subList.get(1).getText();
        Assert.assertTrue(text2.contains("from"));
        String text3 = rx3Page.subList.get(2).getText();
        Assert.assertTrue(text3.contains("from"));
        String text4 = rx3Page.subList.get(3).getText();
        Assert.assertTrue(text4.contains("from"));
        String text5 = rx3Page.subList.get(4).getText();
        Assert.assertTrue(text5.contains("from"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
