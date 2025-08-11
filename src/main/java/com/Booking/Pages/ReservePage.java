package com.Booking.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ReservePage {
    //variables
    private final WebDriver driver;
    private final By hotelNameBox = By.cssSelector("div[class='c3bdfd4ac2 a0ab5da06c d46ff48a92 f728e61e72 d0acd69e66 c256f1a28a bc2204a477 fd0a104462 f74ae46b12'] div[class='aa97d6032f'] div[class='ad8fb705c9'] div[class='f6e3a11b0d ae5dbab14d e95943ce9b d32e843a31'] div[class='f6e3a11b0d a19a26a18c ac30880487 e95943ce9b c91dad2a8f'] div[class='aa225776f2 ca9d921c46'] div[class='f6e3a11b0d ae5dbab14d e95943ce9b'] div div[class='b87c397a13 a3e0b4ffd1']");

    //constructor
    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHotelName() {
        return driver.findElement(hotelNameBox).getText();
    }

    public ReservePage AssertReservation() {
        Assert.assertTrue(getHotelName().contains("Tolip Hotel Alexandria"),
                "Hotel name is incorrect");
    return this;}
}