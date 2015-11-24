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
    @FindBy(id = "customer_email")
    private WebElement inputBillingEmail;
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

    public CheckoutPage inputBillingFirstName(String firstName) {
        clearInput(this.inputBillingFirstName, firstName);
        return this;
    }

    public CheckoutPage inputBillingLastName(String lastName) {
        clearInput(this.inputBillingLastName, lastName);
        return this;
    }

    public CheckoutPage inputBillingEmail(String email) {
        clearInput(this.inputBillingEmail, email);
        return this;
    }

    public CheckoutPage inputBillingTelephone(String tel) {
        clearInput(this.inputBillingTelephone, tel);
        return this;
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
