package com.motionglobal.pages.sbg.desktop.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CN_CartPage extends AbstractBaseSbgDesktopPage {
    @FindBy(css = ".paySecurexDo")
    public WebElement btnCheckout;
    @FindBy(className = "cartEmptyIcon")
    public WebElement cartEmptyIcon;

    public CN_CartPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".title.clearfix li"), 20);
    }

}
