package com.Booking.Pages;

import com.Booking.Utlis.ElementActions;
import com.Booking.Utlis.Scrolling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
    //variables
    private final WebDriver driver;
    //locators
    private final By ToLipHotelAlexandria = By.cssSelector("//div[contains(text(),'Tolip Hotel Alexandria')]");
    private final By details = By.cssSelector("div[class='c3bdfd4ac2 a0ab5da06c d46ff48a92 f728e61e72 d0acd69e66 c256f1a28a bc2204a477 fd0a104462 f74ae46b12'] span[class='ca2ca5203b']");

    //constructor
    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResults HotelName() {
        Scrolling.scrolling(driver,ToLipHotelAlexandria);
        ElementActions.clickOnElement(driver,ToLipHotelAlexandria);
        ElementActions.clickOnElement(driver, details);
        return this;
    }

}
