package com.motionglobal.pages.sbg.desktop.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HomePage extends AbstractBaseSbgDesktopPage {

    public WebElement getFeaturedDesignerDealsElement(int Num) {
        return driver.findElement(By.xpath("//div[@class='pro_slider_eyeglasses']/div/ul/li[" + Num + "]/a"));
    }

    public WebElement getTopSellElement(int Num) {
        return driver.findElement(By.xpath("//div[@class='pro_slider_eyeglasses']/div/ul/li[" + Num + "]/a"));
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("slideshow"), 40);
    }
}
