package com.zepto.service;

import com.microsoft.playwright.*;
import org.springframework.stereotype.Service;

@Service
public class ZeptoAutomationService {

    public void addToCart(String productName) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(true)   // MUST be true on Render
                            .setSlowMo(100)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.zeptonow.com/");
            page.waitForTimeout(6000);

            page.click("input[placeholder='Search']");
            page.fill("input[placeholder='Search']", productName);
            page.keyboard().press("Enter");

            page.waitForTimeout(5000);
            page.click("text=Add");

            System.out.println("Added to cart: " + productName);
            browser.close();
        }
    }
}
