package com.motionglobal.pages.sbg.desktop.product;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class VirtualPage extends AbstractBaseSbgDesktopPage {
    public void assertVirtualPage() {
        Assert.assertTrue((driver.findElement(By.id("virtual-try-on-switch")).getAttribute("id")).contains("virtual"));
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("take_photo_btn2"), 20);
    }

}
