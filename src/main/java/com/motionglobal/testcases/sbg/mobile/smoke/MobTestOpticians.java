package com.motionglobal.testcases.sbg.mobile.smoke;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobNewOpticianPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * m.com Test option ≈‰æµ
 * 
 */
public class MobTestOpticians extends AbstractBaseTestCase {

    @Test(groups = { "debug2", "smoke", "fastsmoke" })
    public void opticianPage() {
        String url = "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html";
        getURL(url);
        MobProductDetailPage productDetailPage = new MobProductDetailPage();
        productDetailPage.addLens.click();
        // try {
        MobNewOpticianPage opticianPage = new MobNewOpticianPage();
        opticianPage.waitForVisibility(opticianPage.priceTotal, 5);
        double priceFrame = opticianPage.regexGetDouble(opticianPage.priceFrame.getText());
        double buyFrame = opticianPage.regexGetDouble(opticianPage.buyFrame.getText());
        double priceLens = opticianPage.regexGetDouble(opticianPage.priceLens.getText());
        double actualTotal = opticianPage.regexGetDouble(opticianPage.priceTotal.getText());
        double expectTotal = opticianPage.mathAdd(priceFrame, priceLens);
        opticianPage.AsssetEquals(actualTotal, expectTotal);
        opticianPage.AsssetEquals(priceFrame, buyFrame);
        opticianPage.waitForVisibility(opticianPage.btnContinue, 5);
        opticianPage.JsMouse(opticianPage.btnContinue);
        opticianPage.btnContinue.click();
        // }
        // catch (Exception e) {
        // // old RX
        // MobOpticianPage opticianPage = new MobOpticianPage();
        // opticianPage.distance.click();
        // opticianPage.selectDegree(opticianPage.rightSPH, "-4.50");
        // opticianPage.selectDegree(opticianPage.rightCYL, "+4.75");
        // opticianPage.selectDegree(opticianPage.rightAX, "1");
        // //
        // opticianPage.selectDegree(opticianPage.leftSPH, "-4.50");
        // opticianPage.selectDegree(opticianPage.leftCYL, "+4.75");
        // opticianPage.selectDegree(opticianPage.leftAX, "1");
        // opticianPage.checkBox.click();
        // opticianPage.continueBtn.click();
        // }
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
