package com.motionglobal.pages.sbg.mobile.explore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobFaceShpePage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".header_fixed")
    public WebElement headerBlock;
    //
    @FindBy(css = ".panel.panel-default a[class^='ie8_tab']")
    public List<WebElement> shapeList;
    @FindBy(css = ".collapse.in a>img")
    public WebElement shapeBtn;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".visible-xs.carousel-image"), 5);
    }

}
