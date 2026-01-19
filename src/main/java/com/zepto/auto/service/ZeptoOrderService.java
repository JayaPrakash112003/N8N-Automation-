package com.zepto.auto.service;

import com.microsoft.playwright.*;
import com.zepto.auto.model.ZeptoOrderRequest;
import com.zepto.auto.util.PlaywrightManager;
import org.springframework.stereotype.Service;

@Service
public class ZeptoOrderService {

    public String orderProduct(ZeptoOrderRequest request) {

        Browser browser = PlaywrightManager.launchBrowser();
        Page page = browser.newPage();

        page.navigate("https://www.zepto.in");

        // WAIT FOR PAGE LOAD
        page.waitForTimeout(5000);

        // SEARCH PRODUCT
        page.click("input[placeholder='Search']");
        page.fill("input[placeholder='Search']", request.getProductName());
        page.waitForTimeout(3000);

        // CLICK FIRST PRODUCT
        page.click("div[data-testid='product-card']");
        page.waitForTimeout(2000);

        // ADD TO CART
        page.click("button:has-text('Add')");
        page.waitForTimeout(2000);

        browser.close();

        return "Order placed for " + request.getProductName() + " " + request.getQuantity() + " with UPI: "
                + request.getUpiId();
    }
}
