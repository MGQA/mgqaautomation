package com.motionglobal.pages.sbg.desktop.thankyou;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ThankYouPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".rew_t_word span")
    public WebElement reWard;
    @FindBy(css = "h2>br+span")
    public WebElement order;

    //
    @FindBy(id = "thank_you_page")
    private WebElement thankYou;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(thankYou, 25);
    }
}
