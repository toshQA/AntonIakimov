package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class Results extends Section {

    @UI(".panel-body-list.results li")
    public static List<WebElement> resultList;

    public static List<String> getResults() {
        System.out.println(resultList.size());
        return resultList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
