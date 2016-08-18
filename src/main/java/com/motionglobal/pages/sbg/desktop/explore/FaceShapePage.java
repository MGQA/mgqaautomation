package com.motionglobal.pages.sbg.desktop.explore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class FaceShapePage extends AbstractBaseSbgDesktopPage {

    @FindBy(xpath = "//section[1]/section[2]//h2")
    public WebElement glassOvalBrand;
    @FindBy(css = ".wysiwyg-1>p>a[href*='sunglass']")
    public WebElement glassTopSell;
    @FindBy(css = ".wysiwyg-1>p>a[href*='face']")
    public WebElement faceHomeBtn;

    // S
    @FindBy(className = "product")
    public List<WebElement> glassesAll;

    public enum FaceShape {
        oval, square, heart, round;
    }

    public WebElement getListFaceEle(FaceShape FaceShape) {
        WebElement element = null;
        switch (FaceShape) {
        case oval:
            element = driver.findElement(By.className("ie8_tab1"));
            break;
        case square:
            element = driver.findElement(By.className("ie8_tab2"));
            break;
        case heart:
            element = driver.findElement(By.className("ie8_tab3"));
            break;
        case round:
            element = driver.findElement(By.className("ie8_tab4"));
            break;
        }
        return element;
    }

    public WebElement getListFaceLinkEle(FaceShape FaceShape) {
        WebElement element = null;
        switch (FaceShape) {
        case oval:
            element = driver.findElement(By.cssSelector("[href$='oval']"));
            break;
        case square:
            element = driver.findElement(By.cssSelector("[href$='square']"));
            break;
        case heart:
            element = driver.findElement(By.cssSelector("[href$='heart']"));
            break;
        case round:
            element = driver.findElement(By.cssSelector("[href$='round']"));
            break;
        }
        return element;
    }

    public WebElement getListImgEle(FaceShape FaceShape) {
        WebElement element = null;
        switch (FaceShape) {
        case oval:
            element = driver.findElement(By.cssSelector("[src$='oval.png']"));
            break;
        case square:
            element = driver.findElement(By.cssSelector("[src$='square.png']"));
            break;
        case heart:
            element = driver.findElement(By.cssSelector("[src$='heart.png']"));
            break;
        case round:
            element = driver.findElement(By.cssSelector("[src$='round.png']"));
            break;
        }
        return element;
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".item>.hidden-xs.carousel-image"), 30);
    }
}
