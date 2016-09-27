package com.motionglobal.testcases.sbg.mobile.product;

import java.util.Random;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.MobHeader.MegaMenu;
import com.motionglobal.pages.sbg.mobile.product.MobProductAllPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobTestSportGlassMenu extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://m.smartbuyglasses.com/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug2", "smoke" })
    public void menuToGridPage(String url) {
        getURL(url);
        MobHeader header = new MobHeader();

        // click menu Sport glass
        header.btnMenu.click();
        header.getMainMenuElement(MegaMenu.SPORT).click();
        MobProductAllPage productPage2 = new MobProductAllPage();
        String title2 = productPage2.regexGetLetterLow(productPage2.productTitle.getText());
        Assert.assertEquals(title2, "sportssunglasses");

        // click sport picture into product grid page
        Random random = new Random();
        int num = random.nextInt(productPage2.sectionSport.size());
        WebElement sport = productPage2.sectionSport.get(num);
        String sportName = productPage2.regexGetLetterLow(sport.getText());
        productPage2.elementClick(sport);
        MobProductPage productPage3 = new MobProductPage();
        String urlName = productPage3.regexGetLetterLow(productPage3.getCurrentUrl().split("/")[4]);
        Assert.assertEquals(urlName, sportName);
        Assert.assertTrue("_Product Number Is 0 !!!", productPage3.productList.size() > 0);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
