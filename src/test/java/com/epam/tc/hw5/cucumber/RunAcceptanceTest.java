package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
    (plugin = {"pretty"},
     features = {"/Users/Anton_Iakimov/work/Java automation/AntonIakimov/src/test/resources/com.epam.tc.hw5/cucumber"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {

}
