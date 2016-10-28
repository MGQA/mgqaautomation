package com.motionglobal.pages.sbg.mobile.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobThankYouPage extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "main__order__youroreder")
    public WebElement thankYouOrder;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(thankYouOrder, 30);
    }

}
