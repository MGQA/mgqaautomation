package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductGridPage extends AbstractBaseSbgDesktopPage {
    // assert_element
    @FindBy(className = "proCell_click")
    public List<WebElement> sunTop100Eles;
    @FindBy(className = "pho")
    public List<WebElement> lenseDailyEles;

    // without CL
    // Assert
    /**
     * .extra FEATURED'(New Arrival),without category's(sports and ski) and $>200
     * 
     * @param gender
     * @return
     */
    /**
     * @return
     */
    public void assertGenderMaterialSubMidMenuPage(String containsName) {
        String displayName = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span[2]")).getText();
        Assert.assertEquals(displayName, containsName);// TODO
    }

    public void assertCategoryIsSportsPage(String clickedName) {
        String displayName = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span[1]/a")).getText();
        Assert.assertTrue(displayName.contains(clickedName));
    }

    public void assertBrandAndSkiPage(String containsName) {
        String displayName = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span[2]/a")).getText();
        Assert.assertTrue(displayName.contains(containsName));
    }

    public void assertTop100Page() {
        String displayName = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]/span/a")).getText();
        Assert.assertEquals(displayName, "100 Best Selling Sports Glasses");
    }

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

}
