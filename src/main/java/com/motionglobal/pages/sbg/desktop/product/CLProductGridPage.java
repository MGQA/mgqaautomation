package com.motionglobal.pages.sbg.desktop.product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CLProductGridPage extends AbstractBaseSbgDesktopPage {
    // CL clickedName contains Label
    @FindBy(xpath = "//*[@id='CL_Breadcrumb']")
    public WebElement submenuCLLeftClickedLabel;

    public String regexPage(String pagetext) {
        Pattern pattern = Pattern.compile("/ ");
        Matcher matcher = pattern.matcher(pagetext);
        return matcher.replaceAll("");
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("CL-ProductCount"), 20);
    }

}
