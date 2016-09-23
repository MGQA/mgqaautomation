package com.motionglobal.methodbase;

import java.util.Set;

import com.motionglobal.pages.AbstractBaseContainer;

public class SwitchToWindow extends AbstractBaseContainer {

    /**
     * switch to new window
     */
    public void switch2NewWindow() {
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        int counter = 0;
        while (counter < 5) {
            if (handles.size() == 1) {
                handles = driver.getWindowHandles();
                dummyWait(1);
                counter++;
                continue;
            }
            for (String a : handles) {
                if (!a.equals(parentWindowHandle)) {
                    driver.switchTo().window(a); // switch to new window
                    return;
                }
            }
            counter++;
        }
    }
}
