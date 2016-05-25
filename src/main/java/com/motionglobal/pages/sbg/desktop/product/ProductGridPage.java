package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductGridPage extends AbstractBaseSbgDesktopPage {
    @FindBy(xpath = "//div[contains(@class,'pro_r_buynow')]/a[2]/span")
    public WebElement buyNowButton;
    @FindBy(className = "cart_btn")
    public WebElement cartBtn;
    // List WebElement
    @FindBy(className = "quick_view_text")
    public WebElement quickView;
    @FindBy(className = "recProInfo")
    public List<WebElement> proInfo;
    @FindBy(xpath = "//div[@class='pro_right_size']/a")
    public List<WebElement> eyeproSize;
    @FindBy(css = "label.clearfix")
    public List<WebElement> frameOrAdd;
    // Opticians
    @FindBy(id = "discount_price_promotion_display")
    public WebElement framePrice;
    @FindBy(className = "frame_price")
    public WebElement frame_price;
    @FindBy(xpath = "//li[@class='recommended cur']/a/p[2]")
    public WebElement deluxeVeryPriece;
    @FindBy(className = "lenses_price")
    public WebElement lenses_price;
    @FindBy(className = "total_price")
    public WebElement total_price;
    @FindBy(xpath = "//li[@data-index='deluxe']")
    public WebElement deluxe;
    @FindBy(xpath = "//li[@data-value='8']/a")
    public WebElement deluxeVery;
    // filter
    @FindBy(partialLinkText = "Arnette")
    public WebElement filterArnette;
    @FindBy(css = "li.frameS_av a.FrameShape")
    public WebElement filterAviator;
    // assert_element！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @FindBy(className = "proCell_click")
    public List<WebElement> sunTop100Eles;
    @FindBy(className = "size_s_bor")
    public WebElement sizeClicked;
    @FindBy(className = "on")
    public WebElement frameOrAddClicked;
    @FindBy(xpath = "//div[@id='jp-pagination-ajax']/h3")
    public WebElement productNum;
    @FindBy(className = "sideRemove")
    public WebElement filterSide;

    public enum Label {
        gender, material, mid, pre, polarized, sports, brands, ski;
    }

    public WebElement submenuPageLabelElement(Label label) {
        WebElement element = null;
        switch (label) {
        case gender:
        case material:
        case mid:
        case pre:
        case polarized:
            element = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span[2]"));
            break;
        case sports:
            element = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span[1]/a"));
            break;
        case brands:
        case ski:
            element = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span[2]/a"));
            break;
        default:
            System.out.println("_ don't right page !_");
            break;
        }
        return element;
    }

    /**
     * ~ change - of price
     * 
     * @param pagetext
     * @return
     */
    public String regexPage(String pagetext) {
        Pattern pattern = Pattern.compile("~");
        Matcher matcher = pattern.matcher(pagetext);
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbr, "-");
        }
        matcher.appendTail(sbr);
        return sbr.toString();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("jp-pagination-ajax"), 10);
    }
    //
    //
    //
    //
    //
}
