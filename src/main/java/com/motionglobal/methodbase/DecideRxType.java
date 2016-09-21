package com.motionglobal.methodbase;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.motionglobal.pages.AbstractBaseContainer;

public class DecideRxType extends AbstractBaseContainer {

    /**
     * XXX decide RX type
     * 
     * @return "new" or "old"
     */
    public String getRXType() {
        String rx = "empty";
        for (int i = 0; i < 100; i++) {
            try {
                driver.findElement(By.className("cart_btn"));
                rx = "new";
                break;
            }
            catch (Exception e) {
            }
            try {
                driver.findElement(By.xpath("//div[@id='lensStep01']/div[1]/div[1]/h4"));
                rx = "old";
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
                Assert.assertTrue(false, "Wait 20s, But Page No't Load Finish !!");
            }
        }
        return rx;
    }

}
