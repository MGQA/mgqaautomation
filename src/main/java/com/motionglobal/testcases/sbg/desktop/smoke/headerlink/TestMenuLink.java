package com.motionglobal.testcases.sbg.desktop.smoke.headerlink;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.product.AllProduct;
import com.motionglobal.pages.sbg.desktop.product.CLProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestMenuLink extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void sungless(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.waitForVisibility(Menu.getMegaMenuMainElement(1), 5);
        Menu.getMegaMenuMainElement(1).click();
        AllProduct allProduct = new AllProduct();
        try {
            allProduct.deleteHead();
            allProduct.deleteLetTalk();
        }
        catch (Exception e) {
        }
        allProduct.waitForVisibility(allProduct.imgRanban, 5);
        String ranbanUrl = allProduct.brandSunRanban.getAttribute("href");
        allProduct.AsssetEquals(ranbanUrl, "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/");
        allProduct.imgRanban.click();
        ProductGridPage gridPage = new ProductGridPage();
        String currentUrl = gridPage.getCurrentUrl();
        gridPage.AsssetEquals(currentUrl, "http://www.smartbuyglasses.co.uk/designer-sunglasses/Ray-Ban/");
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void eyegless(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.waitForVisibility(Menu.getMegaMenuMainElement(2), 5);
        Menu.getMegaMenuMainElement(2).click();
        AllProduct allProduct = new AllProduct();
        try {
            allProduct.deleteHead();
            allProduct.deleteLetTalk();
        }
        catch (Exception e) {
        }
        allProduct.waitForVisibility(allProduct.imgRanban, 5);
        String ranbanUrl = allProduct.brandEyeRanban.getAttribute("href");
        allProduct.AsssetEquals(ranbanUrl, "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/");
        allProduct.imgRanban.click();
        ProductGridPage gridPage = new ProductGridPage();
        String currentUrl = gridPage.getCurrentUrl();
        gridPage.AsssetEquals(currentUrl, "http://www.smartbuyglasses.co.uk/designer-eyeglasses/Ray-Ban/");
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void CL(String url) {
        getURL(url);
        Menu Menu = new Menu();
        Menu.waitForVisibility(Menu.getMegaMenuMainElement(5), 5);
        Menu.getMegaMenuMainElement(5).click();
        CLProductGridPage gridPage = new CLProductGridPage();
        try {
            gridPage.deleteHead();
            gridPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        gridPage.daily.click();
        gridPage.waitForVisibility(gridPage.checkedDaily, 5);
        double productNum = gridPage.regexGetDouble(gridPage.productCountString.getText());
        gridPage.AsssetTrue(productNum > 0, " PRODUCT NUMBER = 0 !!!");
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
