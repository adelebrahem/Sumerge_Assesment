package com.Booking.Utlis;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private BrowserActions(){
    }
    public static void navigateToUrl(WebDriver driver,String url){
        driver.get(url);
    }
}
