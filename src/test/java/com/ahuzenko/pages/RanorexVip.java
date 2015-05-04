package com.ahuzenko.pages;


import java.util.List;


import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;


@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip/")
public class RanorexVip extends PageObject{



    /**
     * User name
     */
    @FindBy(id = "FirstName")
    private WebElementFacade firstName;

    public RanorexVip() {
    }

    public void setFirstNameFieldValue(String value){
        firstName.type(value);
    }
    /**
     * User surname
     */
    @FindBy(id = "LastName")
    private WebElementFacade lastName;
    public void setLastNameFieldValue(String value){
        lastName.type(value);
    }
    /**
     * Button [Add] - register user
     */
    @FindBy(id = "Add")
    private WebElementFacade add;
    public void addUserToTheVIPList()
    {
        add.click();
    }

    /**
     * Button [Delete] - Delete user
     */
    @FindBy(id = "Delete")
    private WebElementFacade delete;
    public void deleteUserFromList()
    {
        delete.click();
    }

    /**
     * ListItem [Category] - {Other*, Music, Movie, Science, Sport, Politics}
     */
    @FindBy(id = "Category")
    private WebElementFacade category;
    public void selectCategoryFromList(String categoryValue)
    {

        category.selectByValue(categoryValue);
    }

    /**
     * Radio [Gender] - {Female*, Male}
     */
    @FindBy(id = "Gender")
    private WebElementFacade gender;
    public void selectGender(String genderValue)
    {
       gender.findElement(By.xpath("//input[@value='"+genderValue+"']")).click();

    }
    /**
     * Table [Vips] - List of registered bip users
     */
    @FindBy(id = "VIPs")
    private WebElementFacade vips;
    public String findUserInTheVIPTable(String searchString, String newGender, String newCategory)
    {
        List<WebElement> vipRows = vips.findElements(By.xpath("./tbody/tr"));

        for(WebElement row : vipRows)
        {
            String sr = (row.findElement(By.xpath("./td[2]")).getText()).toUpperCase() +
                row.findElement(By.xpath("./td[3]")).getText().toUpperCase()+
                row.findElement(By.xpath("./td[4]")).getText().toUpperCase()+
                row.findElement(By.xpath("./td[5]")).getText().toUpperCase();

            if(sr.equals((searchString+newGender+newCategory).toUpperCase()))
                return sr;
        }

        return "";
    }

    public boolean selectUserInTheVIPTable(String searchString, String newGender, String newCategory)  {
        List<WebElement> vipRows = vips.findElements(By.xpath("./tbody/tr"));

        for(WebElement row : vipRows)
        {
            String sr = (row.findElement(By.xpath("./td[2]")).getText()).toUpperCase() +
                    row.findElement(By.xpath("./td[3]")).getText().toUpperCase()+
                    row.findElement(By.xpath("./td[4]")).getText().toUpperCase()+
                    row.findElement(By.xpath("./td[5]")).getText().toUpperCase();

            if(sr.equals((searchString+newGender+newCategory).toUpperCase()))
            {
                row.findElement(By.xpath("./td[1]/input")).click();
                return true;
            }

        }

        return false;
    }
    /**
     * Button [Load] - gets list of registered users
     */

    @FindBy(id = "Load")
    private WebElementFacade load;
    public void loadVIPList()
    {
        load.click();
    }

    /**
     * Button [Save] - Commits registered users to bd
     */

    @FindBy(id = "Save")
    private WebElementFacade save;

    /**
     * Button [Clear] - clear table of loaded users on the page.
     */

    @FindBy(id = "Clear")
    private WebElementFacade clear;

    /**
     * Label [count] - Shows number of loaded users
     */

    @FindBy(id = "count")
    private WebElementFacade count;


    @FindBy(id = "connection")
    private WebElementFacade connection;



 }