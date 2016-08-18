package com.motionglobal.testcases.sbg.desktop.explore;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.explore.HappyCustomer;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestHappyCustomer extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/happy-customers" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void topSellImg(String url) {
        getURL(url);
        HappyCustomer customer = new HappyCustomer();
        customer.waitForVisibility(customer.customer2, 5);
        int coustomerNum = customer.customerAll.size();
        customer.AsssetTrue(coustomerNum > 1, " COUSTOMER NUMBER EMPTY !!!");
        try {
            customer.deleteHead();
            customer.deleteLetTalk();
        }
        catch (Exception e) {
        }
        customer.customer2.click();
        customer.switch2NewWindow();
        ProductDetailPage detailPage = new ProductDetailPage();
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
