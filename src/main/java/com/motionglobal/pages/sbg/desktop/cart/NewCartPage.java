package com.motionglobal.pages.sbg.desktop.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class NewCartPage extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "empty-cart-content")
    public WebElement newCartEmptyIcon;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".empty-cart-content"), 30);
    }

}
