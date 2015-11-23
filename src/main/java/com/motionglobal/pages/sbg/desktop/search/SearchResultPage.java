package com.motionglobal.pages.sbg.desktop.search;

import org.openqa.selenium.By;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class SearchResultPage extends AbstractBaseSbgDesktopPage {
    private ResultGrid resultGrid;

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
