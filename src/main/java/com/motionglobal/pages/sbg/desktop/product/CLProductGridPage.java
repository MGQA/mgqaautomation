package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CLProductGridPage extends AbstractBaseSbgDesktopPage {
    @FindBy(className = "pho")
    public List<WebElement> lenseDailyEles;

    // @FindBy(xpath = "//*[@id='CL_Breadcrumb']")
    // public WebElement submenuCLLeftClickedLabel;
    //
    // public String regexPage(String pagetext) {
    // Pattern pattern = Pattern.compile("/ ");
    // Matcher matcher = pattern.matcher(pagetext);
    // return matcher.replaceAll("");
    // }

    public WebElement submenuCLLeftClickedLabel1(int pageLabeleNum) {
        return driver
                .findElement(By.xpath("//*[@id='content']/div/div[1]/div[2]/ul[2]/li[" + pageLabeleNum + "]/input[@checked='checked']/../label/span/span"));
    }

    public WebElement submenuCLLeftClickedLabel2(int pageLabeleNum) {
        return driver
                .findElement(By.xpath("//*[@id='content']/div/div[1]/div[2]/ul[3]/li[" + pageLabeleNum + "]/input[@checked='checked']/../label/span/span"));
    }

    public WebElement submenuCLLeftClickedLabel3(int pageLabeleNum) {
        return driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div[4]/ul/li[" + pageLabeleNum + "]/input[@data-checked-id='1']/../label/span/span"));
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("CL-ProductCount"), 20);
    }
}
