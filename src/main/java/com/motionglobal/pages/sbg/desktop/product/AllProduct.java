package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class AllProduct extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "heih")
    public List<WebElement> linkBrand;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("L_A"), 30);
    }

}
