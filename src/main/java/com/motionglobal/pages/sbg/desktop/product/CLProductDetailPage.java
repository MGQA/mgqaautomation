package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CLProductDetailPage extends AbstractBaseSbgDesktopPage {

    // @FindBy(css = ".cl_productImgTitle>a>h1")
    @FindAll({ @FindBy(css = ".pro-buy-name>a>h1"), @FindBy(css = ".cl_productImgTitle>a>h1") })
    public WebElement productName;
    //
    @FindBy(id = "right_check")
    private WebElement chkRight;
    @FindBy(id = "R_qty")
    private WebElement selRightBoxes;
    @FindBy(id = "R_power")
    private WebElement selRightPower;
    @FindBy(id = "R_cylinder")
    private WebElement selRightCyl;
    @FindBy(id = "R_axis")
    private WebElement selRightAxis;

    @FindBy(id = "left_check")
    private WebElement chkLeft;
    @FindBy(id = "L_qty")
    private WebElement selLeftBoxes;
    @FindBy(id = "L_power")
    private WebElement selLeftPower;
    @FindBy(id = "L_cylinder")
    private WebElement selLeftCyl;
    @FindBy(id = "L_axis")
    private WebElement selLeftAxis;

    // new CL PRE
    @FindBy(css = "#R_qty+div")
    public WebElement RBoxArea;
    @FindBy(css = "#R_power+div")
    public WebElement RPowerArea;
    @FindBy(css = "#R_cylinder+div")
    public WebElement RCylArea;
    @FindBy(css = "#R_axis+div")
    public WebElement RAxisArea;

    @FindBy(css = "#L_qty+div")
    public WebElement LBoxArea;
    @FindBy(css = "#L_power+div")
    public WebElement LPowerArea;
    @FindBy(css = "#L_cylinder+div")
    public WebElement LCylArea;
    @FindBy(css = "#L_axis+div")
    public WebElement LAxisArea;
    //
    @FindBy(css = "#R_qty+div>ul>li")
    public List<WebElement> RBox;
    @FindBy(css = "#R_power+div>ul>li")
    public List<WebElement> RPower;
    @FindBy(css = "#R_cylinder+div>ul>li")
    public List<WebElement> RCyl;
    @FindBy(css = "#R_axis+div>ul>li")
    public List<WebElement> RAxis;

    @FindBy(css = "#L_qty+div>ul>li")
    public List<WebElement> LBox;
    @FindBy(css = "#L_power+div>ul>li")
    public List<WebElement> LPower;
    @FindBy(css = "#L_cylinder+div>ul>li")
    public List<WebElement> LCyl;
    @FindBy(css = "#L_axis+div>ul>li")
    public List<WebElement> LAxis;

    @FindBy(css = "#addToCart")
    private WebElement btnAddToCart;

    @FindAll({ @FindBy(css = "#nav_suspend_product_information"), @FindBy(css = "#suspend_information_tag") })
    public WebElement information;

    public CLProductDetailPage() {
        super();
    }

    public void assertCLDetailPage(String containsName) {
        String displayName = driver.findElement(By.xpath("//*[@id='wrapper']/div[4]/div[2]")).getText();
        Assert.assertTrue(displayName.contains(containsName), "Not the CL Detail page");
    }

    public CLProductDetailPage setRightPrescription(boolean check, String boxes, String power, String cyl, String axis) {
        if (check ^ chkRight.isSelected()) {
            this.chkRight.click();
        }
        if (check) {
            Select sel = new Select(this.selRightBoxes);
            sel.selectByValue(boxes);
            sel = new Select(this.selRightPower);
            sel.selectByValue(power);
            sel = new Select(this.selRightCyl);
            sel.selectByValue(cyl);
            sel = new Select(this.selRightAxis);
            sel.selectByValue(axis);
        }
        return this;
    }

    public CLProductDetailPage setLeftPrescription(boolean check, String boxes, String power, String cyl, String axis) {
        if (check ^ chkLeft.isSelected()) {
            this.chkLeft.click();
        }
        if (check) {
            Select sel = new Select(this.selLeftBoxes);
            sel.selectByValue(boxes);
            sel = new Select(this.selLeftPower);
            sel.selectByValue(power);
            sel = new Select(this.selLeftCyl);
            sel.selectByValue(cyl);
            sel = new Select(this.selLeftAxis);
            sel.selectByValue(axis);
        }
        return this;
    }

    public void CLNewPreR(int box, int power, int axis, int cyl) {
        CLProductDetailPage page = new CLProductDetailPage();
        page.RBoxArea.click();
        page.waitForVisibility(page.RBox, 2);
        page.RBox.get(box).click();
        //
        page.RPowerArea.click();
        page.waitForVisibility(page.RPower, 2);
        page.RPower.get(power).click();
        //
        page.RAxisArea.click();
        page.waitForVisibility(page.RAxis, 2);
        page.RAxis.get(axis).click();
        //
        page.RCylArea.click();
        page.waitForVisibility(page.RCyl, 2);
        page.RCyl.get(cyl).click();
        //
    }

    public void CLNewPreL(int box, int power, int axis, int cyl) {
        CLProductDetailPage page = new CLProductDetailPage();
        page.LBoxArea.click();
        page.waitForVisibility(page.LBox, 2);
        page.LBox.get(box).click();
        //
        page.LPowerArea.click();
        page.waitForVisibility(page.LPower, 2);
        page.LPower.get(power).click();
        //
        page.LAxisArea.click();
        page.waitForVisibility(page.LAxis, 2);
        page.LAxis.get(axis).click();
        //
        page.LCylArea.click();
        page.waitForVisibility(page.LCyl, 2);
        page.LCyl.get(cyl).click();
        //
    }

    public void clickAddToCart() {
        waitForVisibility(By.id("addToCart"), 10);
        this.btnAddToCart.click();
    }

    @FindAll({ @FindBy(className = "cl-save-more"), @FindBy(className = "cl_productType") })
    private WebElement target;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(target, 5);
    }

}
