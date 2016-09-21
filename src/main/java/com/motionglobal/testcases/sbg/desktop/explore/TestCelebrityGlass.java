package com.motionglobal.testcases.sbg.desktop.explore;

import java.util.Iterator;

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
    public void celebrity(String url) {
        getURL(url);
        CelebrityPage celebrityPage = new CelebrityPage();
        celebrityPage.deleteHead();
        celebrityPage.waitForVisibility(celebrityPage.swift, 5);
        celebrityPage.JsMouse(celebrityPage.swift);
        celebrityPage.mouseOver(celebrityPage.swift);
        celebrityPage.waitForVisibility(celebrityPage.swiftGlass, 5);
        String handle = driver.getWindowHandle();
        celebrityPage.swiftGlass.click();
        celebrityPage.switch2NewWindow();
        celebrityPage.waitForVisibility(celebrityPage.buyNowBtn, 5);
        celebrityPage.deleteHead();
        String newHandle = driver.getWindowHandle();
        celebrityPage.JsMouse(celebrityPage.buyNowBtn);
        celebrityPage.buyNowBtn.click();
        Iterator<String> allHandle = driver.getWindowHandles().iterator();
        while (allHandle.hasNext()) {
            if ((allHandle.next() != handle) && (allHandle.next() != newHandle)) {
                driver.switchTo().window(allHandle.next());
            }
        }
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
