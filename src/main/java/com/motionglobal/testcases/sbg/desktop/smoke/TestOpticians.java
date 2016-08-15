package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.product.BuyNowPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * au Test £ºRX
 * 
 */
public class TestOpticians extends AbstractBaseTestCase {

    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void Opticians() {
        String url = "http://www.visiondirect.com.au/designer-eyeglasses/Tom-Ford/";
        getURL(url);
        Header header = new Header();
        ProductGridPage productGridPage = new ProductGridPage();
        header.mouseOver(productGridPage.proInfo.get(0));
        header.waitForVisibility(productGridPage.quickView, 2);
        productGridPage.quickView.click();
        productGridPage.waitForVisibility(productGridPage.buyNowButton, 5);
        header.waitForVisibility(productGridPage.buyNowButton, 2);
        productGridPage.buyNowButton.click();
        //
        try {
            // new RX
            Double framePrice = productGridPage.regexGetMath(productGridPage.framePrice.getText());
            header.waitForVisibility(productGridPage.cartBtn, 2);
            productGridPage.deluxe.click();
            header.waitForVisibility(productGridPage.deluxeVery, 2);
            productGridPage.deluxeVery.click();
            Double lensePrice = productGridPage.regexGetMath(productGridPage.lenses_price.getText());
            Assert.assertEquals(productGridPage.regexGetMath(productGridPage.frame_price.getText()), framePrice);
            Assert.assertEquals(productGridPage.regexGetMath(productGridPage.deluxeVeryPriece.getText()), lensePrice);
            double price = AbstractBasePage.mathAdd(lensePrice, framePrice);
            Assert.assertEquals(productGridPage.regexGetMath(productGridPage.total_price.getText()), price);
        }
        catch (Exception e) {
            // old RX
            BuyNowPage buyNow = new BuyNowPage();
            //
            WebDriverWait wait = new WebDriverWait(driver, 5);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //
            buyNow.lensTypeImg01.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            // header.waitForVisibility(buyNow.UpLoadPre, 5);
            // buyNow.UpLoadPre.click();
            js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            buyNow.sendLater.click();
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            buyNow.lensEnter.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            buyNow.clickEditBtn();
            //
            buyNow.lensTypeImg02.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            // header.waitForVisibility(buyNow.UpLoadPre, 5);
            // buyNow.UpLoadPre.click();
            js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            buyNow.sendLater.click();
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            buyNow.lensEnter.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            buyNow.clickEditBtn();
            //
            buyNow.lensTypeImg03.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            // header.waitForVisibility(buyNow.UpLoadPre, 5);
            // buyNow.UpLoadPre.click();
            js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            buyNow.sendLater.click();
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            buyNow.lensEnter.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            buyNow.clickEditBtn();
            //
            buyNow.lensTypeImg04.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            wait.until(ExpectedConditions.elementToBeClickable(buyNow.UpLoadPre));
            js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            buyNow.sendLater.click();
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            buyNow.lensEnter.click();
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            //
            buyNow.selectDegree(buyNow.rightSPH, "-4.50");
            buyNow.selectDegree(buyNow.rightCYL, "+4.75");
            buyNow.selectDegree(buyNow.rightAX, "1");
            buyNow.selectDegree(buyNow.rightADD, "0.75");
            //
            buyNow.selectDegree(buyNow.leftSPH, "-4.50");
            buyNow.selectDegree(buyNow.leftCYL, "+4.75");
            buyNow.selectDegree(buyNow.leftAX, "1");
            buyNow.selectDegree(buyNow.leftADD, "0.75");
            buyNow.confirmEnter.click();
            //
            js.executeScript("arguments[0].click();", buyNow.lensTypeImg05);
            // js.executeScript("arguments[0].scrollIntoView();", header.getMegaMenuMainElement(1));
            // wait.until(ExpectedConditions.elementToBeClickable(buyNow.lensTypeImg05));
            // buyNow.lensTypeImg05.click();
            header.waitForVisibility(buyNow.deluxe, 5);
            js.executeScript("arguments[0].click();", buyNow.deluxe);
            header.waitForVisibility(buyNow.Dgold, 2);
            new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(buyNow.Dgold));
            buyNow.Dgold.click();
            Assert.assertTrue(buyNow.isPriceEqual());
            buyNow.Dplatinum.click();
            Assert.assertTrue(buyNow.isPriceEqual());
            buyNow.Dsilver.click();
            Assert.assertTrue(buyNow.isPriceEqual());
            header.waitForVisibility(buyNow.premium, 5);
            js.executeScript("arguments[0].click();", buyNow.premium);
            // buyNow.premium.click();
            buyNow.Pgold.click();
            Assert.assertTrue(buyNow.isPriceEqual());
            buyNow.Pplatinum.click();
            Assert.assertTrue(buyNow.isPriceEqual());
            buyNow.Psilver.click();
            Assert.assertTrue(buyNow.isPriceEqual());
            buyNow.addToCarBtn.click();
            CartPage cartPage = new CartPage();
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
