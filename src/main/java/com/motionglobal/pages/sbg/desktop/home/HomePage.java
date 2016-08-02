package com.motionglobal.pages.sbg.desktop.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class HomePage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//ul[@class='sli_ul']/li[*]/a")
    public List<WebElement> listServiceItem;
    @FindBy(xpath = "// div[@class='glasslink']/a[1]")
    public List<WebElement> linkSun_ImgBelow;
    @FindBy(xpath = "// div[@class='glasslink']/a[2]")
    public List<WebElement> linkEye_ImgBelow;
    @FindBy(xpath = "//div[@class='featured_deals']/div//img")
    public List<WebElement> imgFeature;
    @FindBy(css = "h3")
    public List<WebElement> textBrandName;
    //
    @FindBy(className = "v_aeye_btn")
    public WebElement linkViewSun;
    @FindBy(className = "v_asun_btn")
    public WebElement linkViewEye;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("slideshow"), 40);
    }
}
