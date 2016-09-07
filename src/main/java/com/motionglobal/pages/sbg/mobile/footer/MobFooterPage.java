package com.motionglobal.pages.sbg.mobile.footer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.AbstractBasePage;

public class MobFooterPage extends AbstractBasePage {

    @FindBy(css = ".about_us-title")
    public WebElement title;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(title, 5);
    }

}
