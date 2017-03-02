package com.motionglobal.testcases.sbg.desktop.smoke;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.pages.sbg.desktop.footer.customercare.FaqPage;
import com.motionglobal.pages.sbg.desktop.footer.customercare.HelpPage;
import com.motionglobal.pages.sbg.desktop.footer.customercare.OrderStatuPage;
import com.motionglobal.pages.sbg.desktop.footer.customercare.OrderTracking;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestOrderTracking extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { {} };
    }

    @Test(skipFailedInvocations = true, groups = { "debug111", "smoke" })
    public void orderTracking() {
        // get order and email
        String url = "http://www.smartbuyglasses.co.uk/order";
        String[][] orderData = null;
        String sql = "SELECT order_code,email FROM sbg_open_order_email_log AS a JOIN om_payment_log AS b  ON(b.oid=a.order_code) WHERE order_code != 'null' limit 1";
        try {
            orderData = MysqlConnect219Util.getTestData(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String order = orderData[0][0];
        String email = orderData[0][1];

        //
        getURL(url);
        OrderTracking tracking = new OrderTracking();
        tracking.inputOrder.sendKeys(order);
        tracking.inputEmail.sendKeys(email);
        tracking.waitForVisibility(tracking.btnOrderTracking, 5);
        tracking.btnOrderTracking.click();
        OrderStatuPage statuPage = new OrderStatuPage();
        statuPage.waitForVisibility(statuPage.orderID, 5);
        statuPage.waitForVisibility(statuPage.orderTitle, 5);
        Assert.assertEquals(statuPage.orderID.getText(), "Order " + order);
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void helpOrderTracking() {
        // get order and email
        String url = "https://www.smartbuyglasses.co.uk/help";
        String[][] orderData = null;
        String sql = "SELECT order_code,email FROM sbg_open_order_email_log AS a JOIN om_payment_log AS b  ON(b.oid=a.order_code) WHERE order_code != 'null' limit 1";
        try {
            orderData = MysqlConnect219Util.getTestData(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String order = orderData[0][0];

        //
        getURL(url);
        HelpPage helpPage = new HelpPage();
        helpPage.waitForVisibility(helpPage.btnTracking, 5);
        helpPage.inputOrder.clear();
        helpPage.inputOrder.sendKeys(order);
        helpPage.btnTracking.click();
        OrderStatuPage statuPage = new OrderStatuPage();
        statuPage.waitForVisibility(statuPage.orderID, 5);
        statuPage.waitForVisibility(statuPage.orderTitle, 5);
        Assert.assertEquals(statuPage.orderID.getText(), "Order " + order);
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void faqOrderTracking() {
        // get order and email
        String url = "https://www.smartbuyglasses.co.uk/faq";
        String[][] orderData = null;
        String sql = "SELECT order_code,email FROM sbg_open_order_email_log AS a JOIN om_payment_log AS b  ON(b.oid=a.order_code) WHERE order_code != 'null' limit 1";
        try {
            orderData = MysqlConnect219Util.getTestData(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String order = orderData[0][0];

        //
        getURL(url);
        FaqPage faqPage = new FaqPage();
        faqPage.waitForVisibility(faqPage.btnTracking, 5);
        faqPage.inputOrder.clear();
        faqPage.inputOrder.sendKeys(order);
        faqPage.btnTracking.click();
        OrderStatuPage statuPage = new OrderStatuPage();
        statuPage.waitForVisibility(statuPage.orderID, 5);
        statuPage.waitForVisibility(statuPage.orderTitle, 5);
        Assert.assertEquals(statuPage.orderID.getText(), "Order " + order);

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
