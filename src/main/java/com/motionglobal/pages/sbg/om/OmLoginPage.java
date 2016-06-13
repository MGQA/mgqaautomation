package com.motionglobal.pages.sbg.om;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.AbstractBasePage;

public class OmLoginPage extends AbstractBasePage {
    @FindBy(id = "username")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement passWord;
    @FindBy(id = "sub")
    public WebElement submit;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("uname"), 20);
    }

}
