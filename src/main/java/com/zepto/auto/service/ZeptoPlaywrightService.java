package com.zepto.service;

import com.microsoft.playwright.*;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZeptoPlaywrightService {

    public void placeOrder(List<String> products, String upiId) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("https://www.zeptonow.com");

            for (String product : products) {
                String encoded = URLEncoder.encode(product, StandardCharsets.UTF_8);
                page.navigate("https://www.zeptonow.com/search?query=" + encoded);

                page.waitForTimeout(3000);

                Locator addBtn = page.locator("button:has-text('Add to Cart')").first();
                if (addBtn.isVisible()) {
                    addBtn.click();
                    page.waitForTimeout(2000);
                } else {
                    throw new RuntimeException("Add to cart not found for " + product);
                }
            }

            // Open cart
            page.navigate(page.url() + "?cart=open");
            page.waitForTimeout(3000);

            page.locator("button:has-text('Click to Pay')").click();
            page.waitForTimeout(3000);

            page.locator("text=UPI").click();
            page.waitForTimeout(2000);

            page.fill("input[testid='edt_vpa']", upiId);
            page.locator("text=Verify and Pay").click();

            page.waitForTimeout(5000);

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(
                            java.nio.file.Paths.get("order_" + LocalDateTime.now() + ".png")
                    )
            );

            browser.close();
        }
    }
}
