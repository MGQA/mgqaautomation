package com.motionglobal.pages.sbg.om;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.AbstractBasePage;

public class WareHouse extends AbstractBasePage {
    @FindBy(className = "statusAll")
    private WebElement status;
    @FindBy(name = "current_status")
    private WebElement POStatus;
    @FindBy(css = ".tre>td>select")
    private WebElement manifestStatus;
    // menu
    @FindBy(css = "[href$='import']")
    public WebElement importShipment;
    @FindBy(css = "[node='Manifest']>a")
    public WebElement menuManifest;
    @FindBy(css = "[href$='shippush']")
    public WebElement submenuCreateShipManifest;
    @FindBy(css = "[href$='[]=1']")
    public WebElement submenuViewShipManifest;
    //
    @FindBy(className = "checkAll")
    public WebElement checkAll;
    @FindBy(css = "[value$='Update']")
    public WebElement updateBtn;
    @FindBy(css = "[node='Shipment']")
    public WebElement shipment;
    @FindBy(css = ".ONE-CLICK")
    public WebElement confirmUpDate;
    @FindBy(xpath = "//tr[1]//a[1]")
    public WebElement Edit;

    // import
    @FindBy(id = "supplier")
    private WebElement importSupplier;
    @FindBy(id = "fulfillment")
    private WebElement importFulfillment;
    @FindBy(css = "[value='manual']")
    public WebElement manualRadio;
    @FindBy(className = "rowCheck")
    public List<WebElement> POList;
    @FindBy(id = "manualCreate")
    public WebElement manualCreate;

    public WebElement getManifestInput(String orderID) {
        return driver.findElement(By.xpath("//a[text()='" + orderID + "']/../../td[1]/input[1]"));
    }

    public void confirmSupplier() {
        waitForVisibility(status, 5);
        Select select = new Select(status);
        select.selectByValue("10");
    }

    public void confirmPOstatus() {
        waitForVisibility(POStatus, 5);
        Select select = new Select(POStatus);
        select.selectByValue("5");
    }

    public void confirmManifesStatus() {
        waitForVisibility(manifestStatus, 5);
        Select select = new Select(manifestStatus);
        select.selectByValue("3");
    }

    public void confirmImportSupplier() {
        waitForVisibility(importSupplier, 5);
        Select select = new Select(importSupplier);
        select.selectByValue("72");
    }

    public void confirmImportPopular() {
        waitForVisibility(importSupplier, 5);
        Select select = new Select(importSupplier);
        select.selectByValue("33");
    }

    public void confirmImportFulfillment() {
        waitForVisibility(importFulfillment, 5);
        Select select = new Select(importFulfillment);
        select.selectByValue("HK");
    }

    public void POListSizeGT0() {
        label: for (int i = 0; i < 100; i++) {
            if (POList.size() == 0) {
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
            }
            else
                break label;
        }
    }

    @Override
    protected void waitPageLoad() {
    }
}
