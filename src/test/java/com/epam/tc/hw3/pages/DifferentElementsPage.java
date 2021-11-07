package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.sections.Header;
import com.epam.tc.hw3.sections.LeftSideMenu;
import com.epam.tc.hw3.tests.utils.BaseTest;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends BaseTest {
    protected Header header;
    protected LeftSideMenu leftSideMenu;

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

    public DifferentElementsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        header = new Header(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
    }

    public void selectCheckboxes() {
        waterCheckbox.click();
        windCheckbox.click();
    }

    public void selectRadioButton() {
        selenRadioButton.click();
    }

    public void selectYellowItemInColorDropdown() {
        colorsDropdown.click();
        yellowItemInDropdown.click();
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

}
