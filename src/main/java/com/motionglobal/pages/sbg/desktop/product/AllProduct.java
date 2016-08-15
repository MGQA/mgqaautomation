package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class AllProduct extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "heih")
    public List<WebElement> linkBrand;

    // brand
    @FindBy(xpath = "//span/a[contains(text(),'Ray-Ban Sunglasses')]")
    public WebElement brandSunRanban;
    @FindBy(xpath = "//span/a[contains(text(),'Ray-Ban Glasses')]")
    public WebElement brandEyeRanban;
    @FindBy(xpath = "//*[@id='all_brands']/li[1]/a/img")
    public WebElement imgRanban;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("L_A"), 30);
    }

}
