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

import com.motionglobal.common.utils.VerifyUtil;
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

    public void JsChangeClass(String classContent, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('class','" + classContent + "');", element);
    }

    public void iwtClick(WebElement element) {
        new Actions(driver).moveToElement(element).click();
        // try {
        // element.click();
        // }
        // catch (Exception e) {
        // new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        // element.click();
        // }
    }

    public void displayLogin() {
        JsChangeClass("new_proPop new_proPop2 addblock", driver.findElement(By.cssSelector("#signin_li>div")));
    }

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
    }

    public void deleteLetTalk() {
        try {
            Header header = new Header();
            JsDisplayNone(header.letTalk);
        }
        catch (Exception e) {
        }
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

    public double regexGetDouble(String matcher) {
        Pattern pattern = Pattern.compile("0\\.\\d*|[1-9]\\d*");
        Matcher match = pattern.matcher(matcher);
        Double getNum = 0.0;
        while (match.find()) {
            getNum = Double.parseDouble(match.group());
        }
        return getNum;
    }

    public int regexGeInt(String matcher) {
        Pattern pattern = Pattern.compile("[1-9]\\d*");
        Matcher match = pattern.matcher(matcher);
        int getNum = 0;
        while (match.find()) {
            getNum = Integer.parseInt(match.group());
        }
        return getNum;
    }

    public String regexGetLetterLow(String matcher) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
        Matcher match = pattern.matcher(matcher);
        String getStr = match.replaceAll("").toLowerCase();
        return getStr;
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
     * judge cart type
     * 
     * @return "new" or "old"
     */
    public String getCartType() {
        String cart = "";
        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(By.id("main-wrapper"));
                cart = "new";
                break;
            }
            catch (Exception e) {
            }
            try {
                driver.findElement(By.cssSelector(".cart_detail"));
                cart = "old";
                break;
            }
            catch (Exception e) {
            }
            try {
                Thread.sleep(200);
            }
            catch (Exception e) {
            }
            if (i == 99) {
                Assert.assertTrue(1 == 2, "Wait 20s, But Page No't Load Finish !!");
            }
        }
        return cart;
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

    /**
     * @param domain
     *            domain example: http://m.smartbuyglasses.co.uk/
     */
    final public static String getMobLoginRequest(String domain) {
        String loginRequest = domain + "membership/login-do?username=felix.ma%40motionglobal.com&password=motion888&form=menu&getInfo=0";
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

    public VerifyUtil VerifyUtil() {
        return new VerifyUtil();
    }
}
