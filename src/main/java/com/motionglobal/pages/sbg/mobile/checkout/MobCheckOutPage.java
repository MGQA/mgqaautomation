package com.motionglobal.pages.sbg.mobile.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobCheckOutPage extends AbstractBaseSbgDesktopPage {
    @FindBy(xpath = "//input[contains(@class,'shipping_first_name')]")
    public WebElement inputFistName;
    @FindBy(xpath = "//input[contains(@class,'shipping_last_name')]")
    public WebElement inputLastName;
    @FindBy(className = "shipping_email")
    public WebElement inputEmail;
    @FindBy(xpath = "//input[contains(@class,'shipping_address1')]")
    public WebElement inputAddress1;
    @FindBy(xpath = "//input[contains(@class,'shipping_telephone')]")
    public WebElement inputPhone;
    @FindBy(className = "shipping_post_code")
    public WebElement inputPostAddress;
    @FindBy(className = "shipping_city")
    public WebElement inputCity;
    @FindBy(name = "shipping_state")
    private WebElement inputState;
    @FindBy(className = "cartGreenBtn")
    public WebElement continueBtn;
    @FindBy(id = "product_122")
    public WebElement VISA;
    @FindBy(id = "F1009")
    public WebElement Card;
    @FindBy(tagName = "iframe")
    public WebElement iframe;

    public void selectStateGA() {
        Select select = new Select(inputState);
        select.selectByValue("GA");
    }

    public void SwitchToIframe() {
        driver.switchTo().frame(iframe);
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("checkOutStepTi"), 30);
    }

}
