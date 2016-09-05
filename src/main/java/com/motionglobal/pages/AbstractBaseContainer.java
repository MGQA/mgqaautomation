package com.motionglobal.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.motionglobal.common.webdriver.IWaiter;
import com.motionglobal.testcases.AbstractBaseTestCase;

public abstract class AbstractBaseContainer implements IWaiter {

    // Handles to WebDriver that each page object will inherit
    protected WebDriver driver;
    protected static Logger logger;

    // Constructor for each page object
    public AbstractBaseContainer() {
        this.driver = AbstractBaseTestCase.getDriver();
        this.logger = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    @Override
    public void waitForVisibility(WebElement element, int seconds) throws Error {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForVisibility(By by, int seconds) throws Error {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Override
    public void waitForVisibility(List<WebElement> element, int seconds) throws Error {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    /**
     * This function is used to check whether a specific text is displayed on the page.
     * 
     * @param text
     * @return
     */
    public boolean isTextPresent(String text) {
        return driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]")).size() > 0;
    }

    public boolean isEmpty(List<WebElement> eles) {
        return eles == null || eles.size() == 0;
    }

    @Override
    public void dummyWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AbstractBaseContainer clearInput(WebElement input, String str) {
        input.clear();
        input.sendKeys(str);
        return this;
    }

    public void acceptAlert() {
        // try {
        // driver.switchTo().alert().accept();
        // }
        // catch (Exception e) {
        // // Do nothing if there is no alert.
        // }
        boolean flag = false;
        Alert alert = null;
        try {
            new WebDriverWait(driver, 2).until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();
            flag = true;
            // alert.accept();
        }
        catch (Exception ex) {
        }
        if (flag) {
            alert.accept();
        }
    }
}
