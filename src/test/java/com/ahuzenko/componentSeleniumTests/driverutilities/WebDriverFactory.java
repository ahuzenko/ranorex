package com.ahuzenko.componentSeleniumTests.driverutilities;

/**
 * Created by Sunny on 02.06.2015.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriver driver;

    public void startBrowser(String url){

        if(null == driver)
        {
            driver = new FirefoxDriver();
        }

        driver.get(url);
    }

    public void finishBrowser(){
        if(null != driver)
        {
            driver.quit();
        }

    }

    public WebDriver getDriver(){
        if(null == driver)
        {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
