package com.motionglobal.methodbase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.AbstractBaseContainer;
import com.motionglobal.pages.sbg.desktop.Header;

public class DeleteHeader extends AbstractBaseContainer {

    public void deleteHead() {
        Header header = new Header();
        try {
            JsDisplayNone(header.delBlackHead);
        }
        catch (Exception e) {
        }
        try {
            JsDisplayNone(header.delSearchHead);
        }
        catch (Exception e) {
        }
        try {
            JsDisplayNone(header.delDiscount);
        }
        catch (Exception e) {
        }
        deleteLetTalk();
    }

    public void deleteLetTalk() {
        try {
            JsDisplayNone(new Header().letTalk);
        }
        catch (Exception e) {
        }
    }

    public void JsDisplayNone(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='none';", element);
    }
}
