package com.motionglobal.testcases.sbg.desktop.MobSmoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.MobCartPage;
import com.motionglobal.pages.sbg.desktop.product.MobOpticianPage;
import com.motionglobal.pages.sbg.desktop.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestViewEyeProduct extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-eyeglasses/Tom-Ford/Tom-Ford-FT5146-003-77433.html" } };
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke" })
    public void searchPro(String url) {
        driver.get(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.productSizeOne.click();
        Assert.assertEquals(detailPage.productSizeOne.getAttribute("class"), "size__select");
        detailPage.productSizeTwo.click();
        Assert.assertEquals(detailPage.productSizeTwo.getAttribute("class"), "size__select");
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        driver.navigate().back();
        detailPage.addLens.click();
        MobOpticianPage opticianPage = new MobOpticianPage();
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
