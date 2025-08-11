package com.Booking.Pages;

import com.Booking.Utlis.ElementActions;
import com.Booking.Utlis.Scrolling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResults {
    //variables
    private final WebDriver driver;
    //locators
    private final By tolipHotel = By.xpath("//div[contains(@data-testid,'property-card')]//div[contains(text(),'Tolip Hotel Alexandria')]");


    //constructor
    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResults HotelName() {
        Scrolling.scrolling(driver, tolipHotel);
        ElementActions.clickOnElement(driver, tolipHotel);
        System.out.println("test");
        return this;
    }

    public String getHotelName() {
        return ElementActions.findElement(driver, tolipHotel).getText();
    }

    public SearchResults AssertName() {
        Assert.assertTrue(getHotelName().contains("Tolip Hotel Alexandria"));
        return this;
    }


}