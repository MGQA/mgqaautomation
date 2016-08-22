package com.motionglobal.pages.sbg.desktop.footer.customercare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class OrderTracking extends AbstractBaseSbgDesktopPage {

    @FindBy(name = "orderId_orderpage")
    public WebElement inputOrder;
    @FindBy(name = "email")
    public WebElement inputEmail;
    @FindBy(css = "[onclick='orderTrackingSubmit()']")
    public WebElement btnOrderTracking;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".track_order_status"), 30);
    }

}
