package com.motionglobal.pages.sbg.desktop.product;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class BuyNowPage extends AbstractBaseSbgDesktopPage {
    // IMG 5 ;
    @FindBy(className = "lensTypeImg01")
    public WebElement lensTypeImg01;
    @FindBy(className = "lensTypeImg02")
    public WebElement lensTypeImg02;
    @FindBy(className = "lensTypeImg03")
    public WebElement lensTypeImg03;
    @FindBy(className = "lensTypeImg06")
    public WebElement lensTypeImg04;
    @FindBy(className = "lensTypeImg04")
    public WebElement lensTypeImg05;
    // Lens
    @FindBy(xpath = "//li[1]/h3")
    public WebElement premium;
    @FindBy(id = "recommended_lens_index_1")
    public WebElement Psilver;
    @FindBy(id = "recommended_lens_index_3")
    public WebElement Pgold;
    @FindBy(id = "recommended_lens_index_4")
    public WebElement Pplatinum;
    @FindBy(xpath = "//li[2]/h3/span")
    public WebElement deluxe;
    @FindBy(id = "recommended_lens_index_7")
    public WebElement Dsilver;
    @FindBy(id = "recommended_lens_index_8")
    public WebElement Dgold;
    @FindBy(id = "recommended_lens_index_9")
    public WebElement Dplatinum;
    //
    @FindBy(id = "preStepEdit01")
    public WebElement editBtn;
    @FindBy(id = "addToCart")
    public WebElement addToCarBtn;
    //
    @FindBy(id = "lensEnterBtn")
    public WebElement lensEnter;
    @FindBy(xpath = "//div[@class='lensTypeCnt ']/a[2]")
    public WebElement UpLoadPre;
    @FindBy(xpath = "//div[@class='lensTypeCnt ']/a[3]")
    public WebElement sendLater;
    // Price
    @FindBy(xpath = "//table/tbody/tr[1]/td[2]/p")
    public WebElement framePrice;
    @FindBy(xpath = "//table/tbody/tr[2]/td[2]/p")
    public WebElement lensePrice;
    @FindBy(xpath = "//*[@id='right_scroll_bar']/div/div/p")
    public WebElement total;
    // Right
    @FindBy(id = "sphere_right")
    public WebElement rightSPH;
    @FindBy(id = "cylinder_right")
    public WebElement rightCYL;
    @FindBy(id = "axis_right")
    public WebElement rightAX;
    @FindBy(id = "add_right")
    public WebElement rightADD;
    // Left
    @FindBy(id = "sphere_left")
    public WebElement leftSPH;
    @FindBy(id = "cylinder_left")
    public WebElement leftCYL;
    @FindBy(id = "axis_left")
    public WebElement leftAX;
    @FindBy(id = "add_left")
    public WebElement leftADD;
    // Assert Element
    @FindBy(id = "confirmEnter")
    public WebElement confirmEnter;
    @FindBy(id = "confirmUpload")
    public WebElement UpLoadBtn;
    @FindBy(id = "confirmSendLater")
    public WebElement confirmSendLater;

    public void selectDegree(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void clickEditBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", header().getMegaMenuMainElement(1));
        new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
    }

    public boolean isPriceEqual() {
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
        Boolean pri = null;
        Integer priF = Integer.parseInt(framePrice.getText().replace("$", "").replace(".", ""));
        Integer priL = Integer.parseInt(lensePrice.getText().replace("$", "").replace(".", ""));
        Integer num = priF + priL;
        Integer totalPri = Integer.parseInt(total.getText().replace("$", "").replace(".", ""));
        if (num.equals(totalPri))
            pri = true;
        else
            pri = false;
        return pri;
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(By.xpath("//div[@id='lensStep01']/div[1]/div[1]/h4"), 5);

    }

}
