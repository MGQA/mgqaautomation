package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductStyleFinderPage extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "recProInfo")
    public List<WebElement> proInfo;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".top_search_options"), 15);
    }
}
