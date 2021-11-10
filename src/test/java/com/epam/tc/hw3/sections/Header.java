package com.epam.tc.hw3.sections;

import com.epam.tc.hw3.tests.utils.TestProperties;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    @FindBy(id = "epam-logo")
    private WebElement epamLogo;

    @FindBy(linkText = "HOME")
    private WebElement homeHeaderTab;

    @FindBy(linkText = "CONTACT FORM")
    private WebElement contactFormHeaderTab;

    @FindBy(linkText = "SERVICE")
    private WebElement serviceHeaderTab;

    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalsAndColorsHeaderTab;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsSubTab;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li/a")
    private List<WebElement> actualHeaderNavBarItems;

    @FindBy(id = "icon-search")
    private WebElement searchButton;

    @FindBy(id = "user-icon")
    private WebElement userIconButton;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    public Header(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void login() {
        userIconButton.click();
        typeLogin();
        typePassword();
        enterButton.click();
    }

    public void typeLogin() {
        loginInput.sendKeys(TestProperties.getTestProperties().getProperty("login"));
    }

    public void typePassword() {
        passwordInput.sendKeys(TestProperties.getTestProperties().getProperty("password"));
    }

    public String getUserName() {
        return userName.getText();
    }

    public List<WebElement> getActualHeaderNavBarItems() {
        return actualHeaderNavBarItems;
    }

    public List<String> getActualHeaderNavBarItemsTexts(List<WebElement> actualHeaderNavBarItems) {
        return actualHeaderNavBarItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void openDifferentElementsPage() {
        serviceHeaderTab.click();
        differentElementsSubTab.click();
    }
}
