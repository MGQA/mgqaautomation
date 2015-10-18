package com.motionglobal.common.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IWaiter {
    public void dummyWait(int seconds);

    public void waitForVisibility(By by, int seconds);

    public void waitForVisibility(WebElement element, int seconds);
}