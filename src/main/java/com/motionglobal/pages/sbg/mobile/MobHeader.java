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
    public WebElement menuBtn;
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
    public WebElement loginBtn;
    @FindBy(xpath = "//input[@placeholder='E-mail Address']")
    public WebElement emailAddress;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passWord;
    @FindBy(className = "submit_login")
    public WebElement signIn;
    @FindBy(className = "member_hello")
    public WebElement account;
    // SUN Glasses
    @FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[1]/div/div[2]/ul/li[4]/a")
    public WebElement subMenuPolarized;
    @FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[1]/div/div[2]/ul/li[5]/a")
    public WebElement subMenuPre;
    @FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[1]/div/div[2]/ul/li[6]/a")
    public WebElement subMenuSki;
    // deals
    @FindBy(css = ".main__type__li [onclick*='Sunglasses'][onclick*='Deals']")
    public WebElement dealsSun;
    @FindBy(css = ".main__type__li [onclick*='Glasses'][onclick*='Deals']")
    public WebElement dealsEye;

    // footer
    @FindBy(className = "footer__navs__item")
    public List<WebElement> footer;
    @FindBy(css = ".footer__shares__item")
    public List<WebElement> share;

    //
    // public WebElement getMainMenuElement(int mainNum) {
    // WebElement element = driver.findElement(By.xpath("//ul[@class='index__menu']/li[" + mainNum + "]/div/div[1]/span"));
    // return element;
    // }

    public enum MegaMenu {
        SUN, EYE, CL, DEALS;
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
        default:
            System.out.println("");
            break;
        }
        return element;
    }

    public WebElement getSubMenuElement(int mainNum, int sectionNum) {
        WebElement element = driver.findElement(By.xpath("//div[@id='menu']//li[" + mainNum + "]//li[" + sectionNum + "]//div[span]"));
        return element;
    }

    public int getSubMenuElementSize(int mainNum, int sectionNum) {
        int size = driver.findElements(By.xpath("//*[@id='menu']//li[" + mainNum + "]//li[" + sectionNum + "]//li")).size();
        return size;
    }

    public WebElement getDetailLinkElement(int mainNum, int sectionNum, int rowNum) {
        WebElement element = driver.findElement(By.xpath("//*[@id='menu']//li[" + mainNum + "]//li[" + sectionNum + "]//li[" + rowNum + "]/a"));
        return element;
    }

    @Override
    protected void waitPageLoad() {
    }
}