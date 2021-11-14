package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.tests.utils.BaseTest;
import com.epam.tc.hw4.tests.utils.TestProperties;
import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class DifferentElementsPageSteps {

    protected SoftAssert softAssert;
    protected DifferentElementsPage differentElementsPage;
    protected HomePage homePage;

    public DifferentElementsPageSteps(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        softAssert = new SoftAssert();
    }

    @Step("Open Home Page")
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Step("Assert Home Page title")
    public void assertHomePageTitle() {
        softAssert.assertTrue(homePage.getDriver().getTitle().contains("Home Page"));
    }

    @Step("Perform Login")
    public void performLogin() {
        homePage.getHeader().login();
    }

    @Step("Assert Username")
    public void assertUsername() {
        softAssert.assertEquals(homePage.getHeader().getUserName(),
            TestProperties.getTestProperties().getProperty("fullName"));
    }

    @Step("Open Different Elements Page")
    public void openDifferentElementPage() {
        homePage
            .getHeader()
            .openDifferentElementsPage();
        softAssert.assertEquals(homePage.getDriver().getCurrentUrl(),
            TestProperties.getTestProperties().getProperty("differentElementsPageURL"));
    }

    @Step("Select Checkboxes")
    public void selectCheckboxes() {
        differentElementsPage.selectCheckboxes();
    }

    @Step("Select Radio Buttons")
    public void selectRadioButtons() {
        differentElementsPage.selectRadioButton();
    }

    @Step("Select Yellow Item in Color Dropdown")
    public void selectYellowItemInColorDropdown() {
        differentElementsPage.selectYellowItemInColorDropdown();
    }

    @Step("Assert Data from Logs")
    public void assertDataFromLogs() {
        List<WebElement> logsList = differentElementsPage.getLogsList();
        softAssert.assertTrue(logsList.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logsList.get(1).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logsList.get(2).getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logsList.get(3).getText().contains("Water: condition changed to true"));

    }

    @Step("Assert All")
    public void assertAll() {
        softAssert.assertAll();
    }

}
