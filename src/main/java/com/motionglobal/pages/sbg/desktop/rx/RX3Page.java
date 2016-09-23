package com.motionglobal.pages.sbg.desktop.rx;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class RX3Page extends AbstractBaseSbgDesktopPage {

    // Opticians
    @FindBy(id = "discount_price_promotion_display")
    public WebElement framePrice;
    @FindBy(className = "frame_price")
    public WebElement frame_price;
    @FindBy(xpath = "//li[@class='recommended cur']/a/p[2]")
    public WebElement deluxeVeryPriece;
    @FindBy(className = "lenses_price")
    public WebElement lenses_price;
    @FindBy(className = "total_price")
    public WebElement total_price;
    @FindBy(xpath = "//li[@data-index='deluxe']")
    public WebElement deluxe;
    @FindBy(xpath = "//li[@data-value='8']/a")
    public WebElement deluxeVery;

    @FindBy(className = "cart_btn")
    public WebElement addToCart;

    @Override
    protected void waitPageLoad() {
    }
}