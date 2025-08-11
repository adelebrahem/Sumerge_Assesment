package com.Booking.Pages;

import com.Booking.Utlis.BrowserActions;
import com.Booking.Utlis.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //variables
    private final WebDriver driver;
    //locators
    private final By searchBar = By.id(":rh:");
    private final By checkIn = By.cssSelector(".ed9f289288");
    private final By checkInDate = By.cssSelector("span[aria-label='Sa 9 August 2025']");
    private final By checkoutDate = By.cssSelector("span[aria-label='Mo 8 September 2025']");
    private final By searchButton = By.cssSelector("button[type='submit'] span[class='ca2ca5203b']");

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //navigate to url
    public void navigateToUrl() {
        BrowserActions.navigateToUrl(driver,"https://www.booking.com/" );
    }

    public HomePage enterLocation(String location) {
        ElementActions.clickOnElement(driver,searchBar);
        ElementActions.clearData(driver, searchBar);
        ElementActions.sendData(driver, searchBar, location);
        return this;
    }

    public HomePage selectInDate() {
        ElementActions.clickOnElement(driver,checkIn);
        ElementActions.clickOnElement(driver,checkInDate);
        ElementActions.clickOnElement(driver,checkoutDate);
        return this;
    }


    public HomePage clickOnSearchButton() {
        ElementActions.clickOnElement(driver, searchButton);
    return this;}
    //validations

}