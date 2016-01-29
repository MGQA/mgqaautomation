package com.motionglobal.pages.sbg.desktop.footer.customercare;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class FaqPage extends AbstractBaseSbgDesktopPage {

    public FaqPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.name("txt_faq_search"), 20);
    }

}
