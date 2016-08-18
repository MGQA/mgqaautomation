package com.motionglobal.testcases.sbg.desktop.explore;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.explore.FaceShapePage;
import com.motionglobal.pages.sbg.desktop.explore.FaceShapePage.FaceShape;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestFaceShape extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/face-shape" }, { "http://www.smartbuyglasses.com/face-shape" } };
    }

    // FIXME CASE 1
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void faceList(String url) {
        getURL(url);
        FaceShapePage shapePage = new FaceShapePage();
        try {
            shapePage.deleteHead();
            shapePage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        shapePage.waitForVisibility(shapePage.getListFaceEle(FaceShape.heart), 5);
        //
        shapePage.getListFaceEle(FaceShape.square).click();
        shapePage.waitForVisibility(shapePage.getListImgEle(FaceShape.square), 5);
        shapePage.waitForVisibility(shapePage.getListFaceLinkEle(FaceShape.square), 5);
        //
        shapePage.getListFaceEle(FaceShape.heart).click();
        shapePage.waitForVisibility(shapePage.getListImgEle(FaceShape.heart), 5);
        shapePage.waitForVisibility(shapePage.getListFaceLinkEle(FaceShape.heart), 5);
        //
        shapePage.getListFaceEle(FaceShape.round).click();
        shapePage.waitForVisibility(shapePage.getListImgEle(FaceShape.round), 5);
        shapePage.waitForVisibility(shapePage.getListFaceLinkEle(FaceShape.round), 5);
        //
        shapePage.getListFaceEle(FaceShape.oval).click();
        shapePage.waitForVisibility(shapePage.getListImgEle(FaceShape.oval), 5);
        shapePage.waitForVisibility(shapePage.getListFaceLinkEle(FaceShape.oval), 5);
        //
        shapePage.getListFaceLinkEle(FaceShape.oval).click();
        if (url.equals("http://www.smartbuyglasses.co.uk/face-shape")) {
            String current = shapePage.getCurrentUrl();
            shapePage.AsssetEquals(current, url + "-oval");

        }
        else {
            shapePage.switch2NewWindow();
            String current = shapePage.getCurrentUrl();
            shapePage.AsssetEquals(current, url + "-oval");
        }
    }

    // FIXME CASE 2
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void faceHomeGlass(String url) {
        getURL(url);
        FaceShapePage shapePage = new FaceShapePage();
        shapePage.waitForVisibility(shapePage.glassOvalBrand, 5);
        String topSellUrl = shapePage.glassTopSell.getAttribute("href");
        String country = url.split("/")[2];
        Assert.assertEquals(topSellUrl, "http://" + country + "/designer-sunglasses/general/--------------1---------");
        Assert.assertEquals(shapePage.glassesAll.size(), 24);
        String randName = shapePage.glassOvalBrand.getText().trim().replace(" ", "-");
        try {
            shapePage.deleteHead();
            shapePage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        shapePage.JsMouse(shapePage.glassOvalBrand);
        shapePage.glassOvalBrand.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        String productUrl = detailPage.getCurrentUrl();
        detailPage.AsssetTrue(productUrl.contains(randName), " PRODUCT RAND NAME FAIL !!!");
    }

    // FIXME CASE 3
    @Test(groups = { "debug", "smoke" })
    public void glassOval() {
        String url = "http://www.smartbuyglasses.co.uk/face-shape-oval";
        getURL(url);
        FaceShapePage shapePage = new FaceShapePage();
        shapePage.waitForVisibility(shapePage.faceHomeBtn, 5);
        int productNum = shapePage.glassesAll.size();
        shapePage.AsssetTrue(productNum > 1, " PRODUCT NUMBER EMPTY !!!");
        try {
            shapePage.deleteHead();
            shapePage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        String faceHomeUrl = shapePage.faceHomeBtn.getAttribute("href");
        String topSellUrl = shapePage.glassTopSell.getAttribute("href");
        Assert.assertEquals(faceHomeUrl, "http://www.smartbuyglasses.com/face-shape");
        Assert.assertEquals(topSellUrl, "http://www.smartbuyglasses.co.uk/designer-sunglasses/general/--------------1---------");
        String randName = shapePage.glassOvalBrand.getText().trim().replace(" ", "-");
        shapePage.JsMouse(shapePage.glassOvalBrand);
        shapePage.glassOvalBrand.click();
        ProductDetailPage detailPage = new ProductDetailPage();
        String productUrl = detailPage.getCurrentUrl();
        detailPage.AsssetTrue(productUrl.contains(randName), " PRODUCT RAND NAME FAIL !!!");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
