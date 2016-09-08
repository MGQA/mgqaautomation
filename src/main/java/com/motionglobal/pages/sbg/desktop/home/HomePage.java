package com.motionglobal.pages.sbg.desktop.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HomePage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//ul[@class='sli_ul']/li[*]/a")
    public List<WebElement> listServiceItem;
    @FindBy(xpath = "//div[@class='glasslink']/a[1]")
    public List<WebElement> linkSun_ImgBelow;
    @FindBy(xpath = "//div[@class='glasslink']/a[2]")
    public List<WebElement> linkEye_ImgBelow;
    @FindBy(xpath = "//div[@class='featured_deals']/div//img")
    public List<WebElement> imgFeature;
    @FindBy(css = "h3")
    public List<WebElement> textBrandName;
    @FindBy(css = ".inf_cnt_txt>p>a")
    public List<WebElement> linkFooterS;
    // pimcore
    @FindBy(css = ".newhead_banner")
    public WebElement linkPimcore;

    // top sell
    @FindBy(css = ".tempWrap img")
    public List<WebElement> linkTopSellImg;
    @FindBy(css = ".pro_sli_name")
    public List<WebElement> textTopSellBrandName;
    @FindBy(css = ".pro_slider_ul>li>a")
    public List<WebElement> linkTopSellLabelA;
    @FindBy(xpath = "//*[@id='content']/div[7]//li[5]/a")
    public WebElement linkSunNo1;
    @FindBy(xpath = "//*[@id='content']/div[8]//li[5]/a")
    public WebElement linkEyeNo1;

    // feature
    @FindBy(className = "v_aeye_btn")
    public WebElement linkViewSun;
    @FindBy(className = "v_asun_btn")
    public WebElement linkViewEye;
    @FindBy(xpath = "//div[@class='featured_deals']/div[1]//img")
    public WebElement linkFeatureImgNo1;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("slideshow"), 5);
    }
}
