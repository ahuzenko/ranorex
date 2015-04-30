package com.ahuzenko.features;


/**
 * Created by Sunny on 29.04.2015.
 */
import com.ahuzenko.steps.UserSteps;

//import net.thucydides.junit.annotations.Qualifier;
//import net.thucydides.junit.annotations.TestData;

import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.core.pages.Pages;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



    @RunWith(SerenityParameterizedRunner.class)
    @Concurrent
    @UseTestDataFrom(value="testdata/addnewvip.csv", separator=',')
    public class RanorexAddUserParameterized {

        private String newFirstName;
        private String newLastName;
        private String newGender;
        private String newCategory;

        @Managed(uniqueSession = true)
        public WebDriver webdriver;


        public Pages pages;

        @Steps
        public UserSteps userSteps;


        @Test
        public void AddUserToTheVipListTest(){


            userSteps.openHomePage();
            userSteps.fillNewVipUserData(newFirstName, newLastName, newGender, newCategory);
            userSteps.addUser();
            userSteps.isUserAdded(newFirstName, newLastName, newGender,newCategory);

        }


    }
