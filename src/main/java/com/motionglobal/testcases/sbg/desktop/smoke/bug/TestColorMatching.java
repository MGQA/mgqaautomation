package com.motionglobal.testcases.sbg.desktop.smoke.bug;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.rx.RX3Page;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestColorMatching extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com.hk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void colorMatching(String url) {
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.btnSunRX.click();
        detailPage.getRXType();
        RX3Page rx3Page = new RX3Page();
        rx3Page.waitForVisibility(rx3Page.rxList.get(3), 2);
        int price1 = rx3Page.regexGeInt(rx3Page.color_price.getText());
        String color1 = rx3Page.rxList.get(3).getText();
        rx3Page.rxList.get(3).click();
        rx3Page.waitForVisibility(rx3Page.subList.get(4), 5);
        rx3Page.subList.get(4).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(rx3Page.rxList.get(3), color1)));
        int price2 = rx3Page.regexGeInt(rx3Page.color_price.getText());
        rx3Page.waitForVisibility(rx3Page.subList.get(0), 5);
        rx3Page.subList.get(0).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(rx3Page.rxList.get(3), color1));
        int price3 = rx3Page.regexGeInt(rx3Page.color_price.getText());
        System.out.println(price1 + "_" + price2 + "_" + price3);
        Assert.assertEquals(price3, price1, " _OMG COLOR MATCHING IS FREE !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
