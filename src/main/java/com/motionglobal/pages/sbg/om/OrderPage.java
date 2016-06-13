package com.motionglobal.pages.sbg.om;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.AbstractBasePage;

public class OrderPage extends AbstractBasePage {
    @FindBy(css = "[node*='Manual ']")
    public WebElement AddManualOrder;
    @FindBy(id = "cid")
    public WebElement cid;
    @FindBy(id = "btn")
    public WebElement btn;
    @FindBy(id = "button6")
    public WebElement AddLineItemBtn;
    @FindBy(id = "product_id")
    public WebElement productID;
    @FindBy(id = "size_option")
    public WebElement size;
    @FindBy(id = "lens_type")
    public WebElement type;
    @FindBy(xpath = "//*[text()='Ray-Ban RB4165 Justin 852/88']")
    public WebElement RayBan4165Exist;

    // details

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

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".OM-SUBMENU.level2"), 20);
    }
}
