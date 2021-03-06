package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
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
    public WebElement buyRX;
    @FindAll({ @FindBy(css = ".pro_labuy.formSubmit>span"), @FindBy(css = ".pro_labuy.formSubmit_b.pro_buynow_btn>span") })
    public WebElement buySun;
    @FindBy(className = "cart_btn")
    public WebElement cartBtn;
    // @FindBy(css = ".pro_view_quick[style='display: table;']>a>span")
    // public WebElement quickView;
    @FindBy(css = ".qick_view_do>i")
    public List<WebElement> quickView;
    @FindBy(css = ".recProInfo>a")
    public WebElement brankOneIntoDetail;
    @FindBy(css = ".proInfoN")
    public WebElement productDetailName;
    // add new product page
    @FindAll({ @FindBy(css = ".detail_link"), @FindBy(className = "qv-pro-detail-btn") })
    public WebElement detail;
    // @FindBy(css = ".pro_title_logo>a>h1")
    @FindAll({ @FindBy(css = ".pro-buy-name.pro_big_title>h1"), @FindBy(css = ".pro_title_logo>a>h1") })
    public WebElement quickViewName;
    // multi-angle picture
    @FindBy(css = ".pro_leftIcon_click")
    public List<WebElement> multiPucture;
    @FindAll({ @FindBy(css = ".pro_bigimg>img[style*='inline']"), @FindBy(css = ".pro_bigimg>img[style='width: 320px;']"), @FindBy(css = ".cloudzoom") })
    public WebElement quickViewMainPicture;
    // List WebElement
    @FindBy(className = "recProInfo")
    public List<WebElement> proInfo;
    // @FindBy(xpath = "//div[@class='pro_right_size']/a")
    @FindBy(css = ".pro_rightSizeIcon_click")
    public List<WebElement> eyeproSize;
    @FindBy(css = "label.clearfix")
    public List<WebElement> frameOrAdd;
    // @FindBy(css = ".discount-cnt>span:not([class*='discount'])")
    @FindAll({ @FindBy(css = ".proPriceN.pro-cur-price"), @FindBy(css = ".discount-cnt>span:not([class*='discount'])") })
    public List<WebElement> productPriceS;
    @FindBy(className = "price_clearance_new_tag")
    public WebElement discountIcon;

    // sort and page
    // @FindBy(css = "#sortByDrop>dt>a")
    @FindBy(css = "#sortByDrop>a,#sortByDrop>dt>a")
    public WebElement SortDrop;
    @FindBy(css = "#sortByDrop li>a")
    public List<WebElement> SortSection;
    @FindBy(css = ".pagination>a[href*=---]")
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
    // @FindBy(xpath = "//*[@id='content']/div[1]/div/div[4]/ul/li[2]/a")
    @FindAll({ @FindBy(css = ".FrameShape>.sun-shapes-wa"), @FindBy(xpath = "//*[@id='content']/div[1]/div/div[4]/ul/li[2]/a") })
    public WebElement shapesMostPopular;
    // @FindBy(xpath = "//div[@class='choose_model']/p[3]/a")
    @FindAll({ @FindBy(xpath = ".//*[@id='content']/div[2]/div[1]/div/div[3]/div/a[3]"), @FindBy(xpath = "//div[@class='choose_model']/p[3]/a") })
    public WebElement filterRayban;
    // @FindBy(css = "a.FrameType")
    // public List<WebElement> filterFrameType;
    // @FindBy(xpath = "//*[@id='content']/div[1]/div/div[6]/ul/li[1]/a")
    @FindAll({ @FindBy(xpath = ".//*[@id='content']/div[2]/div[1]/div/div[7]/div/a[1]"), @FindBy(xpath = "//*[@id='content']/div[1]/div/div[6]/ul/li[1]/a") })
    public WebElement filterFrameType;
    // @FindBy(xpath = "//*[@id='content']//div[7]/ul/li/a")
    // public List<WebElement> filterPrice;
    // @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[2]/a")
    @FindAll({ @FindBy(xpath = ".//*[@id='content']/div[2]/div[1]/div/div[8]/div/li[2]/a"), @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[2]/a") })
    public WebElement filterPriceNo2;
    // @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[3]/a")
    @FindAll({ @FindBy(xpath = ".//*[@id='content']/div[2]//div[8]/div/li[3]/a"), @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[3]/a") })
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
    // @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    @FindAll({ @FindBy(xpath = ".//*[@id='content']/p/span"), @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]") })
    private WebElement lableA;
    // @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[1]/a")
    @FindBy(xpath = "//*[@id='content']/p/a[2]")
    private WebElement lableB;
    // @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]/a")
    @FindAll({ @FindBy(xpath = ".//*[@id='content']/p/a[3]"), @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]/a") })
    private WebElement lableC;

    public String getSubmenuPageLabelText(Label label) {
        String text = null;
        switch (label) {
        case gender:
        case material:
        case mid:
        case pre:
        case polarized:
            text = lableA.getText().toLowerCase();
            break;
        case designer:
        case sports:
            text = lableB.getText().toLowerCase();
            break;
        case brands:
        case ski:
            text = lableC.getText().toLowerCase();
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

    public void matcherQuickViewClickOpen(int num) {
        ProductGridPage gridPage = new ProductGridPage();
        gridPage.deleteHead();
        gridPage.waitForVisibility(gridPage.proInfo.get(num - 1), 2);
        gridPage.JsMouse(gridPage.proInfo.get(num - 1));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        new Actions(driver).moveToElement(gridPage.proInfo.get(num - 1)).build().perform();
        gridPage.waitForVisibility(gridPage.quickView.get(num - 1), 2);
        gridPage.quickView.get(num - 1).click();
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
            gridPage.waitForVisibility(gridPage.quickView.get(i), 2);
            gridPage.quickView.get(i).click();
            gridPage.waitForVisibility(gridPage.eyeproSize, 10);
            if (gridPage.eyeproSize.size() >= 2) {
                break;
            }
            else if (i == gridPage.proInfo.size() - 1) {
                Assert.assertTrue(false, "No't Find : Size is 2");
            }
        }
    }

    public void matcherQuickViewSunCanRX() {
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
            gridPage.waitForVisibility(gridPage.quickView.get(i), 2);
            gridPage.quickView.get(i).click();
            gridPage.waitForVisibility(gridPage.eyeproSize, 10);
            if (gridPage.buyRX.isDisplayed()) {
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
        waitForVisibility(By.cssSelector(".proCell.proCell_click.grid-pro-cell"), 5);
    }
}
