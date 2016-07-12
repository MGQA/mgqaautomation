package com.motionglobal.testcases.sbg.mobile.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.product.MobOpticianPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * .m.com Test : product size clickable
 * 
 */
public class MobTestViewEyeProduct extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/designer-eyeglasses/Tom-Ford/Tom-Ford-FT5146-003-77433.html" } };
    }

    @Test(dataProvider = "dp", groups = { "debug2", "smoke", "fastsmoke" })
    public void searchPro(String url) {
        getURL(url);
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
