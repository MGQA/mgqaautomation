package com.motionglobal.testcases.sbg.desktop.smoke;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestDynamicPrice extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "https://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-" /* 110094.html" */} };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void dynamic(String url) {
        String[][] dyndate = null;
        try {
            dyndate = MysqlConnect219Util
                    .getTestData("SELECT product_id,discount_value,urlparameter from sbg_marketing_dynamic_promotion WHERE country_id='11' AND category_id='1' AND is_active='1' LIMIT 1;");
        }
        catch (SQLException e) {
        }
        String productId = dyndate[0][0];
        int dynRate = Integer.parseInt(dyndate[0][1].replace(".00", "").replace(".0", ""));
        String dynCode = dyndate[0][2];
        System.out.println(productId + " - " + dynRate + " - " + dynCode);
        getURL(url + productId + ".html");
        ProductDetailPage detailPage = new ProductDetailPage();
        double price = detailPage.regexGetDouble(detailPage.price.getText());
        getURL(url + productId + ".html/?d=" + dynCode);
        double dynPrice = detailPage.regexGetDouble(detailPage.price.getText());
        int actualRate = (int) Math.round((price - dynPrice) / price * 100);
        System.out.println(actualRate + " - " + dynRate);
        Assert.assertEquals(actualRate, dynRate);
        detailPage.btnBuyNow.click();
        NewCartPage cartPage = new NewCartPage();
        double totalPrice = cartPage.regexGetDouble(cartPage.priceTotal.getText());
        System.out.println(totalPrice + " - " + dynPrice);
        Assert.assertEquals(totalPrice, dynPrice);
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
