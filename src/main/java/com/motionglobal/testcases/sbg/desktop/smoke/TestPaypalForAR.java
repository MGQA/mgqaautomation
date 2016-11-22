package com.motionglobal.testcases.sbg.desktop.smoke;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.common.utils.VerifyUtil;
import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.PaypalPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestPaypalForAR extends AbstractBaseSbgDesktopTestCase {

    /**
     * ar : paypal blank
     */
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void paypalAR() {
        // XXX case 1
        ProductDetailPage detailPage = null;
        try {
            // D & G no sale
            // String url = "http://www.smartbuyglasses.com.ar/lentes-de-sol-de-dise%C3%B1o/D&G/D&G-DD3065/S-1870/8G-116377.html";
            String url = "http://www.smartbuyglasses.com.ar/lentes-de-sol-de-dise%C3%B1o/Dolce-&-Gabbana/Dolce-&-Gabbana-DG2099/S-GYM-10818G-116525.html";
            // url 219
            // String url = "http://www.smartbuyglasses.com.ar/gafas-de-sol-de-diseno/D&G/D&G-DD3065/S-1870/8G-116377.html";
            getURL(url);
            detailPage = new ProductDetailPage();
            detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        }
        catch (Exception e) {
            // D & G no sale
            // String url = "http://www.smartbuyglasses.com.ar/lentes-de-dise%C3%B1o/D&G/D&G-DD1238-501-167081.html";
            String url = "http://www.smartbuyglasses.com.ar/lentes-de-dise%C3%B1o/Dolce-&-Gabbana/Dolce-&-Gabbana-DG5005-Young-&-Coloured-2727-195776.html";
            getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.com.ar/"));
            getURL(url);
            detailPage = new ProductDetailPage();
            detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
            detailPage.btnFrameOnly.click();
        }
        detailPage.btnBuyNow.click();

        // cartpage click paypal
        NewCartPage cartPage = new NewCartPage();
        cartPage.JsMouse(cartPage.paypalBtn);
        cartPage.deleteHead();
        cartPage.paypalBtn.click();
        PaypalPage paypalPage = new PaypalPage();
        Assert.assertNotNull(paypalPage.paypalContentDisplay);
    }

    // XXX 2
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void UKPayMethod() {
        String url = "http://www.smartbuyglasses.co.uk/designer-sunglasses/Maui-Jim/Maui-Jim-Hookipa-polarised-407-02-27194.html";
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.co.uk/"));
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();

        // cartpage click paypal
        String cart = detailPage.getCartType();
        if (cart.equals("old")) {
            CartPage cartPage = new CartPage();
            cartPage.btnCheckout.click();
            CheckoutPage checkoutPage = new CheckoutPage();
            String cardID = "";
            for (int i = 0; i < checkoutPage.cardID.size(); i++) {
                cardID += checkoutPage.cardID.get(i).getAttribute("id");
            }
            System.out.println(cardID);
            checkoutPage.AsssetEquals(
                    cardID,
                    "payment_product_1payment_product_2payment_product_3payment_product_5payment_product_7payment_product_9payment_product_18");
        }
        else {
            // XXX new cart
            NewCartPage newCartPage = new NewCartPage();
            newCartPage.waitForVisibility(newCartPage.btnCheckout, 5);
            newCartPage.btnCheckout.click();
            NewCheckoutPage checkoutPage = new NewCheckoutPage();
            checkoutPage.inputBillingFirstName.sendKeys("jack");
            checkoutPage.inputBillingLastName.sendKeys("zhong");
            checkoutPage.inputBillingEmail.sendKeys("jack.zhong@motionglobal.com");
            checkoutPage.inputBillingTelephone.sendKeys("15962626262");
            checkoutPage.inputBillingAddress1.sendKeys("xuhuiqu");
            checkoutPage.inputBillingCity.sendKeys("shanghai");
            checkoutPage.inputBillingPostCode.sendKeys("200000");
            checkoutPage.selectCountry("US");
            checkoutPage.selectState("Alaska");
            checkoutPage.btnPayment.click();
            //
            checkoutPage.AssertPayPicture(url, 1, 2, 3, 122, 836, 125, 117, 114);
            new VerifyUtil().verifyEnd();
        }
    }

    //
    /**
     * assert use 1-20 is card name(payment_product_id) , table from gc_payment_product
     */
    // XXX case 3
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke", "pay" }, priority = 1)
    public void testSQL() {
        VerifyUtil verify = new Header().VerifyUtil();
        // US
        String US = "1";
        String USpay = getID(US);
        verify.verifyEquals(USpay, "1239", "Fail Country_ID IS :" + US);
        // AU
        String AU = "4";
        String AUpay = getID(AU);
        verify.verifyEquals(AUpay, "123915", "Fail Country_ID IS :" + AU);
        // CN
        String CN = "5";
        String CNpay = getID(CN);
        verify.verifyEquals(CNpay, "1235", "Fail Country_ID IS :" + CN);
        // CA
        String CA = "6";
        String CApay = getID(CA);
        verify.verifyEquals(CApay, "13", "Fail Country_ID IS :" + CA);
        // NZ
        String NZ = "7";
        String NZpay = getID(NZ);
        verify.verifyEquals(NZpay, "1235", "Fail Country_ID IS :" + NZ);
        // JP
        String JP = "8";
        String JPpay = getID(JP);
        verify.verifyEquals(JPpay, "1235920", "Fail Country_ID IS :" + JP);
        // HK
        String HK = "9";
        String HKpay = getID(HK);
        verify.verifyEquals(HKpay, "1235", "Fail Country_ID IS :" + HK);
        // TW
        String TW = "10";
        String TWpay = getID(TW);
        verify.verifyEquals(TWpay, "1235", "Fail Country_ID IS :" + TW);
        // GB/UK
        String GB = "11";
        String GBpay = getID(GB);
        verify.verifyEquals(GBpay, "12357918", "Fail Country_ID IS :" + GB);
        // DE
        String DE = "12";
        String DEpay = getID(DE);
        verify.verifyEquals(DEpay, "12357", "Fail Country_ID IS :" + DE);
        // EU
        String EU = "13";
        String EUpay = getID(EU);
        verify.verifyEquals(EUpay, "1235", "Fail Country_ID IS :" + EU);
        // NL
        String NL = "14";
        String NLpay = getID(NL);
        verify.verifyEquals(NLpay, "12345", "Fail Country_ID IS :" + NL);
        // ES 15 skip to 49
        String ES = "49";
        String ESpay = getID(ES);
        verify.verifyEquals(ESpay, "1239", "Fail Country_ID IS :" + ES);
        // ZA
        String ZA = "18";
        String ZApay = getID(ZA);
        verify.verifyEquals(ZApay, "13515", "Fail Country_ID IS :" + ZA);
        // IE
        String IE = "21";
        String IEpay = getID(IE);
        verify.verifyEquals(IEpay, "123", "Fail Country_ID IS :" + IE);
        // SE
        String SE = "22";
        String SEpay = getID(SE);
        verify.verifyEquals(SEpay, "1235", "Fail Country_ID IS :" + SE);
        // GR
        String GR = "23";
        String GRpay = getID(GR);
        verify.verifyEquals(GRpay, "1235", "Fail Country_ID IS :" + GR);
        // SG
        String SG = "24";
        String SGpay = getID(SG);
        verify.verifyEquals(SGpay, "123511", "Fail Country_ID IS :" + SG);
        // US ES..COM
        String US2 = "29";
        String US2pay = getID(US2);
        verify.verifyEquals(US2pay, "12359", "Fail Country_ID IS :" + US2);
        // CN EN..CN
        String CN2 = "30";
        String CN2pay = getID(CN2);
        verify.verifyEquals(CN2pay, "1235", "Fail Country_ID IS :" + CN2);
        // HK EN..HK
        String HK2 = "32";
        String HK2pay = getID(HK2);
        verify.verifyEquals(HK2pay, "1235", "Fail Country_ID IS :" + HK2);
        // HK SCN..HK
        String HK3 = "33";
        String HK3pay = getID(HK3);
        verify.verifyEquals(HK3pay, "1235", "Fail Country_ID IS :" + HK3);
        // TW EN...TW
        String TW2 = "34";
        String TW2pay = getID(TW2);
        verify.verifyEquals(TW2pay, "1235", "Fail Country_ID IS :" + TW2);
        // CA FR...CA
        String CA2 = "38";
        String CA2pay = getID(CA2);
        verify.verifyEquals(CA2pay, "1359", "Fail Country_ID IS :" + CA2);
        // FR
        String FR = "39";
        String FRpay = getID(FR);
        verify.verifyEquals(FRpay, "1235", "Fail Country_ID IS :" + FR);
        // CH
        String CH = "40";
        String CHpay = getID(CH);
        verify.verifyEquals(CHpay, "12357", "Fail Country_ID IS :" + CH);
        // BE
        String BE = "41";
        String BEpay = getID(BE);
        verify.verifyEquals(BEpay, "12357", "Fail Country_ID IS :" + BE);
        // AT
        String AT = "42";
        String ATpay = getID(AT);
        verify.verifyEquals(ATpay, "12357", "Fail Country_ID IS :" + AT);
        // BE FR...BE
        String BE2 = "43";
        String BE2pay = getID(BE2);
        verify.verifyEquals(BE2pay, "12357", "Fail Country_ID IS :" + BE2);
        // CH EN...CH
        String CH2 = "44";
        String CH2pay = getID(CH2);
        verify.verifyEquals(CH2pay, "12357", "Fail Country_ID IS :" + CH2);
        // CH FR...CH
        String CH3 = "45";
        String CH3pay = getID(CH3);
        verify.verifyEquals(CH3pay, "12357", "Fail Country_ID IS :" + CH3);
        // BE EN...BE
        String BE3 = "46";
        String BE3pay = getID(BE3);
        verify.verifyEquals(BE3pay, "12357", "Fail Country_ID IS :" + BE3);
        // BR
        String BR = "48";
        String BRpay = getID(BR);
        verify.verifyEquals(BRpay, "13912", "Fail Country_ID IS :" + BR);
        // DK
        String DK = "51";
        String DKpay = getID(DK);
        verify.verifyEquals(DKpay, "123513", "Fail Country_ID IS :" + DK);
        // IT
        String IT = "56";
        String ITpay = getID(IT);
        verify.verifyEquals(ITpay, "1235", "Fail Country_ID IS :" + IT);
        // PT
        String PT = "57";
        String PTpay = getID(PT);
        verify.verifyEquals(PTpay, "123", "Fail Country_ID IS :" + PT);
        // FI
        String FI = "58";
        String FIpay = getID(FI);
        verify.verifyEquals(FIpay, "123519", "Fail Country_ID IS :" + FI);
        // KR
        String KR = "59";
        String KRpay = getID(KR);
        verify.verifyEquals(KRpay, "1235", "Fail Country_ID IS :" + KR);
        // CZ
        String CZ = "60";
        String CZpay = getID(CZ);
        verify.verifyEquals(CZpay, "1235", "Fail Country_ID IS :" + CZ);
        // MX
        String MX = "61";
        String MXpay = getID(MX);
        verify.verifyEquals(MXpay, "135", "Fail Country_ID IS :" + MX);
        // CO
        String CO = "62";
        String COpay = getID(CO);
        verify.verifyEquals(COpay, "13", "Fail Country_ID IS :" + CO);
        // AR 63 skip to 74
        String AR = "74";
        String ARpay = getID(AR);
        verify.verifyEquals(ARpay, "13", "Fail Country_ID IS :" + AR);
        // NO
        String NO = "64";
        String NOpay = getID(NO);
        verify.verifyEquals(NOpay, "1235", "Fail Country_ID IS :" + NO);
        // CL
        String CL = "66";
        String CLpay = getID(CL);
        verify.verifyEquals(CLpay, "13", "Fail Country_ID IS :" + CL);
        // RU
        String RU = "67";
        String RUpay = getID(RU);
        verify.verifyEquals(RUpay, "1231617", "Fail Country_ID IS :" + RU);
        // PL
        String PL = "68";
        String PLpay = getID(PL);
        verify.verifyEquals(PLpay, "1235", "Fail Country_ID IS :" + PL);
        // TR
        String TR = "69";
        String TRpay = getID(TR);
        verify.verifyEquals(TRpay, "123", "Fail Country_ID IS :" + TR);
        // MY
        String MY = "70";
        String MYpay = getID(MY);
        verify.verifyEquals(MYpay, "1239", "Fail Country_ID IS :" + MY);
        // VN
        String VN = "71";
        String VNpay = getID(VN);
        verify.verifyEquals(VNpay, "1239", "Fail Country_ID IS :" + VN);
        // ID
        String ID = "73";
        String IDpay = getID(ID);
        verify.verifyEquals(IDpay, "1239", "Fail Country_ID IS :" + ID);
        verify.verifyEnd();
        //
    }

    private String getID(String countryID) {
        String[][] paymentID = null;
        String ID = "";
        try {
            paymentID = MysqlConnect219Util.getTestData("SELECT payment_product_id FROM gc_payment_country WHERE country_id=" + countryID
                    + " AND allowance=1 ORDER BY country_id , payment_product_id;");
            for (int i = 0; i < paymentID.length; i++) {
                for (int j = 0; j < paymentID[i].length; j++) {
                    ID += paymentID[i][j];
                }
            }
        }
        catch (SQLException e1) {
        }
        return ID;
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
