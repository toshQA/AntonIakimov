package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//label[contains(., 'Water')]/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[contains(., 'Wind')]/input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[contains(., 'Selen')]/input")
    private WebElement selenRadioButton;

    @FindBy(className = "colors")
    private WebElement colorsDropdown;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowItemInDropdown;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]/li")
    private List<WebElement> logsList;

    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkboxList;

    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radiobuttonList;

    @FindBy(tagName = "option")
    private List<WebElement> colorsList;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectColorInDropdown(String color) {
        colorsDropdown.click();
        clickOnTheColorItem(color);
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public List<WebElement> getRadiobuttonList() {
        return radiobuttonList;
    }

    public List<WebElement> getColorsList() {
        return colorsList;
    }

    public void clickOnTheCheckbox(String checkboxName) {
        checkboxList.stream()
                    .filter(checkbox -> checkbox.getText().contains(checkboxName))
                    .findFirst().orElseThrow().click();
    }

    public void clickOnTheRadiobutton(String radiobuttonName) {
        radiobuttonList.stream()
                       .filter(radiobutton -> radiobutton.getText().contains(radiobuttonName))
                       .findFirst().orElseThrow().click();
    }

    public void clickOnTheColorItem(String color) {
        colorsList.stream()
                  .filter(colorName -> colorName.getText().contains(color))
                  .findFirst().orElseThrow().click();
    }
}
