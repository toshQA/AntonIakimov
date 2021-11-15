package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.utils.TestProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.openHomePage(TestProperties.getTestProperties().getProperty("homePageURL"));
    }

    @And("I login as user 'Roman Iovlev'")
    public void loginAsRomanIovlev() {
        homePage.getHeader().clickUserIconButton();
        homePage.getHeader().typeLogin(TestProperties.getTestProperties().getProperty("login"));
        homePage.getHeader().typePassword(TestProperties.getTestProperties().getProperty("password"));
        homePage.getHeader().clickEnterButton();
    }

    @When("I click on 'Service' button in Header")
    public void clickOnTheServiceTabInHeader() {
        homePage.getHeader().clickOnTheServiceTabInHeader();
    }

    @And("I click on 'Different Elements' button in Service dropdown")
    public void clickOnTheDifferentElementsMenuItemInDropdownMenu() {
        homePage.getHeader().clickOnTheDifferentElementsMenuItemInDropdownMenu();
    }

    @And("I click on 'User Table' button in Service dropdown")
    public void clickOnTheUserTableMenuItemInDropdownMenu() {
        homePage.getHeader().clickOnTheUserTableMenuItemInDropdownMenu();
    }

    @When("I select 'Water' checkbox")
    public void selectWaterCheckbox() {
        differentElementsPage.selectWaterCheckbox();
    }

    @When("I select 'Wind' checkbox")
    public void selectWindCheckbox() {
        differentElementsPage.selectWindCheckbox();
    }

    @When("I select 'Selen' radiobutton")
    public void selectSelenRadioButton() {
        differentElementsPage.selectSelenRadioButton();
    }

    @When("I select 'Yellow' in the dropdown menu")
    public void selectYellowInDropdownMenu() {
        differentElementsPage.selectYellowItemInColorDropdown();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckboxForSergeyIvan() {
        userTablePage.clickOnSergeyIvanVipCheckbox();
    }
}
