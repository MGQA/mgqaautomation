package com.motionglobal.testcases.sbg.desktop.smoke;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.PaypalPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestPaypalForAR extends AbstractBaseSbgDesktopTestCase {

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void topSellImg() {
        String url = "http://www.smartbuyglasses.com.ar/lentes-de-sol-de-dise%C3%B1o/D&G/D&G-DD3065/S-1870/8G-116377.html";
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.com.ar/"));
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();

        // cartpage click paypal
        CartPage cartPage = new CartPage();
        cartPage.waitForVisibility(cartPage.paypalBtn, 5);
        cartPage.paypalBtn.click();
        PaypalPage paypalPage = new PaypalPage();
        Assert.assertNotNull(paypalPage.paypalContentDisplay);
    }

    //
    @DataProvider(name = "sqlData")
    public static String[][] sql() throws IOException, SQLException {
        // return MysqlConnect219Util.getTestData("SELECT payment_product_id FROM gc_payment_country WHERE country_id=63;");
        return MysqlConnect219Util
                .getTestData("SELECT payment_product_id FROM gc_payment_country WHERE allowance=1 AND country_id<30 ORDER BY country_id , payment_product_id;");
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void testSQL() {
        String b = "";
        try {
            for (int i = 0; i < sql().length; i++) {
                for (int j = 0; j < sql()[i].length; j++) {
                    b += sql()[i][j];
                }
            }
            System.out.println(b);
        }
        catch (IOException e) {
        }
        catch (SQLException e) {
        }

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
