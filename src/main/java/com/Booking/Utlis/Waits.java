package com.Booking.Utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Waits {
    private Waits(){
    }
    //wait element to be present
    public static WebElement waitElementToBePresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(driver1 -> driver1.findElement(locator));
    }
    //wait element to be visible
    public static WebElement waitElementToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver1 ->
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
    public static void switchToNewWindow(WebDriver driver, int expectedWindows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(expectedWindows));

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String targetWindow = "";
        for (int i = 0; i < expectedWindows; i++) {
            targetWindow = iterator.next();
        }
        driver.switchTo().window(targetWindow);
    }
}
