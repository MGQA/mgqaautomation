package com.motionglobal.testcases.sbg.mobile.explore;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.explore.MobFaceShpePage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobFaceShape extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/face-shape" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug111", "smoke" })
    public void bebeClickText(String url) throws InterruptedException {
        getDriver().get(url);
        driver.manage().window().setSize(new Dimension(360, 640));
        MobFaceShpePage shpePage = new MobFaceShpePage();
        shpePage.JsDisplayNone(shpePage.headerBlock);
        //
        shpePage.JsMouse(shpePage.shapeList.get(1));
        shpePage.shapeList.get(1).click();
        String shapeUrl1 = shpePage.shapeBtn.getAttribute("src");
        Assert.assertEquals(shapeUrl1, "http://pimcore.motionglobal.com/face-shape-main/en/main/button_square.jpg");
        shpePage.shapeBtn.click();
        shpePage.switch2NewWindow();
        String currentUrl = shpePage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://m.smartbuyglasses.com/face-shape-square");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
