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
    @FindBy(id = "cl_id")
    public WebElement CLid;
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
    // CL бу
    @FindBy(id = "R_power")
    private WebElement R_power;
    @FindBy(id = "R_curve")
    private WebElement R_curve;
    @FindBy(id = "R_diameter")
    private WebElement R_diameter;
    @FindBy(id = "L_power")
    private WebElement L_power;
    @FindBy(id = "L_curve")
    private WebElement L_curve;
    @FindBy(id = "L_diameter")
    private WebElement L_diameter;

    // wait brand exist
    @FindBy(xpath = "//*[text()='1-Day Acuvue TruEye 30 Pack']")
    public WebElement CL451Exist;
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

    // CL select
    public void selectR_power(String value) {
        waitForVisibility(R_power, 5);
        Select select = new Select(R_power);
        select.selectByValue(value);
    }

    public void selectR_curve(String value) {
        waitForVisibility(R_curve, 5);
        Select select = new Select(R_curve);
        select.selectByValue(value);
    }

    public void selectR_diameter(String value) {
        waitForVisibility(R_diameter, 5);
        Select select = new Select(R_diameter);
        select.selectByValue(value);
    }

    public void selectL_power(String value) {
        waitForVisibility(L_power, 5);
        Select select = new Select(L_power);
        select.selectByValue(value);
    }

    public void selectL_curve(String value) {
        waitForVisibility(L_curve, 5);
        Select select = new Select(L_curve);
        select.selectByValue(value);
    }

    public void selectL_diameter(String value) {
        waitForVisibility(L_diameter, 5);
        Select select = new Select(L_diameter);
        select.selectByValue(value);
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector("[node='View Sales Order']"), 20);
    }
}
