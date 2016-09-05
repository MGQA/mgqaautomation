package com.motionglobal.pages.sbg.desktop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.AbstractBasePage;

public class Header extends AbstractBasePage {
    // need delete head
    @FindBy(css = ".hp_topsmallad_box")
    public WebElement delDiscount;
    @FindBy(css = ".header_box")
    public WebElement delSearchHead;
    @FindBy(css = ".topbar_box")
    public WebElement delBlackHead;
    @FindBy(id = "lc_chat_layout")
    public WebElement letTalk;

    // deals
    @FindBy(css = ".megamenu_left_all>a>span")
    public WebElement dealShowNow;
    @FindBy(className = "megamenu_center_buynow")
    public WebElement dealBuyNow;
    @FindBy(css = ".megamenu_righ_sunglasses>a")
    public WebElement dealSunGlass;
    @FindBy(css = ".megamenu_righ_glasses>a")
    public WebElement dealEyeGlass;
    @FindBy(className = "center_span_number")
    public WebElement dealPrice;
    @FindBy(css = ".top_brand_details")
    public List<WebElement> dealIMG;
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
    public WebElement signInButton;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//span[text()='Your Account']")
    public WebElement yourAccount;
    @FindBy(className = "menulogout")
    public WebElement signout;
    // register
    @FindBy(xpath = "//li[@id='signin_li']/div/div/p/a")
    public WebElement register;
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
    @FindBy(partialLinkText = "Complete registration")
    public WebElement registerCompleterBtn;
    @FindBy(id = "removeOnProductGlass")
    public WebElement registerSuccess;

    // Search
    @FindBy(id = "search_input")
    public WebElement inputSearch;
    @FindBy(css = ".search_image i.fa-search")
    public WebElement iconSearch;

    // Style of Glasses button
    @FindBy(id = "buttonNext")
    public WebElement styleNextButton;
    @FindBy(id = "buttonPrevious")
    public WebElement stylePrevious;
    @FindBy(xpath = "//*[@id='show_result_page']/span")
    public WebElement styleRecommend;
    @FindBy(id = "guidewin")
    public WebElement StyleFrame;
    @FindBy(id = "close_style_finder_guide")
    public WebElement StykeFrameCloseBtn;

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
    @FindBy(linkText = "Top100")
    public WebElement sunTop100;

    // header and footer
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
