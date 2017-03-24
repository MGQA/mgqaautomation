package com.motionglobal.testcases.sbg.desktop.header_footer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class ShopGuide extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "https://www.smartbuyglasses.dk/" }, { "https://www.smartbuyglasses.com/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void heartGuide(String url) {
        getURL(url);
        Header header = new Header();
        try {
            header.mouseOver(header.iHeart);
            header.waitForVisibility(header.iHeartSGuide, 5);
        }
        catch (Exception e) {
            header.mouseOver(header.cartBox);
            header.mouseOver(header.iHeart);
            header.waitForVisibility(header.iHeartSGuide, 5);
        }
        String findStyle = header.iHeartSGuide.get(0).getAttribute("onclick");
        System.out.println(findStyle);
        header.AsssetEquals(
                findStyle,
                "dataLayer.push({'event':'GAEvent', 'eventCategory':'Header', 'eventAction':'click', 'eventLabel':'Style Finder - Sun'})");
        String shopGuideUrl = header.iHeartSGuide.get(1).getAttribute("href");
        header.AsssetEquals(shopGuideUrl, url + "shopping-guides/");
        String topSunUrl = header.iHeartSGuide.get(2).getAttribute("href");
        header.AsssetEquals(topSunUrl, url + "designer-sunglasses/general/--------------1--------");
        String topEyeUrl = header.iHeartSGuide.get(3).getAttribute("href");
        header.AsssetEquals(topEyeUrl, url + "designer-eyeglasses/general/--------------1--------");
        //
        header.iHeartSGuide.get(2).click();
        ProductGridPage gridPage = new ProductGridPage();
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void cartGuide(String url) {
        getURL(url);
        Header header = new Header();
        try {
            header.mouseOver(header.cartBox);
            header.waitForVisibility(header.cartSGuide, 5);
        }
        catch (Exception e) {
            header.mouseOver(header.iHeart);
            header.mouseOver(header.cartBox);
            header.waitForVisibility(header.cartSGuide, 5);
        }
        String findStyle = header.cartSGuide.get(0).getAttribute("onclick");
        System.out.println(findStyle);
        header.AsssetEquals(
                findStyle,
                "dataLayer.push({'event':'GAEvent', 'eventCategory':'Header', 'eventAction':'click', 'eventLabel':'Style Finder - Sun'})");
        String shopGuideUrl = header.cartSGuide.get(1).getAttribute("href");
        header.AsssetEquals(shopGuideUrl, url + "shopping-guides/");
        String topSunUrl = header.cartSGuide.get(2).getAttribute("href");
        header.AsssetEquals(topSunUrl, url + "designer-sunglasses/general/--------------1--------");
        String topEyeUrl = header.cartSGuide.get(3).getAttribute("href");
        header.AsssetEquals(topEyeUrl, url + "designer-eyeglasses/general/--------------1--------");
        header.cartSGuide.get(2).click();
        ProductGridPage gridPage = new ProductGridPage();
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
