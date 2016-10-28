package com.motionglobal.pages.sbg.desktop.rx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class RX3Page extends AbstractBaseSbgDesktopPage {

    // Price
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
    @FindBy(css = ".price.lens_color_price")
    public WebElement color_price;

    // Opticians
    @FindBy(xpath = "//li[@data-index='deluxe']")
    public WebElement deluxe;
    @FindBy(xpath = "//li[@data-value='8']/a")
    public WebElement deluxeVery;

    @FindBy(css = ".step-title-bold")
    public List<WebElement> rxList;
    @FindBy(css = "ul[style*=block] li[data-name]")
    public List<WebElement> subList;

    //
    @FindBy(className = "cart_btn")
    public WebElement addToCart;
    @FindBy(css = ".buy-frame.pro_labuy.without-Prescription")
    public WebElement buyOnlyFrame;

    @Override
    protected void waitPageLoad() {
        try {
            for (int i = 0; i < 33; i++) {
                driver.findElement(By.className("xubox_shade"));
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
        }
    }
}
