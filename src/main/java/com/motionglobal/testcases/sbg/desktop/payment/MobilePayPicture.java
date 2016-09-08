package com.motionglobal.testcases.sbg.desktop.payment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.cart.MobCartPage;
import com.motionglobal.pages.sbg.mobile.checkout.MobCheckOutPage;
import com.motionglobal.pages.sbg.mobile.home.MobHomePage;
import com.motionglobal.pages.sbg.mobile.home.MobHomePage.Sell;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class MobilePayPicture extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://m.smartbuyglasses.com" }, { "http://m.visiondirect.com.au" }, { "http://m.smartbuyglasses.ca" },
                { "http://m.smartbuyglasses.co.nz" }, { "http://m.smartbuyglasses.jp" }, { "http://m.smartbuyglasses.com.tw" },
                { "http://m.smartbuyglasses.co.uk" }, { "http://m.smartbuyglasses.de" }, { "http://m.smartbuyglasses.nl" },
                { "http://m.smartbuyglasses.co.in" }, { "http://m.smartbuyglasses.co.za" }, { "http://m.smartbuyglasses.ie" },
                { "http://m.smartbuyglasses.se" }, { "http://m.smartbuyglasses.gr" }, { "http://m.smartbuyglasses.com.sg" },
                { "http://m.es.smartbuyglasses.com" }, { "http://m.en.smartbuyglasses.com.tw" }, { "http://m.scn.smartbuyglasses.com.tw" },
                { "http://m.scn.smartbuyglasses.com.sg" }, { "http://m.tcn.smartbuyglasses.com.sg" }, { "http://m.fr.smartbuyglasses.ca" },
                { "http://m.easylunettes.fr" }, { "http://m.smartbuyglasses.ch" }, { "http://m.smartbuyglasses.be" }, { "http://m.smartbuyglasses.at" },
                { "http://m.fr.smartbuyglasses.be" }, { "http://m.en.smartbuyglasses.ch" }, { "http://m.fr.smartbuyglasses.ch" },
                { "http://m.en.smartbuyglasses.be" }, { "http://m.oculosworld.com.br" }, { "http://m.gafasworld.es" }, { "http://m.smartbuyglasses.dk" },
                { "http://m.smartbuyglasses.it" }, { "http://m.oculosworld.com.pt" }, { "http://m.smartbuyglasses.fi" }, { "http://m.sbg.co.kr" },
                { "http://m.smartbuyglasses.cz" }, { "http://m.lentesworld.com.mx" }, { "http://m.gafasworld.com.co" }, { "http://m.smartbuyglasses.no" },
                { "http://m.visiondirecta.cl" }, { "http://m.optikaworld.ru" }, { "http://m.optykaworld.pl" }, { "http://m.smartbuyglasses.com.tr" },
                { "http://m.smartbuyglasses.com.my" }, { "http://m.smartbuyglasses.com.vn" }, { "http://m.smartbuyglasses.co.id" },
                { "http://m.smartbuyglasses.com.ar" } };
    }

    /**
     * all url sum total is 51 . check it payment picture
     * 
     * @throws InterruptedException
     */
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug111", "pay" }, priority = 2)
    public void payPicture(String url) throws InterruptedException {
        // switch (url) {
        // case "http://m.es.smartbuyglasses.com":
        // case "http://m.smartbuyglasses.com.ar":
        // case "http://m.visiondirecta.cl":
        // case "http://m.gafasworld.com.co":
        // case "http://m.lentesworld.com.mx":
        // getURL(url + "/lentes-de-sol-de-diseño/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        // break;
        // case "http://m.fr.smartbuyglasses.ca":
        // case "http://m.fr.smartbuyglasses.be":
        // case "http://m.fr.smartbuyglasses.ch":
        // getURL(url + "/lunettes-de-soleil-design/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        // break;
        // default:
        // getURL(url + "/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        // break;
        // }
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
        switch (url.split("\\.")[url.split("\\.").length - 1]) {
        case "sg":
        case "ch":
        case "be":
        case "at":
        case "de":
            checkOutPage.selectCountry("DE");
            checkOutPage.sendkeyState();
            break;
        case "nl":
            checkOutPage.selectCountry("NL");
            checkOutPage.sendkeyState();
            break;
        case "za":
            checkOutPage.selectCountry("ZA");
            checkOutPage.selectState("ZA-FS");
            break;
        case "br":
            checkOutPage.selectCountry("BR");
            checkOutPage.selectState("AL");
            break;
        case "au":
            checkOutPage.selectCountry("AU");
            checkOutPage.selectState("AU-NT");
            break;
        default:
            if (!(url.split("\\.")[url.split("\\.").length - 1].equals("hk"))) {
                checkOutPage.selectCountry("US");
                checkOutPage.selectState("AL");
            }
            break;
        }
        checkOutPage.clearInput(checkOutPage.inputFistName, "automationFirst");
        checkOutPage.clearInput(checkOutPage.inputLastName, "automationLast");
        checkOutPage.clearInput(checkOutPage.inputEmail, "testautomation@automation.com");
        checkOutPage.clearInput(checkOutPage.inputAddress1, "automationAddress1");
        checkOutPage.clearInput(checkOutPage.inputPhone, "15212345678");
        if (!(url.split("\\.")[url.split("\\.").length - 1].equals("hk"))) {
            checkOutPage.clearInput(checkOutPage.inputPostAddress, "200000");
            checkOutPage.clearInput(checkOutPage.inputCity, "shanghai");
        }
        // checkOutPage.waitForVisibility(checkOutPage.continueBtn, 10);
        // checkOutPage.continueBtn.click();
        checkOutPage.continueBtn.click();
        //
        checkOutPage.waitForVisibility(checkOutPage.payPicture, 5);
        switch (url.split("\\.")[url.split("\\.").length - 1]) {
        case "mx":
        case "co":
        case "ar":
        case "cl":
            checkOutPage.AssertPayPicture(url, 1, 3);
            break;
        case "nz":
        case "pt":
        case "pl":
        case "tr":
            checkOutPage.AssertPayPicture(url, 1, 2, 3);
            break;
        case "za":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 11);
            break;
        case "ru":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 849, 841);
            break;
        case "ca":
            if (url.split("\\.")[1].equals("fr")) {
                checkOutPage.AssertPayPicture(url, 1, 3, 122, 125);
            }
            else {
                checkOutPage.AssertPayPicture(url, 1, 3, 122);
            }
            break;
        case "es":
        case "no":
        case "info":
        case "my":
        case "vn":
        case "id":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 125);
            break;
        case "dk":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 123);
            break;
        case "hk":
        case "tw":
        case "ie":
        case "se":
        case "gr":
        case "fr":
        case "it":
        case "kr":
        case "cz":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122);
            break;
        case "sg":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 810);
            break;
        case "nl":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 809, 122);
            break;
        case "de":
        case "ch":
        case "be":
        case "at":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 836);
            break;
        case "com":
        case "in":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 125);
            break;
        case "br":
            checkOutPage.AssertPayPicture(url, 1, 3, 125, 1503);
            break;
        case "fi":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 802);
            break;
        case "au":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 125, 11);
            break;
        case "jp":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 125, 1504);
            break;
        case "uk":
            checkOutPage.AssertPayPicture(url, 1, 2, 3, 122, 836, 125, 117);
            break;
        default:
            Assert.assertEquals(1, 2);
            break;
        }
        if (url == "http://m.smartbuyglasses.com.ar") {
            homePage.VerifyUtil().verifyEnd();
        }
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
