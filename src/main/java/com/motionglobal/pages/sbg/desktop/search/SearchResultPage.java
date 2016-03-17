package com.motionglobal.pages.sbg.desktop.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class SearchResultPage extends AbstractBaseSbgDesktopPage {
    private final ResultGrid resultGrid;

    // assert_element
    @FindBy(className = "rplp_brand")
    public WebElement rayPanEles;

    // assert_element
    @FindBy(className = "proCell_click")
    public List<WebElement> sunTop100Eles;
    @FindBy(className = "pho")
    public List<WebElement> lenseDailyEles;

    public SearchResultPage() {
        super();
        this.resultGrid = new ResultGrid();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".s_r_product_number"), 40);
    }

    public ResultGrid resultGrid() {
        return this.resultGrid;
    }
}
