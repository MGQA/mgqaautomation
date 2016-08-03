package com.motionglobal.testcases.sbg.desktop.smoke.pimcore;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.pimcore.PimcorePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestPimcore extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" }, { "http://www.smartbuyglasses.com/" } };
    }

    @DataProvider
    public Object[][] pk() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/optical-centre" }, { "http://www.smartbuyglasses.com/optical-center" },
                { "http://www.smartbuyglasses.dk/optisk-center" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void intoPimcore(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.waitForVisibility(homePage.linkPimcore, 5);
        homePage.linkPimcore.click();
        PimcorePage pimcorePage = new PimcorePage();
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuEye(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuEye, 5);
        String expectTitle1 = pimcorePage.linkMenuEye.getText().toLowerCase();
        pimcorePage.deleteHead();
        pimcorePage.linkMenuEye.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle1 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle1, expectTitle1);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuSun(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuSun, 5);
        String expectTitle2 = pimcorePage.linkMenuSun.getText().toLowerCase();
        pimcorePage.deleteHead();
        pimcorePage.linkMenuSun.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle2 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle2, expectTitle2);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuCL(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuCL, 5);
        String expectTitle3 = pimcorePage.linkMenuCL.getText().toLowerCase();
        if (url == "http://www.smartbuyglasses.com/optical-center") {
            expectTitle3 = "contact lenses";
        }
        pimcorePage.deleteHead();
        pimcorePage.linkMenuCL.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle3 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle3, expectTitle3);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuEH(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuEH, 5);
        String expectTitle4 = pimcorePage.linkMenuEH.getText().toLowerCase();
        pimcorePage.deleteHead();
        pimcorePage.linkMenuEH.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle4 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle4, expectTitle4);
    }

    @Test(groups = { "debug", "smoke" })
    public void menuMG() {
        String url = "http://www.smartbuyglasses.co.uk/optical-centre";
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuMG, 5);
        pimcorePage.deleteHead();
        pimcorePage.linkMenuMG.click();
        pimcorePage.waitForVisibility(pimcorePage.textMGTitle, 5);
        String actualTitle7 = pimcorePage.textMGTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle7, "smart glasses of 2016");
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
