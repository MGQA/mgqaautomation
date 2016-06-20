package com.motionglobal.pages.sbg.om;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.AbstractBasePage;

public class Supplier extends AbstractBasePage {
    // menu
    @FindBy(css = "[node$='New PO']>a")
    public WebElement menuCreatePO;
    @FindBy(css = "[node^='Edit']>a")
    public WebElement menuEditAllPO;
    // common
    @FindBy(id = "order_code")
    public WebElement order;
    @FindBy(id = "button")
    public WebElement goBtn;
    @FindBy(className = "checkAll")
    public WebElement checkAll;
    @FindBy(className = "rowCheck")
    public WebElement check;
    @FindBy(css = ".ONE-CLICK")
    public WebElement createBtn;
    // submenu
    @FindBy(xpath = "//a[contains(text(),'te Sup')]")
    public WebElement submenuSupplier;
    @FindBy(xpath = "//a[contains(text(),'Create HK')]")
    public WebElement submenuHKPO;
    // edit
    @FindBy(xpath = "//tr[1]//a[text()='Edit']")
    public WebElement Edit1;
    @FindBy(css = "[value$='Update']")
    public WebElement confirmUpdate;
    //
    @FindBy(className = "statusAll")
    private WebElement statu;
    @FindBy(name = "current_status")
    private WebElement POstatu;
    @FindBy(css = "[name^='detail_status']")
    private WebElement stockReceivedInWH;

    //

    public void confirmSupplier() {
        waitForVisibility(statu, 5);
        Select select = new Select(statu);
        select.selectByValue("3");
    }

    public void confirmPOstatu() {
        waitForVisibility(POstatu, 5);
        Select select = new Select(POstatu);
        select.selectByValue("5");
    }

    // public void confirmStockReceivedInWH() {
    // waitForVisibility(stockReceivedInWH, 5);
    // Select select = new Select(stockReceivedInWH);
    // select.selectByValue("10");
    // }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(driver.findElement(By.cssSelector("[node='View All Suppliers']")), 20);
    }
}
