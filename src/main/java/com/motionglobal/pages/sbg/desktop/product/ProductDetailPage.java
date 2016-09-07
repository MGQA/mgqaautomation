package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductDetailPage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//a[contains(@class,'buy')][not(contains(@style,'none'))]")
    public WebElement btnBuyNow; // There are two buy now buttons, one is hidden by lens selection condition.
    @FindBy(id = "withLenses")
    public WebElement btnAddLenses;
    @FindBy(id = "frameOnly")
    public WebElement btnFrameOnly;
    @FindBy(id = "frameOnly")
    public WebElement radioFrameOnly;
    @FindBy(xpath = "//a[@class='pro_big_title']/h1")
    public WebElement glassName;

    // Ë¥ÍË BUG
    @FindBy(xpath = "//a[contains(@class,'buy')][not(contains(@style,'none'))]")
    public List<WebElement> BUG2BuyNow;

    public ProductDetailPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("navigation"), 5);
    }
}
