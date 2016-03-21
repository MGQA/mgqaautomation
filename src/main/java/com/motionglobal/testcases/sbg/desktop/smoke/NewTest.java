package com.motionglobal.testcases.sbg.desktop.smoke;

import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.Header;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class NewTest extends AbstractBaseTestCase {

    @Test(groups = "!debug")
    public void f() throws InterruptedException {
        driver.get("http://www.smartbuyglasses.com/");
        Header header = new Header();
        header.mouseOverMainMenu(2);
        String name1 = header.getLeftSubMenuElement(2, 3, 1).getText();
        String name2 = header.getLeftSubMenuElement(2, 3, 2).getText();
        String name3 = header.getLeftSubMenuElement(2, 3, 3).getText();
        System.out.println(name1 + "1" + name2 + "2" + name3 + "3");
        Thread.sleep(3000);
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
