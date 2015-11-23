package com.motionglobal.pages.sbg.desktop.payment3rdparty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class GcPaymentPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".ORB_INPUT")
    public WebElement inputORB;

    public GcPaymentPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".ORB_INPUT"), 20);
    }

}
