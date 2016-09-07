package com.motionglobal.pages.sbg.desktop.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class VirtualPage extends AbstractBaseSbgDesktopPage {
    // Assert - id = virtual
    @FindBy(id = "virtual-try-on-switch")
    public WebElement VirtualClickPage;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("take_photo_btn2"), 5);
    }

}
