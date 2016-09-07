package com.motionglobal.pages.sbg.desktop.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.common.utils.VerifyUtil;
import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.MobHeader;

public class NewCheckoutPage extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "checkout-payment-btn")
    public WebElement btnPayment;
    @FindBy(css = ".payment_method.payment_method_li")
    public List<WebElement> payPicture;
    //
    @FindBy(id = "billing_country")
    public WebElement selectCountry;
    @FindBy(id = "billing_state")
    public WebElement state;

    public void AssertPayPicture(int... pay) {
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
            actualPay += header.regexGeInt(payPicture.get(i).getAttribute("value"));
        }
        verify.verifyEquals(actualPay, expectPay);
    }

    public void selectCountry(String value) {
        Select select = new Select(selectCountry);
        select.selectByValue(value);
    }

    public void selectState(String value) {
        for (int i = 0; i < 20; i++) {
            try {
                if (state.getTagName().equals("select")) {
                    Thread.sleep(500);
                    Select select = new Select(state);
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

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("fixedTab"), 30);
    }

}
