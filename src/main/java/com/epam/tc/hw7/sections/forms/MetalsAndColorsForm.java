package com.epam.tc.hw7.sections.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @UI("#summary-block input")
    public static RadioButtons summary;

    @UI("#elements-checklist input")
    public static Checklist elements;

    @JDropdown(root = "#colors",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "#metals",
               list = "li",
               expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "#vegetables",
               list = "label",
               expand = ".caret")
    public static Dropdown vegetables;

    @UI("#submit-button")
    public static Button submit;

    public void submit() {
        submit.click();
    }

}
