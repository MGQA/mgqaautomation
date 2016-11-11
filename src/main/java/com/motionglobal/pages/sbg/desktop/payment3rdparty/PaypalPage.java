package com.motionglobal.pages.sbg.desktop.payment3rdparty;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class PaypalPage extends AbstractBaseSbgDesktopPage {

    // assert page don't blank
    @FindBy(id = "singlePagePayment")
    public WebElement paypalContentDisplay;

    @FindAll({ @FindBy(css = "#stdpage"), @FindBy(css = "xo-header") })
    public WebElement page;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(page, 5);
    }
}
