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
