package com.motionglobal.pages.sbg.desktop.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CheckoutPage extends AbstractBaseSbgDesktopPage {

    @FindBy(id = "gc-payment")
    public WebElement btnGcPayment;
    @FindBy(css = "#payment_product_1 input")
    private WebElement radioVISA;

    @FindBy(id = "billing_first_name")
    private WebElement inputBillingFirstName;
    @FindBy(id = "billing_last_name")
    private WebElement inputBillingLastName;
    @FindBy(id = "billing__address1")
    private WebElement inputBillingAddress1;
    @FindBy(id = "billing_post_code")
    private WebElement inputBillingPostCode;
    @FindBy(id = "billing_state")
    private WebElement inputBillingState;
    @FindBy(id = "billing_city")
    private WebElement inputBillingCity;
    @FindBy(id = "billing_country")
    private WebElement inputBillingCountry;
    @FindBy(id = "billing_telephone")
    private WebElement inputBillingTelephone;

    public void enterBillingAddress(String firstName, String lastName, String address1, String postcode, String state, String city, String country,
            String telephone) {
        clearInput(this.inputBillingFirstName, firstName);
        clearInput(this.inputBillingLastName, lastName);
        clearInput(this.inputBillingAddress1, address1);
        clearInput(this.inputBillingPostCode, postcode);
        clearInput(this.inputBillingState, state);
        clearInput(this.inputBillingCity, city);
        clearInput(this.inputBillingCountry, country);
        clearInput(this.inputBillingTelephone, telephone);
    }

    public CheckoutPage clickVISA() {
        // Not accurate. to be fixed.
        // We are now using index, rather than text in the payment
        this.radioVISA.click();
        return this;
    }

    public CheckoutPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("gc-payment"), 20);
    }

}
