package com.Booking.tests;

import com.Booking.Pages.HomePage;
import com.Booking.Pages.HotelDetailsPage;
import com.Booking.Pages.ReservePage;
import com.Booking.Pages.SearchResults;
import com.Booking.Utlis.ExcelSheetReader;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.naming.directory.SearchResult;

public class BookingTest {
    //variables
    private WebDriver driver;
    //tests
    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExcelSheetReader.getData("src/main/resources/testData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "bookingData")
    public void checkInAndCheckoutDatesDisplayedCorrectly(String city, String checkIn, String checkOut){
    new HomePage(driver).enterLocation(city).selectInDate().clickOnSearchButton();
        System.out.println(checkIn+checkOut);

    }
    @Test
    public void searchResult(){
        new SearchResults(driver).HotelName();
    }
    @Test
    public void selectBedsAndAmount(){
        new HotelDetailsPage(driver).navigateToUrl().scrollToElement(driver).selectBedAndAmount(driver).setReserveButton(driver);
    }
    @Test
    public void reservationPage(){
        new ReservePage(driver).AssertReservation();
    }
    //configurations
    @BeforeTest
    public void setup(){
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        new HomePage(driver).navigateToUrl();
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }
}
