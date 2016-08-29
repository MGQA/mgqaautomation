package com.motionglobal.testcases.sbg.desktop.smoke;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.MysqlConnect219Util;
import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.desktop.footer.aboutus.AccountPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class TestAccount extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        return new Object[][] { {} };
    }

    // FIXME CASE 1
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void accountReward() {
        // get data reward
        String[][] sumAllReward = null;
        String[][] sumUseReward = null;
        try {
            MysqlConnect219Util
                    .updateSQL("UPDATE om_pay_rewards_log SET member_id='775310',currency_code='GBP' WHERE currency_code='EUR' and is_active=1 and `status`=1 LIMIT 1;");
            sumAllReward = MysqlConnect219Util
                    .getTestData("select SUM(ava_rewards) from om_pay_rewards_log  where member_id=775310 and is_active=1 and `status`=1;");
            sumUseReward = MysqlConnect219Util.getTestData("select SUM(ava_rewards) from sbg_pay_rewards_log  where member_id=775310 and is_active=1;");
        }
        catch (Exception e) {
        }
        double allReward;
        if (sumAllReward[0][0] == null) {
            allReward = 0.0;
        }
        else {
            allReward = Double.parseDouble(sumAllReward[0][0]);
        }
        double useReward;
        if (sumUseReward[0][0] == null) {
            useReward = 0.0;
        }
        else {
            useReward = Double.parseDouble(sumUseReward[0][0]);
        }

        // check page reward
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.co.uk/"));
        String url = "https://www.smartbuyglasses.co.uk/membership/";
        getURL(url);
        AccountPage accountPage = new AccountPage();
        accountPage.AsssetTrue(accountPage.accountName.getText().contains("test"), " ACCOUNT NAME DON'T MATCH !!!");
        double dispalyRemainPrice = 0.0;
        for (int i = 1; i < accountPage.remainReward.size(); i++) {
            double remainPrice = accountPage.regexGetMath(accountPage.remainReward.get(i).getText().replace(",", "."));
            dispalyRemainPrice = accountPage.mathAdd(dispalyRemainPrice, remainPrice);
        }
        double dispalyUsePrice = 0.0;
        for (int i = 1; i < accountPage.remainReward.size(); i++) {
            double usePrice = accountPage.regexGetMath(accountPage.useReward.get(i).getText().replace(",", "."));
            dispalyUsePrice = accountPage.mathAdd(dispalyUsePrice, usePrice);
        }
        double remainReward = accountPage.mathSub(allReward, useReward);
        Assert.assertEquals(dispalyRemainPrice, remainReward);
        Assert.assertEquals(dispalyUsePrice, useReward);

        // check login reward
        accountPage.displayLogin();
        Boolean haveReward;
        try {
            accountPage.waitForVisibility(accountPage.loginReward, 1);
            haveReward = true;
        }
        catch (Exception e) {
            haveReward = false;
        }
        if (haveReward) {
            double loginReward = accountPage.regexGetMath(accountPage.loginReward.getText());
            Assert.assertEquals(loginReward, remainReward);
        }
        else {
            Assert.assertEquals(0, remainReward);
        }
    }

    // FIXME CASE 2
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" }, priority = 0)
    public void addPrescription() {
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.co.uk/"));
        String url = "https://www.smartbuyglasses.co.uk/membership/add-prescription/";
        getURL(url);
        AccountPage accountPage = new AccountPage();
        accountPage.waitForVisibility(accountPage.radioPrePC, 5);
        try {
            accountPage.deleteHead();
            accountPage.deleteLetTalk();
        }
        catch (Exception e) {
        }
        accountPage.radioPrePC.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(accountPage.tbody, "Near PD")));
        //
        accountPage.selectValue(accountPage.rightSPH, "-4.50");
        accountPage.selectValue(accountPage.rightCYL, "+4.75");
        accountPage.selectValue(accountPage.rightAX, "1");
        accountPage.selectValue(accountPage.rightADD, "0.75");
        //
        accountPage.selectValue(accountPage.leftSPH, "-4.50");
        accountPage.selectValue(accountPage.leftCYL, "+4.75");
        accountPage.selectValue(accountPage.leftAX, "1");
        accountPage.selectValue(accountPage.leftADD, "0.75");
        //
        accountPage.selectValue(accountPage.PD, "60");

        Random random = new Random();
        int Num = random.nextInt(9999999);
        String preName = "my prescription" + Num;
        accountPage.preName.sendKeys(preName);
        accountPage.JsMouse(accountPage.btnSave);
        accountPage.btnSave.click();
        accountPage.acceptAlert();
        accountPage.waitForVisibility(accountPage.newPre, 10);
        String newPre = accountPage.newPre.getText();
        accountPage.AsssetTrue(newPre.contains(preName), " NEW CREATE PRESCRIPTION FAIL !!! ");
    }

    // FIXME CASE 3
    @Test(skipFailedInvocations = true, groups = { "debug", "smoke" })
    public void checkAccount() {
        getURL(AbstractBasePage.getLoginRequest("http://www.smartbuyglasses.co.uk/"));
        String url = "https://www.smartbuyglasses.co.uk/membership/account-information/";
        getURL(url);
        AccountPage accountPage = new AccountPage();
        String email = accountPage.infoEmail.getText();

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
