package com.motionglobal.pages.sbg.desktop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.AbstractBaseContainer;

public class Header extends AbstractBaseContainer {

    @FindBy(id = "logo")
    public WebElement logo;
    @FindBy(id = "search_input")
    public WebElement inputSearch;
    @FindBy(css = ".search_image i.fa-search")
    public WebElement iconSearch;
}
