package com.motionglobal.pages.sbg.desktop.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class NewCartPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".quantity-wrapper>select")
    public List<WebElement> selectQuantity;
    @FindBy(css = ".pay_now.gc-checkout-class")
    public WebElement btnCheckout;

    // assert
    @FindBy(className = "empty-cart-content")
    public WebElement newCartEmptyIcon;
    @FindBy(className = "price-wrapper")
    public List<WebElement> priceS;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("main-wrapper"), 15);
    }

}
