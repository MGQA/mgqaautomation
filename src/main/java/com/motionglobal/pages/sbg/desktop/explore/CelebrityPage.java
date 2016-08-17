package com.motionglobal.pages.sbg.desktop.explore;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CelebrityPage extends AbstractBaseSbgDesktopPage {

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".celebrity-title"), 30);
    }

}
