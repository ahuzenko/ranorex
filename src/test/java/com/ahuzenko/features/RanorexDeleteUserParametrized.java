package com.ahuzenko.features;

/**
 * Created by Sunny on 29.04.2015.
 */
import com.ahuzenko.steps.UserSteps;
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
@UseTestDataFrom(value="testdata/deletevip.csv", separator=',')
public class RanorexDeleteUserParametrized {

    private String vipFirstName;
    private String vipLastName;
    private String vipGender;
    private String vipCategory;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    public Pages pages;

    @Steps
    public UserSteps userSteps;


    @Test
    public void SelectAndDeleteUserFromTheVipListTest(){

        userSteps.openHomePage();
        userSteps.loadVipList();
        userSteps.selectVipUserFromTheList(vipFirstName, vipLastName, vipGender, vipCategory);
        userSteps.deleteSelectedUser();
        userSteps.isNotInTheList(vipFirstName, vipLastName, vipGender, vipCategory);

    }







}
