package com.epam.tc.hw6.steps;

import static com.epam.tc.hw6.tests.utils.TestProperties.getProperty;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("checkstyle:WhitespaceAround")
public class DifferentElementsPageSteps extends BasePageSteps {

    public DifferentElementsPageSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open Different Elements Page")
    public DifferentElementsPageSteps openDifferentElementPage() {
        homePage
            .getHeader()
            .openDifferentElementsPage();
        softAssert.assertEquals(homePage.getDriver().getCurrentUrl(), getProperty("differentElementsPageURL"));
        return this;
    }

    @Step("Select Checkboxes")
    public DifferentElementsPageSteps selectCheckboxes() {
        differentElementsPage.selectCheckboxes();
        return this;
    }

    @Step("Select Radio Buttons")
    public DifferentElementsPageSteps selectRadioButtons() {
        differentElementsPage.selectRadioButton();
        return this;
    }

    @Step("Select Yellow Item in Color Dropdown")
    public DifferentElementsPageSteps selectYellowItemInColorDropdown() {
        differentElementsPage.selectYellowItemInColorDropdown();
        return this;
    }

    @Step("Assert Data from Logs")
    public DifferentElementsPageSteps assertDataFromLogs() {
        List<WebElement> logsList = differentElementsPage.getLogsList();
        softAssert.assertTrue(logsList.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logsList.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logsList.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logsList.get(3).getText().contains("Water: condition changed to true"));
        return this;
    }

    @Step("Assert All")
    public void assertAll() {
        softAssert.assertAll();
    }

}
