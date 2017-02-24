package com.motionglobal.pages.sbg.desktop.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CLProductDetailPage extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".cl_productImgTitle>a>h1")
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
