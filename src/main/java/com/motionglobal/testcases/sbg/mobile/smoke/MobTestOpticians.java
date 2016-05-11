package com.motionglobal.testcases.sbg.mobile.smoke;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.product.MobOpticianPage;
import com.motionglobal.pages.sbg.mobile.product.MobProductDetailPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestOpticians extends AbstractBaseTestCase {

    @Test(groups = { "debug2", "smoke", "fastsmoke" })
    public void opticianPage() {
        String url = "http://m.smartbuyglasses.com/designer-sunglasses/Ray-Ban/Ray-Ban-RB4165-Justin-852/88-110094.html";
        driver.get(url);
        MobProductDetailPage productDetailPage = new MobProductDetailPage();
        productDetailPage.addLens.click();
        MobOpticianPage opticianPage = new MobOpticianPage();
        opticianPage.distance.click();
        opticianPage.selectDegree(opticianPage.rightSPH, "-4.50");
        opticianPage.selectDegree(opticianPage.rightCYL, "+4.75");
        opticianPage.selectDegree(opticianPage.rightAX, "1");
        //
        opticianPage.selectDegree(opticianPage.leftSPH, "-4.50");
        opticianPage.selectDegree(opticianPage.leftCYL, "+4.75");
        opticianPage.selectDegree(opticianPage.leftAX, "1");
        opticianPage.checkBox.click();
        opticianPage.continueBtn.click();
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
