package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.cart.CartPage;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.pages.sbg.desktop.product.RX2Page;
import com.motionglobal.testcases.AbstractBaseTestCase;

/**
 * au Test £ºRX
 * 
 */
public class TestOpticians extends AbstractBaseTestCase {

    // FIXME CASE 1
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void ABRX() {
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
        String RX = "";
        RX2Page buyNow = null;
        try {
            // new RX
            header.waitForVisibility(productGridPage.cartBtn, 5);
            RX = "new";
        }
        catch (Exception e) {
            // old RX
            buyNow = new RX2Page();
            RX = "old";
        }
        if (RX.equals("new")) {
            // new RX
            Double framePrice = productGridPage.regexGetDouble(productGridPage.framePrice.getText());
            productGridPage.deluxe.click();
            header.waitForVisibility(productGridPage.deluxeVery, 2);
            productGridPage.deluxeVery.click();
            Double lensePrice = productGridPage.regexGetDouble(productGridPage.lenses_price.getText());
            Assert.assertEquals(productGridPage.regexGetDouble(productGridPage.frame_price.getText()), framePrice);
            Assert.assertEquals(productGridPage.regexGetDouble(productGridPage.deluxeVeryPriece.getText()), lensePrice);
            double price = productGridPage.mathAdd(lensePrice, framePrice);
            Assert.assertEquals(productGridPage.regexGetDouble(productGridPage.total_price.getText()), price);
        }
        else {
            // old RX
            WebDriverWait wait = new WebDriverWait(driver, 5);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //
            buyNow.lensTypeImg01.click();
            buyNow.waitForVisibility(buyNow.confirmEnter, 8);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            header.waitForVisibility(buyNow.UpLoadPre, 10);
            checkBtnClicked(buyNow.UpLoadPre);
            // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            checkBtnClicked(buyNow.sendLater);
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            checkBtnClicked(buyNow.lensEnter);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            buyNow.clickEditBtn();
            //
            buyNow.lensTypeImg02.click();
            buyNow.waitForVisibility(buyNow.confirmEnter, 8);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            header.waitForVisibility(buyNow.UpLoadPre, 10);
            checkBtnClicked(buyNow.UpLoadPre);
            // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            checkBtnClicked(buyNow.sendLater);
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            checkBtnClicked(buyNow.lensEnter);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            buyNow.clickEditBtn();
            //
            buyNow.lensTypeImg03.click();
            buyNow.waitForVisibility(buyNow.confirmEnter, 8);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            header.waitForVisibility(buyNow.UpLoadPre, 10);
            checkBtnClicked(buyNow.UpLoadPre);
            // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            checkBtnClicked(buyNow.sendLater);
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            checkBtnClicked(buyNow.lensEnter);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            buyNow.clickEditBtn();
            //
            buyNow.lensTypeImg04.click();
            buyNow.waitForVisibility(buyNow.confirmEnter, 8);
            Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
            header.waitForVisibility(buyNow.UpLoadPre, 10);
            checkBtnClicked(buyNow.UpLoadPre);
            // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
            Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
            header.waitForVisibility(buyNow.sendLater, 5);
            checkBtnClicked(buyNow.sendLater);
            Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
            header.waitForVisibility(buyNow.lensEnter, 5);
            checkBtnClicked(buyNow.lensEnter);
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
            checkInputClicked(buyNow.Dgold);
            Assert.assertTrue(buyNow.isPriceEqual());
            // checkInputClicked(buyNow.Dplatinum);
            // Assert.assertTrue(buyNow.isPriceEqual());
            checkInputClicked(buyNow.Dsilver);
            Assert.assertTrue(buyNow.isPriceEqual());
            header.waitForVisibility(buyNow.premium, 5);
            js.executeScript("arguments[0].click();", buyNow.premium);
            // buyNow.premium.click();
            checkInputClicked(buyNow.Pgold);
            Assert.assertTrue(buyNow.isPriceEqual());
            // checkInputClicked(buyNow.Pplatinum);
            // Assert.assertTrue(buyNow.isPriceEqual());
            checkInputClicked(buyNow.Psilver);
            Assert.assertTrue(buyNow.isPriceEqual());
            buyNow.waitForVisibility(buyNow.addToCarBtn, 5);
            buyNow.addToCarBtn.click();
            CartPage cartPage = new CartPage();
        }
    }

    // FIXME CASE 2 RX2 stale
    @Test(groups = { "debug", "smoke", "fastsmoke" })
    public void RX2() {
        // String url = "http://www.smartbuyglasses.dk/designer-eyeglasses/Tom-Ford/Tom-Ford-FT5323-002-254012.html";
        // getURL(url);
        // Header header = new Header();
        // ProductDetailPage detailPage = new ProductDetailPage();
        // header.waitForVisibility(detailPage.btnBuyNow, 2);
        // detailPage.btnBuyNow.click();
        // //
        // RX2Page buyNow = new RX2Page();
        // try {
        // buyNow.deleteHead();
        // buyNow.deleteLetTalk();
        // }
        // catch (Exception e) {
        // }
        // // old RX
        // WebDriverWait wait = new WebDriverWait(driver, 5);
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // //
        // // buyNow.lensTypeImg01.click();
        // // buyNow.waitForVisibility(buyNow.confirmEnter, 8);
        // // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // // header.waitForVisibility(buyNow.UpLoadPre, 10);
        // // checkBtnClicked(buyNow.UpLoadPre);
        // // // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
        // // Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
        // // header.waitForVisibility(buyNow.sendLater, 5);
        // // checkBtnClicked(buyNow.sendLater);
        // // Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
        // // header.waitForVisibility(buyNow.lensEnter, 5);
        // // checkBtnClicked(buyNow.lensEnter);
        // // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // // buyNow.clickEditBtn();
        // // //
        // // buyNow.lensTypeImg02.click();
        // // buyNow.waitForVisibility(buyNow.confirmEnter, 8);
        // // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // // header.waitForVisibility(buyNow.UpLoadPre, 10);
        // // checkBtnClicked(buyNow.UpLoadPre);
        // // // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
        // // Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
        // // header.waitForVisibility(buyNow.sendLater, 5);
        // // checkBtnClicked(buyNow.sendLater);
        // // Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
        // // header.waitForVisibility(buyNow.lensEnter, 5);
        // // checkBtnClicked(buyNow.lensEnter);
        // // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // // buyNow.clickEditBtn();
        // // //
        // // buyNow.lensTypeImg03.click();
        // // buyNow.waitForVisibility(buyNow.confirmEnter, 8);
        // // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // // header.waitForVisibility(buyNow.UpLoadPre, 10);
        // // checkBtnClicked(buyNow.UpLoadPre);
        // // // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
        // // Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
        // // header.waitForVisibility(buyNow.sendLater, 5);
        // // checkBtnClicked(buyNow.sendLater);
        // // Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
        // // header.waitForVisibility(buyNow.lensEnter, 5);
        // // checkBtnClicked(buyNow.lensEnter);
        // // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // // buyNow.clickEditBtn();
        // //
        // buyNow.lensTypeImg04.click();
        // buyNow.waitForVisibility(buyNow.confirmEnter, 8);
        // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // header.waitForVisibility(buyNow.UpLoadPre, 10);
        // checkBtnClicked(buyNow.UpLoadPre);
        // // js.executeScript("arguments[0].click();", buyNow.UpLoadPre);
        // Assert.assertTrue(buyNow.UpLoadBtn.isDisplayed());
        // header.waitForVisibility(buyNow.sendLater, 5);
        // checkBtnClicked(buyNow.sendLater);
        // Assert.assertTrue(buyNow.confirmSendLater.isDisplayed());
        // header.waitForVisibility(buyNow.lensEnter, 5);
        // checkBtnClicked(buyNow.lensEnter);
        // Assert.assertTrue(buyNow.confirmEnter.isDisplayed());
        // //
        // buyNow.selectDegree(buyNow.rightSPH, "-4.50");
        // buyNow.selectDegree(buyNow.rightCYL, "+4.75");
        // buyNow.selectDegree(buyNow.rightAX, "1");
        // buyNow.selectDegree(buyNow.rightADD, "0.75");
        // //
        // buyNow.selectDegree(buyNow.leftSPH, "-4.50");
        // buyNow.selectDegree(buyNow.leftCYL, "+4.75");
        // buyNow.selectDegree(buyNow.leftAX, "1");
        // buyNow.selectDegree(buyNow.leftADD, "0.75");
        // buyNow.confirmEnter.click();
        // //
        // js.executeScript("arguments[0].click();", buyNow.lensTypeImg05);
        // // js.executeScript("arguments[0].scrollIntoView();", header.getMegaMenuMainElement(1));
        // // wait.until(ExpectedConditions.elementToBeClickable(buyNow.lensTypeImg05));
        // // buyNow.lensTypeImg05.click();
        //
        // //
        // header.waitForVisibility(buyNow.deluxe, 5);
        // js.executeScript("arguments[0].click();", buyNow.deluxe);
        // header.waitForVisibility(buyNow.Dgold, 2);
        // new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(buyNow.Dgold));
        // checkInputClicked(buyNow.Dgold);
        // Assert.assertTrue(buyNow.isPriceEqual());
        // // checkInputClicked(buyNow.Dplatinum);
        // // Assert.assertTrue(buyNow.isPriceEqual());
        // checkInputClicked(buyNow.Dsilver);
        // Assert.assertTrue(buyNow.isPriceEqual());
        // header.waitForVisibility(buyNow.premium, 5);
        // js.executeScript("arguments[0].click();", buyNow.premium);
        // // buyNow.premium.click();
        // checkInputClicked(buyNow.Pgold);
        // Assert.assertTrue(buyNow.isPriceEqual());
        // // checkInputClicked(buyNow.Pplatinum);
        // // Assert.assertTrue(buyNow.isPriceEqual());
        // checkInputClicked(buyNow.Psilver);
        // Assert.assertTrue(buyNow.isPriceEqual());
        // buyNow.waitForVisibility(buyNow.addToCarBtn, 5);
        // buyNow.addToCarBtn.click();
        // CartPage cartPage = new CartPage();

    }

    // FIXME CASE 3
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" }, priority = 2)
    public void addMyselfPrescription() {
        // getURL(AbstractBasePage.getLoginRequest("https://www.smartbuyglasses.dk/"));
        // String url = "http://www.smartbuyglasses.dk/designer-eyeglasses/Tom-Ford/Tom-Ford-FT5323-002-254012.html";
        // getURL(url);
        // Header header = new Header();
        // ProductDetailPage detailPage = new ProductDetailPage();
        // header.waitForVisibility(detailPage.btnBuyNow, 2);
        // detailPage.btnBuyNow.click();
        // //
        // RX2Page rx = new RX2Page();
        // try {
        // rx.deleteHead();
        // rx.deleteLetTalk();
        // }
        // catch (Exception e) {
        // }
        // rx.lensTypeImg03.click();
        // new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(rx.lensTypeImg03)));
        // rx.waitForVisibility(rx.confirmEnter, 8);
        // // old RX
        // for (int i = 0; i < 30; i++) {
        // rx.waitForVisibility(rx.addPreInfo, 5);
        // try {
        // rx.addPreInfo.click();
        // if (rx.preDetail.getAttribute("data-display").equals("0")) {
        // break;
        // }
        // else {
        // Thread.sleep(200);
        // }
        // }
        // catch (Exception e) {
        // try {
        // Thread.sleep(200);
        // }
        // catch (InterruptedException e1) {
        // e1.printStackTrace();
        // }
        // }
        // }
        // rx.waitForVisibility(rx.btnSelectPre, 5);
        // rx.btnSelectPre.click();
        // header.waitForVisibility(rx.Pgold, 5);
        // checkInputClicked(rx.Pgold);
        // rx.waitForVisibility(rx.addToCarBtn, 5);
        // rx.addToCarBtn.click();
        // CartPage cartPage = new CartPage();
    }

    // private Method
    private void checkBtnClicked(WebElement element) {
        Header header = new Header();
        for (int i = 0; i < 30; i++) {
            if (element.getAttribute("style").equals("opacity: 1;")) {
                break;
            }
            else {
                try {
                    Thread.sleep(200);
                    header.waitForVisibility(element, 5);
                    new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
                    try {
                        element.click();
                        Thread.sleep(100);
                    }
                    catch (Exception e) {
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkInputClicked(WebElement element) {
        Header header = new Header();
        for (int i = 0; i < 50; i++) {
            if (element.getAttribute("checked") != null) {
                break;
            }
            else {
                try {
                    Thread.sleep(200);
                    header.waitForVisibility(element, 5);
                    new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
                    try {
                        element.click();
                        Thread.sleep(100);
                    }
                    catch (Exception e) {
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
