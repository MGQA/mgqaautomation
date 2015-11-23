package com.motionglobal.pages.sbg.desktop.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ResultGrid extends AbstractBaseSbgDesktopPage {

    @FindBy(css = ".searchPart > .s_rpl_block")
    public List<WebElement> resultItems;

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.cssSelector(".s_r_pn_pager"), 10);
    }

    public SearchResultItem getItem(int index) {
        if (isEmpty(this.resultItems)) {
            logger.info("No search result found in current page.");
            return null;
        }
        if (this.resultItems.size() > index) {
            logger.error(String.format("No so many result items in this page. Total: %s, expected index: %s", this.resultItems.size(), index));
            return null;
        }
        return new SearchResultItem(this.resultItems.get(index));
    }

    /*
     * 
     * public SearchResultItem get(String itemName) { return null; }
     * 
     * public void clickPreviousPage(int index) {
     * 
     * }
     * 
     * public void clickFirstPage() {
     * 
     * }
     * 
     * public void clickNextPage(int index) {
     * 
     * }
     * 
     * public void clickLastPage() {
     * 
     * }
     * 
     * public int currentPageNum() { return 0; }
     * 
     * public void clickPageNum() { }
     * 
     * public int totalResultNum() { return 0; }
     * 
     * public int pageResultNum() { return 0; }
     */
}
