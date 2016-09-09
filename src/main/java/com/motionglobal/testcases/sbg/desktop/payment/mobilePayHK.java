package com.motionglobal.testcases.sbg.desktop.payment;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.checkout.MobCheckOutPage;
import com.motionglobal.pages.sbg.mobile.home.MobHomePage;
import com.motionglobal.pages.sbg.mobile.home.MobHomePage.Sell;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class mobilePayHK extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://m.smartbuyglasses.com.hk" }, { "http://m.en.smartbuyglasses.com.hk" }, { "http://m.scn.smartbuyglasses.com.hk" }, };
    }

    /**
     * all url sum total is 51 . check it payment picture
     * 
     * @throws InterruptedException
     */
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug2", "pay" }, priority = 3)
    public void payPicture(String url) throws InterruptedException {
        getURL(url);
        new MobHeader().acceptAlert();
        MobHomePage homePage = new MobHomePage();
        homePage.getTopSell(Sell.SUNIMG).click();
        //
        MobProductDetailPage detailPage = new MobProductDetailPage();
        detailPage.waitForVisibility(detailPage.buyNow, 5);
        detailPage.buyNow.click();

        // judge page in cart page ;
        for (int i = 0; i < 40; i++) {
            try {
                // elemet is detailPage.fastCheckout;
                driver.findElement(By.className("shopping__cart__checkout"));
                break;
            }
            catch (Exception e) {
            }
            try {
                // elemet is detailPage.buyNow;
                driver.findElement(By.className("buy_now_btn"));
                detailPage.buyNow.click();
            }
            catch (Exception e) {
                Thread.sleep(200);
            }
        }
        new MobCartPage().fastCheckOut.click();
        MobCheckOutPage checkOutPage = new MobCheckOutPage();
        //
        checkOutPage.clearInput(checkOutPage.inputFistName, "automationFirst");
        checkOutPage.clearInput(checkOutPage.inputLastName, "automationLast");
        checkOutPage.clearInput(checkOutPage.inputEmail, "testautomation@automation.com");
        checkOutPage.clearInput(checkOutPage.inputAddress1, "automationAddress1");
        checkOutPage.clearInput(checkOutPage.inputPhone, "15212345678");
        // TODO hk is fail
        checkOutPage.continueBtn.click();
        //
        checkOutPage.waitForVisibility(checkOutPage.payPicture, 5);
        checkOutPage.AssertPayPicture(url, 1, 2, 3, 122);
        homePage.VerifyUtil().verifyEnd();
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
