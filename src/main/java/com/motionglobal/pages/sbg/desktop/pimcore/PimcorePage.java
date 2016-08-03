package com.motionglobal.pages.sbg.desktop.pimcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class PimcorePage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".col-sm-12>h1")
    public WebElement textTitle;
    @FindBy(css = "hgroup>h1")
    public WebElement textMGTitle;

    // menu
    @FindBy(xpath = "//ul[@id='sidebar-menu']/li[1]/a")
    public WebElement linkMenuEye;
    @FindBy(xpath = "//ul[@id='sidebar-menu']/li[2]/a")
    public WebElement linkMenuSun;
    @FindBy(xpath = "//ul[@id='sidebar-menu']/li[3]/a")
    public WebElement linkMenuCL;
    @FindBy(xpath = "//ul[@id='sidebar-menu']/li[4]/a")
    public WebElement linkMenuEH;
    @FindBy(xpath = "//ul[@id='sidebar-menu']/li[7]/a")
    public WebElement linkMenuMG;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("oc"), 30);
    }
}
