package com.motionglobal.pages.sbg.desktop.footer.aboutus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class AccountPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".account_content_title>div>h3")
    public WebElement accountName;
    @FindBy(xpath = "//table[1]/tbody/tr[1]/td[2]")
    public WebElement infoEmail;

    // reward
    @FindBy(xpath = "//tr[1]/td")
    public List<WebElement> remainReward;
    @FindBy(xpath = "//tr[3]/td")
    public List<WebElement> useReward;
    @FindBy(className = "sign_inlist_span")
    public WebElement loginReward;

    // prescription
    @FindBy(id = "computer_vision")
    public WebElement radioPrePC;
    @FindBy(css = ".singlev_button>a")
    public WebElement btnSave;
    @FindBy(id = "prescription_name")
    public WebElement preName;
    @FindBy(id = "pdist")
    public WebElement PD;
    @FindBy(tagName = "tbody")
    public WebElement tbody;
    @FindBy(css = ".single_vision:last-of-type>h6:last-of-type")
    public WebElement newPre;
    // Right
    @FindBy(id = "sphere_right")
    public WebElement rightSPH;
    @FindBy(id = "cylinder_right")
    public WebElement rightCYL;
    @FindBy(id = "axis_right")
    public WebElement rightAX;
    @FindBy(id = "dis_add_right")
    public WebElement rightADD;
    // Left
    @FindBy(id = "sphere_left")
    public WebElement leftSPH;
    @FindBy(id = "cylinder_left")
    public WebElement leftCYL;
    @FindBy(id = "axis_left")
    public WebElement leftAX;
    @FindBy(id = "dis_add_left")
    public WebElement leftADD;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".account_title>h2"), 5);
    }

}
