package com.motionglobal.testcases;

import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.motionglobal.common.webdriver.InitializeUtility;
import com.motionglobal.common.webdriver.ScreenshotListener;
import com.motionglobal.methodbase.DeleteHeader;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.mobile.MobHeader;

@Test
public abstract class AbstractBaseTestCase {

    public final static String ROOT = System.getProperty("user.dir");
    protected WebDriver driver = null;
    private WebDriver driver2 = null;
    protected static Properties CONFIG = null;
    protected static ITestContext context;
    private static int i;

    @Parameters({ "config" })
    @BeforeSuite(alwaysRun = true)
    public void initConfig(String config) {
        if (config == null || config.isEmpty()) {
            config = System.getProperty("config");
        }
        CONFIG = InitializeUtility.initailzeProperties(ROOT + config);
        this.logger().info("Testing started... ");
    }

    @BeforeClass(alwaysRun = true)
    public void initDriver(ITestContext context) {
        this.context = context;
        driver = newDriver();
        initialize();
    }

    // XXX getURL
    protected void getURL(String url) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }
        if (i == 0) {
            this.reloadDriver(false);
        }
        driver.get(url);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e) {
        }
        delDeal(url);
        i = 0;
    }

    protected void switchDriver() {
        if (isDriverClosed(driver2)) {
            driver2 = newDriver();
        }
        WebDriver tempDriver = driver;
        driver = driver2;
        driver2 = tempDriver;
        context.setAttribute(ScreenshotListener.DRIVER_ATTR + Thread.currentThread().getId(), driver);
    }

    public static WebDriver getDriver() {
        return (WebDriver) context.getAttribute(ScreenshotListener.DRIVER_ATTR + Thread.currentThread().getId());
    }

    private void reloadDriver(boolean hard) {
        if (hard) {
            closeDriver(driver);
        }
        if (this.isDriverClosed(driver)) {
            driver = newDriver();
        }
    }

    private WebDriver newDriver() {
        WebDriver driver = InitializeUtility.initializeDriver(CONFIG.getProperty("browser"));
        driver.manage().window().maximize();
        context.setAttribute(ScreenshotListener.DRIVER_ATTR + Thread.currentThread().getId(), driver);
        i = 1;
        return driver;
    }

    protected void switchWindow() {
        // Get all the window handles in a set
        String newWindow = driver.getWindowHandle();
        Iterator<String> it = driver.getWindowHandles().iterator();
        // iterate through your windows
        while (it.hasNext()) {
            newWindow = it.next();
        }
        driver.switchTo().window(newWindow);
    }

    private void closeDriver(WebDriver driver) {
        try {
            if (!isDriverClosed(driver)) {
                driver.quit();
            }
        }
        catch (UnreachableBrowserException e) {
        }
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        tearDown();
        // close the browsers
        closeDriver(driver);
        closeDriver(driver2);
    }

    private boolean isDriverClosed(WebDriver driver) {
        return driver == null || driver.toString().contains("null");
    }

    protected Logger logger() {
        return Logger.getLogger(this.getClass());
    }

    // To be implement in the sub class
    protected abstract void initialize();

    // To be implement in the sub class
    protected abstract void tearDown();

    protected void print(Object... obj) {
        for (Object s : obj) {
            System.out.println(s);
        }
    }

    // XXX delete deal
    private void delDeal(String url) {
        try {
            driver.switchTo().alert().accept();
        }
        catch (Exception e) {
        }
        // mobile
        if (url.contains("http://m.")) {
            MobHeader mobHeader = new MobHeader();
            try {
                if (!(url == "http://m.smartbuyglasses.co.uk/?discount")) {
                    mobHeader.JsDisplayNone(mobHeader.discount);
                    mobHeader.closeHappySummer.click();
                }
                Thread.sleep(100);
            }
            catch (Exception e) {
            }
            try {
                System.out.println("mobile popUp");
                mobHeader.waitForVisibility(mobHeader.domainPopUp, 2);
                mobHeader.domainPopUp.click();
                // mobHeader.JsDisplayNone(mobHeader.domainPopUp);
            }
            catch (Exception e) {
            }
            new DeleteHeader().deleteLetTalk();
            try {
                mobHeader.waitForVisibility(driver.findElement(By.cssSelector(".overlay[style='display: none;']")), 2);
            }
            catch (Exception e) {
            }
        }
        else {
            // desktop
            Header header = new Header();
            try {
                header.geo.click();
                Thread.sleep(100);
            }
            catch (Exception e) {
            }
            try {
                header.happySummer.click();
                Thread.sleep(100);
            }
            catch (Exception e) {
            }
            try {
                if (!(url == "http://www.smartbuyglasses.co.uk/?birthday"))
                    System.out.println("start");
                header.firstBuy.click();
                System.out.println("end");
                Thread.sleep(100);
            }
            catch (Exception e) {
            }
            if (!(url.contains("sliderBar"))) {
                try {
                    header.JsDisplayNone(header.sliderBar);
                    Thread.sleep(100);
                }
                catch (Exception e) {
                }
            }
        }
    }
}
