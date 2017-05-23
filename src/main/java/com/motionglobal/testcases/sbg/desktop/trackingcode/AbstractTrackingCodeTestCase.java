package com.motionglobal.testcases.sbg.desktop.trackingcode;

import java.util.HashMap;

import com.motionglobal.common.utils.VerifyUtil;
import com.motionglobal.testcases.AbstractBaseTestCase;

public class AbstractTrackingCodeTestCase extends AbstractBaseTestCase {

    // 存放tracking code的地方
    private HashMap<Object, Object> Tacking() {
        HashMap<Object, Object> tacking = new HashMap<>();
        tacking.put("criteo", "static.criteo.net/js/ld/ld.js");
        tacking.put("doubleclick", "stats.g.doubleclick.net");
        tacking.put("facebookPixel", "connect.facebook.net/en_US/fbevents.js");
        tacking.put("googleAnalysis", "www.google-analytics.com");
        tacking.put("googleAds", "www.googleadservices.com");
        tacking.put("googleManager", "www.googletagmanager.com/gtm.js");
        tacking.put("googleRemarketing", "www.googleadservices.com");
        tacking.put("kenshoo", "https://services.xg4ken.com/js/kenshoo.js?");
        tacking.put("optimizely", "cdn.optimizely.com");
        return tacking;
    }

    public void checkTracking(String... keys) {
        String source = driver.getPageSource();
        HashMap<Object, Object> trackMap = Tacking();
        VerifyUtil verify = new VerifyUtil();
        verify.verifyBegin();
        for (String key : keys) {
            verify.verifyTure(source.contains(trackMap.get(key).toString()), "Can't find tracking code: " + key + "! script is: "
                    + trackMap.get(key).toString());
        }
        verify.verifyEnd();
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void tearDown() {

    }

}
