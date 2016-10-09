package com.motionglobal.methodbase;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AbstractStartByiPhone {
    WebDriver driver = null;

    public WebDriver getDriver() {
        // 启动ChromedriverServer
        ChromeDriverService chromeServer = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/browserDrivers/chromedriver.exe")).usingAnyFreePort().build();
        try {
            chromeServer.start();
        }
        catch (IOException e) {
        }
        // 以iPad模式启动Chrome，
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities
                .setCapability(
                        "chrome.switches",
                        Arrays.asList("--user-agent=\"Mozilla/5.0 (iPad; U; CPU OS 3_2_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B500 Safari/531.21.10\""));
        WebDriver driver = new RemoteWebDriver(chromeServer.getUrl(), capabilities);
        // iPhone5 屏幕大小为 : 360x640
        driver.manage().window().setSize(new Dimension(360, 640));
        return driver;
    }
}
