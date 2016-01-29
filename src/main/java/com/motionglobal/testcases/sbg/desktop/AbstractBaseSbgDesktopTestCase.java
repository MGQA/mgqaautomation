package com.motionglobal.testcases.sbg.desktop;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.motionglobal.common.webdriver.InitializeUtility;
import com.motionglobal.common.webdriver.ScreenshotListener;
import com.motionglobal.testcases.AbstractBaseTestCase;

@Test
public abstract class AbstractBaseSbgDesktopTestCase extends AbstractBaseTestCase {

    @Override
    @BeforeClass(alwaysRun = true)
    public void initDriver(ITestContext context) {
        driver = InitializeUtility.initializeDriver(CONFIG.getProperty("browser"));
        this.context = context;
        context.setAttribute(ScreenshotListener.DRIVER_ATTR + Thread.currentThread().getId(), driver);

        initialize();
    }

}
