package com.motionglobal.testcases.sbg.desktop.home.sliderBar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.home.NewsLetterPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestSliderBar extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "https://www.smartbuyglasses.co.uk/?sliderBar" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sliderBar(String url) {
        getURL(url);
        Header header = new Header();
        header.sliderTry.click();
        ProductGridPage gridPage = new ProductGridPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("----------1----1---------"));
        header.sliderNewsLetter.click();
        NewsLetterPage letterPage = new NewsLetterPage();
        letterPage.firstName.sendKeys("jack");
        letterPage.lastName.sendKeys("zhong");
        String email = "qatest@motionglobal" + Math.round(Math.random() * 10000) + ".com";
        System.out.println(email);
        letterPage.newsletterEmail.sendKeys(email);
        letterPage.male.click();
        letterPage.waitForVisibility(By.className("note"), 5);
        letterPage.isTextPresent("Thank");
    }

    @DataProvider
    public Object[][] sg() {
        return new Object[][] { { "https://www.smartbuyglasses.co.uk/?sliderBar" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "sg", groups = { "debug", "smoke" })
    public void sliderBar_EyeTest(String url) {
        getURL(url);
        Header header = new Header();
        header.sliderEyeTest.click();
        header.waitForVisibility(header.eyeTestBox, 5);
        header.waitForVisibility(By.cssSelector(".gm-style-mtc"), 10);
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
