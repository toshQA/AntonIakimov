package com.epam.tc.hw5.sections;

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

    @FindBy(linkText = "USER TABLE")
    private WebElement userTableSubTab;

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

    public void clickUserIconButton() {
        userIconButton.click();
    }

    public void clickEnterButton() {
        enterButton.click();
    }

    public void typeLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
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

    public void clickOnTheServiceTabInHeader() {
        serviceHeaderTab.click();
    }

    public void clickOnTheDifferentElementsMenuItemInDropdownMenu() {
        differentElementsSubTab.click();
    }

    public void clickOnTheUserTableMenuItemInDropdownMenu() {
        userTableSubTab.click();
    }

    public void openDifferentElementsPage() {
        serviceHeaderTab.click();
        differentElementsSubTab.click();
    }
}