package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductGridPage extends AbstractBaseSbgDesktopPage {

    // assert_element！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @FindBy(className = "proCell_click")
    public List<WebElement> sunTop100Eles;
    @FindBy(className = "pho")
    public List<WebElement> lenseDailyEles;
    // subMenu clicked page label// Label contains click
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    public WebElement submenuGenderClickedLabel;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    public WebElement submenuMaterialClickedLabel;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    public WebElement submenuMidClickedLabel;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    public WebElement submenuCategoryPrescriptionClickedLabel;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    public WebElement submenuCategoryPolarizedClickedLabel;

    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[1]/a")
    public WebElement submenuCategorySportsClickedLabel;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[1]/a")
    public WebElement submenuBrandsClickedLabel;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]/a")
    public WebElement submenuSkiClickedLabel;

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
