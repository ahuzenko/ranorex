package com.ahuzenko.componentSeleniumTests.pages;

/**
 * Created by Sunny on 04.06.2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


//http://www.intel.com/content/www/us/en/homepage.html

public class IntelHomePage {
    private WebDriver driver;
    private static String URL_MATCH = "homepage";
    private static String PAGE_URL = "http://www.intel.com/content/www/us/en/homepage.html";


    @FindBy(id = "mobile-search")
    @CacheLookup
    private WebElement mobileSearch;
    public void fillSearch(String searchWords){

        mobileSearch.sendKeys(searchWords);

    }


    @FindBy(className = "submit")
    @CacheLookup
    private WebElement search;
    public SearchPageResults clickSearch(){

        search.click();


        //wait for search results are loaded
        (new WebDriverWait(driver, 15))
                .until(new ExpectedCondition<Boolean>(){
                    @Override
                    public Boolean apply(WebDriver d) {
                        return d.findElement(By.className("results-count")).isDisplayed();
                    }
                });

        return new SearchPageResults(driver);
    }


    public IntelHomePage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
