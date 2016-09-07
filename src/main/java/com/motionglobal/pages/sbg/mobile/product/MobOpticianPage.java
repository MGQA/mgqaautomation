package com.motionglobal.pages.sbg.mobile.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobOpticianPage extends AbstractBaseSbgDesktopPage {
    @FindBy(xpath = "//div[@id='step1']/div[1]/div[3]/ul/li[1]/a")
    public WebElement distance;
    @FindBy(className = "rx_step_enter")
    public WebElement continueBtn;
    @FindBy(id = "terms_cond")
    public WebElement checkBox;
    //
    @FindBy(id = "sphere_right")
    public WebElement rightSPH;
    @FindBy(id = "cylinder_right")
    public WebElement rightCYL;
    @FindBy(id = "axis_right")
    public WebElement rightAX;
    @FindBy(id = "add_right")
    public WebElement rightADD;
    // Left
    @FindBy(id = "sphere_left")
    public WebElement leftSPH;
    @FindBy(id = "cylinder_left")
    public WebElement leftCYL;
    @FindBy(id = "axis_left")
    public WebElement leftAX;
    @FindBy(id = "add_left")
    public WebElement leftADD;

    public void selectDegree(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("main__lens__type__title"), 5);
    }

}
