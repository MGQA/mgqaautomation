package com.motionglobal.pages.sbg.desktop.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.AbstractBaseContainer;

public class SearchResultItem extends AbstractBaseContainer {

    private WebElement container;

    @SuppressWarnings("unused")
    private SearchResultItem() {
        // hide default constructor to avoid null initialization
        super();
    }

    public SearchResultItem(WebElement container) {
        super();
        this.container = container;
    }

    public void click() {
        this.container.findElement(By.cssSelector(".rpl_proname")).click();
    }

    public String getName() {
        return this.container.findElement(By.cssSelector(".rplp_name")).getText();
    }

    public String getPrice() {
        return this.container.findElement(By.cssSelector(".rpl_only")).getText();
    }

    public String getBrand() {
        return this.container.findElement(By.cssSelector(".rplp_brand")).getText();
    }
}
