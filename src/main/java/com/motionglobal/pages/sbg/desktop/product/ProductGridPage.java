package com.motionglobal.pages.sbg.desktop.product;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductGridPage extends AbstractBaseSbgDesktopPage {

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("jp-pagination-ajax"), 10);
    }
}
