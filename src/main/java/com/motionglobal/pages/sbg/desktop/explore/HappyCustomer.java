package com.motionglobal.pages.sbg.desktop.explore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HappyCustomer extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//section/a[2]/section/div")
    public WebElement customer2;
    @FindBy(className = "articlelink")
    public List<WebElement> customerAll;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".hidden-xs.carousel-image"), 30);
    }

}
