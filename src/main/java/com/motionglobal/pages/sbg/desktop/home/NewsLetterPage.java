package com.motionglobal.pages.sbg.desktop.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class NewsLetterPage extends AbstractBaseSbgDesktopPage {

    @FindBy(name = "firstName")
    public WebElement firstName;
    @FindBy(name = "lastName")
    public WebElement lastName;
    @FindBy(name = "newsletterEmail")
    public WebElement newsletterEmail;
    @FindBy(className = "male")
    public WebElement male;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".newsletter_landing"), 5);
    }

}
