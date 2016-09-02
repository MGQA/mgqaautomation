package com.motionglobal.pages.sbg.mobile.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobProductAllCLPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".newslist__logos>li>a>img")
    public List<WebElement> productImg;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("all__brands__title"), 20);
    }

}
