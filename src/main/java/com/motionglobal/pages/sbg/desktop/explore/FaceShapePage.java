package com.motionglobal.pages.sbg.desktop.explore;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class FaceShapePage extends AbstractBaseSbgDesktopPage {

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".item>.hidden-xs.carousel-image"), 30);
    }
}
