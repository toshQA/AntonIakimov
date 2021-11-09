package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.sections.Header;
import com.epam.tc.hw3.sections.LeftSideMenu;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "icons-benefit")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> texts;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public Header getHeader() {
        return header;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTexts() {
        return texts;
    }

    public List<String> getActualTexts(List<WebElement> texts) {
        List<String> actualTexts = texts.stream().map(WebElement::getText).collect(Collectors.toList());
        return actualTexts;
    }

    public void switchToFrame() {
        getDriver().switchTo().frame(frame);
    }

    public void switchToParentFrame() {
        getDriver().switchTo().parentFrame();
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

}
