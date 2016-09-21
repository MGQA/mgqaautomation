package com.motionglobal.methodbase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.motionglobal.pages.AbstractBaseContainer;

public class MoveAndClick extends AbstractBaseContainer {

    /**
     * chrome no't move to element , so create it to move and click
     */
    public void elementClick(WebElement element) {
        for (int i = 0; i < 21; i++) {
            try {
                JsMouse(element);
                if (element.getText() != "" && element.getText() != null) {
                    element.click();
                    break;
                }
            }
            catch (Exception e) {
                if (i == 20) {
                    Assert.assertTrue(false, " Wait 2 Second, No't Find Elemnt !!!");
                }
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e1) {
                }
            }
        }
    }

    public void JsMouse(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
