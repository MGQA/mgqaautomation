package com.motionglobal.pages.sbg.desktop.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class NewCartPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".quantity-wrapper>select")
    public List<WebElement> selectQuantity;
    @FindBy(css = ".top-checkout-btn.pay_now.gc-checkout-class.gointerpay_submit")
    public WebElement btnCheckout;

    // assert
    @FindBy(className = "empty-cart-content")
    public WebElement newCartEmptyIcon;
    @FindBy(className = "price-wrapper")
    public List<WebElement> priceOnlyFrame; // price no't RX
    @FindBy(className = "price-cost")
    public List<WebElement> priceRx;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("main-wrapper"), 5);
    }

}
