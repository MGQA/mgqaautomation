package com.motionglobal.pages.sbg.mobile.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobSearchResultPage extends AbstractBaseSbgDesktopPage {
    @FindBy(className = "detail_view")
    public List<WebElement> productList;
    @FindBy(className = "main__glass-list__item__detail__name")
    public List<WebElement> productName;
    @FindBy(xpath = "//div[contains(@class,'detail__other')][1]")
    public WebElement productDetailName;
    @FindBy(className = "main__btn-group__btnl")
    public WebElement filter;
    @FindBy(xpath = "//*[@id='filter_main__btn-group']/div/ul/li[3]//span")
    public WebElement branksBtn;
    @FindBy(css = ".selected a[onclick*='rnette']")
    public WebElement Arnette;

    // category
    @FindBy(css = ".search_category_container.clearfix>li>a")
    public List<WebElement> category;
    @FindBy(className = "current")
    public WebElement categoryChecked;
    @FindBy(css = ".main__glass-list__item[href*='sunglass']")
    public List<WebElement> sunGlass;
    @FindBy(css = ".main__glass-list__item[href*='eyeglass']")
    public List<WebElement> eyeGlass;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".main__btn-group__btn.main__btn-group__btnl"), 5);
    }

}
