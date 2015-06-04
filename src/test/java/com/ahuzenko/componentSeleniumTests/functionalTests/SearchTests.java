package com.ahuzenko.componentSeleniumTests.functionalTests;

import com.ahuzenko.componentSeleniumTests.driverutilities.WebDriverFactory;
import com.ahuzenko.componentSeleniumTests.pages.FoundItem;
import com.ahuzenko.componentSeleniumTests.pages.IntelHomePage;
import com.ahuzenko.componentSeleniumTests.pages.SearchPageResults;
import org.junit.*;


import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sunny on 04.06.2015.
 */

public class SearchTests {

    private WebDriverFactory fDriver;
    String searchWords = "\"lineage 2\"";

    @Before
    public void startBrowser(){

        fDriver = new WebDriverFactory();

    }

    @Test
    public void searchFromHomePage(){

        int expected = 5;
        fDriver.startBrowser("http://www.intel.com/content/www/us/en/homepage.html");
        IntelHomePage iHP = new IntelHomePage(fDriver.getDriver());

        iHP.fillSearch(searchWords);


        SearchPageResults spRes = iHP.clickSearch();
        int actual = spRes.countSearchResults();


        spRes.countSearchResults();
        assertThat("Incorrect count of search results. Expected" + expected + " actual is " + actual, actual == expected);

    }

    @Test
    public void invalidSearch() {

        int expected = 0;
        fDriver.startBrowser("http://www.intel.com/content/www/us/en/search.html");
        String searchString = "auishrauhsr82347 sdfsdfmnkjasqoiwu4nasd";


        SearchPageResults spRes = new SearchPageResults(fDriver.getDriver());
        spRes.fillSearch("\"" + searchString + "\"");

        spRes.clickSearch();

        int actual = spRes.countSearchResults();

        assertThat("Incorrect count of search results. Expected" + expected + " actual is " + actual, actual == expected);
    }



    @Test
    public void checkRelevantSearchResult(){


        fDriver.startBrowser("http://www.intel.com/content/www/us/en/search.html");
        String searchString = "desktop board ca810e";


        SearchPageResults spRes = new SearchPageResults(fDriver.getDriver());
        spRes.fillSearch("\""+searchString+"\"");
        spRes.clickSearch();
        FoundItem foundItem = spRes.clickFirstFoundItem();

        assertThat("Search result is not relevant to "+searchString, foundItem.validateFoundItem(searchString));

    }

    @After
    public void stopBrowser()
    {
        fDriver.finishBrowser();

    }

}
