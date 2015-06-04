package com.ahuzenko.componentSeleniumTests.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sunny on 04.06.2015.
 */
public class FoundItem {

    private WebDriver driver;


    public boolean validateFoundItem(String val){

        return (driver.getPageSource().contains("val"))?true:false ;
    }


    public FoundItem(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}

