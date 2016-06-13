package com.motionglobal.pages.sbg.om;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.AbstractBasePage;

public class OmHeader extends AbstractBasePage {

    public WebElement getHeader(int menuNum) {
        return driver.findElement(By.xpath("//div[@id='header']/div[4]/ul/li[" + menuNum + "]/a"));
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector("[alt='MotionGlobal']"), 20);
    }
}
