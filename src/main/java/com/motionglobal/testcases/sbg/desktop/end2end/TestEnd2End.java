package com.motionglobal.testcases.sbg.desktop.end2end;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.cart.NewCartPage;
import com.motionglobal.pages.sbg.desktop.checkout.NewCheckoutPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.product.ProductDetailPage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.pages.sbg.desktop.thankyou.ThankYouPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * HK Test: ËÑË÷ ray ban µ½Ö§¸¶Ò³Ãæ
 */
public class TestEnd2End extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "smoke", "debug", "fastsmoke" })
    public void testSearchItemAndPayByGC() {
        logger().info("started...");
        HomePage homePage = new HomePage();
        homePage.header().inputSearch.sendKeys("ray ban");
        homePage.header().iconSearch.click();
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.resultGrid().getItem(0).click();
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.btnBuyNow.click();
        // new CartPage().btnCheckout.click();
        new NewCartPage().btnCheckout.click();

        NewCheckoutPage checkoutPage = new NewCheckoutPage();

        checkoutPage.inputBillingFirstName.sendKeys("automationFirst");
        checkoutPage.inputBillingLastName.sendKeys("automationLast");
        checkoutPage.inputBillingEmail.sendKeys("testautomation@automation.com");
        checkoutPage.inputBillingTelephone.sendKeys("automationTel");
        checkoutPage.inputBillingAddress1.sendKeys("automationAddress1");

        checkoutPage.btnPayment.click();
        try {
            checkoutPage.VISA.click();
        }
        catch (Exception e) {
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(checkoutPage.orderIFrame));
        checkoutPage.waitForVisibility(checkoutPage.orderSubmit, 20);
        checkoutPage.orderCard.sendKeys("4111111111111111");
        Select selectMM = new Select(checkoutPage.orderMM);
        selectMM.selectByValue("10");
        Select selectYY = new Select(checkoutPage.orderYY);
        selectYY.selectByValue("20");
        checkoutPage.orderSecurity.sendKeys("1111");
        checkoutPage.orderSubmit.click();
        ThankYouPage thankYouPage = new ThankYouPage();
        String sMoneyReward = thankYouPage.reWard.getText().replace("$", "");
        System.out.println(sMoneyReward);
    }

    @Override
    protected void initialize() {
        getURL(CONFIG.getProperty("sbgDesktopURL"));
    }

    @Override
    protected void tearDown() {
    }

}
