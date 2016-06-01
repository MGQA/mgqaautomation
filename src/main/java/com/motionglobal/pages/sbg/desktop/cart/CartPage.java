package com.motionglobal.pages.sbg.desktop.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CartPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".paySecurexDo")
    public WebElement btnCheckout;
    @FindBy(className = "cartEmptyIcon")
    public WebElement cartEmptyIcon;
    @FindBy(xpath = "//div[@class='left']/input")
    public List<WebElement> productNum;
    @FindBy(className = "refresh")
    public List<WebElement> productRefresh;
    @FindBy(className = "td_title")
    public List<WebElement> productName;
    @FindBy(id = "rmv")
    public List<WebElement> productRemove;

    public CartPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".cart_detail"), 20);
    }

}
