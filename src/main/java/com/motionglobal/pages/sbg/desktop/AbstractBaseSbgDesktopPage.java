package com.motionglobal.pages.sbg.desktop;

import com.motionglobal.pages.AbstractBasePage;

public abstract class AbstractBaseSbgDesktopPage extends AbstractBasePage {
    private Header header;

    public AbstractBaseSbgDesktopPage() {
        super();
        this.header = new Header();
    }

    public Header header() {
        return header;
    }

}
