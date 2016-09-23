package com.motionglobal.testcases.sbg.desktop.productdetail;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * drag picture
 * 
 */
public class TestMainImgSlide extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://m.smartbuyglasses.com/designer-sunglasses/Tom-Ford/Tom-Ford-FT0248-HENRY-05N-159833.html" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void rightslide(String url) {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        new Actions(driver).dragAndDropBy(detailPage.mainImg.get(1), 600, 0).build().perform();
        detailPage.waitForVisibility(detailPage.mainImg.get(0), 5);
        String css = detailPage.mainImg.get(0).findElement(By.xpath("..")).getAttribute("class");
        System.out.println(css);
        Assert.assertTrue(css.contains("swiper-slide-active"));
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void leftslide(String url) {
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        new Actions(driver).dragAndDropBy(detailPage.mainImg.get(1), -600, 0).build().perform();
        detailPage.waitForVisibility(detailPage.mainImg.get(2), 5);
        String css = detailPage.mainImg.get(2).findElement(By.xpath("..")).getAttribute("class");
        System.out.println(css);
        Assert.assertTrue(css.contains("swiper-slide-active"));
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
