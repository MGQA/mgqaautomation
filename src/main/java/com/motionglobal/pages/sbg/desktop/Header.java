package com.motionglobal.pages.sbg.desktop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.AbstractBasePage;

public class Header extends AbstractBasePage {
    // need delete head
    @FindBy(className = "Fixed_navigation_bar")
    public WebElement sliderBar;
    @FindBy(css = ".hp_topsmallad_box")
    public WebElement delDiscount;
    @FindBy(css = ".header_box")
    public WebElement delSearchHead;
    @FindBy(css = ".topbar_box")
    public WebElement delBlackHead;
    @FindBy(css = ".sidebar_lenses_div")
    public WebElement delAddLens;
    @FindBy(id = "lc_chat_layout")
    public WebElement letTalk;
    @FindBy(id = "pro_infor_list")
    public WebElement inforList;
    @FindBy(className = "geo-close-btn")
    public WebElement geo;

    // sliderBar
    @FindBy(css = "#Fixed_navigation_bar a[onclick*='Try']")
    public WebElement sliderTry;
    @FindBy(css = "#Fixed_navigation_bar a[onclick*='Newsletter']")
    public WebElement sliderNewsLetter;
    @FindBy(css = "#Fixed_navigation_bar a[onclick*='Eye Test']")
    public WebElement sliderEyeTest;
    @FindBy(css = ".omni_cont_popup.optical88-box")
    public WebElement eyeTestBox;
    //
    @FindBy(id = "logo")
    public WebElement logo;
    @FindBy(id = "mini_cart_items_total")
    public WebElement cartProductNum;
    @FindBy(xpath = "//div[@id='cart']/a/i")
    public WebElement cartBox;
    @FindBy(xpath = "//*[@id='help_li']/a/span")
    public WebElement Help;
    // heard login link
    @FindBy(xpath = "//li[@id='signin_li']/a/span")
    public WebElement loginlable;
    @FindBy(css = ".sign_inlist_span>em")
    public WebElement priceCoupon;
    // after moveover heard login links
    @FindBy(xpath = "//li[@id='signin_li']//span/a")
    public WebElement signin;
    // after press login button : Loginin new Windows
    @FindBy(xpath = "//form[@id='loginFormNew']/span")
    public List<WebElement> signInButton;
    @FindBy(css = ".login_in_popup .facebookS")
    public WebElement loginFaceBook;
    @FindBy(id = "username")
    public List<WebElement> username;
    @FindBy(id = "password")
    public List<WebElement> password;
    // @FindBy(css = "#signin_li_already>a>span")
    @FindBy(xpath = "//span[text()='Your Account']")
    public WebElement yourAccount;
    @FindBy(css = "#signin_li>a>span")
    public WebElement HKCartYourAccount;
    @FindBy(className = "menulogout")
    public WebElement signout;
    // register
    @FindBy(xpath = "//li[@id='signin_li']/div/div/p/a")
    public WebElement register;
    @FindBy(css = ".register_btn.registerStep1")
    public WebElement loginRegister;
    @FindBy(id = "step1_username")
    public WebElement registerName;
    @FindBy(id = "register_step1_btn")
    public WebElement registerBtn;
    @FindBy(id = "step2_username")
    public WebElement registerFirstName;
    @FindBy(id = "step2_password")
    public WebElement registerWd;
    @FindBy(id = "step2_pConfirmation")
    public WebElement registerWdConfirm;
    @FindAll({ @FindBy(partialLinkText = "Complete registration"), @FindBy(css = "#register_step2_btn>a") })
    public WebElement registerCompleterBtn;
    @FindBy(id = "removeOnProductGlass")
    public WebElement registerSuccess;

    // Search
    @FindBy(id = "search_input")
    public WebElement inputSearch;
    @FindBy(css = "#search_button i")
    public WebElement iconSearch;

    // header list
    @FindBy(xpath = "//*[@id='all_brand_for_contact_tab']/a/p")
    public WebElement clViewAllBrands;
    @FindBy(xpath = "//div[@class='center_contact_left']/div[2]/a")
    public WebElement clDailyViewAll;
    @FindBy(xpath = "//div[@class='shop_by_cont']/div[2]/div[2]/div[2]/a")
    public WebElement lenseWeeksViewAll;
    @FindBy(xpath = "//div[@class='shop_by_cont']/div[2]/div[2]/div[4]/a")
    public WebElement clMonthlyViewAll;

    //
    @FindBy(xpath = "//*[@id='menuN_level_1']/li/div/div[1]/ul[1]/li[1]/a")
    public WebElement men;
    @FindBy(xpath = "//div[@class='center_contact_left']/div[2]/a")
    public WebElement dailyglass;
    @FindBy(css = "a[onclick*='Sunglasses -Top 100']")
    public WebElement sunTop100;

    // header and footer
    @FindBy(css = ".helpList a[type='new']")
    public WebElement helpStyleFinder;
    @FindBy(className = "newhead_banner_ja")
    public WebElement headerStyleFinder;
    @FindBy(xpath = "//div[@id='top']/ul[1]/li[1]/a")
    public WebElement FREESHIPPING;
    @FindBy(xpath = "//div[@id='top']/ul/li[1]/div/ul/li[4]/a")
    public WebElement freeshipmoreinfo;
    @FindBy(xpath = "//div[@id='top']/ul/li[2]/a")
    public WebElement DayReturns;
    @FindBy(xpath = "//div[@id='top']/ul/li[2]/div/ul/li[5]/a")
    public WebElement DayReturnsMoreInfo;
    @FindBy(className = "newhead_banner2_en")
    public WebElement referAFriend;
    @FindBy(id = "by_email_btn")
    public WebElement shareByEmail;
    @FindBy(className = "newhead_banner_1")
    public WebElement optical_center;
    @FindBy(css = "#footer_lang_select>a>span.flag-icon")
    public WebElement flagCountry;

    // heart/favorite
    @FindBy(css = ".fa.fa-heart-o")
    public WebElement iHeart;
    @FindBy(css = ".clearfixes>li>a")
    public List<WebElement> iHeartSGuide;
    @FindBy(css = "#cart li>a ")
    public List<WebElement> cartSGuide;

    // birthday
    @FindBy(css = ".fa.fa-2x.fa-close")
    public WebElement firstBuy;
    @FindBy(css = ".close_btn>.fa.fa-times")
    public WebElement happySummer;
    @FindBy(css = ".thankyou i")
    public WebElement birthdayClose;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "bday")
    public WebElement bDay;
    @FindBy(className = "male")
    public WebElement man;
    @FindBy(xpath = "//body/div[2]/div[2]/p[1]")
    public WebElement birthdaySuccess;

    // recommend
    @FindBy(className = "newhead_banner2_en")
    public WebElement recommend;
    @FindBy(id = "referral_first_name")
    public WebElement recommendFirstName;
    @FindBy(id = "referral_email")
    public WebElement recommendEmail;
    @FindBy(id = "by_email_btn")
    public WebElement recommendShareBtn;
    @FindBy(id = "referral_to_emails")
    public WebElement recommendToEmail;
    @FindBy(id = "referral_send_email_btn")
    public WebElement recommendSendBtn;
    @FindBy(id = "referral_email_tips_lable")
    public WebElement recommendThank;

    // discount
    @FindBy(css = "img[height='33'][usemap='#Map2']")
    // .hp_topsmallad_box[style='display: block;']
    public WebElement discountSmallIMG;
    // @FindBy(css = "img[height='160'][usemap='#Map1']")
    @FindBy(css = ".hp_topbigad_box[style='display: block;']")
    public WebElement discountBigIMG;

    // FaceBook
    @FindBy(id = "email")
    public WebElement faceBookEmail;
    @FindBy(id = "pass")
    public WebElement faceBookPasswd;
    @FindBy(id = "loginbutton")
    public WebElement faceBookBtn;

    //
    @FindBy(xpath = "//div[@id='sub_Eyeglasses_Q_list']//a[text()='Tom Ford']")
    public WebElement TomFordBrank;

    // public get Element methods ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public WebElement getHelpLinkElement(int Num) {
        return driver.findElement(By.xpath("//*[@id='help_li']/div/div/ul/li[" + Num + "]/a"));
    }

    @Override
    protected void waitPageLoad() {
        // TODO Auto-generated method stub

    }

}
