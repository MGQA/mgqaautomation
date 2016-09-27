package com.motionglobal.pages.sbg.mobile.product;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobProductAllPage extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "all__brands__title")
    public WebElement productTitle;

    // CL
    @FindBy(css = ".newslist__logos>li>a>img")
    public List<WebElement> productImg;

    // Sport
    @FindBy(css = ".clearfix>a")
    public List<WebElement> sectionSport;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(productTitle, 5);
    }

}
