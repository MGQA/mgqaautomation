package com.motionglobal.pages.sbg.mobile.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.common.utils.VerifyUtil;
import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.MobHeader;

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
    // @FindBy(id = "product_122")
    @FindBy(css = "img[src*='bigVisa']")
    public WebElement VISA;
    @FindBy(css = "img[src*='bigVisa'][style='opacity: 1;']")
    public WebElement VISAclicked;
    @FindBy(id = "getPaymentPage")
    public WebElement payFrame;
    //
    @FindBy(css = ".img-box:nth-of-type(6)>label>img")
    public WebElement payPictureInJP;

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
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
    }

    public void AssertPayPicture(String url, int... pay) {
        Header header = new Header();
        VerifyUtil verify = new MobHeader().VerifyUtil();
        String expectPay = "";
        String actualPay = "";
        // Assert.assertEquals(payPicture.size(), pay.length);
        // verify.verifyEquals(payPicture.size(), pay.length);
        for (int i = 0; i < pay.length; i++) {
            expectPay += pay[i];
        }
        for (int i = 0; i < payPicture.size(); i++) {
            actualPay += header.regexGeInt(payPicture.get(i).getAttribute("for"));
        }
        verify.verifyEquals(actualPay, expectPay, url);
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("checkOutStepTi"), 5);
    }

}
