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
        Menu.getMegaMenuMainElement(1).click();
        AllProduct allProduct = new AllProduct();
        allProduct.deleteHead();
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
        Menu.getMegaMenuMainElement(2).click();
        AllProduct allProduct = new AllProduct();
        allProduct.deleteHead();
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
        gridPage.deleteHead();
        try {
            gridPage.daily.click();
            gridPage.waitForVisibility(gridPage.checkedDaily, 5);
            gridPage.waitForVisibility(gridPage.product1, 5);
            int productNum = gridPage.regexGeInt(gridPage.productCountString.getText());
            gridPage.AsssetTrue(productNum > 0, " PRODUCT NUMBER IS :" + productNum);
        }
        catch (Exception e) {
            // new CL page empty TODO
        }
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
