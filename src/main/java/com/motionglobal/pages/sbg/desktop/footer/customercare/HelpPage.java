package com.motionglobal.pages.sbg.desktop.footer.customercare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HelpPage extends AbstractBaseSbgDesktopPage {

    @FindBy(name = "orderId")
    public WebElement inputOrder;
    @FindBy(className = "in_search")
    public WebElement btnTracking;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".inside_contact.contact_span_1"), 20);
    }

}
