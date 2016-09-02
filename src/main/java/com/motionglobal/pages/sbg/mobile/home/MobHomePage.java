package com.motionglobal.pages.sbg.mobile.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobHomePage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//div[@class='main__type']/ul/li[1]/div/div[1]")
    public WebElement indexMenuSun;
    @FindBy(xpath = "//div[@class='main__type']/ul/li[2]/div/div[1]")
    public WebElement indexMenuEye;
    @FindBy(xpath = "//div[@class='main__type']/ul/li[3]/div/div[1]")
    public WebElement indexMenuCL;
    @FindBy(css = ".main__type__li__open li")
    public List<WebElement> indexSubMenu;

    //
    @FindBy(css = "[data-id='main_topbrands_2'] img")
    public WebElement topBrank2Img;
    @FindBy(css = ".item__menu__open li:nth-of-type(1)")
    public WebElement topBrank2Sun;
    @FindBy(css = ".item__menu__open li:nth-of-type(2)")
    public WebElement topBrank2Eye;

    public enum Sell {
        SUNIMG, SUNPRICE, SUNBRANK, EYEIMG, EYEPRICE, EYEBRANK;
    }

    public WebElement getTopSell(Sell sell) {
        WebElement element = null;
        switch (sell) {
        case SUNIMG:
            element = driver.findElement(By.cssSelector("#slider_img1 .swiper-slide-active"));
            break;
        case SUNPRICE:
            element = driver.findElement(By.cssSelector("#slider_img1 .swiper-slide-active [class$='price']"));
            break;
        case SUNBRANK:
            element = driver.findElement(By.cssSelector("#slider_img1 .swiper-slide-active [class$='name']"));
            break;
        case EYEIMG:
            element = driver.findElement(By.cssSelector("#slider_img2 .swiper-slide-active"));
            break;
        case EYEPRICE:
            element = driver.findElement(By.cssSelector("#slider_img2 .swiper-slide-active [class$='price']"));
            break;
        case EYEBRANK:
            element = driver.findElement(By.cssSelector("#slider_img2 .swiper-slide-active [class$='name']"));
            break;
        default:
            break;
        }
        return element;
    }

    @Override
    protected void waitPageLoad() {
    }

}
