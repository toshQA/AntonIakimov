package com.epam.tc.hw5.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends BasePage {

    @FindBy(xpath = "//tr/td[1]")
    List<WebElement> numberList;

    @FindBy(xpath = "//td/select")
    List<WebElement> typeList;

    @FindBy(xpath = "//td/a")
    List<WebElement> userList;

    @FindBy(xpath = "//div[@class='user-descr']/span")
    List<WebElement> descriptionList;

    @FindBy(xpath = "//div[@class='user-descr']/input")
    List<WebElement> checkboxList;

    @FindBy(xpath = "//tr[1]/td/select/option")
    List<WebElement> dropdownItemsList;

    @FindBy(xpath = "//input[@id='ivan']")
    WebElement ivanVipCheckbox;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]/li")
    private List<WebElement> logsList;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> getNumberList() {
        return numberList;
    }

    public List<WebElement> getTypeList() {
        return typeList;
    }

    public List<WebElement> getUserList() {
        return userList;
    }

    public List<WebElement> getDescriptionList() {
        return descriptionList;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public List<WebElement> getDropdownItemsList() {
        return dropdownItemsList;
    }

    public List<WebElement> getLogsList() {
        return logsList;
    }

    public void clickOnSergeyIvanVipCheckbox() {
        ivanVipCheckbox.click();
    }

    public List<String> getActualDropdownItemsList() {
        return dropdownItemsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getActualNumbersList() {
        return numberList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getActualUsernamesList() {
        return userList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getActualDescriptionsList() {
        return descriptionList.stream()
                              .map(WebElement::getText)
                              .map(s -> s.replace("\n", " "))
                                         .collect(Collectors.toList());
    }
}
