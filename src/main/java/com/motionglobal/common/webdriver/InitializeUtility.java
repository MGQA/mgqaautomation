package com.motionglobal.common.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.motionglobal.common.utils.PropertiesUtil;

public class InitializeUtility {
    private static Logger logger = Logger.getLogger(InitializeUtility.class);

    /**
     * This function is used to launch browser
     * 
     * @return
     */
    public static WebDriver initializeDriver(String browser) {
        // use which browser
        logger.info("Launching " + browser + "...");
        WebDriver driver = null;
        browser = browser.toLowerCase();
        switch (browser) {
        case "firefox":
            File pathBinary = new File("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); // TODO
            FirefoxBinary binary = new FirefoxBinary(pathBinary);
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("webdriver_accept_untrusted_certs", true);
            // profile.setAssumeUntrustedCertificateIssuer(false);
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("security.OCSP.enabled", 0);
            profile.setPreference("browser.download.dir", "/driverdownload");
            profile.setPreference(
                    "browser.helperApps.neverAsk.saveToDisk",
                    "application/msword,application/x-rar-compressed,application/octet-stream,application/csv,text/csv");
            driver = new FirefoxDriver(binary, profile);

            break;
        case "ie":
            // System.setProperty("webdriver.ie.driver", "\\src\\main\\resources\\browserDrivers\\IEDriverServer64.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new InternetExplorerDriver(ieCapabilities);

            break;
        case "chrome":
            System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\browserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();

            break;
        default:
            break;
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * This function is used to initialize the CONFIG property file
     */
    public static Properties initailzeProperties(String config) {
        File configFile = new File(config);
        logger.info("Initializing configurations..." + configFile.getAbsolutePath());
        Properties CONFIG = new Properties();
        try {
            if (configFile.exists()) {
                FileInputStream fs = new FileInputStream(config);
                CONFIG.load(fs);
            }
            else {
                CONFIG = PropertiesUtil.load(config);
            }
        }
        catch (Exception e) {
            logger.info(e.getMessage());
        }
        return CONFIG;
    }

    public static void updateProperties(String propertiesPath, String keyname, String keyvalue) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(propertiesPath));
            props.setProperty(keyname, keyvalue);
            savePropertyAsFile(props, propertiesPath);
        }
        catch (IOException e) {
            logger.info("Error when updating properties file.");
        }
    }

    public static void savePropertyAsFile(Properties props, String propertiesPath) throws IOException {
        OutputStream fos = new FileOutputStream(propertiesPath);
        props.store(fos, "");
        fos.flush();
        fos.close();
    }

}
