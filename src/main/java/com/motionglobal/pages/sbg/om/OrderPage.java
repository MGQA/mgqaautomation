package com.motionglobal.pages.sbg.om;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.AbstractBasePage;

public class OrderPage extends AbstractBasePage {
    @FindBy(css = "[onclick*='show']")
    public WebElement orderStatu;
    @FindBy(xpath = "//td[text()='Order ID']/../td[2]")
    public WebElement OrderID;
    // menu
    @FindBy(css = "[node*='Manual ']")
    public WebElement AddManualOrder;
    @FindBy(css = "[href*='active']")
    public WebElement ActiveOrderList;
    // private
    @FindBy(id = "size_option")
    private WebElement size;
    @FindBy(id = "cid")
    private WebElement cid;
    @FindBy(id = "lens_type")
    private WebElement type;
    @FindBy(id = "billing_country")
    private WebElement country;
    @FindBy(id = "paymentLogStatus")
    private WebElement payStatu;
    @FindBy(id = "category")
    private WebElement glassCategory;
    //
    @FindBy(id = "btn")
    public WebElement btn;
    @FindBy(id = "button6")
    public WebElement AddLineItemBtn;
    @FindBy(id = "product_id")
    public WebElement productID;
    @FindBy(css = "[value='Add']")
    public WebElement addBtn;
    @FindBy(id = "button")
    public WebElement placeOrder;
    @FindBy(id = "paymentLogs-checkAll")
    public WebElement Date;
    @FindBy(css = "[value='Confirm All']")
    public WebElement confirmAllBtn;
    //
    @FindBy(css = "[value='Confirm']")
    public WebElement payConfirm;

    // massage detail
    @FindBy(css = "[value*='Copy To']")
    public WebElement CopyTo;
    @FindBy(id = "billing_first_name")
    public WebElement InputFirstName;
    @FindBy(id = "billing_last_name")
    public WebElement InputLastName;
    @FindBy(id = "billing_address1")
    public WebElement InputAddress1;
    @FindBy(id = "billing_city")
    public WebElement InputCity;
    @FindBy(id = "billing_state")
    public WebElement InputState;
    @FindBy(id = "billing_postcode")
    public WebElement InputPostCode;
    @FindBy(id = "billing_tel")
    public WebElement InputPhone;
    @FindBy(id = "customer_email")
    public WebElement InputEmail;

    // wait brand exist
    @FindBy(xpath = "//*[text()='Tom Ford FT0237 SNOWDON 52N']")
    public WebElement TomFordExist;
    @FindBy(xpath = "//*[text()='Nine West NW535S 615']")
    public WebElement nineWestExist;

    // active order list
    @FindBy(xpath = "//td[text()='jack.zhong']/..//a[2]")
    public WebElement BtnDeleteJACKZHONG;

    public void selectUrl(String value) {
        waitForVisibility(cid, 5);
        Select select = new Select(cid);
        select.selectByValue(value);
    }

    public void selectType(String value) {
        waitForVisibility(type, 5);
        Select select = new Select(type);
        select.selectByValue(value);
    }

    public void selectSize(String value) {
        waitForVisibility(size, 5);
        Select select = new Select(size);
        select.selectByValue(value);
    }

    public void selectCountry(String value) {
        waitForVisibility(country, 5);
        Select select = new Select(country);
        select.selectByValue(value);
    }

    public void selectCL() {
        waitForVisibility(glassCategory, 5);
        Select select = new Select(glassCategory);
        select.selectByValue("Contact Lenses");
    }

    public void confirmStatu() {
        waitForVisibility(payStatu, 5);
        Select select = new Select(payStatu);
        select.selectByValue("1");
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector("[node='View Sales Order']"), 20);
    }
}
