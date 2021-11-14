package com.epam.tc.hw4.tests.ex2;

import com.epam.tc.hw4.steps.DifferentElementsPageSteps;
import com.epam.tc.hw4.tests.utils.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {
    @Feature("Allure report for Different Elements Page")
    @Story("Allure reporting training")
    @Test
    public void differentElementsPageTest() {
        DifferentElementsPageSteps differentElementsPageSteps = new DifferentElementsPageSteps(webDriver);

        differentElementsPageSteps.openHomePage();
        differentElementsPageSteps.assertHomePageTitle();
        differentElementsPageSteps.performLogin();
        differentElementsPageSteps.assertUsername();
        differentElementsPageSteps.openDifferentElementPage();
        differentElementsPageSteps.selectCheckboxes();
        differentElementsPageSteps.selectRadioButtons();
        differentElementsPageSteps.selectYellowItemInColorDropdown();
        differentElementsPageSteps.assertDataFromLogs();
        differentElementsPageSteps.assertAll();

    }
}
