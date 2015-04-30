package com.ahuzenko.steps;

import com.ahuzenko.pages.RanorexVip;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Assert;
/**
 * Created by Sunny on 28.04.2015.
 */
public class UserSteps extends ScenarioSteps {


    RanorexVip ranorexVIP ;

    @Step
    public void openHomePage() { ranorexVIP.open(); }


    @Step
    public void setNewUserFirstName(String firstName) { ranorexVIP.setFirstNameFieldValue(firstName);}

    @Step
    public void setNewUserLastName(String lastName) { ranorexVIP.setLastNameFieldValue(lastName);}
    @Step
    public void selectNewUserGender(String gndr) { ranorexVIP.selectGender(gndr);}

    @Step
    public void selectNewCategory(String category) {
        ranorexVIP.selectCategoryFromList(category);
    }

    @Step
    public void selectVipUserFromTheList(String firstName,String lastName, String gndr,String category) {


            assertThat( firstName + "  " + lastName + " " + gndr + " "+ category + " not found. Check test data.",ranorexVIP.selectUserInTheVIPTable(firstName+lastName,gndr,category));

    }


    @Step
    public void addUser() { ranorexVIP.addUserToTheVIPList();}

    @Step
    public void deleteSelectedUser() { ranorexVIP.deleteUserFromList();}

    @Step
    public void loadVipList(){ ranorexVIP.loadVIPList(); }

   @Step
   public void fillNewVipUserData(String firstName,String lastName, String gndr,String category){
       setNewUserFirstName(firstName);
       setNewUserLastName(lastName);
       selectNewUserGender(gndr);
       selectNewCategory(category);
   }

    @Step
    public void isUserAdded(String firstName, String lastName, String gender, String category) {

        String expected;
        expected = (firstName+lastName+gender+category).toUpperCase();

        String result;
        result = ranorexVIP.findUserInTheVIPTable(firstName + lastName, gender, category);

        assertThat("Actual is: " + result + "\nExpected is: " + expected, result.equals(expected));
    }

    @Step
    public void isNotInTheList(String firstName, String lastName, String gender, String category) {

        String expected;
        expected = "";

        String result;
        result = ranorexVIP.findUserInTheVIPTable(firstName + lastName, gender, category);

        assertThat("Found: "+ result + "  Expected: vip was deleted. ", result.equals(expected));
    }

}
