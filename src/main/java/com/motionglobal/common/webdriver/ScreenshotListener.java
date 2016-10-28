package com.motionglobal.common.webdriver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.uncommons.reportng.HTMLReporter;

/**
 * ITestListener, to listen the test method's status.
 * 
 */
public class ScreenshotListener extends HTMLReporter implements ITestListener {

    public static final String DRIVER_ATTR = "driver";

    // take browser page shot if test failed or on exception.
    @Override
    public void onTestFailure(ITestResult result) {
        this.logPicture(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logPicture(result);
    }

    private void logPicture(ITestResult tr) {

        Reporter.setCurrentTestResult(tr);
        File file = new File("");
        String fileName = tr.getName() + "_" + System.currentTimeMillis();
        String imagePath = file.getAbsolutePath() + "\\test-output\\screenshots\\" + fileName + ".png";

        ITestContext context = tr.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute(DRIVER_ATTR + Thread.currentThread().getId());
        if (driver != null && !(driver.toString().contains("(null)"))) {
            String url = driver.getCurrentUrl();
            Reporter.log("<a alt='" + fileName + "' href='../screenshots/" + fileName + ".png'><img src='../screenshots/" + fileName
                    + ".png' width='100' height='100'/></a><a href='" + url + "'>" + url + "</a>", false);
            try {
                File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File saved = new File(imagePath);
                FileUtils.copyFile(f, saved);
            }
            catch (Exception e) {
                System.out.println("error generating screenshot: " + e);
            }
        }
        Reporter.setCurrentTestResult(null);
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // Auto-generated method stub

    }

}
