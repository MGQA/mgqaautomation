package com.motionglobal.testcases.sbg.om;

import com.motionglobal.pages.sbg.om.OmLoginPage;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class OmLogin extends AbstractBaseTestCase {

    public OmLogin() {
        OmLoginPage page = new OmLoginPage();
        page.waitForVisibility(page.userName, 2);
        page.userName.sendKeys("jack.zhong");
        page.waitForVisibility(page.passWord, 2);
        page.passWord.sendKeys("motion@888");
        page.waitForVisibility(page.submit, 2);
        page.submit.click();
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }
}
