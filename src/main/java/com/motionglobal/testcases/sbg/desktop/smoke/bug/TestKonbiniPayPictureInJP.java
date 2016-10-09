package com.motionglobal.testcases.sbg.desktop.smoke.bug;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.checkout.MobCheckOutPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestKonbiniPayPictureInJP extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { {} };
    }

    @Test(skipFailedInvocations = true, groups = { "debug111", "smoke" })
    public void topSellImg() {
        String url = "http://m.smartbuyglasses.jp/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html/";
        getURL(url);
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.buyNow.click();
        MobCartPage cartPage = new MobCartPage();
        cartPage.fastCheckOut.click();
        MobCheckOutPage checkOutPage = new MobCheckOutPage();
        checkOutPage.inputFistName.sendKeys("jack");
        checkOutPage.inputLastName.sendKeys("zhong");
        checkOutPage.inputEmail.sendKeys("jack.zhong@motiongloabl.com");
        checkOutPage.inputAddress1.sendKeys("japan");
        checkOutPage.selectCountry("JP");
        checkOutPage.sendkeyState();
        checkOutPage.inputPostAddress.sendKeys("10086");
        checkOutPage.inputCity.sendKeys("daban");
        checkOutPage.inputPhone.sendKeys("0453-5521521");
        checkOutPage.continueBtn.click();
        String img = checkOutPage.payPictureInJP.getAttribute("src");
        System.out.println(img);
        // TODO
        // Assert.assertEquals(img, "");
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
