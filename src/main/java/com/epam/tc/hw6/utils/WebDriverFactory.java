package com.epam.tc.hw6.utils;

import com.epam.tc.hw6.exception.IllegalBrowserNameException;
import com.epam.tc.hw6.exception.WebDriverLaunchTypeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class WebDriverFactory {

    public static final String LOCAL_LAUNCH = "local";
    public static final String REMOTE_LAUNCH = "remote";

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(final String launchType, final Browser browser) {
        WebDriver webDriver;
        if (LOCAL_LAUNCH.equalsIgnoreCase(launchType)) {
            webDriver = createLocalWebDriver(browser);
        } else if (REMOTE_LAUNCH.equalsIgnoreCase(launchType)) {
            webDriver = createRemoteWebDriver(browser);
        } else {
            throw new WebDriverLaunchTypeException();
        }
        return webDriver;
    }

    private static WebDriver createLocalWebDriver(final Browser browser) {
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                webDriver = createChromeDriver();
                break;

            case FIREFOX:
                webDriver = createFirefoxDriver();
                break;

            default:
                throw new IllegalBrowserNameException();
        }
        return webDriver;
    }

    private static WebDriver createRemoteWebDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createChromeCapabilities();
                break;

            case FIREFOX:
                capabilities = createFirefoxCapabilities();
                break;

            default:
                throw new IllegalBrowserNameException();
        }
        WebDriver webDriver;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        return webDriver;
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }


    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new SafariDriver();
    }
}
