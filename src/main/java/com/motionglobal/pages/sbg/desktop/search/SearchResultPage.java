package com.motionglobal.pages.sbg.desktop.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class SearchResultPage extends AbstractBaseSbgDesktopPage {

    private final ResultGrid resultGrid;
    //
    @FindBy(css = ".pro_view_quick[style='display: table;']>a>span")
    public WebElement quickView;
    @FindBy(xpath = "//div[contains(@class,'pro_r_buynow')]/a[2]/span")
    public WebElement buyNowButton;
    @FindBy(css = ".pro_lawith.formSubmitRx>span")
    public WebElement buyPre;
    @FindBy(className = "detail_link")
    public WebElement detailBtn;
    @FindBy(id = "totleRsCount")
    public WebElement productCount;
    // Multi-Angle picture
    @FindBy(css = ".pro_leftIcon_click")
    public List<WebElement> multiPucture;
    @FindAll({ @FindBy(css = ".pro_bigimg>img[style*='inline']"), @FindBy(css = ".pro_bigimg>img[style='width: 320px;']") })
    public WebElement quickViewMainPicture;
    @FindBy(xpath = "//ul[contains(@class,'similar')]/li[2]/a")
    public WebElement multiColor;
    // List WebElement
    @FindBy(className = "recProInfo")
    public List<WebElement> proInfo;
    @FindBy(className = "rplp_brand")
    public WebElement brandName;
    @FindBy(xpath = "//div[@class='pro_right_size']/a")
    public List<WebElement> eyeproSize;
    @FindBy(css = "label.clearfix")
    public List<WebElement> frameOrAdd;
    @FindBy(className = "cart_btn")
    public WebElement carBtn;
    // assert_element
    @FindBy(className = "rplp_brand")
    public WebElement searchName;
    @FindBy(className = "size_s_bor")
    public WebElement sizeClicked;
    @FindBy(className = "on")
    public WebElement frameOrAddClicked;
    @FindBy(xpath = "//input[contains(@onclick,'Bebe')]")
    public WebElement BebeBrank;
    @FindBy(xpath = "//input[contains(@onclick,'Bebe')][@checked='checked']")
    public WebElement BebeBrankChecked;
    @FindBy(className = "srg_number")
    public WebElement brankNum;
    @FindBy(xpath = "//div[@id='wrapper']//li/i")
    public WebElement filterGlassChecked;

    // filter product
    @FindBy(xpath = "//span[text()='Sunglasses']")
    public WebElement filterSun;
    @FindBy(xpath = "//span[text()='Eyeglasses']")
    public WebElement filterEye;
    @FindBy(xpath = "//a[contains(@onclick,'Men')][label]")
    public WebElement filterMen;
    @FindBy(css = "#choose_title i")
    public WebElement filterMenChecked;
    @FindBy(partialLinkText = "Wayfarer")
    public WebElement filterWayfarer;
    @FindBy(css = ".s_s_Wayfarer .current")
    public WebElement filterWayfarerChecked;
    @FindBy(css = ".s_sf_item .list-group-item")
    public List<WebElement> filterFeature;
    @FindBy(css = ".refined.list-group-item")
    public List<WebElement> filterFeatureChecked;

    @FindBy(xpath = ".//*[@id='wrapper']//div[5]/div[1]/ul/a/li[2]/span")
    public WebElement brand4;

    public SearchResultPage() {
        super();
        this.resultGrid = new ResultGrid();
    }

    public ResultGrid resultGrid() {
        return this.resultGrid;
    }

    public void matcherQuickViewClickOpen(int num) {
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.deleteHead();
        searchPage.waitForVisibility(searchPage.proInfo.get(num - 1), 2);
        searchPage.JsMouse(searchPage.proInfo.get(num - 1));
        new Actions(driver).moveByOffset(500, 500).build().perform();
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
        }
        new Actions(driver).moveToElement(searchPage.proInfo.get(num - 1)).build().perform();
        searchPage.waitForVisibility(searchPage.quickView, 5);
        searchPage.quickView.click();
    }

    public void matcherQuickViewSize2() {
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.deleteHead();
        for (int i = 0; i < searchPage.proInfo.size(); i++) {
            searchPage.waitForVisibility(searchPage.proInfo.get(i), 2);
            searchPage.JsMouse(searchPage.proInfo.get(i));
            new Actions(driver).moveByOffset(500, 500).build().perform();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
            }
            new Actions(driver).moveToElement(searchPage.proInfo.get(i)).build().perform();
            // try {
            // searchPage.waitForVisibility(searchPage.quickView, 1);
            // }
            // catch (Exception e) {
            new Actions(driver).moveByOffset(500, 500).build().perform();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException ee) {
            }
            new Actions(driver).moveToElement(searchPage.proInfo.get(i)).build().perform();
            searchPage.waitForVisibility(searchPage.quickView, 1);
            // }
            searchPage.quickView.click();
            searchPage.waitForVisibility(searchPage.eyeproSize, 10);
            if (searchPage.eyeproSize.size() >= 2) {
                break;
            }
            else if (i == searchPage.proInfo.size() - 1) {
                Assert.assertTrue(false, "No't Find : Size is 2");
            }
        }
    }

    public void matcherQuickSunCanRX() {
        SearchResultPage searchPage = new SearchResultPage();
        searchPage.deleteHead();
        for (int i = 0; i < searchPage.proInfo.size(); i++) {
            searchPage.waitForVisibility(searchPage.proInfo.get(i), 2);
            searchPage.JsMouse(searchPage.proInfo.get(i));
            new Actions(driver).moveByOffset(500, 500).build().perform();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
            }
            new Actions(driver).moveToElement(searchPage.proInfo.get(i)).build().perform();
            searchPage.waitForVisibility(searchPage.quickView, 5);
            searchPage.quickView.click();
            searchPage.waitForVisibility(searchPage.eyeproSize, 15);
            if (searchPage.buyPre.isDisplayed()) {
                break;
            }
            else if (i == searchPage.proInfo.size() - 1) {
                Assert.assertTrue(false, "No't Find : Sun Glass Can RX");
            }
        }
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".s_r_product_number"), 5);
    }
}
