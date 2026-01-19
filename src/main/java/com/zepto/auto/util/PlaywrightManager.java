package com.zepto.auto.util;

import com.microsoft.playwright.*;

public class PlaywrightManager {

    public static Browser launchBrowser() {
        Playwright playwright = Playwright.create();
        return playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );
    }
}
