package com.motionglobal.pages.sbg.desktop.explore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CelebrityPage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//*[@id='wrapper']//li[5]/a[1]/p[1]/img")
    public WebElement swift;
    @FindBy(xpath = "//*[@id='wrapper']//li[5]/a[2]/p/img")
    public WebElement swiftGlass;
    @FindBy(xpath = "//*[@id='wrapper']/div/div[1]/div[2]/div/a")
    public WebElement buyNowBtn;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".celebrity-title"), 5);
    }

}
