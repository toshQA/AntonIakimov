package com.epam.tc.hw6.utils;

import java.util.Locale;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

public final class WebDriverProvider {

    private static WebDriver webDriver;

    private WebDriverProvider() {
    }

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            String launchType = System.getProperty("launch.type", "local");
            String browserName = System.getProperty("browser.name", "chrome");
            webDriver = WebDriverFactory.createWebDriver(launchType,
                Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
        }
        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
