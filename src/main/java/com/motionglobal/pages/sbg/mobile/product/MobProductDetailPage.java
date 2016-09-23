package com.motionglobal.pages.sbg.mobile.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobProductDetailPage extends AbstractBaseSbgDesktopPage {
    // private Element
    @FindBy(className = "pro_selling_price")
    public WebElement price;
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
    @FindBy(css = ".swiper-slide.swiper-slide-active>a>img")
    public WebElement similarProduct;
    @FindBy(css = ".swiper-slide>img")
    public List<WebElement> mainImg;

    // XXX CL
    @FindBy(css = "#prescription_tag[style='display: none;']+a>div")
    public WebElement buyCL;
    @FindBy(id = "your_price_val")
    public WebElement priceUnit;
    @FindBy(id = "total")
    public WebElement priceTotal;

    public enum Prescription {
        RIGHTQTY, RIGHTPOWER, RIGHTBC, LEFTQTY, LEFTPOWER, LEFTBC;
    }

    public void selectPreValue(Prescription pre, String value) {
        WebElement element;
        switch (pre) {
        case RIGHTQTY:
            element = driver.findElement(By.id("R_qty"));
            super.selectValue(element, value);
            break;
        case RIGHTPOWER:
            element = driver.findElement(By.id("R_power"));
            super.selectValue(element, value);
            break;
        case RIGHTBC:
            element = driver.findElement(By.id("R_curve"));
            super.selectValue(element, value);
            break;
        case LEFTQTY:
            element = driver.findElement(By.id("L_qty"));
            super.selectValue(element, value);
            break;
        case LEFTPOWER:
            element = driver.findElement(By.id("L_power"));
            super.selectValue(element, value);
            break;
        case LEFTBC:
            element = driver.findElement(By.id("L_curve"));
            super.selectValue(element, value);
            break;
        default:
            AsssetTrue(false, " Enum Pre is Empty,");
            break;
        }
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(productName, 5);
    }

}
