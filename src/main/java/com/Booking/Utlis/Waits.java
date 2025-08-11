package com.Booking.Utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits(){
    }
    //wait element to be present
    public static WebElement waitElementToBePresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(2)).
                until(driver1 -> driver1.findElement(locator));
    }
    //wait element to be visible
    public static WebElement waitElementToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 ->
        {
            WebElement element = waitElementToBePresent(driver, locator);
            return element.isDisplayed() ? element : null;
        });
    }
//wait element to be clickable
    public static WebElement waitElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(2)).
                until(driver1 ->
                {
                    WebElement element = waitElementToBeVisible(driver, locator);
                    return element.isEnabled() ? element : null;
                });
    }
}
