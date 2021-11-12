package com.epam.tc.hw4.tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    public static Properties getTestProperties() {

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/com.epam.tc.hw3/test.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
