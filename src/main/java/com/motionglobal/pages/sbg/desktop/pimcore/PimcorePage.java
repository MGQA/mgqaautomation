package com.motionglobal.pages.sbg.desktop.pimcore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class PimcorePage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".col-sm-12>h1")
    public WebElement textTitle;
    @FindBy(css = "hgroup>h1")
    public WebElement textMGTitle;
    @FindBy(css = ".search-results>li>a")
    public List<WebElement> linkSearchAppendMenu;
    @FindBy(className = "cat-article")
    public List<WebElement> linkSearchResult;
    @FindBy(css = ".ask-now.hidden-xs")
    public WebElement linkOptician;
    @FindBy(className = "content")
    public List<WebElement> divOpticianContent;
    // @FindBy(xpath = "//div[@class='row']/div[1]/article/a")
    // public List<WebElement> divPimcoreHomeContentNo1;
    @FindBy(xpath = "//section[1]/div[2]/div/div[1]/article/a")
    public WebElement divPimcoreHomeContentNo1;
    @FindBy(css = ".article-header>img")
    public WebElement imgContentDETAIL;

    // assert
    @FindBy(css = ".active>a")
    public WebElement linkAppendMenuClicked;
    @FindBy(css = ".top_sun_glass_brand_list")
    public List<WebElement> linkMenuBrandIMG;
    @FindBy(xpath = "//*[@id='sub_Sunglasses_A_list']/ul[1]/li[1]/a")
    public WebElement linkMenuBrandASection;

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
    @FindBy(css = ".sidebar-search>input")
    public WebElement inputSearch;
    @FindBy(css = "button#search")
    public WebElement buttonSearch;

    // most popular post
    @FindBy(css = ".hidden-xs>ul>li>a")
    public List<WebElement> MostPopluarPostS;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("oc"), 5);
    }
}
