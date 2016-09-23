package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.ColorGlass;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.FrameType;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.Material;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.Shape;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.Sport;

public class ProductGridPage extends AbstractBaseSbgDesktopPage {
    @FindBy(xpath = "//div[contains(@class,'pro_r_buynow')]/a[2]/span")
    public WebElement buyNowButton;
    @FindBy(css = ".pro_lawith.formSubmitRx>span")
    public WebElement buyPre;
    @FindBy(className = "cart_btn")
    public WebElement cartBtn;
    // List WebElement
    @FindBy(css = ".pro_view_quick[style='display: table;']>a>span")
    public WebElement quickView;
    @FindBy(className = "recProInfo")
    public List<WebElement> proInfo;
    @FindBy(xpath = "//div[@class='pro_right_size']/a")
    public List<WebElement> eyeproSize;
    @FindBy(css = "label.clearfix")
    public List<WebElement> frameOrAdd;
    @FindBy(css = ".proPriceN")
    public List<WebElement> productPriceS;
    @FindBy(className = "price_clearance_new_tag")
    public WebElement discountIcon;

    // sort and page
    @FindBy(css = "#sortByDrop>dt>a")
    public WebElement SortDrop;
    @FindBy(css = "#sortByDrop li>a")
    public List<WebElement> SortSection;
    @FindBy(css = ".pagination.bottom_pagination>a")
    public List<WebElement> productPageNum;
    @FindBy(id = "half_left")
    public WebElement popularLeftBtn;
    @FindBy(id = "half_right")
    public WebElement popularRightBtn;
    @FindBy(id = "half_1")
    public WebElement popularBrands1;
    @FindBy(id = "half_3")
    public WebElement popularBrands3;
    @FindBy(xpath = "//ul[@id='half_1']/li[1]/a")
    public WebElement popularBrandIMG1;

    // filter
    @FindBy(partialLinkText = "Arnette")
    public WebElement filterArnette;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[4]/ul/li[2]/a")
    public WebElement shapesMostPopular;
    @FindBy(xpath = "//div[@class='choose_model']/p[3]/a")
    public WebElement filterRayban;
    // @FindBy(css = "a.FrameType")
    // public List<WebElement> filterFrameType;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[6]/ul/li[1]/a")
    public WebElement filterFrameType;
    // @FindBy(xpath = "//*[@id='content']//div[7]/ul/li/a")
    // public List<WebElement> filterPrice;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[2]/a")
    public WebElement filterPriceNo2;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[3]/a")
    public WebElement filterPriceNo3;

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

    // XXX element URL ;
    @FindBy(className = "navigation")
    public WebElement LabelText;
    @FindBy(className = "Gender")
    public List<WebElement> gender;
    @FindBy(css = ".side_Polarized>a")
    public WebElement polarized;
    @FindBy(css = ".side_Prescription>a")
    public WebElement pre;
    @FindBy(css = ".side_Clearance>a")
    public WebElement clearance;

    public WebElement getShape(Shape shape) {
        return new GridFilter().getShape(shape);
    }

    public WebElement getColor(ColorGlass color) {
        return new GridFilter().getColor(color);
    }

    public WebElement getFrameType(FrameType type) {
        return new GridFilter().getFrameType(type);
    }

    public WebElement getFrameMaterial(Material material) {
        return new GridFilter().getFrameMaterial(material);
    }

    public WebElement getSport(Sport sport) {
        return new GridFilter().getSport(sport);
    }

    // XXX Label use to Assert
    public enum Label {
        gender, material, mid, pre, polarized, sports, brands, ski, designer;
    }

    // getSubmenuPageLabelText element
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    private WebElement lableA;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[1]/a")
    private WebElement lableB;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]/a")
    private WebElement lableC;

    public String getSubmenuPageLabelText(Label label) {
        String text = null;
        switch (label) {
        case gender:
        case material:
        case mid:
        case pre:
        case polarized:
            text = lableA.getText();
            break;
        case designer:
        case sports:
            text = lableB.getText();
            break;
        case brands:
        case ski:
            text = lableC.getText();
            break;
        default:
            System.out.println("_ don't right page !_");
            break;
        }
        return text;
    }

    /**
     * ~ change - of price
     * 
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

    public void matcherQuickViewSize2() {
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.deleteHead();
        for (int i = 0; i < gridPage.proInfo.size(); i++) {
            gridPage.waitForVisibility(gridPage.proInfo.get(i), 2);
            gridPage.JsMouse(gridPage.proInfo.get(i));
            new Actions(driver).moveByOffset(500, 500).build().perform();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
            }
            new Actions(driver).moveToElement(gridPage.proInfo.get(i)).build().perform();
            gridPage.waitForVisibility(gridPage.quickView, 5);
            gridPage.quickView.click();
            gridPage.waitForVisibility(gridPage.eyeproSize, 10);
            if (gridPage.eyeproSize.size() >= 2) {
                break;
            }
            else if (i == gridPage.proInfo.size() - 1) {
                Assert.assertTrue(false, "No't Find : Size is 2");
            }
        }
    }

    public void matcherQuickSunCanRX() {
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.deleteHead();
        for (int i = 0; i < gridPage.proInfo.size(); i++) {
            gridPage.waitForVisibility(gridPage.proInfo.get(i), 2);
            gridPage.JsMouse(gridPage.proInfo.get(i));
            new Actions(driver).moveByOffset(500, 500).build().perform();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
            }
            new Actions(driver).moveToElement(gridPage.proInfo.get(i)).build().perform();
            gridPage.waitForVisibility(gridPage.quickView, 5);
            gridPage.quickView.click();
            gridPage.waitForVisibility(gridPage.eyeproSize, 10);
            if (gridPage.buyPre.isDisplayed()) {
                break;
            }
            else if (i == gridPage.proInfo.size() - 1) {
                Assert.assertTrue(false, "No't Find : Sun Glass Can RX");
            }
        }
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("jp-pagination-ajax"), 5);
    }
}
