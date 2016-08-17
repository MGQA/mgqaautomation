package com.motionglobal.pages.sbg.mobile.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobNewOpticianPage extends AbstractBaseSbgDesktopPage {

    // RX3
    @FindBy(css = ".clearfix[data-index='type']")
    public WebElement distance;
    @FindBy(css = ".clearfix[data-index='color']")
    public WebElement color;
    @FindBy(css = ".clearfix[data-index='prescription']")
    public WebElement prescription;
    @FindBy(css = ".clearfix[data-index='lens']")
    public WebElement lens;
    @FindBy(css = ".RX_phase-btn.confirm")
    public WebElement continueBtn;
    @FindBy(className = "RX_return-link")
    public WebElement buyFrame;

    // price
    @FindBy(id = "frames_price")
    public WebElement priceFrame;
    @FindBy(id = "total_lens_price")
    public WebElement priceLens;
    @FindBy(id = "total")
    public WebElement priceTotal;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("RX-phase"), 30);
    }

}
