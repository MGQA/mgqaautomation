package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CLProductGridPage extends AbstractBaseSbgDesktopPage {
    // @FindBy(css = ".cl_rightCell")
    @FindAll({ @FindBy(css = ".grid-pro-cell.CL-grid-pro"), @FindBy(css = ".cl_rightCell") })
    public WebElement product1;
    // @FindBy(css = ".bra")
    @FindAll({ @FindBy(css = ".cl-pro-name"), @FindBy(css = ".bra") })
    public WebElement productDetailName;
    // @FindBy(className = "pho")
    @FindAll({ @FindBy(css = ".grid-pro-cell.CL-grid-pro"), @FindBy(className = "pho") })
    public List<WebElement> lenseDailyEles;
    // @FindBy(id = "CL-ProductCount")
    @FindAll({ @FindBy(css = ".product_count"), @FindBy(id = "CL-ProductCount") })
    public WebElement productCountString;
    // @FindBy(className = "recProInfo")
    @FindAll({ @FindBy(css = ".grid-pro-cell.CL-grid-pro"), @FindBy(className = "recProInfo") })
    public List<WebElement> ProInfo;

    //
    @FindBy(className = "dailies")
    public WebElement daily;

    // filter
    @FindBy(id = "CL-Acuvue-b")
    public WebElement filterAcuvue;
    @FindBy(id = "CL-daily-disposable-f")
    public WebElement filterDaily;
    @FindBy(id = "CL-spherical-t")
    public WebElement filterSpherical;

    // Assert Element
    // @FindBy(xpath = "//input[@checked='checked']/../label/span/span")
    @FindAll({ @FindBy(xpath = "//input[@checked='checked']/../../span[2]"), @FindBy(xpath = "//input[@checked='checked']/../label/span/span") })
    public WebElement checkedLeftSubmenuElement;
    @FindBy(id = "CL-daily-disposable-f")
    public WebElement checkedDaily;

    public int getProductCount() {
        Integer count = Integer.parseInt(productCountString.getText().replace("Products (", "").replace(")", ""));
        return count;
    }

    public void waitProductChange(String productText) {
        driver.getCurrentUrl();
        String currentProductCount = productCountString.getText();
        for (int i = 0; i < 20; i++) {
            if (productCountString.getText().equals(productText)) {
                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
                break;
        }
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("CL-Products-List-Data"), 5);
    }
}
