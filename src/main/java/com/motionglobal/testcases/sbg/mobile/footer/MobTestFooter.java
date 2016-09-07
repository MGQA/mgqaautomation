package com.motionglobal.testcases.sbg.mobile.footer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.mobile.MobHeader;
import com.motionglobal.pages.sbg.mobile.footer.MobFooterPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class MobTestFooter extends AbstractBaseTestCase {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] { new Object[] { "http://m.smartbuyglasses.com/" } };
    }

    // XXX case 1
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void share(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.JsMouse(header.share.get(0));
        String shareFaceBook = header.share.get(0).getAttribute("href");
        Assert.assertEquals(shareFaceBook, "https://www.facebook.com/SmartBuyGlasses");
        String shareYoutube = header.share.get(1).getAttribute("href");
        Assert.assertEquals(shareYoutube, "https://www.youtube.com/user/SmartBuyGlasses");
        String shareInstagram = header.share.get(2).getAttribute("href");
        Assert.assertEquals(shareInstagram, "https://www.instagram.com/smartbuyglasses/");
        String sharePinterest = header.share.get(3).getAttribute("href");
        Assert.assertEquals(sharePinterest, "https://www.pinterest.com/smartbuyglasses/");
        String shareBlog = header.share.get(4).getAttribute("href");
        Assert.assertEquals(shareBlog, "http://blog.smartbuyglasses.com/");
    }

    // XXX case 2
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void aboutUs(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.mouseAndClick(header.footer.get(0));
        MobFooterPage footerPage = new MobFooterPage();
        String title = footerPage.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title, "aboutus");
        String pimcore = "http://m.smartbuyglasses.com/optical-center/";
        getURL(pimcore);
        header.mouseAndClick(header.footer.get(0));
        MobFooterPage footerPage1 = new MobFooterPage();
        String title2 = footerPage1.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title2, "aboutus");
    }

    // XXX case 3
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void contactUs(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.mouseAndClick(header.footer.get(1));
        MobFooterPage footerPage = new MobFooterPage();
        String title = footerPage.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title, "contactus");
        String pimcore = "http://m.smartbuyglasses.com/optical-center/";
        getURL(pimcore);
        header.mouseAndClick(header.footer.get(1));
        MobFooterPage footerPage1 = new MobFooterPage();
        String title2 = footerPage1.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title2, "contactus");

    }

    // XXX case 4
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void term(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.mouseAndClick(header.footer.get(2));
        MobFooterPage footerPage = new MobFooterPage();
        String title = footerPage.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title, "termsconditions");
        String pimcore = "http://m.smartbuyglasses.com/optical-center/";
        getURL(pimcore);
        header.mouseAndClick(header.footer.get(2));
        MobFooterPage footerPage1 = new MobFooterPage();
        String title2 = footerPage1.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title2, "termsconditions");
    }

    // XXX case 5
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void faq(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.mouseAndClick(header.footer.get(3));
        MobFooterPage footerPage = new MobFooterPage();
        String title = footerPage.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title, "faq");
        String pimcore = "http://m.smartbuyglasses.com/optical-center/";
        getURL(pimcore);
        header.mouseAndClick(header.footer.get(3));
        MobFooterPage footerPage1 = new MobFooterPage();
        String title2 = footerPage1.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title2, "faq");
    }

    // XXX case 6
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void orderTracking(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.mouseAndClick(header.footer.get(4));
        MobFooterPage footerPage = new MobFooterPage();
        String title = footerPage.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title, "ordertracking");
        String pimcore = "http://m.smartbuyglasses.com/optical-center/";
        getURL(pimcore);
        header.mouseAndClick(header.footer.get(4));
        MobFooterPage footerPage1 = new MobFooterPage();
        String title2 = footerPage1.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title2, "ordertracking");
    }

    // XXX case 7
    @Test(skipFailedInvocations = true, dataProvider = "dp", groups = { "debug2", "smoke" })
    public void privacyPolicy(String url) throws InterruptedException {
        getURL(url);
        MobHeader header = new MobHeader();
        header.mouseAndClick(header.footer.get(5));
        MobFooterPage footerPage = new MobFooterPage();
        String title = footerPage.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title, "privacypolicy");
        String pimcore = "http://m.smartbuyglasses.com/optical-center/";
        getURL(pimcore);
        header.mouseAndClick(header.footer.get(5));
        MobFooterPage footerPage1 = new MobFooterPage();
        String title2 = footerPage1.regexGetLetterLow(footerPage.title.getText());
        Assert.assertEquals(title2, "privacypolicy");
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }
}
