package com.motionglobal.pages.sbg.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;

public class Header extends AbstractBasePage {
    @FindBy(id = "logo")
    public WebElement logo;
    @FindBy(xpath = "//div[@id='cart']/a/i")
    public WebElement cartBox;
    // heard login link
    @FindBy(xpath = "//li[@id='signin_li']/a/span")
    public WebElement loginlable;
    // after moveover heard login links
    @FindBy(xpath = "//li[@id='signin_li']/div/div/span/a")
    public WebElement signin;
    // after press login button : Loginin new Windows
    @FindBy(xpath = "//form[@id='loginFormNew']/span")
    public WebElement signInButton;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    // Search
    @FindBy(id = "search_input")
    public WebElement inputSearch;
    @FindBy(css = ".search_image i.fa-search")
    public WebElement iconSearch;
    // Shop by Gender
    @FindBy(xpath = "//ul[@id='menuN_level_1']/li/div/div[1]/ul[1]/li[1]/a")
    public WebElement men;
    @FindBy(xpath = "//ul[@id='menuN_level_1']/li/div/div[1]/ul[1]/li[2]/a")
    public WebElement woMen;
    @FindBy(xpath = "//ul[@id='menuN_level_1']/li/div/div[1]/ul[1]/li[3]/a")
    public WebElement kid;

    // header list
    @FindBy(xpath = "//div[@class='center_contact_left']/div[2]/a")
    public WebElement dailyglass;
    @FindBy(linkText = "Top100")
    public WebElement sunTop100;
    @FindBy(xpath = "//*[@id='all_brand_for_contact_tab']/a/p")
    public WebElement lenseViewAllBrands;
    @FindBy(xpath = "//div[@class='center_contact_left']/div[2]/a")
    public WebElement lenseDailyViewAll;
    @FindBy(xpath = "//div[@class='shop_by_cont']/div[2]/div[2]/div[2]/a")
    public WebElement lenseWeeksViewAll;
    @FindBy(xpath = "//div[@class='shop_by_cont']/div[2]/div[2]/div[4]/a")
    public WebElement lenseMonthlyViewAll;
    //
    @FindBy(xpath = "//li[@id='signin_li_already']/a/span")
    public WebElement yourAccount;
    @FindBy(xpath = "//li[@id='signin_li_already']/div/div/p[2]/a")
    public WebElement signout;
    @FindBy(xpath = "//div[@id='top']/ul[1]/li[1]/a")
    public WebElement FREESHIPPING;
    @FindBy(xpath = "//div[@id='top']/ul/li[1]/div/ul/li[4]/a")
    public WebElement freeshipmoreinfo;
    @FindBy(xpath = "//div[@id='top']/ul/li[2]/a")
    public WebElement DayReturns;
    @FindBy(xpath = "//div[@id='top']/ul/li[2]/div/ul/li[5]/a")
    public WebElement DayReturnsMoreInfo;
    @FindBy(className = "newhead_banner2_en")
    public WebElement referAFriend;
    @FindBy(id = "by_email_btn")
    public WebElement shareByEmail;
    @FindBy(className = "newhead_banner_english")
    public WebElement optical_center;
    @FindBy(xpath = "//div[@id='favoriteDisplayDiv']/a/i")
    public WebElement favHeartButtonLink;

    // element //mainMenuNum model index
    /**
     * 
     * mainMenuNumber is 1 to 6;
     * 
     * @param mainMenuNum
     * @param brandLogoNum
     * @return
     */
    private WebElement getMegaMenuBrandLogoImage(int mainMenuNum, int brandLogoNum) {
        WebElement a = null;
        switch (mainMenuNum) {
        case 1:
            a = driver.findElement(By.xpath("//div[@id='top_sun_glass_list']/ul/li[" + brandLogoNum + "]/a/img"));
            break;
        case 2:
            a = driver.findElement(By.xpath("//div[@id='top_Eyeglasses_glass_list']/ul/li[" + brandLogoNum + "]/a/img"));
            break;
        case 3:
            a = driver.findElement(By.xpath("//div[@id='top_brand_sport_list']/ul/li[" + brandLogoNum + "]/a/img"));
            break;
        case 4:
            a = driver.findElement(By.xpath("//div[@id='top_brand_pre_list']/ul/li[" + brandLogoNum + "]/a/img"));
            break;
        case 5:
            a = driver.findElement(By.xpath("//div[@id='top_brand_contact_list']/ul/li[" + brandLogoNum + "]/a/img"));
            break;
        default:
            System.out.println("mainMenuNumber is 1 to 6;");
            break;
        }
        return a;
    }

    /**
     * mainMenuNumber is 1 & 2 & 4;
     * 
     * @param mainMenuNum
     * @param firstLetter
     * @param colNumber
     * @param rowNum
     * @return
     */
    private WebElement getMegaMenuBrandsNameElement(int mainMenuNum, String firstLetter, int colNumber, int rowNum) {
        WebElement ele = null;
        switch (mainMenuNum) {
        case 1:
            ele = driver.findElement(By.xpath("//div[@id='sub_Sunglasses_" + firstLetter + "_list']/ul[" + colNumber + "]/li[" + rowNum + "]/a"));
            break;
        case 2:
            ele = driver.findElement(By.xpath("//div[@id='sub_Eyeglasses_" + firstLetter + "_list']/ul[" + colNumber + "]/li[" + rowNum + "]/a"));
            break;
        case 4:
            ele = driver.findElement(By.xpath("//div[@id='sub_Prescription_Sunglasses_" + firstLetter + "_list']/ul[" + colNumber + "]/li[" + rowNum + "]/a"));
            break;
        default:
            System.out.println("mainMenuNumber is 1 & 2 & 4;");
            break;
        }
        return ele;
    }

    /**
     * mainMenuNumber is 1 & 2 & 4;
     * 
     * @param mainMenuNum
     * @param firstLetter
     * @return
     */
    private WebElement getMegaMenuBrandInitialElement(int mainMenuNum, String firstLetter) {
        WebElement ele = null;
        switch (mainMenuNum) {
        case 1:
            ele = driver.findElement(By.xpath("//span[@id='sub_Sunglasses_" + firstLetter + "_tab']/a"));
            break;
        case 2:
            ele = driver.findElement(By.xpath("//span[@id='sub_Eyeglasses_" + firstLetter + "_tab']/a"));
            break;
        case 4:
            ele = driver.findElement(By.xpath("//span[@id='sub_Prescription_Sunglasses_" + firstLetter + "_tab']/a"));
            break;
        default:
            System.out.println("mainMenuNumber is 1 & 2 & 4;");
            break;
        }
        return ele;
        // return driver.findElement(By.cssSelector("span[id^='sub_'][id$='_" + firstWorld + "_tab'] a"));
    }

    public WebElement getMegaMenuMainElement(int mainMenuNum) {
        return driver.findElement(By.xpath("//li[@id='menuN_" + mainMenuNum + "']/a"));
    }

    private WebElement getLeftSubmenuElement(int mainMenuNum, int sectionNum, int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_" + mainMenuNum + "']/li/div/div[1]/ul[" + sectionNum + "]/li[" + rowNum + "]/a"));
    }

    private WebElement getMiddleSubmenuElement(int mainMenuNum, int model, int index) {// TODO
        return driver.findElement(By.xpath("//ul[@id='menuN_level_" + mainMenuNum + "']/li/div/div[2]/ul[" + model + "]/li[" + index + "]/a"));
    }

    private WebElement getCLDailyElement(int index) {// TODO
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[1]/ul/li[" + index + "]/a"));
    }// *[@id='menuN_level_5']/li/div/div[2]/div[1]/ul/li[1]/a
     // *[@id='menuN_level_5']/li/div/div[2]/div[1]/ul/li[2]/a

    private WebElement getCLWeeklyElement(int index) {// TODO
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[1]/li[" + index + "]/a"));
    }// *[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[1]/li[1]/a
     // *[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[1]/li[2]/a

    private WebElement getLenseMonthlyElement(int index) {// TODO
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[2]/li[" + index + "]/a"));
    }// *[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[2]/li[1]/a
     // *[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[2]/li[2]/a

    public WebElement getAllShapesElement(int mainMenuNum) {
        return driver.findElement(By.xpath("//*[@id='menuN_level_" + mainMenuNum + "']/li/div/div[2]/div[2]/a"));
    }

    public String[] countryIDs = new String[] { "74", "4", "41", "48", "6", "60", "66", "62", "51", "12", "23", "49", "39", "16", "73", "21", "56", "70", "61",
            "14", "7", "64", "42", "68", "57", "67", "40", "24", "18", "58", "22", "11", "1", "71", "8", "59", "5", "10", "9" };

    public String getCountryIcon() {
        return null;
    }

    public String getCurrentLanguage() {
        return driver.findElement(By.cssSelector("#header_lang_select .country-name")).getText();
    }

    public HomePage selectCountryLanguageByIndex(String countryValue, int languageIndex) {
        driver.findElement(By.id("header_lang_select")).click();
        WebElement countrySelect = driver.findElement(By.cssSelector(".select-country select.country-select"));
        countrySelect.click();
        Select selCountry = new Select(countrySelect);
        selCountry.selectByValue(countryValue);

        // WebElement languageSelect = driver.findElement(By.cssSelector(".select-country select.language-select"));
        // languageSelect.click();
        // Select selLanguage = new Select(languageSelect);
        // selLanguage.selectByIndex(languageIndex);

        driver.findElement(By.cssSelector(".select-country .btn")).click();
        return new HomePage();
    }

    @Override
    protected void waitPageLoad() {
        // TODO Auto-generated method stub

    }

    public void clickMiddleSubMenu(int mainMenuNum, int sectionNum, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        if (mainMenuNum < 5)
            getMiddleSubmenuElement(mainMenuNum, sectionNum, rowNum).click();
        else {
            switch (sectionNum) {
            case 1:
                getCLDailyElement(rowNum);
                break;
            case 2:
                getLenseMonthlyElement(rowNum);
                break;
            case 3:
                getCLWeeklyElement(rowNum);
                break;
            }
        }
    }

    public void mouseOverMainMenu(int mainMenuNum) throws Error {
        this.mouseOver(getMegaMenuMainElement(mainMenuNum));
        this.waitForVisibility(By.cssSelector("#menuN_" + mainMenuNum + " .current"), 1);
    }

    public void clickLeftIndex(int mainMenuNum, int model, int index) {// TODO
        mouseOverMainMenu(mainMenuNum);
        getLeftSubmenuElement(mainMenuNum, model, index).click();
    }

    public void clickLogo(int mainMenuNum, int index) {
        mouseOverMainMenu(mainMenuNum);
        getMegaMenuBrandLogoImage(mainMenuNum, index).click();
    }

    public void clickBrands(int mainMenuNum, String firstLetter, int col, int index) {
        mouseOverMainMenu(mainMenuNum);
        this.mouseOver(getMegaMenuBrandInitialElement(mainMenuNum, firstLetter));
        getMegaMenuBrandsNameElement(mainMenuNum, firstLetter, col, index).click();
    }

}
