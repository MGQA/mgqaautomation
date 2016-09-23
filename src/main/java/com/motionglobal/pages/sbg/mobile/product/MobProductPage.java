package com.motionglobal.pages.sbg.mobile.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobProductPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".main__title")
    public WebElement productTitle;
    @FindBy(className = "main__glass-list__item")
    public List<WebElement> productList;
    @FindBy(className = "main__glass-list__item__detail__name")
    public List<WebElement> brankName;
    @FindBy(className = "main__glass-list__item__detail__other")
    private List<WebElement> productName;
    @FindBy(className = "main__glass-list__item__detail__price")
    public List<WebElement> productPrice;
    @FindBy(className = "main__glass-list__item__tag--cheep")
    public List<WebElement> dealsIcon;

    // product number
    @FindBy(id = "see_more")
    public WebElement btnLoadMore;
    @FindBy(css = ".product-item.main__glass-list__item")
    public List<WebElement> product;

    // filter
    @FindBy(css = ".main__btn-group__btnl")
    public WebElement filter;
    @FindBy(css = ".main__btn-group__btnr")
    public WebElement Sort;
    @FindBy(css = ".main__btn-group__con.open .menu_level_first")
    public List<WebElement> subFilter;
    @FindBy(css = ".main__type__li__open li")
    public List<WebElement> finalFilter;

    public MobProductPage productList(int index) {
        this.productList.get(index);
        return this;
    }

    public String getProductName(int index) {
        String name = productName.get(index).getText();
        return name;
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".main__title"), 5);
    }

}
