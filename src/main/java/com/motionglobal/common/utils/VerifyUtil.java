package com.motionglobal.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class VerifyUtil {

    public static boolean flag = true;

    public static List<Error> errors = new ArrayList<Error>();

    public void verifyBegin() {
        flag = true;
        // errors.clear();
    }

    public void verifyEnd() {
        Assert.assertTrue(flag, errors.toString().replace("java.lang.AssertionError:", ""));
        // Assert.assertTrue(flag);
    }

    public void verifyEquals(Object actual, Object expected) {
        try {
            Assert.assertEquals(actual, expected);
        }
        catch (Error e) {
            errors.add(e);
            flag = false;
        }
    }

    public void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        }
        catch (Error e) {
            errors.add(e);
            flag = false;
        }
    }

    public void verifyTure(Boolean bl, String message) {
        try {
            Assert.assertTrue(bl, message);
        }
        catch (Error e) {
            errors.add(e);
            flag = false;
        }
    }

}
