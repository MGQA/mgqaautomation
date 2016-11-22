package com.motionglobal.testcases.sbg.desktop.home.featured;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestImgBelowLink extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.com/" }, { "http://www.smartbuyglasses.dk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void imgBelowLinkSun(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        Random random = new Random();
        int indexNum = random.nextInt(6);
        WebElement linkSun = homePage.linkSun_ImgBelow.get(indexNum);

        // get url of sunglasses
        String onclickString = linkSun.getAttribute("onclick");
        String brand = (onclickString.split(" - "))[1];
        String expectedUrl = url + "designer-sunglasses/" + brand + "/";

        // random click one url
        homePage.deleteHead();
        homePage.waitForVisibility(linkSun, 5);
        homePage.JsMouse(homePage.linkSun_ImgBelow.get(indexNum));
        linkSun.click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl.replace("s", ""), expectedUrl.replace("s", ""));
    }

    @Test(dataProvider = "db", groups = { "debug", "smoke" })
    public void imgBelowLinkEye(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        Random random = new Random();
        int indexNum = random.nextInt(6);
        WebElement linkSun = homePage.linkEye_ImgBelow.get(indexNum);

        // get url of sunglasses
        String onclickString = linkSun.getAttribute("onclick");
        String brand = (onclickString.split(" - "))[1];
        String expectedUrl = url + "designer-eyeglasses/" + brand + "/";

        // random click one url
        homePage.deleteHead();
        homePage.waitForVisibility(linkSun, 5);
        homePage.JsMouse(linkSun);
        linkSun.click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl.replace("s", ""), expectedUrl.replace("s", ""));
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
