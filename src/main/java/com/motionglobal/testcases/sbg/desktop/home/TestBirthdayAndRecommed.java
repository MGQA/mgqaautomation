package com.motionglobal.testcases.sbg.desktop.home;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestBirthdayAndRecommed extends AbstractBaseSbgDesktopTestCase {

    WebDriver driver;

    /**
     * no something
     */
    @Test(enabled = false, groups = { "debug" })
    public void birthday() {
        getURL("http://www.smartbuyglasses.co.uk/?birthday");
        Header header = new Header();
        int num = new Random().nextInt(999999);
        header.email.sendKeys("felix.ma@motionglobal" + num + ".com");
        header.bDay.sendKeys("19920617");
        header.waitForVisibility(header.man, 2);
        header.man.click();
        header.waitForVisibility(header.birthdayClose, 5);
        header.birthdayClose.click();
        HomePage page = new HomePage();
    }

    @Test(groups = { "debug" })
    public void recommend() {
        getURL("http://www.smartbuyglasses.co.uk/");
        Header header = new Header();
        header.waitForVisibility(header.recommend, 10);
        header.recommend.click();
        int num = new Random().nextInt(999999);
        header.waitForVisibility(header.recommendFirstName, 5);
        header.recommendFirstName.sendKeys("jack.zhong");
        header.recommendEmail.sendKeys("felix.ma@motionglobal.com");
        header.recommendShareBtn.click();
        header.waitForVisibility(header.recommendToEmail, 5);
        header.recommendToEmail.sendKeys("felix.ma@motionglobal" + num + ".com");
        header.recommendSendBtn.click();
        header.waitForVisibility(header.recommendThank, 5);
        String thank = header.recommendThank.getText();
        header.AsssetEquals(thank, "E-mail sent successfully!");
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
