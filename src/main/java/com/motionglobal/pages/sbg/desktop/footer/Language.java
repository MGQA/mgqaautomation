package com.motionglobal.pages.sbg.desktop.footer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;
import com.motionglobal.pages.sbg.desktop.home.HomePage;

public class Language extends AbstractBaseSbgDesktopPage {
    @FindBy(css = "select.language-select option")
    public List<WebElement> languageSelect;

    public String[] countryIDs = new String[] { "74", "4", "41", "48", "6", "60", "66", "62", "51", "12", "23", "49", "39", "16", "73", "21", "56", "70", "61",
            "14", "7", "64", "42", "68", "57", "67", "40", "24", "18", "58", "22", "11", "1", "71", "8", "59", "5", "10", "9" };

    public String[] getCountryIDs() {
        List<WebElement> eles = driver.findElements(By.cssSelector("select.country-select option"));
        String[] sarray = new String[eles.size()];
        for (int i = 0; i < eles.size(); i++) {
            sarray[i] = eles.get(i).getAttribute("value");
        }
        return sarray;
    }

    public String getCountryIcon() {
        return null;
    }

    public String getCurrentLanguage() {
        return driver.findElement(By.cssSelector("a.cur .country-name")).getText();
    }

    public HomePage selectCountryLanguageByIndex(String countryValue, int languageIndex) {
        // driver.findElement(By.id("header_lang_select")).click();
        driver.findElement(By.xpath("//div[@id='footer_lang_select']/a")).click();
        WebElement countrySelect = driver.findElement(By.xpath("//*[@id='footer_lang_select']//p[1]/select"));
        countrySelect.click();
        Select selCountry = new Select(countrySelect);
        selCountry.selectByValue(countryValue);

        // WebElement languageSelect = driver.findElement(By.cssSelector(".select-country select.language-select"));
        // languageSelect.click();
        // Select selLanguage = new Select(languageSelect);
        // selLanguage.selectByIndex(languageIndex);

        driver.findElement(By.xpath("//*[@id='footer_lang_select']/div/div/a")).click();
        return new HomePage();
    }

    @Override
    protected void waitPageLoad() {
        // TODO Auto-generated method stub

    }

}
