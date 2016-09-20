package com.motionglobal.testcases.sbg.desktop.payment;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.VerifyUtil;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class DeskTopPayPicture extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] {
                // domain no't exist
                // { "http://www.smartbuyglasses.co.in" },
                { "http://www.smartbuyglasses.com" }, { "http://www.visiondirect.com.au" }, { "http://www.smartbuyglasses.ca" },
                { "http://www.smartbuyglasses.co.nz" }, { "http://www.smartbuyglasses.jp" }, { "http://www.smartbuyglasses.com.hk" },
                { "http://www.smartbuyglasses.com.tw" }, { "http://www.smartbuyglasses.co.uk" }, { "http://www.smartbuyglasses.de" },
                { "http://www.smartbuyglasses.nl" }, { "http://www.smartbuyglasses.co.za" }, { "http://www.smartbuyglasses.ie" },
                { "http://www.smartbuyglasses.se" }, { "http://www.smartbuyglasses.gr" }, { "http://www.smartbuyglasses.com.sg" },
                { "http://es.smartbuyglasses.com" }, { "http://en.smartbuyglasses.com.hk" }, { "http://scn.smartbuyglasses.com.hk" },
                { "http://en.smartbuyglasses.com.tw" }, { "http://scn.smartbuyglasses.com.tw" }, { "http://scn.smartbuyglasses.com.sg" },
                { "http://tcn.smartbuyglasses.com.sg" }, { "http://fr.smartbuyglasses.ca" }, { "http://www.easylunettes.fr" },
                { "http://www.smartbuyglasses.ch" }, { "http://www.smartbuyglasses.be" }, { "http://www.smartbuyglasses.at" },
                { "http://fr.smartbuyglasses.be" }, { "http://en.smartbuyglasses.ch" }, { "http://fr.smartbuyglasses.ch" }, { "http://en.smartbuyglasses.be" },
                { "http://www.oculosworld.com.br" }, { "http://www.gafasworld.es" }, { "http://www.smartbuyglasses.dk" }, { "http://www.smartbuyglasses.it" },
                { "http://www.oculosworld.com.pt" }, { "http://www.smartbuyglasses.fi" }, { "http://www.sbg.co.kr" }, { "http://www.smartbuyglasses.cz" },
                { "http://www.lentesworld.com.mx" }, { "http://www.gafasworld.com.co" }, { "http://www.smartbuyglasses.no" },
                { "http://www.visiondirecta.cl" }, { "http://www.optikaworld.ru" }, { "http://www.optykaworld.pl" }, { "http://www.smartbuyglasses.com.tr" },
                { "http://www.smartbuyglasses.com.my" }, { "http://www.smartbuyglasses.com.vn" }, { "http://www.smartbuyglasses.co.id" },
                { "http://www.smartbuyglasses.com.ar" } };
    }

    /**
     * all url sum total is 51 . check it payment picture
     */
    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "pay" }, priority = 2)
    public void payPicture(String url) {
        // getURL(AbstractBasePage.getLoginRequest(url + "/"));
        Header header = new Header();
        // switch (url) {
        // case "http://es.smartbuyglasses.com":
        // case "http://www.smartbuyglasses.com.ar":
        // case "http://www.visiondirecta.cl":
        // case "http://www.gafasworld.com.co":
        // case "http://www.lentesworld.com.mx":
        // getURL(url + "/lentes-de-sol-de-diseño/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        // break;
        // case "http://fr.smartbuyglasses.ca":
        // case "http://fr.smartbuyglasses.be":
        // case "http://fr.smartbuyglasses.ch":
        // getURL(url + "/lunettes-de-soleil-design/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        // break;
        // default:
        // getURL(url + "/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html");
        // break;
        // }
        getURL(url);
        header.deleteHead();
        header.deleteLetTalk();
        HomePage homePage = new HomePage();
        header.JsMouse(homePage.linkSunNo1);
        homePage.linkSunNo1.click();
        // co.in is fail in 219
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.acceptAlert();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();
        // /
        String cart = detailPage.getCartType();
        //
        if (cart.equals("new")) {
            // XXX new cart
            NewCartPage newCartPage = new NewCartPage();
            newCartPage.waitForVisibility(newCartPage.btnCheckout, 5);
            newCartPage.deleteLetTalk();
            newCartPage.btnCheckout.click();
            NewCheckoutPage checkoutPage = new NewCheckoutPage();
            checkoutPage.inputBillingFirstName.sendKeys("jack");
            checkoutPage.inputBillingLastName.sendKeys("zhong");
            checkoutPage.inputBillingEmail.sendKeys("jack.zhong@motionglobal.com");
            checkoutPage.inputBillingTelephone.sendKeys("15962626262");
            checkoutPage.inputBillingAddress1.sendKeys("xuhuiqu");
            checkoutPage.inputBillingCity.sendKeys("shanghai");
            checkoutPage.inputBillingPostCode.sendKeys("200000");
            switch (url.split("\\.")[url.split("\\.").length - 1]) {
            case "sg":
            case "ch":
            case "be":
            case "at":
            case "de":
                checkoutPage.selectCountry("DE");
                checkoutPage.sendkeyState();
                break;
            case "nl":
                checkoutPage.selectCountry("NL");
                checkoutPage.sendkeyState();
                break;
            case "za":
                checkoutPage.selectCountry("ZA");
                checkoutPage.sendkeyState();
                break;
            case "br":
                checkoutPage.selectCountry("BR");
                checkoutPage.selectState("Alagoas");
                break;
            case "au":
                checkoutPage.selectCountry("AU");
                checkoutPage.sendkeyState();
                break;
            default:
                if (!(url.split("\\.")[url.split("\\.").length - 1].equals("hk"))) {
                    checkoutPage.selectCountry("US");
                    checkoutPage.selectState("Alaska");
                }
                break;
            }
            checkoutPage.btnPayment.click();
            //
            switch (url.split("\\.")[url.split("\\.").length - 1]) {
            case "mx":
            case "co":
            case "ar":
            case "cl":
                checkoutPage.AssertPayPicture(url, 1, 3);
                break;
            case "nz":
            case "pt":
            case "pl":
            case "tr":
                checkoutPage.AssertPayPicture(url, 1, 2, 3);
                break;
            case "za":
                // checkoutPage.AssertPayPicture(url, 1, 2, 3, 11);
                checkoutPage.AssertPayPicture(url, 1, 3, 11);
                break;
            case "ru":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 849, 841);
                break;
            case "ca":
                if (url.split("\\.")[1].equals("fr")) {
                    checkoutPage.AssertPayPicture(url, 1, 3, 122, 125);
                }
                else {
                    checkoutPage.AssertPayPicture(url, 1, 3, 122);
                }
                break;
            case "es":
            case "info":
            case "my":
            case "vn":
            case "id":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 125);
                break;
            case "no":
                // checkoutPage.AssertPayPicture(url, 1, 2, 3, 125);
                checkoutPage.AssertPayPicture(url, 1, 2, 3);
                break;
            case "dk":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 123);
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
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122);
                break;
            case "sg":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 810);
                break;
            case "nl":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 809, 122);
                break;
            case "de":
            case "ch":
            case "be":
            case "at":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 836);
                break;
            case "com":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 125);
                break;
            case "in":
                // checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 125);
                checkoutPage.AssertPayPicture(url, 1, 3, 122, 125);
                break;
            case "br":
                checkoutPage.AssertPayPicture(url, 1, 3, 125, 1503);
                break;
            case "fi":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 802);
                break;
            case "au":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 125, 11);
                break;
            case "jp":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 125, 1504);
                break;
            case "uk":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 836, 125, 117);
                break;
            default:
                Assert.assertEquals(1, 2);
                break;
            }
        }
        else {
            // XXX old cart
            CartPage cartPage = new CartPage();
            cartPage.waitForVisibility(cartPage.btnCheckout, 5);
            cartPage.btnCheckout.click();
            //
            CheckoutPage checkoutPage = new CheckoutPage();
            switch (url.split("\\.")[url.split("\\.").length - 1]) {
            case "mx":
            case "co":
            case "ar":
            case "cl":
                checkoutPage.AssertPayPicture(url, 1, 3);
                break;
            case "nz":
            case "pt":
            case "pl":
            case "tr":
                checkoutPage.AssertPayPicture(url, 1, 2, 3);
                break;
            case "za":
                // checkoutPage.AssertPayPicture(url, 1, 2, 3, 15);
                checkoutPage.AssertPayPicture(url, 1, 3, 15);
                break;
            case "ru":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 16, 17);
                break;
            case "ca":
                if (url.split("\\.")[0].equals("http://fr")) {
                    checkoutPage.AssertPayPicture(url, 1, 3, 5, 9);
                }
                else {
                    checkoutPage.AssertPayPicture(url, 1, 3, 5);
                }
                break;
            case "es":
            case "info":
            case "my":
            case "vn":
            case "id":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 9);
                break;
            case "no":
                checkoutPage.AssertPayPicture(url, 1, 2, 3);
                break;
            case "dk":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 13);
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
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5);
                break;
            case "sg":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 11);
                break;
            case "nl":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 4, 5);
                break;
            case "de":
            case "ch":
            case "be":
            case "at":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 7);
                break;
            case "com":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 9);
                break;
            case "in":
                // checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 9);
                checkoutPage.AssertPayPicture(url, 1, 3, 5, 9);
                break;
            case "br":
                checkoutPage.AssertPayPicture(url, 1, 3, 9, 12);
                break;
            case "fi":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 19);
                break;
            case "au":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 9, 15);
                break;
            case "jp":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 9, 20);
                break;
            case "uk":
                checkoutPage.AssertPayPicture(url, 1, 2, 3, 5, 7, 9, 18);
                break;
            default:
                Assert.assertEquals(1, 2, " Domain No't Exist !!!");
                break;
            }
        }
        if (url == "http://www.smartbuyglasses.com.ar") {
            new VerifyUtil().verifyEnd();
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
