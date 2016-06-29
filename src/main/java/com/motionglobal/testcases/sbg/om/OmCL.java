package com.motionglobal.testcases.sbg.om;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.om.OmHeader;
import com.motionglobal.pages.sbg.om.OmLoginPage;
import com.motionglobal.pages.sbg.om.OrderPage;
import com.motionglobal.pages.sbg.om.Supplier;
import com.motionglobal.pages.sbg.om.WareHouse;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class OmCL extends AbstractBaseTestCase {

    @Test(groups = { "debug3", "smoke", "om" })
    public void CLHaveInventory() {
        // productID=451.power=5.50.
        String productID = "451";
        getURL("http://omtest.motionglobal.com/login/login/");
        //
        new OmLoginPage().OmLogin();
        OmHeader header = new OmHeader();
        header.waitForVisibility(header.getHeader(3), 20);
        header.getHeader(3).click();
        OrderPage orderPage = new OrderPage();
        // try delete orderID
        try {
            orderPage.waitForVisibility(orderPage.ActiveOrderList, 5);
            orderPage.ActiveOrderList.click();
            orderPage.waitForVisibility(orderPage.BtnDeleteJACKZHONG, 2);
            orderPage.BtnDeleteJACKZHONG.click();
        }
        catch (Exception e) {
        }
        // choose product
        orderPage.waitForVisibility(orderPage.AddManualOrder, 5);
        orderPage.AddManualOrder.click();
        orderPage.selectUrl("2");
        orderPage.waitForVisibility(orderPage.btn, 5);
        orderPage.btn.click();
        orderPage.waitForVisibility(orderPage.AddLineItemBtn, 5);
        orderPage.AddLineItemBtn.click();
        orderPage.selectCL();
        orderPage.waitForVisibility(orderPage.CLid, 5);
        orderPage.CLid.click();
        orderPage.CLid.sendKeys(productID);
        orderPage.actionKey(Keys.ENTER);
        orderPage.waitForVisibility(orderPage.CL451Exist, 10);
        // CL бу
        orderPage.selectR_power("5.50");
        orderPage.selectR_curve("8.5");
        orderPage.selectR_diameter("14.2");
        orderPage.selectL_power("5.50");
        orderPage.selectL_curve("8.5");
        orderPage.selectL_diameter("14.2");
        orderPage.addBtn.click();

        // fill detail massage
        orderPage.waitForVisibility(orderPage.InputFirstName, 5);
        orderPage.InputFirstName.sendKeys("jack");
        orderPage.InputLastName.sendKeys("zhong");
        orderPage.selectCountry("China");
        orderPage.InputAddress1.sendKeys("shanghai");
        orderPage.InputCity.sendKeys("shanghai");
        orderPage.InputState.sendKeys("N/A");
        orderPage.InputPostCode.sendKeys("200000");
        orderPage.InputPhone.sendKeys("15901234569");
        orderPage.InputEmail.sendKeys("jack.zhong@motionglobal.com");
        orderPage.waitForVisibility(orderPage.CopyTo, 5);
        orderPage.CopyTo.click();
        orderPage.placeOrder.click();
        // finished add product

        // Alert accept
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }

        // get orderID\hand
        orderPage.waitForVisibility(orderPage.OrderID, 5);
        String orderID = orderPage.OrderID.getText().substring(0, 13);
        System.out.println(orderID);
        String oderPageHand = driver.getWindowHandle();

        // firm pay
        orderPage.JsMouse(orderPage.Date);
        orderPage.Date.click();
        orderPage.confirmAllBtn.click();
        orderPage.confirmStatu();
        orderPage.waitForVisibility(orderPage.payConfirm, 5);
        orderPage.JsClick(orderPage.payConfirm);

        // Assert status
        driver.navigate().refresh();
        orderPage.waitForVisibility(orderPage.orderStatu, 5);
        Assert.assertEquals(orderPage.orderStatu.getText(), "Approved & In Processing");

        // new windows open url
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String supplierUrl = "http://omtest.motionglobal.com/po/index/act/search/?status[]=1&status[]=2/";
        js.executeScript("window.open('" + supplierUrl + "')");
        orderPage.switch2NewWindow();

        //
        Supplier supplier = new Supplier();
        supplier.waitForVisibility(supplier.menuCreatePO, 5);
        supplier.menuCreatePO.click();

        // CL HK wareHouse
        supplier.waitForVisibility(supplier.submenuCLHK, 5);
        supplier.submenuCLHK.click();
        supplier.waitForVisibility(supplier.goBtn, 5);
        supplier.order.sendKeys(orderID);
        supplier.goBtn.click();
        supplier.waitForVisibility(supplier.checkAll, 10);
        supplier.checkAll.click();
        supplier.waitForVisibility(supplier.createBtn, 5);
        supplier.createBtn.click();

        // Assert status
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "wait for status update");
        orderPage.switch2NewWindow();

        //
        supplier.waitForVisibility(supplier.menuEditAllPO, 10);
        supplier.menuEditAllPO.click();
        supplier.waitForVisibility(supplier.Edit1, 5);
        supplier.Edit1.click();
        WareHouse wareHouse = new WareHouse();
        wareHouse.waitForVisibility(wareHouse.checkAll, 5);
        wareHouse.checkAll.click();
        wareHouse.confirmSupplier();
        wareHouse.updateBtn.click();
        wareHouse.confirmPOstatus();
        wareHouse.waitForVisibility(wareHouse.updateBtn, 5);
        wareHouse.updateBtn.click();

        //
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "stock received in WH");
        orderPage.switch2NewWindow();
        // confirm supplier finished

        // Manifest
        wareHouse.waitForVisibility(wareHouse.menuManifest, 5);
        wareHouse.menuManifest.click();
        wareHouse.waitForVisibility(wareHouse.submenuCreateShipManifest, 5);
        wareHouse.submenuCreateShipManifest.click();

        // add CL
        wareHouse.waitForVisibility(wareHouse.InputCL, 5);
        wareHouse.InputCL.click();
        wareHouse.InputGlasses.click();
        wareHouse.goBtn.click();

        // confirm
        wareHouse.waitForVisibility(wareHouse.getManifestInput(orderID), 10);
        wareHouse.getManifestInput(orderID).click();
        wareHouse.confirmUpDate.click();

        // assert status
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "Wait for Tracking #");
        orderPage.switch2NewWindow();

        // finish
        wareHouse.waitForVisibility(wareHouse.submenuViewShipManifest, 5);
        wareHouse.submenuViewShipManifest.click();
        wareHouse.waitForVisibility(wareHouse.Edit, 5);
        wareHouse.Edit.click();
        wareHouse.waitForVisibility(wareHouse.checkAll, 5);
        wareHouse.checkAll.click();
        wareHouse.confirmManifesStatus();
        wareHouse.confirmUpDate.click();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        wareHouse.waitForVisibility(wareHouse.confirmUpDate, 5);
        wareHouse.confirmUpDate.click();
        //
        driver.close();
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "Shipped");
    }

    // FIXME
    @Test(groups = { "debug3", "smoke", "om" })
    public void CLNoInventory() {
        // productID=451. power=4.50.
        String productID = "451";
        getURL("http://omtest.motionglobal.com/login/login/");
        //
        new OmLoginPage().OmLogin();
        OmHeader header = new OmHeader();
        header.waitForVisibility(header.getHeader(3), 20);
        header.getHeader(3).click();
        OrderPage orderPage = new OrderPage();
        // try delete orderID
        try {
            orderPage.waitForVisibility(orderPage.ActiveOrderList, 5);
            orderPage.ActiveOrderList.click();
            orderPage.waitForVisibility(orderPage.BtnDeleteJACKZHONG, 2);
            orderPage.BtnDeleteJACKZHONG.click();
        }
        catch (Exception e) {
        }
        // choose product
        orderPage.waitForVisibility(orderPage.AddManualOrder, 5);
        orderPage.AddManualOrder.click();
        orderPage.selectUrl("2");
        orderPage.waitForVisibility(orderPage.btn, 5);
        orderPage.btn.click();
        orderPage.waitForVisibility(orderPage.AddLineItemBtn, 5);
        orderPage.AddLineItemBtn.click();
        orderPage.selectCL();
        orderPage.waitForVisibility(orderPage.CLid, 5);
        orderPage.CLid.click();
        orderPage.CLid.sendKeys(productID);
        orderPage.actionKey(Keys.ENTER);
        orderPage.waitForVisibility(orderPage.CL451Exist, 10);
        // CL бу
        orderPage.selectR_power("4.50");
        orderPage.selectR_curve("8.5");
        orderPage.selectR_diameter("14.2");
        orderPage.selectL_power("4.50");
        orderPage.selectL_curve("8.5");
        orderPage.selectL_diameter("14.2");
        orderPage.addBtn.click();

        // fill detail massage
        orderPage.waitForVisibility(orderPage.InputFirstName, 5);
        orderPage.InputFirstName.sendKeys("jack");
        orderPage.InputLastName.sendKeys("zhong");
        orderPage.selectCountry("China");
        orderPage.InputAddress1.sendKeys("shanghai");
        orderPage.InputCity.sendKeys("shanghai");
        orderPage.InputState.sendKeys("N/A");
        orderPage.InputPostCode.sendKeys("200000");
        orderPage.InputPhone.sendKeys("15901234569");
        orderPage.InputEmail.sendKeys("jack.zhong@motionglobal.com");
        orderPage.waitForVisibility(orderPage.CopyTo, 5);
        orderPage.CopyTo.click();
        orderPage.placeOrder.click();
        // finished add product

        // Alert accept
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }

        // get orderID\hand
        orderPage.waitForVisibility(orderPage.OrderID, 5);
        String orderID = orderPage.OrderID.getText().substring(0, 13);
        System.out.println(orderID);
        String oderPageHand = driver.getWindowHandle();

        // firm pay
        orderPage.JsMouse(orderPage.Date);
        orderPage.Date.click();
        orderPage.confirmAllBtn.click();
        orderPage.confirmStatu();
        orderPage.waitForVisibility(orderPage.payConfirm, 5);
        orderPage.JsClick(orderPage.payConfirm);

        // Assert status
        driver.navigate().refresh();
        orderPage.waitForVisibility(orderPage.orderStatu, 5);
        Assert.assertEquals(orderPage.orderStatu.getText(), "Approved & In Processing");

        // new windows open url
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String supplierUrl = "http://omtest.motionglobal.com/po/index/act/search/?status[]=1&status[]=2/";
        js.executeScript("window.open('" + supplierUrl + "')");
        orderPage.switch2NewWindow();

        //
        Supplier supplier = new Supplier();
        supplier.waitForVisibility(supplier.menuCreatePO, 5);
        supplier.menuCreatePO.click();

        // CL HK wareHouse
        supplier.waitForVisibility(supplier.submenuCLSupplier, 5);
        supplier.submenuCLSupplier.click();
        supplier.waitForVisibility(supplier.goBtn, 5);
        supplier.order.sendKeys(orderID);
        supplier.goBtn.click();
        supplier.waitForVisibility(supplier.checkAll, 10);
        supplier.checkAll.click();
        supplier.waitForVisibility(supplier.createBtn, 5);
        supplier.createBtn.click();

        // Assert status
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "wait for status update");
        orderPage.switch2NewWindow();

        //
        supplier.waitForVisibility(supplier.menuEditAllPO, 5);
        supplier.menuEditAllPO.click();
        supplier.waitForVisibility(supplier.Edit1, 5);
        supplier.Edit1.click();
        supplier.waitForVisibility(supplier.checkAll, 2);
        supplier.checkAll.click();
        supplier.confirmSupplier();
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
        // supplier.confirmStockReceivedInWH();
        supplier.confirmUpdate.click();
        supplier.confirmPOstatu();
        supplier.createBtn.click();
        //
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "stock confirmed");
        orderPage.switch2NewWindow();

        // shipment
        header.waitForVisibility(header.getHeader(6), 5);
        header.getHeader(6).click();
        WareHouse wareHouse = new WareHouse();
        wareHouse.waitForVisibility(wareHouse.importShipment, 5);
        wareHouse.importShipment.click();
        wareHouse.waitForVisibility(wareHouse.manualRadio, 5);

        // confirm shipment
        wareHouse.confirmCLSupplier();
        wareHouse.confirmImportFulfillment();
        wareHouse.manualRadio.click();
        wareHouse.POListSizeGT0();
        int POSize = wareHouse.POList.size();
        wareHouse.POList.get(POSize - 1).click();
        wareHouse.POList.get(POSize - 2).click();
        wareHouse.manualCreate.click();
        wareHouse.waitForVisibility(wareHouse.confirmUpDate, 5);
        wareHouse.confirmUpDate.click();

        // assert status
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "stock in transition");
        orderPage.switch2NewWindow();

        // confirm;
        wareHouse.waitForVisibility(wareHouse.Edit, 5);
        wareHouse.Edit.click();
        wareHouse.waitForVisibility(wareHouse.checkAll, 5);
        wareHouse.checkAll.click();
        wareHouse.confirmSupplier();
        wareHouse.confirmUpDate.click();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        wareHouse.waitForVisibility(wareHouse.confirmUpDate, 5);
        wareHouse.confirmUpDate.click();

        //
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "stock received in WH");
        orderPage.switch2NewWindow();
        // confirm supplier finished

        // Manifest
        wareHouse.waitForVisibility(wareHouse.menuManifest, 5);
        wareHouse.menuManifest.click();
        wareHouse.waitForVisibility(wareHouse.submenuCreateShipManifest, 5);
        wareHouse.submenuCreateShipManifest.click();

        // add CL
        wareHouse.waitForVisibility(wareHouse.InputCL, 5);
        wareHouse.InputCL.click();
        wareHouse.InputGlasses.click();
        wareHouse.goBtn.click();
        //
        wareHouse.waitForVisibility(wareHouse.getManifestInput(orderID), 5);
        wareHouse.getManifestInput(orderID).click();
        wareHouse.confirmUpDate.click();
        //
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "Wait for Tracking #");
        orderPage.switch2NewWindow();

        // finish
        wareHouse.waitForVisibility(wareHouse.submenuViewShipManifest, 5);
        wareHouse.submenuViewShipManifest.click();
        wareHouse.waitForVisibility(wareHouse.Edit, 5);
        wareHouse.Edit.click();
        wareHouse.waitForVisibility(wareHouse.checkAll, 5);
        wareHouse.checkAll.click();
        wareHouse.confirmManifesStatus();
        wareHouse.confirmUpDate.click();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        wareHouse.waitForVisibility(wareHouse.confirmUpDate, 5);
        wareHouse.confirmUpDate.click();
        //
        driver.close();
        driver.switchTo().window(oderPageHand);
        driver.navigate().refresh();
        Assert.assertEquals(orderPage.orderStatu.getText(), "Shipped");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
