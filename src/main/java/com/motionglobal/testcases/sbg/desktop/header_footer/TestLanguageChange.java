package com.motionglobal.testcases.sbg.desktop.header_footer;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.footer.Language;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestLanguageChange extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "smoke", "" })
    public void testSunGlassesHeaderMenus() {
        logger().info("started...");
        driver.get("http://www.smartbuyglasses.com/");
        Language language = new Language();
        for (String value : language.countryIDs) {
            language.selectCountryLanguageByIndex(value, 0);
            Assert.assertArrayEquals(language.countryIDs, language.getCountryIDs());
            p(language.languageSelect);
            logger().info(language.getCurrentLanguage());
        }

        // p(driver.findElements(By.cssSelector("select.country-select option")));
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
