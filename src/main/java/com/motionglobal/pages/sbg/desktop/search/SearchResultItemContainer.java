package com.motionglobal.pages.sbg.desktop.search;

import org.openqa.selenium.WebElement;

import com.motionglobal.pages.AbstractBaseContainer;

public class SearchResultItemContainer extends AbstractBaseContainer {

    private WebElement container;

    private SearchResultItemContainer() {
        // hide default constructor to avoid null initialization
        super();
    }

    public SearchResultItemContainer(WebElement container) {
        super();
        this.container = container;
    }

    public void click() {

    }
}
