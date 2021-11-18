package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.cucumber.utils.DataClass.EXPECTED_DESCRIPTIONS_ITEMS_LIST;
import static com.epam.tc.hw5.cucumber.utils.DataClass.EXPECTED_NUMBERS_ITEMS_LIST;
import static com.epam.tc.hw5.cucumber.utils.DataClass.EXPECTED_USERNAME_ITEMS_LIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;

public class AssertionSteps extends AbstractBaseStep {

    @Then("Logs for done actions are displayed")
    public void logsForDoneActionsAreDisplayed() {
        List<WebElement> logsList = differentElementsPage.getLogsList();
        assertThat(logsList.get(0).getText()).containsIgnoringCase("Colors: value changed to Yellow");
        assertThat(logsList.get(1).getText()).containsIgnoringCase("metal: value changed to Selen");
        assertThat(logsList.get(2).getText()).containsIgnoringCase("Wind: condition changed to true");
        assertThat(logsList.get(3).getText()).containsIgnoringCase("Water: condition changed to true");
    }

    @Then("{string} page should be opened")
    public void userTableIsOpened(String userTablePageTitle) {
        assertThat(userTablePage.getTitle())
            .isEqualToIgnoringCase(userTablePageTitle);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void typeDropdownsIsDisplayed(int quantity) {
        assertThat(userTablePage.getTypeList().size()).isEqualTo(quantity);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesIsDisplayed(int quantity) {
        assertThat(userTablePage.getUserList().size()).isEqualTo(quantity);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsIsDisplayed(int quantity) {
        assertThat(userTablePage.getDescriptionList().size()).isEqualTo(quantity);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesIsDisplayed(int quantity) {
        assertThat(userTablePage.getCheckboxList().size()).isEqualTo(quantity);
    }

    @And("User table should contain following values:")
    public void userTableContain(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        List<String> numbersList = userTablePage.getActualNumbersList();
        List<String> usernamesList = userTablePage.getActualUsernamesList();
        List<String> descriptionsList = userTablePage.getActualDescriptionsList();

        assertThat(userTablePage.getActualNumbersList()).isEqualTo(EXPECTED_NUMBERS_ITEMS_LIST);
        assertThat(userTablePage.getActualUsernamesList()).isEqualTo(EXPECTED_USERNAME_ITEMS_LIST);
        assertThat(userTablePage.getActualDescriptionsList()).isEqualTo(EXPECTED_DESCRIPTIONS_ITEMS_LIST);
    }

    @And("droplist should contain values in column Type for user Roman")
    public void dropdownItemList(DataTable table) {
        List<String> expectedDropdownItemsList = new ArrayList<>();
        table.asMaps(String.class, String.class)
             .forEach(s -> expectedDropdownItemsList.add(s.get("Dropdown Values")));

        assertThat(userTablePage
            .getActualDropdownItemsList()).isEqualTo(expectedDropdownItemsList);
    }

    @Then("1 log row has {string} text in log section")
    public void logRowForCheckInLogSection(String vipCheckboxSelectedText) {
        List<WebElement> logsList = userTablePage.getLogsList();
        assertThat(logsList.get(0).getText()).contains(vipCheckboxSelectedText);
    }
}
