package com.motionglobal.pages.sbg.mobile.footer;

import org.openqa.selenium.By;

import com.motionglobal.pages.AbstractBasePage;

public class MobAboutUsPage extends AbstractBasePage {

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("wysiwyg-1"), 5);
    }
}
