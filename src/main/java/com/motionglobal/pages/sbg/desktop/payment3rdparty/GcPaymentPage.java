package com.motionglobal.pages.sbg.desktop.payment3rdparty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class GcPaymentPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".ORB_INPUT")
    public WebElement inputORB;
    @FindBy(id = "F1009")
    public WebElement inputCard;
    @FindBy(id = "F1136")
    public WebElement inputInsuanceCard;
    @FindBy(id = "btnSubmit")
    public WebElement btnContinue;
    @FindBy(id = "F1010_MM")
    private WebElement month;
    @FindBy(id = "F1010_YY")
    private WebElement day;

    public void selectDate() {
        waitForVisibility(month, 2);
        Select select = new Select(month);
        select.selectByValue("01");
        Select select2 = new Select(day);
        select2.selectByValue("20");

    }

    public GcPaymentPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".ORB_INPUT"), 20);
    }

}
