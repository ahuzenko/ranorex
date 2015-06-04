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

import java.util.List;




public class SearchPageResults {

    private WebDriver driver;
    private static String URL_MATCH = "search";
    private static String PAGE_URL = "http://www.intel.com/content/www/us/en/search.html";

    @FindBy(id="search-query-input")
    private WebElement searchInput;
    public void fillSearch(String searchWords){

        searchInput.sendKeys(searchWords);

    }

    @FindBy(className = "input-group-btn")
    @CacheLookup
    private WebElement search;
    public void clickSearch() {

        search.findElement(By.tagName("button")).click();


        //wait for search results are loaded
        (new WebDriverWait(driver, 15))
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver d) {
                        return d.findElement(By.className("results-count")).isDisplayed();
                    }
                });

    }



    @FindBy(className = "results-count")
    private WebElement searchCount;
    public int countSearchResults(){

        String str = searchCount.findElement(By.tagName("h3")).getText().replaceAll("[^0-9]", "");
        int res = Integer.parseInt(str);
        return res;
    }


    @FindBy(className = "result-content")
    private List<WebElement> serchResultItems;
    public FoundItem clickFirstFoundItem(){

        serchResultItems.get(0).findElement(By.tagName("a")).click();
        (new WebDriverWait(driver, 15))
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver d) {
                        return d.findElement(By.id("searchBox")).isDisplayed();
                    }
                });



        return new FoundItem(driver);


    }




    public SearchPageResults(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}



