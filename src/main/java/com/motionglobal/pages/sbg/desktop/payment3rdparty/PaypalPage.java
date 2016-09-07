package com.motionglobal.pages.sbg.desktop.payment3rdparty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class PaypalPage extends AbstractBaseSbgDesktopPage {

    // assert page don't blank
    @FindBy(id = "stdpage")
    public WebElement paypalContentDisplay;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("xptSandbox"), 5);
    }
}
