package com.motionglobal.testcases.sbg.desktop.header_footer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestLanguageChange extends AbstractBaseSbgDesktopTestCase {

    public void testSunGlassesHeaderMenus() {
        logger().info("started...");
        HomePage homePage = new HomePage();
        for (String value : homePage.header().countryIDs) {
            homePage.header().selectCountryLanguageByIndex(value, 0);

            Assert.assertArrayEquals(homePage.header().countryIDs, getCountryIDs());
            p(driver.findElements(By.cssSelector("select.language-select option")));
            logger().info(homePage.header().getCurrentLanguage());
        }

        // p(driver.findElements(By.cssSelector("select.country-select option")));
    }

    public String[] getCountryIDs() {
        List<WebElement> eles = driver.findElements(By.cssSelector("#header_lang_select select.country-select option"));
        String[] sarray = new String[eles.size()];
        for (int i = 0; i < eles.size(); i++) {
            sarray[i] = eles.get(i).getAttribute("value");
        }
        return sarray;
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void tearDown() {
        // TODO Auto-generated method stub

    }

}
