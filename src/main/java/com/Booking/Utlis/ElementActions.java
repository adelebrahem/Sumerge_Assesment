package com.Booking.Utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {
    private WebDriver driver;

    private ElementActions() {
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    //send case
    public static void sendData(WebDriver driver, By locator, String data) {
        Waits.waitElementToBeVisible(driver, locator);
//        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        Waits.waitElementToBeClickable(driver, locator);
//        Scrolling.scrollToElement(driver,locator);
        findElement(driver, locator).click();
    }

    public static void clearData(WebDriver driver, By locator) {
        Waits.waitElementToBeVisible(driver, locator);
//        Scrolling.scrollToElement(driver,locator);
        findElement(driver, locator).clear();
    }

    public static void select(WebDriver driver, By locator, String value) {
        WebElement element = findElement(driver, locator);
        Select select = new Select(element);
        select.selectByValue(value);

    }
}
