package com.motionglobal.testcases.sbg.desktop.home;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.pages.sbg.desktop.stylefinder.StyleFinderPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * com £º header ¡ª¡ª help link
 * 
 */
public class TestHelpLink extends AbstractBaseSbgDesktopTestCase {
    @Test(groups = { "smoke", "debug" })
    public void testHelpLink() {
        String url = "http://www.smartbuyglasses.com/";
        getURL(url);
        Header header = new Header();
        clickHelpLink(1);
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/faq");
        clickHelpLink(2);
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/help?sel=1#contactus");
        header.JsClick(header.getHelpLinkElement(3));
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/virtual-try-on");
        clickHelpLink(4);
        Assert.assertTrue(new StyleFinderPage().StyleFrame.isDisplayed());
        new StyleFinderPage().StykeFrameCloseBtn.click();
        clickHelpLink(5);
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/shopping-guides");
        clickHelpLink(6);
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/returns");
        clickHelpLink(7);
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/fast-shipping");
        String linkUrl = header.getHelpLinkElement(8).getAttribute("href");
        Assert.assertEquals(linkUrl, "http://www.smartbuyglasses.com/premium-lens");
        // clickHelpLink(8);
        // Assert.assertEquals(driver.getCurrentUrl(), "http://www.smartbuyglasses.com/premium-lens");
    }

    private void clickHelpLink(int Num) {
        Header header = new Header();
        header.waitForVisibility(header.Help, 5);
        header.mouseOver(header.Help);
        header.waitForVisibility(header.getHelpLinkElement(Num), 2);
        header.getHelpLinkElement(Num).click();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
