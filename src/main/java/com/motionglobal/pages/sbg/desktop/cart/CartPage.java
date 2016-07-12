package com.motionglobal.pages.sbg.desktop.cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CartPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".paySecurexDo")
    public WebElement btnCheckout;
    @FindBy(className = "cartEmptyIcon")
    public WebElement cartEmptyIcon;
    @FindBy(xpath = "//div[@class='left']/input")
    public List<WebElement> productNum;
    @FindBy(className = "refresh")
    public List<WebElement> productRefresh;
    @FindBy(className = "td_title")
    public List<WebElement> productName;
    @FindBy(id = "rmv")
    public List<WebElement> productRemove;

    // pay
    // @FindBy(css = ".p_2>span")
    // public WebElement price;
    @FindBy(css = ".frbox .orange")
    public WebElement priceGlassTotal;
    @FindBy(css = ".fr .orange:nth-of-type(2)")
    public WebElement priceShipping;
    @FindBy(css = ".fr .orange:nth-of-type(3)")
    public WebElement priceInsurance;
    @FindBy(id = "rewards")
    public WebElement priceCoupon;
    @FindBy(id = "grand_total")
    public WebElement priceTotal;
    @FindBy(id = "used_rewards")
    public WebElement InputUseReWard;
    @FindBy(className = "left_2")
    public WebElement kit;
    @FindBy(css = ".pay_now.fr")
    public WebElement checkOut;
    @FindBy(id = "insurance_option")
    private WebElement insurance;

    public void selectInsurance1() {
        waitForVisibility(insurance, 5);
        Select select = new Select(insurance);
        select.selectByValue("first_insurance");
    }

    // try wait total price change
    public void waitPriceTotalChange(Double oldprice) {
        for (int i = 0; i < 30; i++) {
            String SpriceTotal = priceTotal.getText().replace("$", "");
            Double DpriceTotal = Double.parseDouble(SpriceTotal);
            if (DpriceTotal == oldprice) {
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
            }
            break;
        }
    }

    // coupon
    public Double couponPrice(Double couponTotal) {
        Double coupon;
        Double maxCoupon = (Double.parseDouble(priceGlassTotal.getText().replace("$", ""))) * 0.2;
        if (maxCoupon > couponTotal) {
            coupon = couponTotal;
        }
        else {
            coupon = maxCoupon;
        }
        Double coupon2 = ((double) (Math.round(coupon * 10))) / 10;
        return coupon2;
    }

    public CartPage() {
        super();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".cart_detail"), 20);
    }

}
