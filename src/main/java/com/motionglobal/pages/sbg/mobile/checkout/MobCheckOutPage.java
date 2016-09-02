package com.motionglobal.pages.sbg.mobile.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobCheckOutPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".img-box>label")
    public List<WebElement> payPicture;
    @FindBy(xpath = "//shipping_statelabel/*[1]")
    private WebElement state;
    //
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
    @FindBy(css = ".shipping_country")
    private WebElement selectCountry;
    @FindBy(css = ".ck_continue_btn.i-btn--orange")
    public WebElement continueBtn;
    @FindBy(id = "product_122")
    public WebElement VISA;
    @FindBy(id = "getPaymentPage")
    public WebElement payFrame;

    public void selectStateGA() {
        Select select = new Select(inputState);
        select.selectByValue("GA");
    }

    public void selectState(String value) {
        for (int i = 0; i < 20; i++) {
            try {
                if (state.getTagName().equals("select")) {
                    Thread.sleep(500);
                    Select select = new Select(inputState);
                    select.selectByValue(value);
                    break;
                }
                else {
                    Thread.sleep(200);
                }
            }
            catch (Exception e) {
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e1) {
                }
            }
        }
    }

    public void sendkeyState() {
        for (int i = 0; i < 20; i++) {
            try {
                if (state.getTagName().equals("input")) {
                    Thread.sleep(500);
                    state.sendKeys("thisstate");
                    break;
                }
                else {
                    Thread.sleep(200);
                }
            }
            catch (Exception e) {
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e1) {
                }
            }
        }
    }

    public void selectCountry(String value) {
        Select select = new Select(selectCountry);
        select.selectByValue(value);
    }

    public void AssertPayPicture(int... pay) {
        String[] expectPay = new String[pay.length];
        String[] actualPay = new String[payPicture.size()];
        Assert.assertEquals(payPicture.size(), pay.length);
        for (int i = 0; i < pay.length; i++) {
            expectPay[i] = "product_" + pay[i];
            actualPay[i] = payPicture.get(i).getAttribute("for");
            AsssetEquals(actualPay[i], expectPay[i]);
        }
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("checkOutStepTi"), 30);
    }

}
