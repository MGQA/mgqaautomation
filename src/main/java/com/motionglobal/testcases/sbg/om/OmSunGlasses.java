package com.motionglobal.testcases.sbg.om;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.om.OmHeader;
import com.motionglobal.pages.sbg.om.OrderPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class OmSunGlasses extends AbstractBaseTestCase {

    @Test(groups = "debug")
    public void SunGlasses() {
        getURL("http://omtest.motionglobal.com/login/login/");
        new OmLogin();
        OmHeader header = new OmHeader();
        header.waitForVisibility(header.getHeader(3), 20);
        header.getHeader(3).click();
        OrderPage orderPage = new OrderPage();
        orderPage.waitForVisibility(orderPage.AddManualOrder, 5);
        orderPage.AddManualOrder.click();
        orderPage.selectUrl("2");
        orderPage.waitForVisibility(orderPage.btn, 5);
        orderPage.btn.click();
        orderPage.waitForVisibility(orderPage.AddLineItemBtn, 5);
        orderPage.AddLineItemBtn.click();
        orderPage.waitForVisibility(orderPage.productID, 5);
        orderPage.productID.click();
        orderPage.productID.sendKeys("110094");
        orderPage.actionKey(Keys.ENTER);
        orderPage.waitForVisibility(orderPage.RayBan4165Exist, 10);
        orderPage.selectSize("54");
        orderPage.selectType("Sunglasses");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
