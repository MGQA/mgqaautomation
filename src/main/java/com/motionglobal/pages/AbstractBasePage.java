package com.motionglobal.pages;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.motionglobal.common.utils.VerifyUtil;
import com.motionglobal.methodbase.DecideCartType;
import com.motionglobal.methodbase.DecideRxType;
import com.motionglobal.methodbase.DeleteHeader;
import com.motionglobal.methodbase.MoveAndClick;
import com.motionglobal.methodbase.SwitchToWindow;

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

    // XXX JS
    public void JsMouse(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        new Actions(driver).moveToElement(element).build().perform();
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

    // // screen scale 0.3
    public void JsScaleBody() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.transform='scale(0.3) translate(0,-'+arguments[0].offsetHeight+'px)';",
                driver.findElement(By.tagName("body")));
    }

    public void JsScale(WebElement element, double scale) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.transform='scale(" + scale + ")';", element);
    }

    public void displayMenu(int num) {
        JsChangeClass("nav_submenu menuN_dispaly", driver.findElement(By.id("menuN_level_" + num)));
    }

    public void displayLogin() {
        JsChangeClass("new_proPop new_proPop2 addblock", driver.findElement(By.cssSelector("#signin_li>div")));
    }

    public void selectValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void waitShadow() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(By
                .cssSelector("[id*='xubox'][class*='xubox_shade']")))));
    }

    public void AsssetEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    public void AsssetTrue(Boolean condition, String description) {
        Assert.assertTrue(condition, description);
    }

    // XXX regex
    public double regexGetDouble(String matcher) {
        Pattern pattern = Pattern.compile("[^0-9.]");
        Matcher match = pattern.matcher(matcher);
        String str = match.replaceAll("");
        Double getNum = Double.parseDouble(str);
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
     * XXX mathAdd and mathSub can use to double fuzzy 在double精确度不好的时候用
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

    public String getCartType() {
        return new DecideCartType().getCartType(); // return "new" or "old"
    }

    public String getRXType() {
        return new DecideRxType().getRXType(); // return "new" or "old"
    }

    public void deleteHead() {
        new DeleteHeader().deleteHead(); // display="none" of header
    }

    public void elementClick(WebElement element) {
        new MoveAndClick().elementClick(element); // move and click element
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
        new SwitchToWindow().switch2NewWindow();
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
