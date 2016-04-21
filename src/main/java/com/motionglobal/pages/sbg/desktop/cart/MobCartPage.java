package com.motionglobal.pages.sbg.desktop.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobCartPage extends AbstractBaseSbgDesktopPage {
    @FindBy(className = "cartIcon")
    public WebElement cartIsEmpty;
    @FindBy(className = "shopping__cart__checkout")
    public WebElement fastCheckOut;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("shopping__cart__continue"), 30);
    }

}
