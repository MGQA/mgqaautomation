package com.motionglobal.pages.sbg.desktop.search;

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
    @FindBy(className = "main__glass-list__item__detail__other")
    public WebElement productDetailName;
    @FindBy(className = "main__btn-group__btnl")
    public WebElement filter;
    @FindBy(xpath = "//*[@id='filter_main__btn-group']/div/ul/li[3]//span")
    public WebElement branksBtn;
    @FindBy(xpath = "main__glass-list__item__detail__name")
    public WebElement Bebe;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("s-keywords"), 30);
    }

}
