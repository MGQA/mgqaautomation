package com.motionglobal.pages.sbg.mobile.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobProductDetailPage extends AbstractBaseSbgDesktopPage {
    // private Element
    @FindBy(className = "pro_selling_price")
    private WebElement price;
    @FindBy(className = "buy_lens_btn")
    public WebElement addLens;
    @FindBy(className = "buy_now_btn")
    public WebElement buyNow;
    @FindBy(xpath = "//h1[@itemprop='name']")
    public WebElement productName;
    @FindBy(xpath = "//div[@class='main__product__view__size']/i[1]")
    public WebElement productSizeOne;
    @FindBy(xpath = "//div[@class='main__product__view__size']/i[2]")
    public WebElement productSizeTwo;

    public String getPrice() {
        return price.getText().replace("$", "").replace(".", "");
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(productName, 30);
    }

}
