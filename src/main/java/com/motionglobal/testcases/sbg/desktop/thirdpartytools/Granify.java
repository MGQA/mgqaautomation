package com.motionglobal.testcases.sbg.desktop.thirdpartytools;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.motionglobal.pages.sbg.desktop.home.HomePage;
import com.motionglobal.testcases.sbg.desktop.AbstractBaseSbgDesktopTestCase;

public class Granify extends AbstractBaseSbgDesktopTestCase {

    @Test(groups = { "debug", "au" })
    public void testHomepage() {
        logger().info("started...");
        driver.get("http://www.visiondirect.com.au/");
        HomePage homePage = new HomePage();
        logger().info(driver.getPageSource());
        Assert.assertTrue(homePage.isTextPresent("var GRANIFY_SITE_ID=1257;"));
        Assert.assertTrue(
                homePage.isTextPresent(
                        "(function(e,t,n){var r,i,s,o,u;u=false;try{o=new RegExp(\"(?:^|\\W)_gr_test_url=([^;]*)\");s=document.cookie.match(o);if(s){if(s[1]===\"1\")u=true}else{r=Math.random();if(r&gt;.95)u=true;i=new Date(+(new Date)+1e3*60*60*24*2);document.cookie=\"_gr_test_url=\"+ +u+\";expires=\"+i.toGMTString()+\";path=/\"}}catch(a){}if(u)e.replace(\"javascript.js\",\"javascript.next.js\");try{o=new RegExp(\"(?:^|\\W)_gr_ep=([^;]*)\");s=document.cookie.match(o);if(!s){document.cookie=\"_gr_ep_sent=;expires=Thu, 01-Jan-1970 00:00:01 GMT;path=/\";document.cookie=\"_gr_er_sent=;expires=Thu, 01-Jan-1970 00:00:01 GMT;path=/\";if(!window.location.origin){if(window.location.port)port=\":\"+window.location.port;else port=\"\";window.location.origin=window.location.protocol+\"//\"+window.location.hostname+port}path=window.location.toString().replace(window.location.origin,\"\");referrer=document.referrer;i=new Date(+(new Date)+1e3*60*30);document.cookie=\"_gr_ep=\"+path+\";expires=\"+i.toGMTString()+\";path=/\";document.cookie=\"_gr_er=\"+referrer+\";expires=\"+i.toGMTString()+\";path=/\"}}catch(a){}a=new Date;a=\"\"+a.getUTCFullYear()+(a.getUTCMonth()+1)+a.getUTCDate();e=e+\"?id=\"+t+\"&amp;v=\"+a;window.Granify=n;n._stack=[];n.init=function(e,t,r){function i(e,t){e[t]=function(){Granify._stack.push([t].concat(Array.prototype.slice.call(arguments,0)))}}var s=n;h=[\"on\",\"identify\",\"addTag\",\"trackPageView\",\"trackCart\",\"trackOrder\"];for(a=0;a&lt;h.length;a++)i(s,h[a])};n.init();var f,l,c,p=document.createElement(\"iframe\");p.src=\"javascript:false\";p.title=\"\";p.role=\"presentation\";(p.frameElement||p).style.cssText=\"width: 0 !important; height: 0 !important; border: 0 !important; overflow: hidden !important; position: absolute !important; top: -1000px !important; left: -1000px !important;\";c=document.getElementsByTagName(\"script\");c=c[c.length-1];c.parentNode.insertBefore(p,c);try{l=p.contentWindow.document}catch(a){f=document.domain;p.src=\"javascript:var d=document.open();d.domain='\"+f+\"';void(0);\";l=p.contentWindow.document}l.open()._l=function(){var t=this.createElement(\"script\");if(f)this.domain=f;t.id=\"js-iframe-async\";t.src=e;this.body.appendChild(t)};l.write('&lt;body onload=\"document._l();\"&gt;');l.close()})(\"//cdn.granify.com/assets/javascript.js\",GRANIFY_SITE_ID,[])"));
        Assert.assertTrue(homePage.isTextPresent("Granify.trackPageView("));
        Assert.assertTrue(homePage.isTextPresent("{ page_type: \"home\" }"));
        Assert.assertFalse(homePage.isTextPresent("{ page_type: \"cart\" } \n         );"));
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void tearDown() {
    }

}
