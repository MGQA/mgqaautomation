package com.motionglobal.methodbase;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.motionglobal.pages.AbstractBaseContainer;

public class DecideCartType extends AbstractBaseContainer {

    /**
     * XXX judge cart type
     * 
     * @return "new" or "old"
     */
    public String getCartType() {
        String cart = "";
        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(By.id("main-wrapper"));
                cart = "new";
                break;
            }
            catch (Exception e) {
            }
            try {
                driver.findElement(By.cssSelector(".cart_detail"));
                cart = "old";
                break;
            }
            catch (Exception e) {
            }
            try {
                Thread.sleep(200);
            }
            catch (Exception e) {
            }
            if (i == 99) {
                Assert.assertTrue(1 == 2, "Wait 20s, But Page No't Load Finish !!");
            }
        }
        return cart;
    }
}
