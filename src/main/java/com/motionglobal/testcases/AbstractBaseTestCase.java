package com.motionglobal.testcases;

import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.motionglobal.common.webdriver.InitializeUtility;
import com.motionglobal.common.webdriver.ScreenshotListener;

@Test
public abstract class AbstractBaseTestCase {

    public final static String ROOT = System.getProperty("user.dir");
    protected WebDriver driver = null;
    private WebDriver driver2 = null;
    protected static Properties CONFIG = null;
    protected static ITestContext context;

    @Parameters({ "config" })
    @BeforeSuite(alwaysRun = true)
    public void initConfig(String config) {
        if (config == null || config.isEmpty()) {
            config = System.getProperty("config");
        }
        CONFIG = InitializeUtility.initailzeProperties(ROOT + config);
        this.logger().info("Testing started... ");
    }

    @BeforeTest(alwaysRun = true)
    public void initDriver(ITestContext context) {
        driver = InitializeUtility.initializeDriver(CONFIG.getProperty("browser"));
        this.context = context;
        context.setAttribute(ScreenshotListener.DRIVER_ATTR + Thread.currentThread().getId(), driver);

        initialize();
    }

    protected void getURL(String url) {
        this.reloadDriver(true);
        driver.get(url);
    }

    protected void switchDriver() {
        if (isDriverClosed(driver2)) {
            driver2 = InitializeUtility.initializeDriver(CONFIG.getProperty("browser"));
        }
        WebDriver tempDriver = driver;
        driver = driver2;
        driver2 = tempDriver;
        driver2.manage().window().setSize(new Dimension(80, 60)); // Bring the active window to the front
        driver.manage().window().maximize();
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
            driver = InitializeUtility.initializeDriver(CONFIG.getProperty("browser"));
            driver.manage().window().maximize();
            context.setAttribute(ScreenshotListener.DRIVER_ATTR + Thread.currentThread().getId(), driver);
        }
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

    @AfterTest(alwaysRun = true)
    @AfterClass(alwaysRun = true)
    @AfterSuite(alwaysRun = true)
    private void quitDriver() {
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

    protected void p(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    protected void p(String str) {
        System.out.println(str);
    }

    protected void p(int str) {
        System.out.println(str);
    }

    // protected void p(List<WebElement> list) {
    // for (WebElement s : list) {
    // System.out.println(s.getAttribute("value"));
    // }
    // }
}
