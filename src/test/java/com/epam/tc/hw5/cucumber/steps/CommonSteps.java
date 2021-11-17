package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.cucumber.utils.TestProperties.getProperty;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.openHomePage(getProperty("homePageURL"));
    }

    @And("I login as user 'Roman Iovlev'")
    public void loginAsRomanIovlev() {
        homePage.getHeader().clickUserIconButton();
        homePage.getHeader().typeLogin(getProperty("login"));
        homePage.getHeader().typePassword(getProperty("password"));
        homePage.getHeader().clickEnterButton();
    }

    @When("I click on {string} button in Header")
    public void clickOnTheTabInHeader(String tabName) {
        homePage.getHeader().clickOnTheTabInHeader(tabName);
    }

    @And("I click on {string} button in Service dropdown")
    public void clickOnTheSubTabServiceDropdownMenu(String service) {
        homePage.getHeader().clickOnTheSubTabServiceDropdownMenu(service);
    }

    @When("I select {string} checkbox")
    public void selectCheckbox(String checkboxName) {
        differentElementsPage.clickOnTheCheckbox(checkboxName);
    }

    @When("I select {string} radiobutton")
    public void selectRadioButton(String radiobuttonName) {
        differentElementsPage.clickOnTheRadiobutton(radiobuttonName);
    }

    @When("I select {string} in the dropdown menu")
    public void selectColorInDropdownMenu(String color) {
        differentElementsPage.selectColorInDropdown(color);
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckboxForSergeyIvan() {
        userTablePage.clickOnSergeyIvanVipCheckbox();
    }
}
