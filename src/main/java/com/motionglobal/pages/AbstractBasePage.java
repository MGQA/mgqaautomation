package com.motionglobal.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public String getURL() {
        return driver.getCurrentUrl();
    }
}
