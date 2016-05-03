package com.motionglobal.testcases.sbg.desktop.smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class DebugTest extends AbstractBaseTestCase {

    @Test(groups = { "!debug1" })
    public void buyNow() throws InterruptedException {
        driver.get("http://www.smartbuyglasses.com/designer-eyeglasses/TODS/");
        Header header = new Header();
        ProductGridPage productGridPage = new ProductGridPage();
        for (int i = 0; i < 30; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (i < 3)
                js.executeScript("arguments[0].scrollIntoView();", header.getMegaMenuMainElement(1));
            if ((i + 1) % 3 != 0 && (i + 1) > 3)
                js.executeScript("arguments[0].scrollIntoView();", productGridPage.proInfo.get(i - 3));
            if ((i + 1) % 3 == 0)
                js.executeScript("arguments[0].scrollIntoView();", productGridPage.proInfo.get(i + 3));
            header.mouseOver(productGridPage.proInfo.get(i));
            productGridPage.quickView.click();
            if (productGridPage.eyeproSize.size() > 1) {
                productGridPage.quickView.click();
                productGridPage.eyeproSize.get(1).click();
                Assert.assertTrue(productGridPage.sizeClicked.isDisplayed(), "size button don't click");
                productGridPage.eyeproSize.get(0).click();
                Assert.assertTrue(productGridPage.sizeClicked.isDisplayed(), "size button don't click");
                break;
            }
        }
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void tearDown() {

    }
}
