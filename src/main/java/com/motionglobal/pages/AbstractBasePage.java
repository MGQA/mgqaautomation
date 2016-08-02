package com.motionglobal.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.motionglobal.pages.sbg.desktop.Header;

public abstract class AbstractBasePage extends AbstractBaseContainer {

    private final String parentWindowHandle;

    // Constructor for each page object
    public AbstractBasePage() {
        super();
        this.parentWindowHandle = driver.getWindowHandle();
        waitPageLoad();
    }

    public void mouseOver(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void actionKey(Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    public void JsMouse(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void JsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void JsDisplayNone(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='none';", element);
    }

    public void JsDisplayBlock(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", element);
    }

    public void deleteHead() {
        Header header = new Header();
        JsDisplayNone(header.delBlackHead);
        JsDisplayNone(header.delDiscount);
        JsDisplayNone(header.delSearchHead);
    }

    protected abstract void waitPageLoad();

    public void switch2NewWindow() {
        Set<String> handles = driver.getWindowHandles();

        int counter = 0;
        while (counter < 5) {
            if (handles.size() == 1) {
                handles = driver.getWindowHandles();
                dummyWait(1);
                counter++;
                continue;
            }
            for (String a : handles) {
                if (!a.equals(this.parentWindowHandle)) {
                    driver.switchTo().window(a); // switch to new window
                    return;
                }
            }
            counter++;
        }
    }

    public void switch2PrimaryWindow() {
        driver.switchTo().window(parentWindowHandle); // Switch back to parent window.
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
