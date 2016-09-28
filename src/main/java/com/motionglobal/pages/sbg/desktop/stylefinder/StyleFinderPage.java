package com.motionglobal.pages.sbg.desktop.stylefinder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.motionglobal.pages.sbg.desktop.AbstractBaseSbgDesktopPage;

public class StyleFinderPage extends AbstractBaseSbgDesktopPage {

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

    // clickAndSelectStyle
    @FindBy(css = "[id^='step'][style*='block']>div>div:not([class='clear'])")
    public List<WebElement> getStyleEleS;
    @FindBy(css = ".step_icon>.step_iconCur")
    public WebElement styleStep;
    @FindBy(css = ".step_icon>span")
    public List<WebElement> styleSize;

    public void clickAndSelectStyle(int num) {
        waitForVisibility(getStyleEleS.get(num - 1), 2);
        String initStep = styleStep.getAttribute("stepnum");
        getStyleEleS.get(num - 1).click();
        String step = "";
        System.out.println(initStep + "\t" + styleSize.size());
        if ((Integer.parseInt(initStep)) == (styleSize.size())) {
            waitForVisibility(styleRecommend, 5);
            styleRecommend.click();
        }
        else {
            styleNextButton.click();
            for (int i = 0; i < 10; i++) {
                waitForVisibility(styleStep, 2);
                step = styleStep.getAttribute("stepnum");
                if (step.equals(initStep)) {
                    try {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e) {
                    }
                }
                else {
                    break;
                }
            }
        }
    }

    @Override
    protected void waitPageLoad() {
        waitForVisibility(driver.findElement(By.id("guidewin")), 5);
    }
}
