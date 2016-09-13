package com.motionglobal.pages.sbg.mobile.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobCartPage extends AbstractBaseSbgDesktopPage {

    @FindBy(className = "shopping__cart__checkout")
    public WebElement fastCheckOut;
    @FindBy(className = "subtotal")
    public WebElement priceTotal;

    // XXX empty cart element
    @FindBy(className = "cartIcon")
    public WebElement cartIsEmpty;
    @FindBy(className = "em_sunglasses_btn")
    public WebElement btnSun;
    @FindBy(className = "em_glasses_btn")
    public WebElement btnEye;
    @FindBy(className = "em_contacts_btn")
    public WebElement btnCL;
    @FindBy(className = "shopping__cart__continue")
    public WebElement btnShop;

    // XXX product element
    @FindBy(className = "shopping__cart__product")
    public List<WebElement> product;
    @FindBy(css = ".shopping__cart__product__close.cartProRemove")
    public List<WebElement> productRemove;
    @FindBy(css = ".shopping__cart__product__left__price")
    public List<WebElement> priceProduct;

    // XXX prescription
    @FindBy(className = "shopping__cart__product__right__view")
    public WebElement btnViewPre;
    @FindBy(css = ".open>p>a.edit__prescription")
    public WebElement btnEditPre;
    @FindBy(className = "shopping__cart__product__right__add")
    public WebElement addPre;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("shopping__cart__continue"), 5);
    }

}
