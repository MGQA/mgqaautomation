package com.motionglobal.pages.sbg.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.AbstractBaseContainer;
import com.motionglobal.pages.sbg.desktop.home.HomePage;

public class Header extends AbstractBaseContainer {

    @FindBy(id = "logo")
    public WebElement logo;
    @FindBy(id = "search_input")
    public WebElement inputSearch;
    @FindBy(css = ".search_image i.fa-search")
    public WebElement iconSearch;
    @FindBy(xpath = "//li[@id='signin_li']/a/span")
    public WebElement loginlable;
    @FindBy(xpath = "//li[@id='signin_li']/div/div/span/a")
    public WebElement signin;
    @FindBy(xpath = "//li[@id='menuN_1']/a")
    public WebElement sunglasses;
    @FindBy(xpath = "//ul[@id='menuN_level_1']//li/div/div[1]/ul[1]/li[1]/a")
    public WebElement men;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//form[@id='loginFormNew']/span")
    public WebElement signInButton;
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
    @FindBy(xpath = "//div[@id='cart']/a/i")
    public WebElement cartbox;

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
}
