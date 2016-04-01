package com.motionglobal.testcases.sbg.desktop.smoke;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.ExcelDataUtil;
import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class TestSunGlassesMenus extends AbstractBaseTestCase {
    @DataProvider(name = "DesktopTestData")
    public static Object[][] Words() throws IOException {
        return ExcelDataUtil.getExcelData("src/main/resources/", "DesktopTestData.xlsx", "Top100");
    }

    @Test(dataProvider = "DesktopTestData", groups = { "smoke" })
    public void top100(String url, String num) throws InterruptedException {
        driver.get(url);
        Header header = new Header();
        header.mouseOverMainMenu(1);
        header.sunTop100.click();
        ProductGridPage productGridPage = new ProductGridPage();
        // List<WebElement> sunTop100Eles = driver.findElements(By.className("proCell_click"));
        int i = Integer.parseInt(num);// String to int
        Assert.assertEquals(productGridPage.sunTop100Eles.size(), i, "sunglasses Top100 count : disagree");
        // p(header.sunTop100Eles.size());
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
