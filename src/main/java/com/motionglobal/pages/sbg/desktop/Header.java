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
    // Style of Glasses button
    @FindBy(id = "buttonNext")
    public WebElement styleNextButton;
    @FindBy(id = "buttonPrevious")
    public WebElement stylePrevious;
    @FindBy(xpath = "//*[@id='show_result_page']/span")
    public WebElement styleRecommend;
    // header list
    @FindBy(xpath = "//*[@id='all_brand_for_contact_tab']/a/p")
    public WebElement clViewAllBrands;
    @FindBy(xpath = "//div[@class='center_contact_left']/div[2]/a")
    public WebElement clDailyViewAll;
    @FindBy(xpath = "//div[@class='shop_by_cont']/div[2]/div[2]/div[2]/a")
    public WebElement lenseWeeksViewAll;
    @FindBy(xpath = "//div[@class='shop_by_cont']/div[2]/div[2]/div[4]/a")
    public WebElement clMonthlyViewAll;
    //
    @FindBy(xpath = "//*[@id='menuN_level_1']/li/div/div[1]/ul[1]/li[1]/a")
    public WebElement men;
    @FindBy(xpath = "//div[@class='center_contact_left']/div[2]/a")
    public WebElement dailyglass;
    @FindBy(linkText = "Top100")
    public WebElement sunTop100;
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

    // public get Element methods ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public WebElement getMegaMenuMainElement(int mainMenuNum) {
        return driver.findElement(By.xpath("//li[@id='menuN_" + mainMenuNum + "']/a"));
    }

    public WebElement getAllShapesElement(int mainMenuNum) {
        return driver.findElement(By.xpath("//*[@id='menuN_level_" + mainMenuNum + "']/li/div/div[2]/div[2]/a"));
    }

    public WebElement getCLBrandsElement(int rowNum) {
        return driver.findElement(By.xpath("//*[@id='all_brand_for_contact_list']/ul/li[" + rowNum + "]/a"));
    }

    public WebElement getLeftSubMenuElement(int mainMenuNum, int sectionNum, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        return driver.findElement(By.xpath("//ul[@id='menuN_level_" + mainMenuNum + "']/li/div/div[1]/ul[" + sectionNum + "]/li[" + rowNum + "]/a"));
    }

    public WebElement getMiddleSubmenuElement(int mainMenuNum, int model, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        return driver.findElement(By.xpath("//ul[@id='menuN_level_" + mainMenuNum + "']/li/div/div[2]/ul[" + model + "]/li[" + rowNum + "]/a"));
    }

    /**
     * 
     * mainMenuNumber is 1 to 6;
     * 
     * @param mainMenuNum
     * @param brandLogoNum
     * @return
     */
    public WebElement getMegaMenuBrandLogoImage(int mainMenuNum, int brandLogoNum) {
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
    public WebElement getMegaMenuBrandsNameElement(int mainMenuNum, String firstLetter, int colNumber, int rowNum) {
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

    // private get Element methods ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！

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

    private WebElement getCLDailyElement(int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[1]/ul/li[" + rowNum + "]/a"));
    }

    private WebElement getCLWeeklyElement(int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[1]/li[" + rowNum + "]/a"));
    }

    private WebElement getLenseMonthlyElement(int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[2]/li[" + rowNum + "]/a"));
    }

    // Glass Style ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public WebElement getStyleUserGenderElement(int genderNum) {
        return driver.findElement(By.xpath("//*[@id='step-1']/div[1]/div[" + genderNum + "]/h4"));
    }

    public WebElement getStyleSunOrSportOrFrameElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-2']/div/div[" + typeNum + "]/div"));
    }

    public WebElement getStyleSportGlassStyleElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-3']/div/div[" + typeNum + "]/h4"));
    }

    public WebElement getStyleSunGlassStyleElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-4']/div/div[" + typeNum + "]/div"));
    }

    public WebElement getStyleFrameMaterialElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-5']/div/div[" + typeNum + "]/div"));
    }

    public WebElement getStyleFrameRimElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-6']/div/div[" + typeNum + "]/div"));
    }

    public WebElement getStyleFrameShapeElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-7']/div/div[" + typeNum + "]/h4"));
    }

    public WebElement getStyleFrameColorElement(int typeNum) {
        return driver.findElement(By.xpath("//*[@id='step-8']/div[1]/div[" + typeNum + "]/img"));
    }

    // ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
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

    // click step methods ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public void clickMiddleSubMenu(int mainMenuNum, int sectionNum, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        if (mainMenuNum < 5)
            getMiddleSubmenuElement(mainMenuNum, sectionNum, rowNum).click();
        else {
            switch (sectionNum) {
            case 1:
                getCLDailyElement(rowNum).click();
                break;
            case 2:
                getCLWeeklyElement(rowNum).click();
                break;
            case 3:
                getLenseMonthlyElement(rowNum).click();
                break;
            }
        }
    }

    public void clickLeftSubMenu(int mainMenuNum, int sectionNum, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        getLeftSubMenuElement(mainMenuNum, sectionNum, rowNum).click();
    }

    public void clickGlassImg(int mainMenuNum, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        getMegaMenuBrandLogoImage(mainMenuNum, rowNum).click();
    }

    public void clickBrands(int mainMenuNum, String firstLetter, int col, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        mouseOver(getMegaMenuBrandInitialElement(mainMenuNum, firstLetter));
        getMegaMenuBrandsNameElement(mainMenuNum, firstLetter, col, rowNum).click();
    }

    public void mouseOverMainMenu(int mainMenuNum) throws Error {
        try {
            Thread.sleep(300);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        mouseOver(getMegaMenuMainElement(mainMenuNum));
        waitForVisibility(By.cssSelector("#menuN_" + mainMenuNum + " .current"), 2);
    }

    public void confirmPage(String initUrl) {
        String laterUrl = driver.getCurrentUrl();
        int i = 0;
        while (initUrl.equalsIgnoreCase(laterUrl)) {
            try {
                Thread.sleep(200);
                if (i == 9) {
                    initUrl = "a";
                    laterUrl = "a";
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            laterUrl = driver.getCurrentUrl();
            i++;
        }
    }
}
