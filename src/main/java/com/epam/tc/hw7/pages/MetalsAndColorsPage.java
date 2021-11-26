package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.sections.Results;
import com.epam.tc.hw7.sections.forms.MetalsAndColorsForm;

@Url("metals-colors.html")
@Title("Metals and Colors")
public class MetalsAndColorsPage extends BasePage {

    @UI(".main-content-hg")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @UI(".panel-body-list.results")
    public static Results results;
}
