package com.motionglobal.pages.sbg.mobile.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobRX3Page extends AbstractBaseSbgDesktopPage {

    // RX3
    @FindBy(css = "[data-index='deluxe']")
    public WebElement deluxe;
    @FindBy(css = ".RX_mask-block.RX_mask-small")
    public WebElement optionDisplay;
    @FindBy(css = ".clearfix[data-index='color']")
    public WebElement color;
    @FindBy(css = ".clearfix[data-index='prescription']")
    public WebElement prescription;
    @FindBy(css = ".RX_phase-btn.confirm")
    public WebElement btnContinue;
    @FindBy(id = "only_frame_price")
    public WebElement buyFrame;

    // distance
    @FindBy(css = ".clearfix[data-index='type']")
    public WebElement distance;
    // lens
    @FindBy(css = ".clearfix[data-index='lens']")
    public WebElement btnLens;
    @FindBy(css = "[data-name='deluxe']>.clearfix")
    public List<WebElement> lenOption;
    @FindBy(css = ".deluxe-list .available-price")
    public List<WebElement> lenPrice;

    public Boolean optionChecked(WebElement element) {
        Boolean boo = true;
        boo = element.getAttribute("class").contains("cur");
        return boo;
    }

    // price
    @FindBy(id = "frames_price")
    public WebElement priceFrame;
    @FindBy(id = "total_lens_price")
    public WebElement priceLens;
    @FindBy(id = "total")
    public WebElement priceTotal;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("RX-phase"), 5);
    }

}
