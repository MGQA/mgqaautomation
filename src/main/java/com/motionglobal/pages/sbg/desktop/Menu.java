package com.motionglobal.pages.sbg.desktop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu extends Header {

    // menu
    @FindBy(className = "menuN_display")
    public WebElement menuDisplay;

    // menu 6
    @FindBy(css = ".explore_right>a")
    public List<WebElement> subMenu6Right;
    @FindBy(css = ".explore_left>div[style*='block;']>a")
    public WebElement subMenu6LeftLink;
    @FindBy(css = ".explore_left>div[style*='block;']>a>img")
    public WebElement subMenu6LeftIMG;

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
        return driver.findElement(By.xpath("//ul[@id='menuN_level_" + mainMenuNum + "']/li/div/div[1]/ul[" + sectionNum + "]/li[" + rowNum + "]/a"));
    }

    public WebElement getMiddleSubmenuElement(int mainMenuNum, int model, int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_" + mainMenuNum + "']/li/div/div[2]/ul[" + model + "]/li[" + rowNum + "]/a"));
    }

    /**
     * mainMenuNumber is 1 to 5;
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
            System.out.println("mainMenuNumber is 1 to 5;");
            break;
        }
        return a;
    }

    /**
     * mainMenuNumber is 1 and 2 and 4;
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
            System.out.println("mainMenuNumber is 1 and 2 and 4;");
            break;
        }
        return ele;
    }

    /**
     * mainMenuNumber is 1 and 2 and 4;
     */
    public WebElement getMegaMenuBrandInitialElement(int mainMenuNum, String firstLetter) {
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
            System.out.println("mainMenuNumber is 1 and 2 and 4;");
            break;
        }
        return ele;
        // return driver.findElement(By.cssSelector("span[id^='sub_'][id$='_" + firstWorld + "_tab'] a"));
    }

    // private get Element methods ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！

    private WebElement getCLDailyElement(int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[1]/ul/li[" + rowNum + "]/a"));
    }

    public WebElement getCLWeeklyElement(int rowNum) {
        return driver.findElement(By.xpath("//ul[@id='menuN_level_5']/li/div/div[2]/div[2]/ul[1]/li[" + rowNum + "]/a"));
    }

    private WebElement getCLMonthlyElement(int rowNum) {
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

    public void mouseOverMainMenu(int mainMenuNum) throws Error {
        waitForVisibility(getMegaMenuMainElement(mainMenuNum), 2);
        mouseOver(getMegaMenuMainElement(mainMenuNum));
        try {
            waitForVisibility(menuDisplay, 1);
        }
        catch (Exception e) {
            if (mainMenuNum == 1)
                mouseOver(getMegaMenuMainElement(2));
            else
                mouseOver(getMegaMenuMainElement(mainMenuNum - 1));
            waitForVisibility(menuDisplay, 1);
            mouseOver(getMegaMenuMainElement(mainMenuNum));
            waitForVisibility(menuDisplay, 1);
        }
    }

    // click step methods ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public void clickMiddleSubMenu(int mainMenuNum, int sectionNum, int rowNum) {
        mouseOverMainMenu(mainMenuNum);
        if (mainMenuNum < 5)
            getMiddleSubmenuElement(mainMenuNum, sectionNum, rowNum).click();
        else {
            switch (sectionNum) {
            case 1:
                waitForVisibility(getCLDailyElement(rowNum), 5);
                getCLDailyElement(rowNum).click();
                break;
            case 2:
                waitForVisibility(getCLWeeklyElement(rowNum), 5);
                getCLWeeklyElement(rowNum).click();
                break;
            case 3:
                waitForVisibility(getCLMonthlyElement(rowNum), 5);
                getCLMonthlyElement(rowNum).click();
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

    @Override
    protected void waitPageLoad() {
    }
}
