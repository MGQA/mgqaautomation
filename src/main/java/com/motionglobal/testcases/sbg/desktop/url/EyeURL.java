package com.motionglobal.testcases.sbg.desktop.url;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.motionglobal.common.utils.ExcelDataUtil;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.ColorGlass;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.FrameType;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.Material;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.Shape;
import com.motionglobal.pages.sbg.desktop.product.GridFilter.Sport;
import com.motionglobal.pages.sbg.desktop.product.ProductGridPage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

/**
 * use it to check change url true and not empty.
 * 
 */
public class EyeURL extends AbstractBaseSbgDesktopTestCase {

    @DataProvider
    public Object[][] db() {
        Object[][] url = null;
        try {
            url = ExcelDataUtil.getExcelData("./src/main/resources/", "testData.xlsx", "Top100");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void gender(Object... obj) {
        System.out.print(obj[0]);
        System.out.println(obj[2]);
        getURL(obj[0] + "/" + obj[2] + "/general/-----------------------");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0] + "/" + obj[2]
                + "/general/----------------------- !!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX GENDER
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.gender.get(0));
        gridPage.gender.get(0).click();
        Assert.assertFalse(driver.getCurrentUrl().contains("Men"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(((String) obj[4]).toLowerCase()), driver.getCurrentUrl().toLowerCase() + " !!! "
                + ((String) obj[4]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.gender.get(1));
        gridPage.gender.get(1).click();
        Assert.assertFalse(driver.getCurrentUrl().contains("Women"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(((String) obj[5]).toLowerCase()), driver.getCurrentUrl().toLowerCase() + " !!! "
                + ((String) obj[5]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.gender.get(2));
        gridPage.gender.get(2).click();
        Assert.assertFalse(driver.getCurrentUrl().contains("Unisex"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(((String) obj[7]).toLowerCase()), driver.getCurrentUrl().toLowerCase() + " !!! "
                + ((String) obj[7]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.gender.get(3));
        gridPage.gender.get(3).click();
        Assert.assertFalse(driver.getCurrentUrl().contains("Kids"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[6].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase() + " !!! "
                + ((String) obj[6]).toLowerCase() + " !!! ");
        //
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void feature(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[2].toString() + "/general/-----------------------");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0] + "/" + obj[2]
                + "/general/----------------------- !!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.clearance);
        gridPage.clearance.click();
        Assert.assertFalse(driver.getCurrentUrl().contains("Kids"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[9].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase() + " !!! "
                + ((String) obj[9]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.polarized);
        gridPage.polarized.click();
        Assert.assertFalse(driver.getCurrentUrl().contains("polarized"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[10].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[10]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.pre);
        gridPage.pre.click();
        Assert.assertFalse(driver.getCurrentUrl().contains("prescription"));
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[8].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase() + " !!! "
                + ((String) obj[8]).toLowerCase() + " !!! ");
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void shape(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[2].toString() + "/general/-----------------------");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0] + "/" + obj[2]
                + "/general/----------------------- !!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Aviator));
        gridPage.getShape(Shape.Aviator).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[12].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[12]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Wayfarer));
        gridPage.getShape(Shape.Wayfarer).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[13].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[13]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Butterfly));
        gridPage.getShape(Shape.Butterfly).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[14].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[14]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.CatEye));
        gridPage.getShape(Shape.CatEye).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[15].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[15]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Oval));
        gridPage.getShape(Shape.Oval).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[16].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[16]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Oversized));
        gridPage.getShape(Shape.Oversized).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[17].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[17]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Rectangle));
        gridPage.getShape(Shape.Rectangle).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[18].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[18]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Round));
        gridPage.getShape(Shape.Round).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[19].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[19]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.SingleLens));
        gridPage.getShape(Shape.SingleLens).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[20].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[20]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getShape(Shape.Wraparound));
        gridPage.getShape(Shape.Wraparound).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[21].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[21]).toLowerCase() + " !!! ");
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void sport(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[3].toString() + "/" + obj[22]);
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0].toString() + "/" + obj[3].toString() + "/" + obj[22]
                + "!!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[22].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[22]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Golf));
        gridPage.getSport(Sport.Golf).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[47].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[47]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Running));
        gridPage.getSport(Sport.Running).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[48].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[48]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Cycling));
        gridPage.getSport(Sport.Cycling).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[49].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[49]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Baseball));
        gridPage.getSport(Sport.Baseball).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[50].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[50]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Fishing));
        gridPage.getSport(Sport.Fishing).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[51].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[51]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Driving));
        gridPage.getSport(Sport.Driving).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[52].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[52]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.Tennis));
        gridPage.getSport(Sport.Tennis).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[53].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[53]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getSport(Sport.WaterSports));
        gridPage.getSport(Sport.WaterSports).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[54].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[54]).toLowerCase() + " !!! ");
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void onSale(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[2].toString() + "/" + obj[45]);
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0].toString() + "/" + obj[2].toString() + "/" + obj[45]
                + " page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[45].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[45]).toLowerCase() + " !!! ");
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void frameType(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[2].toString() + "/general/-----------------------");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0].toString() + "/" + obj[2].toString()
                + "/general/-----------------------!!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getFrameType(FrameType.FullRim));
        gridPage.getFrameType(FrameType.FullRim).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[23].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[23]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getFrameType(FrameType.SemiRimless));
        gridPage.getFrameType(FrameType.SemiRimless).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[24].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[24]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getFrameType(FrameType.Rimless));
        gridPage.getFrameType(FrameType.Rimless).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[25].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[25]).toLowerCase() + " !!! ");
    }

    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void frameMaterial(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[2].toString() + "/general/-----------------------");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0].toString() + "/" + obj[2].toString()
                + "/general/-----------------------!!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getFrameMaterial(Material.Plastic));
        gridPage.getFrameMaterial(Material.Plastic).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[26].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[26]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getFrameMaterial(Material.Metal));
        gridPage.getFrameMaterial(Material.Metal).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[27].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[27]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getFrameMaterial(Material.Titanium));
        gridPage.getFrameMaterial(Material.Titanium).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[28].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[28]).toLowerCase() + " !!! ");
    }

    // TODO only one need judge
    @Test(dataProvider = "db", groups = { "url", "smoke" })
    // @Test(skipFailedInvocations = true, dataProvider = "db", groups = { "url", "smoke" })
    public void Color(Object... obj) {
        System.out.println(obj[0].toString());
        getURL(obj[0].toString() + "/" + obj[2].toString() + "/general/-----------------------");
        Assert.assertFalse(driver.getCurrentUrl().contains("error"), " !!! :" + obj[0].toString() + "/" + obj[2].toString()
                + "/general/-----------------------!!! page error .! expect page is " + driver.getCurrentUrl());
        ProductGridPage gridPage = new ProductGridPage();
        // XXX color
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Blue));
        gridPage.getColor(ColorGlass.Blue).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[29].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[29]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Brown));
        gridPage.getColor(ColorGlass.Brown).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[30].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[30]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Green));
        gridPage.getColor(ColorGlass.Green).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[31].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[31]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Gold));
        gridPage.getColor(ColorGlass.Gold).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[32].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[32]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Pink));
        gridPage.getColor(ColorGlass.Pink).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[33].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[33]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Red));
        gridPage.getColor(ColorGlass.Red).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[34].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[34]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Yellow));
        gridPage.getColor(ColorGlass.Yellow).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[35].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[35]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.White));
        gridPage.getColor(ColorGlass.White).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[36].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[36]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Violet));
        gridPage.getColor(ColorGlass.Violet).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[37].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[37]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Crystal));
        gridPage.getColor(ColorGlass.Crystal).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[38].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[38]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Burgundy));
        gridPage.getColor(ColorGlass.Burgundy).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[39].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[39]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Black));
        gridPage.getColor(ColorGlass.Black).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[40].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[40]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Tortoise));
        gridPage.getColor(ColorGlass.Tortoise).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[41].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[41]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Silver));
        gridPage.getColor(ColorGlass.Silver).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[42].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[42]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Grey));
        gridPage.getColor(ColorGlass.Grey).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[43].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[43]).toLowerCase() + " !!! ");
        //
        gridPage.deleteHead();

        gridPage.JsMouse(gridPage.getColor(ColorGlass.Orange));
        gridPage.getColor(ColorGlass.Orange).click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains(obj[44].toString().toLowerCase().trim()), driver.getCurrentUrl().toLowerCase()
                + " !!! " + ((String) obj[44]).toLowerCase() + " !!! ");
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }

}
