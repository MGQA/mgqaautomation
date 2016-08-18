package com.motionglobal.testcases.sbg.desktop.explore;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.explore.CelebrityPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestCelebrityGlass extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/i/celebrity-sunglasses-glasses" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void topSellImg(String url) {
        getURL(url);
        CelebrityPage celebrityPage = new CelebrityPage();
        try {
            celebrityPage.deleteHead();
            celebrityPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        celebrityPage.waitForVisibility(celebrityPage.swift, 5);
        celebrityPage.JsMouse(celebrityPage.swift);
        celebrityPage.mouseOver(celebrityPage.swift);
        celebrityPage.swift.click();
        celebrityPage.waitForVisibility(celebrityPage.buyNowBtn, 5);
        try {
            celebrityPage.deleteHead();
            celebrityPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        celebrityPage.buyNowBtn.click();
        celebrityPage.switch2NewWindow();
        ProductDetailPage detailPage = new ProductDetailPage();
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
