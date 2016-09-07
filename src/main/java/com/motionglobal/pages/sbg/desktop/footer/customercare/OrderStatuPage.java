package com.motionglobal.pages.sbg.desktop.footer.customercare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class OrderStatuPage extends AbstractBaseSbgDesktopPage {

    //
    @FindBy(css = "#order_h1>h1")
    public WebElement orderID;
    @FindBy(className = "td_title")
    public WebElement orderTitle;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(orderTitle, 5);
    }

}
