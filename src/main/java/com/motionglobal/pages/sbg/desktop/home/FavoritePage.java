package com.motionglobal.pages.sbg.desktop.home;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class FavoritePage extends AbstractBaseSbgDesktopPage {

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.xpath("//span[text()=' / Favorite Products']"), 5);
    }

}
