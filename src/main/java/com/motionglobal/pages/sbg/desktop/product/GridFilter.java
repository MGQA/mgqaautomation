package com.motionglobal.pages.sbg.desktop.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.motionglobal.pages.AbstractBaseContainer;

public class GridFilter extends AbstractBaseContainer {
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
    public enum ColorGlass {
        Blue, Brown, Green, Gold, Pink, Red, Yellow, White, Violet, Crystal, Burgundy, Black, Tortoise, Silver, Grey, Orange;
    }

    public WebElement getColor(ColorGlass color) {
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

}
