package com.Booking.Pages;

import com.Booking.Utlis.BrowserActions;
import com.Booking.Utlis.ElementActions;
import com.Booking.Utlis.Scrolling;
import com.Booking.Utlis.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HotelDetailsPage {

    //Variables
    private WebDriver driver;

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;

    }

    //locators
    private final By goToSelectBed = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr[1]/th/div/div[2]/span/div/span/span");
    private final By selectBed = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr[1]/th/div/div[3]/div[1]/label[2]/div/input");
    private final By selectNumberOfBeds = By.id("hprt_nos_select_78883120_91939502_2_33_0_131741");
    private final By reserveButton = By.cssSelector("#hp_book_now_button");
    private final By dataSection = By.cssSelector("//*[@id=\"hp_availability_style_changes\"]/div[3]/div/form/div/div[1]/div/div");

    //select bed and amount
    public HotelDetailsPage scrollToElement(WebDriver driver) {
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

    public HotelDetailsPage navigateToUrl() {
        BrowserActions.navigateToUrl(driver, "https://www.booking.com/hotel/eg/royal-tulip-alexandria.en-gb.html?aid=304142&label=gen173nr-10CAEoggI46AdIM1gEaEOIAQGYATO4ARfIAQzYAQPoAQH4AQGIAgGoAgG4AsqW4cQGwAIB0gIkNTg5ODM5YTEtY2FiNS00MmVkLWJkZGQtYTY1ZTg3NjM1YmZh2AIB4AIB&sid=101a32db801e68bf3ca4e6dd0dd222a3&all_sr_blocks=78883120_386871369_2_34_0_131741&checkin=2025-08-10&checkout=2025-08-11&dest_id=-290263&dest_type=city&dist=0&group_adults=2&group_children=0&hapos=1&highlighted_blocks=78883120_386871369_2_34_0_131741&hpos=1&matching_block_id=78883120_386871369_2_34_0_131741&no_rooms=1&req_adults=2&req_children=0&room1=A%2CA&sb_price_type=total&sr_order=popularity&sr_pri_blocks=78883120_386871369_2_34_0_131741_8400&srepoch=1754833988&srpvid=7b4f4d7b260318c3&type=total&ucfs=1&");
        return this;
    }

    //validations
    public HotelDetailsPage datesDisplayedCorrectly(){
        Assert.assertTrue(getDisplayedDates().contains("Mon 8 Sept") && getDisplayedDates().contains("Tue 9 Sept"),
                "Dates are incorrect");
    return this; }
}