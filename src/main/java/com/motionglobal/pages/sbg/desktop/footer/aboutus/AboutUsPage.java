package com.motionglobal.pages.sbg.desktop.footer.aboutus;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class AboutUsPage extends AbstractBaseSbgDesktopPage {

    public AboutUsPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".about_us"), 20);
    }

}
