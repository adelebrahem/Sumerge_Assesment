package com.Booking.Pages;

import com.Booking.Utlis.BrowserActions;
import com.Booking.Utlis.ElementActions;
import com.Booking.Utlis.Scrolling;
import com.Booking.Utlis.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HotelDetailsPage {

    //Variables
    private WebDriver driver;

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;

    }

    //locators
    private final By goToSelectBed = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr[1]/th/div/div[2]/span/div/span/span");
    private final By selectBed = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr[1]/th/div/div[3]/div[1]/label[2]/div/input");
    private final By selectNumberOfBeds = By.id("hprt_nos_select_78883128_406187102_2_33_0_131741");
    private final By reserveButton = By.cssSelector("#hp_book_now_button");
    private final By dataSection = By.cssSelector("//*[@id=\"hp_availability_style_changes\"]/div[3]/div/form/div/div[1]/div/div");

    //select bed and amount
    public HotelDetailsPage scrollToElement(WebDriver driver) {
        Waits.switchToNewWindow(driver, 2);
        Waits.waitElementToBePresent(driver, goToSelectBed);
        Scrolling.scrolling(driver, goToSelectBed);
        return this;
    }

    public HotelDetailsPage selectBedAndAmount(WebDriver driver) {
        ElementActions.clickOnElement(driver, selectBed);
        ElementActions.select(driver, selectNumberOfBeds, "1");
        return this;
    }

    public HotelDetailsPage setReserveButton(WebDriver driver) {
        ElementActions.clickOnElement(driver, reserveButton);
        return this;
    }

    public String getDisplayedDates() {
        return driver.findElement(dataSection).getText();
    }

    //validations
    public HotelDetailsPage assertDatesDisplayedCorrectly(String checkIn, String checkOut) {
        Assert.assertTrue(getDisplayedDates().contains(checkIn) && getDisplayedDates().contains(checkOut),
                "Dates are incorrect");
        return this;
    }

}