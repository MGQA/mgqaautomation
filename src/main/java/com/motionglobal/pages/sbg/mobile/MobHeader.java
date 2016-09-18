package com.motionglobal.pages.sbg.mobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.AbstractBasePage;

public class MobHeader extends AbstractBasePage {
    //
    @FindBy(className = "header__notice__text")
    public WebElement discount;
    @FindBy(className = "close_btn")
    public WebElement closeHappySummer;
    //
    @FindBy(className = "header__menu-btn")
    public WebElement btnMenu;
    @FindBy(className = "header__search-btn")
    public WebElement searchBtn;
    @FindBy(className = "logo_image")
    public WebElement logo;
    @FindBy(id = "search_input")
    public WebElement searchInput;
    @FindBy(className = "header__cart-nav")
    public WebElement cartBox;
    @FindBy(className = "header__cart-num")
    public WebElement cartNum;
    @FindBy(className = "main__type__li__sign")
    public WebElement btnLogin;
    @FindBy(css = ".member_signout")
    public WebElement btnLogout;
    @FindBy(xpath = "//input[@placeholder='E-mail Address']")
    public WebElement emailAddress;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passWord;
    @FindBy(className = "submit_login")
    public WebElement signIn;
    @FindBy(className = "member_hello")
    public WebElement account;

    // footer
    @FindBy(className = "footer__navs__item")
    public List<WebElement> footer;
    @FindBy(css = ".footer__shares__item")
    public List<WebElement> share;

    // XXX MENU
    @FindBy(css = ".main__type__li__open>ul>li")
    public List<WebElement> subMenuS;
    @FindBy(css = ".main__type__li__open>ul>li .main__type__li__open>ul>li")
    public List<WebElement> subSubMenuS;

    public enum MegaMenu {
        SUN, EYE, CL, DEALS, EXPLORE;
    }

    public WebElement getMainMenuElement(MegaMenu megaMenuName) {
        WebElement element = null;
        switch (megaMenuName) {
        case SUN:
            element = driver.findElement(By.xpath("//ul[@class='index__menu']/li[1]/div/div[1]/span"));
            break;
        case EYE:
            element = driver.findElement(By.xpath("//ul[@class='index__menu']/li[2]/div/div[1]/span"));
            break;
        case CL:
            element = driver.findElement(By.xpath("//ul[@class='index__menu']/li[4]/div/div[1]/span"));
            break;
        case DEALS:
            element = driver.findElement(By.xpath("//ul[@class='index__menu']/li[6]/div/div[1]/span"));
            break;
        case EXPLORE:
            element = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[8]/div/div[1]"));
            break;
        default:
            System.out.println("");
            break;
        }
        return element;
    }

    @Override
    protected void waitPageLoad() {
    }
}