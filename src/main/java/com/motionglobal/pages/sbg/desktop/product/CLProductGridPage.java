package com.motionglobal.pages.sbg.desktop.product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class CLProductGridPage extends AbstractBaseSbgDesktopPage {

    public void assertCLGridPage(String clickedName) {
        String displayName = driver.findElement(By.xpath("//*[@id='CL_Breadcrumb']")).getText();
        Pattern pattern = Pattern.compile("/ ");
        Matcher matcher = pattern.matcher(displayName);
        Assert.assertTrue(clickedName.contains(matcher.replaceAll("")), "Not the CL Grid page !");
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("CL-ProductCount"), 20);
    }

}
