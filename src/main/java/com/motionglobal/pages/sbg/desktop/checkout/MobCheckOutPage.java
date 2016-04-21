package com.motionglobal.pages.sbg.desktop.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(className = "cartGreenBtn")
    public WebElement continueBtn;
    @FindBy(id = "product_122")
    public WebElement VISA;
    // Assert Element
    @FindBy(id = "MISSING")
    public WebElement CardDiv;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("checkOutStepTi"), 30);
    }

}
