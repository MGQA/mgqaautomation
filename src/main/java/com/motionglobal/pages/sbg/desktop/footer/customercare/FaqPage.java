package com.motionglobal.pages.sbg.desktop.footer.customercare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class FaqPage extends AbstractBaseSbgDesktopPage {

    @FindBy(name = "orderId")
    public WebElement inputOrder;
    @FindBy(css = "[onclick='checkOrder();']")
    public WebElement btnTracking;

    public FaqPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.name("txt_faq_search"), 5);
    }

}
