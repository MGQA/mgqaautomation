package com.motionglobal.pages.sbg.desktop.product;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class ProductGridPage extends AbstractBaseSbgDesktopPage {
    @FindBy(xpath = "//div[contains(@class,'pro_r_buynow')]/a[2]/span")
    public WebElement buyNowButton;
    @FindBy(className = "cart_btn")
    public WebElement cartBtn;
    // List WebElement
    @FindBy(className = "quick_view_text")
    public WebElement quickView;
    @FindBy(className = "recProInfo")
    public List<WebElement> proInfo;
    @FindBy(xpath = "//div[@class='pro_right_size']/a")
    public List<WebElement> eyeproSize;
    @FindBy(css = "label.clearfix")
    public List<WebElement> frameOrAdd;
    @FindBy(css = ".proPriceN")
    public List<WebElement> productPriceS;
    @FindBy(className = "price_clearance_new_tag")
    public WebElement discountIcon;

    // Opticians
    @FindBy(id = "discount_price_promotion_display")
    public WebElement framePrice;
    @FindBy(className = "frame_price")
    public WebElement frame_price;
    @FindBy(xpath = "//li[@class='recommended cur']/a/p[2]")
    public WebElement deluxeVeryPriece;
    @FindBy(className = "lenses_price")
    public WebElement lenses_price;
    @FindBy(className = "total_price")
    public WebElement total_price;
    @FindBy(xpath = "//li[@data-index='deluxe']")
    public WebElement deluxe;
    @FindBy(xpath = "//li[@data-value='8']/a")
    public WebElement deluxeVery;

    // sort and page
    @FindBy(css = "#sortByDrop>dt>a")
    public WebElement SortDrop;
    @FindBy(css = "#sortByDrop li>a")
    public List<WebElement> SortSection;
    @FindBy(css = ".pagination.bottom_pagination>a")
    public List<WebElement> productPageNum;
    @FindBy(id = "half_left")
    public WebElement popularLeftBtn;
    @FindBy(id = "half_right")
    public WebElement popularRightBtn;
    @FindBy(id = "half_1")
    public WebElement popularBrands1;
    @FindBy(id = "half_3")
    public WebElement popularBrands3;
    @FindBy(xpath = "//ul[@id='half_1']/li[1]/a")
    public WebElement popularBrandIMG1;

    // filter
    @FindBy(partialLinkText = "Arnette")
    public WebElement filterArnette;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[4]/ul/li[2]/a")
    public WebElement shapesMostPopular;
    @FindBy(xpath = "//div[@class='choose_model']/p[3]/a")
    public WebElement filterRayban2132;
    // @FindBy(css = "a.FrameType")
    // public List<WebElement> filterFrameType;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[6]/ul/li[1]/a")
    public WebElement filterFrameType;
    // @FindBy(xpath = "//*[@id='content']//div[7]/ul/li/a")
    // public List<WebElement> filterPrice;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[2]/a")
    public WebElement filterPriceNo2;
    @FindBy(xpath = "//*[@id='content']/div[1]/div/div[7]/ul/li[3]/a")
    public WebElement filterPriceNo3;

    // assert_element！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    @FindBy(className = "proCell_click")
    public List<WebElement> sunTop100Eles;
    @FindBy(className = "size_s_bor")
    public WebElement sizeClicked;
    @FindBy(className = "on")
    public WebElement frameOrAddClicked;
    @FindBy(xpath = "//div[@id='jp-pagination-ajax']/h3")
    public WebElement productNum;
    @FindBy(className = "sideRemove")
    public WebElement filterSide;

    // XXX element URL ;
    @FindBy(className = "navigation")
    public WebElement LabelText;
    @FindBy(className = "Gender")
    public List<WebElement> gender;
    @FindBy(css = ".side_Polarized>a")
    public WebElement polarized;
    @FindBy(css = ".side_Prescription>a")
    public WebElement pre;
    @FindBy(css = ".side_Clearance>a")
    public WebElement clearance;

    public enum Shape {
        Aviator, Wayfarer, Butterfly, CatEye, Goggle, Oversized, Rectangle, Round, SingleLens, Wraparound, Oval;
    }

    public WebElement getShape(Shape shape) {
        WebElement element = null;
        switch (shape) {
        case Aviator:
            element = driver.findElement(By.name("Aviator"));
            break;
        case Wayfarer:
            element = driver.findElement(By.name("Wayfarer"));
            break;
        case Butterfly:
            element = driver.findElement(By.name("Butterfly"));
            break;
        case CatEye:
            element = driver.findElement(By.name("Cat Eye"));
            break;
        case Goggle:
            element = driver.findElement(By.name("Goggle"));
            break;
        case Oversized:
            element = driver.findElement(By.name("Oversized"));
            break;
        case Rectangle:
            element = driver.findElement(By.name("Rectangle"));
            break;
        case Round:
            element = driver.findElement(By.name("Round"));
            break;
        case SingleLens:
            element = driver.findElement(By.name("Single Lens"));
            break;
        case Wraparound:
            element = driver.findElement(By.name("Wraparound"));
            break;
        case Oval:
            element = driver.findElement(By.name("Oval"));
            break;
        default:
            System.out.println(" fail !!! elemnet empty !");
            break;
        }
        return element;
    }

    // XXX
    public enum Color {
        Blue, Brown, Green, Gold, Pink, Red, Yellow, White, Violet, Crystal, Burgundy, Black, Tortoise, Silver, Grey, Orange;
    }

    public WebElement getColor(Color color) {
        WebElement element = null;
        switch (color) {
        case Blue:
            element = driver.findElement(By.name("Blue"));
            break;
        case Brown:
            element = driver.findElement(By.name("Brown"));
            break;
        case Green:
            element = driver.findElement(By.name("Green"));
            break;
        case Gold:
            element = driver.findElement(By.name("Gold"));
            break;
        case Pink:
            element = driver.findElement(By.name("Pink"));
            break;
        case Red:
            element = driver.findElement(By.name("Red"));
            break;
        case Yellow:
            element = driver.findElement(By.name("Yellow"));
            break;
        case White:
            element = driver.findElement(By.name("White"));
            break;
        case Violet:
            element = driver.findElement(By.name("Violet"));
            break;
        case Crystal:
            element = driver.findElement(By.name("Crystal"));
            break;
        case Burgundy:
            element = driver.findElement(By.name("Burgundy"));
            break;
        case Black:
            element = driver.findElement(By.name("Black"));
            break;
        case Tortoise:
            element = driver.findElement(By.name("Tortoise"));
            break;
        case Silver:
            element = driver.findElement(By.name("Silver"));
            break;
        case Grey:
            element = driver.findElement(By.name("Grey"));
            break;
        case Orange:
            element = driver.findElement(By.name("Orange"));
            break;
        default:
            System.out.println(" FAIL EMEMENT EMPTY !!!");
            break;
        }
        return element;
    }

    // XXX
    public enum FrameType {
        FullRim, SemiRimless, Rimless;
    }

    public WebElement getFrameType(FrameType type) {
        WebElement element = null;
        switch (type) {
        case FullRim:
            element = driver.findElement(By.name("Full Rim"));
            break;
        case SemiRimless:
            element = driver.findElement(By.name("Semi Rimless"));
            break;
        case Rimless:
            element = driver.findElement(By.name("Rimless"));
            break;
        default:
            System.out.println(" FAIL EMEMENT EMPTY !!!");
            break;
        }
        return element;
    }

    // XXX
    public enum Material {
        Plastic, Metal, Titanium;
    }

    public WebElement getFrameMaterial(Material material) {
        WebElement element = null;
        switch (material) {
        case Plastic:
            element = driver.findElement(By.cssSelector("[title='Plastic']"));
            break;
        case Metal:
            element = driver.findElement(By.cssSelector("[title='Metal']"));
            break;
        case Titanium:
            element = driver.findElement(By.cssSelector("[title='Titanium']"));
            break;
        default:
            System.out.println(" FAIL EMEMENT EMPTY !!!");
            break;
        }
        return element;
    }

    // XXX
    public enum Sport {
        Baseball, Cycling, Driving, Fishing, Golf, Running, SkiGoggles, Tennis, WaterSports;
    }

    public WebElement getSport(Sport sport) {
        WebElement element = null;
        switch (sport) {
        case Baseball:
            element = driver.findElement(By.name("Baseball"));
            break;
        case Cycling:
            element = driver.findElement(By.name("Cycling"));
            break;
        case Driving:
            element = driver.findElement(By.name("Driving"));
            break;
        case Fishing:
            element = driver.findElement(By.name("Fishing"));
            break;
        case Golf:
            element = driver.findElement(By.name("Golf"));
            break;
        case Running:
            element = driver.findElement(By.name("Running"));
            break;
        case SkiGoggles:
            element = driver.findElement(By.name("Ski Goggles"));
            break;
        case Tennis:
            element = driver.findElement(By.name("Tennis"));
            break;
        case WaterSports:
            element = driver.findElement(By.name("Water Sports"));
            break;
        default:
            System.out.println(" FAIL EMEMENT EMPTY !!!");
            break;
        }
        return element;
    }

    // XXX
    public enum Label {
        gender, material, mid, pre, polarized, sports, brands, ski, designer;
    }

    // getSubmenuPageLabelText element
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]")
    private WebElement lableA;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[1]/a")
    private WebElement lableB;
    @FindBy(xpath = "//*[@id='wrapper']/div[4]/div[2]/span[2]/a")
    private WebElement lableC;

    public String getSubmenuPageLabelText(Label label) {
        String text = null;
        switch (label) {
        case gender:
        case material:
        case mid:
        case pre:
        case polarized:
            text = lableA.getText();
            break;
        case designer:
        case sports:
            text = lableB.getText();
            break;
        case brands:
        case ski:
            text = lableC.getText();
            break;
        default:
            System.out.println("_ don't right page !_");
            break;
        }
        return text;
    }

    /**
     * ~ change - of price
     * 
     */
    public String regexPage(String pagetext) {
        Pattern pattern = Pattern.compile("~");
        Matcher matcher = pattern.matcher(pagetext);
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbr, "-");
        }
        matcher.appendTail(sbr);
        return sbr.toString();
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.id("jp-pagination-ajax"), 10);
    }
}
