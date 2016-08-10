package com.motionglobal.pages.sbg.desktop.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class SearchResultPage extends AbstractBaseSbgDesktopPage {
    private final ResultGrid resultGrid;
    //
    @FindBy(className = "quick_view_text")
    public WebElement quickView;
    @FindBy(xpath = "//div[contains(@class,'pro_r_buynow')]/a[2]/span")
    public WebElement buyNowButton;
    @FindBy(className = "detail_link")
    public WebElement detailBtn;
    @FindBy(id = "totleRsCount")
    public WebElement productCount;
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
    @FindBy(xpath = "//*[@id='wrapper']/div[5]/div[2]/div[1]/ul/li[1]/i")
    public WebElement filterEyeChecked;
    @FindBy(xpath = "//*[@id='wrapper']/div[5]/div[2]/div[1]/ul/li[2]/i")
    public WebElement filterSunCkecked;

    // filter product
    @FindBy(css = ".search_category_container>li>a")
    public List<WebElement> filterGlasses;
    @FindBy(xpath = "//a[contains(@onclick,'Men')][label]")
    public WebElement filterMen;
    @FindBy(css = "span.count +i")
    public WebElement filterMenChecked;
    @FindBy(partialLinkText = "Wayfarer")
    public WebElement filterWayfarer;
    @FindBy(css = ".s_s_Wayfarer .current")
    public WebElement filterWayfarerChecked;
    @FindBy(css = ".s_sf_item .list-group-item")
    public List<WebElement> filterFeature;
    @FindBy(css = ".refined.list-group-item")
    public List<WebElement> filterFeatureChecked;

    public SearchResultPage() {
        super();
        this.resultGrid = new ResultGrid();
    }

    public ResultGrid resultGrid() {
        return this.resultGrid;
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".s_r_product_number"), 40);
    }
}
