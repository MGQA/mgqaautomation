package com.motionglobal.pages.sbg.desktop.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HomePage extends AbstractBaseSbgDesktopPage {
    @FindBy(xpath = "//ul[@class='pro_slider_ul']/li[6]//img")
    public WebElement TopSell2;

    public WebElement getFeaturedDesignerDealsElement(int Num) {
        return driver.findElement(By.xpath("//div[@class='pro_slider_eyeglasses']/div/ul/li[" + Num + "]/a"));
    }

    public WebElement getFeaturedImgElement(int Num) {
        return driver.findElement(By.xpath("//div[@class='featured_deals']/div[" + Num + "]//img"));
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("slideshow"), 40);
    }
}
