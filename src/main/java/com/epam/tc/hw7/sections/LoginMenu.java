package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.sections.forms.LoginForm;

@UI(".uui-navigation navbar-nav navbar-right")
public class LoginMenu extends Section {

    @UI("#user-icon")
    public Icon userIcon;

    @UI("#user-name")
    public Label userName;

    @UI("#login-form")
    public LoginForm loginForm;

    public String getUserName() {
        return userName.getValue();
    }

    public void login(User user) {
        userIcon.click();
        loginForm.submit(new User(), "enter");
    }

}
