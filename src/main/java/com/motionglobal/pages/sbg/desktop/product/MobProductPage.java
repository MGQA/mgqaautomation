package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class MobProductPage extends AbstractBaseSbgDesktopPage {
    @FindBy(className = "main__glass-list__item")
    public List<WebElement> productList;
    @FindBy(className = "main__glass-list__item__detail__other")
    private List<WebElement> productName;

    public MobProductPage productList(int index) {
        this.productList.get(index);
        return this;
    }

    public String getProductName(int index) {
        String name = productName.get(index).getText();
        return name;
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.className("main__glass-list__item"), 30);
    }

}
