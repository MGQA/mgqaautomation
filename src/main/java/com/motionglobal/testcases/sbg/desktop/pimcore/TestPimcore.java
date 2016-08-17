package com.motionglobal.testcases.sbg.desktop.pimcore;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.Menu;
import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.pages.sbg.desktop.pimcore.PimcorePage;
import com.motionglobal.pages.sbg.desktop.search.SearchResultPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * pimcor page search , menu , header menu
 */
public class TestPimcore extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/" }, { "http://www.smartbuyglasses.dk/" }, { "http://www.smartbuyglasses.com/" } };
    }

    @DataProvider
    public Object[][] pk() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/optical-centre" }, { "http://www.smartbuyglasses.com/optical-center" },
                { "http://www.smartbuyglasses.dk/optisk-center" } };
    }

    @DataProvider
    public Object[][] pop() {
        return new Object[][] { { "http://www.smartbuyglasses.co.uk/optical-centre/search-results?popular=true" },
                { "http://www.smartbuyglasses.com/optical-center/search-results?popular=true" },
                { "http://www.smartbuyglasses.dk/optisk-center/search-results?popular=true" } };
    }

    @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "debug", "smoke" })
    public void intoPimcore(String url) {
        getURL(url);
        HomePage homePage = new HomePage();
        homePage.waitForVisibility(homePage.linkPimcore, 5);
        homePage.linkPimcore.click();
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.divPimcoreHomeContentNo1, 5);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuEye(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuEye, 5);
        String expectTitle1 = pimcorePage.linkMenuEye.getText().toLowerCase();
        pimcorePage.deleteHead();
        pimcorePage.linkMenuEye.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle1 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle1, expectTitle1);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuSun(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuSun, 5);
        String expectTitle2 = pimcorePage.linkMenuSun.getText().toLowerCase();
        pimcorePage.deleteHead();
        pimcorePage.linkMenuSun.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle2 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle2, expectTitle2);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuCL(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuCL, 5);
        String expectTitle3 = pimcorePage.linkMenuCL.getText().toLowerCase();
        if (url == "http://www.smartbuyglasses.com/optical-center") {
            expectTitle3 = "contact lenses";
        }
        pimcorePage.deleteHead();
        pimcorePage.linkMenuCL.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle3 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle3, expectTitle3);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuEH(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuEH, 5);
        String expectTitle4 = pimcorePage.linkMenuEH.getText().toLowerCase();
        pimcorePage.deleteHead();
        pimcorePage.linkMenuEH.click();
        pimcorePage.waitForVisibility(pimcorePage.textTitle, 5);
        String actualTitle4 = pimcorePage.textTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle4, expectTitle4);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuSearch(String url) {
        getURL(url);
        String searchContent = "glasses";
        String urlAppend = "/search-results?term=glasses";
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.inputSearch.sendKeys(searchContent);
        pimcorePage.buttonSearch.click();
        String actualUrl = pimcorePage.getCurrentUrl();
        String expectUrl = url + urlAppend;
        pimcorePage.AsssetEquals(actualUrl, expectUrl);
        pimcorePage.waitForVisibility(pimcorePage.linkSearchAppendMenu, 5);
        pimcorePage.AsssetEquals(pimcorePage.linkSearchAppendMenu.get(0).getAttribute("href"), expectUrl + "&category=eyeglasses&page=1&popular=0");
        pimcorePage.AsssetEquals(pimcorePage.linkSearchAppendMenu.get(1).getAttribute("href"), expectUrl + "&category=sunglasses&page=1&popular=0");
        pimcorePage.AsssetEquals(pimcorePage.linkSearchAppendMenu.get(2).getAttribute("href"), expectUrl + "&category=contact-lenses&page=1&popular=0");
        pimcorePage.AsssetEquals(pimcorePage.linkSearchAppendMenu.get(3).getAttribute("href"), expectUrl + "&category=eye-health&page=1&popular=0");
        pimcorePage.AsssetEquals(pimcorePage.linkSearchAppendMenu.get(4).getAttribute("href"), expectUrl + "&category=optician&page=1&popular=0");
        pimcorePage.waitForVisibility(pimcorePage.linkSearchResult, 5);
        pimcorePage.AsssetTrue(pimcorePage.linkSearchResult.size() > 0, " DON'T FIND THE SEARCH RESULT !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuOptician(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkOptician, 5);
        pimcorePage.deleteHead();
        pimcorePage.waitForVisibility(pimcorePage.linkOptician, 5);
        pimcorePage.JsMouse(pimcorePage.linkOptician);
        pimcorePage.linkOptician.click();
        String actualUrl = pimcorePage.getCurrentUrl();
        String expectUrl = url + "/optician";
        pimcorePage.AsssetEquals(actualUrl, expectUrl);
        pimcorePage.waitForVisibility(pimcorePage.divOpticianContent, 5);
        pimcorePage.AsssetTrue(pimcorePage.divOpticianContent.size() > 0, " DON'T FIND THE OPTICIAN MESSAGE !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void menuContent(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.divPimcoreHomeContentNo1, 5);
        pimcorePage.deleteHead();
        //
        String splitUrl = url.split("/")[3];
        String href = pimcorePage.divPimcoreHomeContentNo1.getAttribute("href");
        pimcorePage.AsssetTrue(href.contains(splitUrl), " HREF DON'T CONTAINS " + splitUrl + " !!! ");
        pimcorePage.waitForVisibility(pimcorePage.divPimcoreHomeContentNo1, 5);
        pimcorePage.divPimcoreHomeContentNo1.click();
        pimcorePage.waitForVisibility(pimcorePage.textMGTitle, 5);
        pimcorePage.waitForVisibility(pimcorePage.imgContentDETAIL, 5);
    }

    // FIXME
    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void mostPopularPost(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.MostPopluarPostS, 10);
        pimcorePage.deleteHead();
        Random random = new Random();
        int num = random.nextInt(4) + 1;
        String splitUrl = url.split("/")[3];
        String href = pimcorePage.MostPopluarPostS.get(num).getAttribute("href");
        pimcorePage.AsssetTrue(href.contains(splitUrl), " HREF DON'T CONTAINS " + splitUrl + " !!! ");
        pimcorePage.waitForVisibility(pimcorePage.MostPopluarPostS.get(num), 10);
        pimcorePage.JsMouse(pimcorePage.MostPopluarPostS.get(num));
        pimcorePage.MostPopluarPostS.get(num).click();
        pimcorePage.waitForVisibility(pimcorePage.textMGTitle, 5);
        pimcorePage.waitForVisibility(pimcorePage.imgContentDETAIL, 5);
        //
        pimcorePage.deleteHead();
        String href0 = pimcorePage.MostPopluarPostS.get(0).getAttribute("href");
        pimcorePage.AsssetTrue(href0.contains(splitUrl), " HREF DON'T CONTAINS " + splitUrl + " !!! ");
        pimcorePage.waitForVisibility(pimcorePage.MostPopluarPostS.get(0), 5);
        pimcorePage.JsMouse(pimcorePage.MostPopluarPostS.get(0));
        pimcorePage.MostPopluarPostS.get(0).click();
        pimcorePage.waitForVisibility(pimcorePage.textMGTitle, 5);
        pimcorePage.waitForVisibility(pimcorePage.imgContentDETAIL, 5);
    }

    @Test(groups = { "debug", "smoke" })
    public void menuMG() {
        String url = "http://www.smartbuyglasses.co.uk/optical-centre";
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.waitForVisibility(pimcorePage.linkMenuMG, 5);
        pimcorePage.deleteHead();
        pimcorePage.linkMenuMG.click();
        pimcorePage.waitForVisibility(pimcorePage.textMGTitle, 5);
        String actualTitle7 = pimcorePage.textMGTitle.getText().toLowerCase();
        Assert.assertEquals(actualTitle7, "smart glasses of 2016");
    }

    @Test(groups = { "debug", "smoke" })
    public void menuSearchResultAppendMenu() {
        String url = "http://www.smartbuyglasses.com/optical-center/search-results?term=glasses";
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        pimcorePage.deleteHead();
        Random random = new Random();
        int num = random.nextInt(5);
        pimcorePage.waitForVisibility(pimcorePage.linkSearchAppendMenu, 5);
        pimcorePage.linkSearchAppendMenu.get(num).click();
        pimcorePage.waitForVisibility(pimcorePage.linkAppendMenuClicked, 5);
        pimcorePage.waitForVisibility(pimcorePage.linkSearchResult, 5);
        pimcorePage.AsssetTrue(pimcorePage.linkSearchResult.size() > 0, " DON'T FIND THE DATE¡¡MESSAGE !!!");
    }

    // FIXME
    /**
     * because pimcore is different with other page , so we need check header
     */
    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void headerSearchRayban(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        Header header = new Header();
        header.inputSearch.sendKeys("rayban");
        header.waitForVisibility(header.iconSearch, 2);
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        String brand = resultPage.resultGrid().getItem(0).getBrand();
        header.AsssetEquals(brand, "Ray-Ban");
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void headerSearchAcuVue(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        Header header = new Header();
        header.inputSearch.sendKeys("acuvue");
        header.waitForVisibility(header.iconSearch, 2);
        header.iconSearch.click();
        SearchResultPage resultPage = new SearchResultPage();
        String acuvueBand = resultPage.resultGrid().getItem(0).getBrand();
        Assert.assertTrue(acuvueBand.contains("Acuvue"), "Expected acuvue displayed, but no");

    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void headerMenuSun(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        Menu menu = new Menu();
        String menuNo1 = menu.getLeftSubMenuElement(1, 1, 1).getAttribute("href");
        String slitUrl = url.split("/")[2];
        String expectUrl1 = "http://" + slitUrl + "/designer-sunglasses/general/-Men----------------------";
        menu.AsssetEquals(menuNo1, expectUrl1);
        String menuNo2 = menu.getLeftSubMenuElement(1, 2, 3).getAttribute("href");
        String expectUrl2 = "http://" + slitUrl + "/designer-sunglasses/general/--------------1---------";
        menu.AsssetEquals(menuNo2, expectUrl2);
        String menuNo3 = menu.getLeftSubMenuElement(1, 3, 1).getAttribute("href");
        String expectUrl3 = "http://" + slitUrl + "/designer-sunglasses/general/---------------------prescription--";
        menu.AsssetEquals(menuNo3, expectUrl3);
        if (!(url == "http://www.smartbuyglasses.dk/optisk-center")) {
            String menuNo21 = menu.getMiddleSubmenuElement(1, 1, 1).getAttribute("href");
            String expectUrl21 = "http://" + slitUrl + "/designer-sunglasses/general/--Aviator---------------------";
            menu.AsssetEquals(menuNo21, expectUrl21);
        }
        else {
            String menuNo21 = menu.getMiddleSubmenuElement(1, 1, 1).getAttribute("href");
            String expectUrl21 = "http://www.smartbuyglasses.dk/designer-sunglasses/general/--Pilot---------------------";
            menu.AsssetEquals(menuNo21, expectUrl21);
        }
        String menuNo23 = menu.getMiddleSubmenuElement(1, 3, 1).getAttribute("href");
        String expectUrl23 = "http://" + slitUrl + "/designer-sunglasses/general/-------Plastic----------------";
        menu.AsssetEquals(menuNo23, expectUrl23);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void headerMenuBrank(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        Menu menu = new Menu();
        menu.mouseOverMainMenu(1);
        menu.mouseOver(menu.getMegaMenuBrandInitialElement(1, "A"));
        pimcorePage.waitForVisibility(pimcorePage.linkMenuBrandASection, 2);
        String adidas = pimcorePage.linkMenuBrandASection.getText();
        menu.AsssetEquals(adidas, "Adidas");
        String brankUrl = pimcorePage.linkMenuBrandASection.getAttribute("href");
        String slitUrl = url.split("/")[2];
        String expectUrl = "http://" + slitUrl + "/designer-sunglasses/Adidas/";
        menu.AsssetEquals(brankUrl, expectUrl);
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void headerMenuBrandImg(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        Menu menu = new Menu();
        menu.mouseOverMainMenu(1);
        pimcorePage.waitForVisibility(pimcorePage.linkMenuBrandIMG, 2);
        String imgSrc = null;
        String imgDataUrl = null;
        String raybanIMG = "http://cdn1.smartbuyglasses.com/public/images/showbrand/brand_Ray%20Ban.gif";
        for (int i = 0; i < 16; i++) {
            imgSrc += pimcorePage.linkMenuBrandIMG.get(i).getAttribute("src");
            imgDataUrl += pimcorePage.linkMenuBrandIMG.get(i).getAttribute("data-url");
        }
        menu.AsssetTrue(imgSrc.contains(raybanIMG), " DON'T CONTAINS RAYBAN BRAND !!!");
        menu.AsssetTrue(imgDataUrl.contains(raybanIMG), " DON'T CONTAINS RAYBAN BRAND !!!");
    }

    @Test(skipFailedInvocations = true, dataProvider = "pk", groups = { "debug", "smoke" })
    public void headerMenuDealsIMG(String url) {
        getURL(url);
        PimcorePage pimcorePage = new PimcorePage();
        Menu menu = new Menu();
        menu.mouseOverMainMenu(7);
        menu.waitForVisibility(menu.dealShowNow, 1);
        menu.waitForVisibility(menu.dealBuyNow, 1);
        menu.waitForVisibility(menu.dealSunGlass, 1);
        menu.waitForVisibility(menu.dealEyeGlass, 1);
        //
        String handle = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            handle = driver.getWindowHandle();
            String imgSrc = menu.dealIMG.get(i).getAttribute("src").toString();
            js.executeScript("window.open('" + imgSrc + "')");
            Set<String> handles = driver.getWindowHandles();
            // check img is display
            for (String window : handles) {
                if (!(window.equals(handle))) {
                    driver.switchTo().window(window);
                    Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
                    driver.close();
                }
            }
            driver.switchTo().window(handle);
        }
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }

}
