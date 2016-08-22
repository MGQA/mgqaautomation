package com.motionglobal.pages;

import java.math.BigDecimal;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    public void JSMenuDisplay(int menuNum) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('class','nav_submenu menuN_display');", driver.findElement(By.id("menuN_level_" + menuNum)));
    }

    public void deleteHead() {
        Header header = new Header();
        JsDisplayNone(header.delBlackHead);
        JsDisplayNone(header.delDiscount);
        JsDisplayNone(header.delSearchHead);
    }

    public void deleteLetTalk() {
        Header header = new Header();
        waitForVisibility(header.letTalk, 5);
        JsDisplayNone(header.letTalk);
    }

    public void selectValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void AsssetEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    public void AsssetTrue(Boolean condition, String description) {
        Assert.assertTrue(condition, description);
    }

    public Double regexGetMath(String matcher) {
        Pattern pattern = Pattern.compile("[^0-9/.]");
        Matcher match = pattern.matcher(matcher);
        String getStr = match.replaceAll("");
        Double getNum = Double.parseDouble(getStr);
        return getNum;
    }

    /**
     * mathAdd and mathSub can use to doub fuzzy 在double精确度不好的时候用
     */
    public double mathAdd(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();

    }

    public double mathSub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();

    }

    /**
     * @param domain
     *            domain example: http://www.smartbuyglasses.co.uk/
     */
    final public static String getLoginRequest(String domain) {
        String loginRequest = domain
                + "order/login?jsoncallback=jQuery16408493127196615433_1470738431732&username=felix.ma%40motionglobal.com&password=f8b708301cea089f3490279a90fcdb6b&remember_me=1&fromMember=Membership&_=1470738448814";
        return loginRequest;
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
