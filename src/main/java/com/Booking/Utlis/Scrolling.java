package com.Booking.Utlis;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class Scrolling {
    public static void scrolling(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
}
