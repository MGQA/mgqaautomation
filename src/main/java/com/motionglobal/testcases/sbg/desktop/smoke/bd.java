package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class bd extends AbstractBaseSbgDesktopPage {
    @FindBy(className = "keyword")
    public WebElement ss;
    @FindBy(css = "i.fa.fa-search")
    public WebElement bm;

    private WebDriver driver;

    public bd(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("keyword"), 20);
    }

}
