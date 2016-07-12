package com.motionglobal.pages.sbg.desktop.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CheckoutPage extends AbstractBaseSbgDesktopPage {

    @FindBy(id = "gc-payment")
    public WebElement btnGcPayment;
    @FindBy(css = ".total_price.td_r")
    public WebElement priceTotal;
    @FindBy(css = "#payment_product_1 input")
    private WebElement radioVISA;
    //
    @FindBy(id = "billing_first_name")
    private WebElement inputBillingFirstName;
    @FindBy(id = "billing_last_name")
    private WebElement inputBillingLastName;
    @FindBy(id = "customer_email")
    private WebElement inputBillingEmail;
    @FindBy(name = "billing_address1")
    private WebElement inputBillingAddress1;
    @FindBy(id = "billing_post_code")
    private WebElement inputBillingPostCode;
    @FindBy(id = "billing_state")
    private WebElement inputBillingState;
    @FindBy(id = "billing_city")
    private WebElement inputBillingCity;
    @FindBy(name = "billing_country")
    private WebElement selBillingCountry;
    @FindBy(name = "billing_telephone")
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

    public CheckoutPage selectBillingCountry(String countryValue) {
        Select country = new Select(this.selBillingCountry);
        country.selectByValue(countryValue);
        return this;
    }

    public CheckoutPage inputBillingAddress1(String billingAddress1) {
        clearInput(this.inputBillingAddress1, billingAddress1);
        return this;
    }

    public CheckoutPage clickVISA() {
        // Not accurate. to be fixed.
        // We are now using index, rather than text in the payment
        waitForVisibility(radioVISA, 2);
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
