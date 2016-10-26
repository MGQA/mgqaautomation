package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductDetailPage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//a[contains(@class,'buy')][not(contains(@style,'none'))]")
    public WebElement btnBuyNow; // There are two buy now buttons, one is hidden by lens selection condition.
    @FindBy(css = ".pro_lawith.formSubmitRx")
    public WebElement btnSunRX;
    @FindBy(id = "withLenses")
    public WebElement btnAddLenses;
    @FindBy(css = ".pro_r_buynow div:nth-of-type(2) label")
    public WebElement btnFrameOnly;
    @FindBy(id = "frameOnly")
    public WebElement radioFrameOnly;
    @FindBy(id = "discount_price_promotion_display")
    public WebElement price;
    @FindBy(xpath = "//a[@class='pro_big_title']/h1")
    public WebElement glassName;
    @FindBy(css = ".pro_big_title>h1")
    public WebElement productName;

    //
    @FindBy(css = ".pro_rightSizeIcon_click")
    public List<WebElement> productSizeS;
    @FindBy(css = ".pro_buynow_radio")
    public List<WebElement> radio;
    @FindBy(css = ".pro_leftIcon_click")
    public List<WebElement> productIcon;
    @FindBy(css = ".pro_leftIcon_display:not([style*='none'])")
    public WebElement displayIcon;
    //
    @FindBy(css = ".similar_content_element>a")
    public WebElement similarProduct; // list
    @FindBy(css = ".pro_rec_li.similar_content_element>a")
    public WebElement recommendProduct; // list

    //

    /**
     * click size and wait ajax finish
     * 
     * @param index
     */
    public void clickSizeNum(int index) {
        new Actions(driver).moveToElement(productSizeS.get(index)).build().perform();
        productSizeS.get(index).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeToBe(productSizeS.get(index), "class", "pro_rightSizeIcon_click size_s_bor"));
        waitForVisibility(By.cssSelector(".proPop.addBlock"), 5);
    }

    /**
     * click frame or lense radio , wait radio checked
     * 
     * @param index
     */
    public void clickFrameRadio(int index) {
        radio.get(index).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.attributeToBe(radio.get(index), "class", "pro_buynow_radio on"));
    }

    /**
     * click multi angle icon , and wait clicked
     * 
     * @param index
     */
    public void clickIcon(int index) {
        productIcon.get(index).click();
        System.out.println(productIcon.get(index).getAttribute("class"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeContains(productIcon.get(index), "class", "view_bold_border"));
    }

    // Ë¥ÍË BUG
    @FindBy(xpath = "//a[contains(@class,'buy')][not(contains(@style,'none'))]")
    public List<WebElement> BUG2BuyNow;

    public ProductDetailPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        // waitForVisibility(By.className("navigation"), 5);
        waitForVisibility(By.id("big_image"), 5);

    }
}
