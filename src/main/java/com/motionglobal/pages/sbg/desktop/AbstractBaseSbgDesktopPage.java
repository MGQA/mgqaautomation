package com.motionglobal.pages.sbg.desktop;

import com.motionglobal.pages.AbstractBasePage;
import com.motionglobal.pages.sbg.mobile.MobHeader;

public abstract class AbstractBaseSbgDesktopPage extends AbstractBasePage {
    private final Header header;

    public AbstractBaseSbgDesktopPage() {
        super();
        this.header = new Header();
    }

    public Header header() {
        return header;
    }

    public Menu menu() {
        return new Menu();
    }

    public MobHeader mobHeader() {
        return new MobHeader();
    }
}
