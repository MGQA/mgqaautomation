package com.motionglobal.testcases.sbg.desktop.smoke;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.checkout.CheckoutPage;
import com.motionglobal.pages.sbg.desktop.payment3rdparty.PaypalPage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestPaypalForAR extends AbstractBaseSbgDesktopTestCase {

    /**
     * ar : paypal blank
     */
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void paypalAR() {
        String url = "http://www.smartbuyglasses.com.ar/lentes-de-sol-de-dise%C3%B1o/D&G/D&G-DD3065/S-1870/8G-116377.html";
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.com.ar/"));
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();

        // cartpage click paypal
        CartPage cartPage = new CartPage();
        cartPage.waitForVisibility(cartPage.paypalBtn, 5);
        cartPage.paypalBtn.click();
        PaypalPage paypalPage = new PaypalPage();
        Assert.assertNotNull(paypalPage.paypalContentDisplay);
    }

    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void UKPayMethod() {
        String url = "http://www.smartbuyglasses.co.uk/designer-sunglasses/Gucci/Gucci-GG-3500/S-WNQ/02-108457.html";
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.co.uk/"));
        getURL(url);
        ProductDetailPage detailPage = new ProductDetailPage();
        detailPage.waitForVisibility(detailPage.btnBuyNow, 5);
        detailPage.btnBuyNow.click();

        // cartpage click paypal
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

    //
    /**
     * assert use 1-20 is card name(payment_product_id) , table from gc_payment_product
     */
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void testSQL() {
        // US
        String US = "1";
        String USpay = getID(US);
        Assert.assertEquals(USpay, "12359");
        // AU
        String AU = "2";
        String AUpay = getID(AU);
        Assert.assertEquals(AUpay, "12359");
        // CN
        String CN = "5";
        String CNpay = getID(CN);
        Assert.assertEquals(CNpay, "1235");
        // CA
        String CA = "6";
        String CApay = getID(CA);
        Assert.assertEquals(CApay, "135");
        // NZ
        String NZ = "7";
        String NZpay = getID(NZ);
        Assert.assertEquals(NZpay, "123");
        // JP
        String JP = "8";
        String JPpay = getID(JP);
        Assert.assertEquals(JPpay, "1235920");
        // HK
        String HK = "9";
        String HKpay = getID(HK);
        Assert.assertEquals(HKpay, "1235");
        // TW
        String TW = "10";
        String TWpay = getID(TW);
        Assert.assertEquals(TWpay, "1235");
        // GB/UK
        String GB = "11";
        String GBpay = getID(GB);
        Assert.assertEquals(GBpay, "12357918");
        // DE
        String DE = "12";
        String DEpay = getID(DE);
        Assert.assertEquals(DEpay, "12357");
        // EU
        String EU = "13";
        String EUpay = getID(EU);
        Assert.assertEquals(EUpay, "1235");
        // NL
        String NL = "14";
        String NLpay = getID(NL);
        Assert.assertEquals(NLpay, "12345");
        // ES 15 skip to 49
        String ES = "49";
        String ESpay = getID(ES);
        Assert.assertEquals(ESpay, "1239");
        // ZA
        String ZA = "18";
        String ZApay = getID(ZA);
        Assert.assertEquals(ZApay, "12315");
        // IE
        String IE = "21";
        String IEpay = getID(IE);
        Assert.assertEquals(IEpay, "1235");
        // SE
        String SE = "22";
        String SEpay = getID(SE);
        Assert.assertEquals(SEpay, "1235");
        // GR
        String GR = "23";
        String GRpay = getID(GR);
        Assert.assertEquals(GRpay, "1235");
        // SG
        String SG = "24";
        String SGpay = getID(SG);
        Assert.assertEquals(SGpay, "123511");
        // US ES..COM
        String US2 = "29";
        String US2pay = getID(US2);
        Assert.assertEquals(US2pay, "12359");
        // CN EN..CN
        String CN2 = "30";
        String CN2pay = getID(CN2);
        Assert.assertEquals(CN2pay, "1235");
        // HK EN..HK
        String HK2 = "32";
        String HK2pay = getID(HK2);
        Assert.assertEquals(HK2pay, "1235");
        // HK SCN..HK
        String HK3 = "33";
        String HK3pay = getID(HK3);
        Assert.assertEquals(HK3pay, "1235");
        // TW EN...TW
        String TW2 = "34";
        String TW2pay = getID(TW2);
        Assert.assertEquals(TW2pay, "1235");
        // CA FR...CA
        String CA2 = "38";
        String CA2pay = getID(CA2);
        Assert.assertEquals(CA2pay, "1359");
        // FR
        String FR = "39";
        String FRpay = getID(FR);
        Assert.assertEquals(FRpay, "1235");
        // CH
        String CH = "40";
        String CHpay = getID(CH);
        Assert.assertEquals(CHpay, "12357");
        // BE
        String BE = "41";
        String BEpay = getID(BE);
        Assert.assertEquals(BEpay, "12357");
        // AT
        String AT = "42";
        String ATpay = getID(AT);
        Assert.assertEquals(ATpay, "12357");
        // BE FR...BE
        String BE2 = "43";
        String BE2pay = getID(BE2);
        Assert.assertEquals(BE2pay, "12357");
        // CH EN...CH
        String CH2 = "44";
        String CH2pay = getID(CH2);
        Assert.assertEquals(CH2pay, "12357");
        // CH FR...CH
        String CH3 = "45";
        String CH3pay = getID(CH3);
        Assert.assertEquals(CH3pay, "12357");
        // BE EN...BE
        String BE3 = "46";
        String BE3pay = getID(BE3);
        Assert.assertEquals(BE3pay, "12357");
        // BR
        String BR = "48";
        String BRpay = getID(BR);
        Assert.assertEquals(BRpay, "13912");
        // DK
        String DK = "51";
        String DKpay = getID(DK);
        Assert.assertEquals(DKpay, "123513");
        // IT
        String IT = "56";
        String ITpay = getID(IT);
        Assert.assertEquals(ITpay, "1235");
        // PT
        String PT = "57";
        String PTpay = getID(PT);
        Assert.assertEquals(PTpay, "123");
        // FI
        String FI = "58";
        String FIpay = getID(FI);
        Assert.assertEquals(FIpay, "123519");
        // KR
        String KR = "59";
        String KRpay = getID(KR);
        Assert.assertEquals(KRpay, "1235");
        // CZ
        String CZ = "60";
        String CZpay = getID(CZ);
        Assert.assertEquals(CZpay, "1235");
        // MX
        String MX = "61";
        String MXpay = getID(MX);
        Assert.assertEquals(MXpay, "13");
        // CO
        String CO = "62";
        String COpay = getID(CO);
        Assert.assertEquals(COpay, "13");
        // AR 63 skip to 74
        String AR = "74";
        String ARpay = getID(AR);
        Assert.assertEquals(ARpay, "13");
        // NO
        String NO = "64";
        String NOpay = getID(NO);
        Assert.assertEquals(NOpay, "1239");
        // CL
        String CL = "66";
        String CLpay = getID(CL);
        Assert.assertEquals(CLpay, "13");
        // RU
        String RU = "67";
        String RUpay = getID(RU);
        Assert.assertEquals(RUpay, "1231617");
        // PL
        String PL = "68";
        String PLpay = getID(PL);
        Assert.assertEquals(PLpay, "123");
        // TR
        String TR = "69";
        String TRpay = getID(TR);
        Assert.assertEquals(TRpay, "123");
        // MY
        String MY = "70";
        String MYpay = getID(MY);
        Assert.assertEquals(MYpay, "1239");
        // VN
        String VN = "71";
        String VNpay = getID(VN);
        Assert.assertEquals(VNpay, "1239");
        // ID
        String ID = "73";
        String IDpay = getID(ID);
        Assert.assertEquals(IDpay, "1239");
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
