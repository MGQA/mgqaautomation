package com.motionglobal.testcases.sbg.desktop.smoke.bug;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestFlagTrue extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" }, { "http://www.smartbuyglasses.com/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void countryFlag(String url) {
        getURL(url);
        Header header = new Header();
        header.waitForVisibility(header.flagCountry, 3);
        String flag = header.flagCountry.getAttribute("class");
        switch (url) {
        case "http://www.smartbuyglasses.co.uk/":
            try {
                Assert.assertEquals(flag, "flag-icon gb");
            }
            catch (Exception e) {
                Assert.assertEquals(flag, "flag-icon flag-icon-geo_flag_GB");
            }
            break;
        case "http://www.smartbuyglasses.dk/":
            try {
                Assert.assertEquals(flag, "flag-icon dk");
            }
            catch (Exception e) {
                Assert.assertEquals(flag, "flag-icon flag-icon-geo_flag_DK");
            }
            break;
        default:
            try {
                Assert.assertEquals(flag, "flag-icon us");
            }
            catch (Error e) {
                Assert.assertEquals(flag, "flag-icon flag-icon-geo_flag_US");
            }
            break;
        }

    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
