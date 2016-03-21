package com.motionglobal.pages.sbg.desktop.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HomePage extends AbstractBaseSbgDesktopPage {

    public WebElement getFeaturedDesignerDealsElement(int index) {
        return driver.findElement(By.xpath("//div[@class='pro_slider_eyeglasses']/div/ul/li[" + index + "]/a"));
    }

    public WebElement getTopSellElement(int index) {
        return driver.findElement(By.xpath("//div[@class='pro_slider_eyeglasses']/div/ul/li[" + index + "]/a"));
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("slideshow"), 40);
    }
}
