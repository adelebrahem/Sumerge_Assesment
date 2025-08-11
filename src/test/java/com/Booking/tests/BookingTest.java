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
import org.testng.annotations.*;

public class BookingTest {
    //variables
    private WebDriver driver;

    //tests
    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExcelSheetReader.getData("src/main/resources/testData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "bookingData", priority = 1)
    public void searchHotel(String city, String checkIn, String checkOut) {
        new HomePage(driver).enterLocation(city).selectInDate().clickOnSearchButton();
        System.out.println(checkIn + checkOut);
        //Go to search results
        new SearchResults(driver).HotelName().AssertName();
    }

    @Test(priority = 3)
    public void selectBedAndAmount() {
        //Go to search results
        new HotelDetailsPage(driver).scrollToElement(driver).selectBedAndAmount(driver).setReserveButton(driver);
    }

    @Test(priority = 4)
    public void verifyDetails() {
        new HotelDetailsPage(driver).assertDatesDisplayedCorrectly("Mon 8 Sept", "Tue 9 Sept");
    }

    @Test(priority = 5)
    public void reservationPage() {
        new ReservePage(driver).AssertReservation();
    }

    //configurations
    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        new HomePage(driver).navigateToUrl();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
