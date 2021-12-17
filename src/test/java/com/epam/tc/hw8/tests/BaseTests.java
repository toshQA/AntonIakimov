package com.epam.tc.hw8.tests;

import static com.epam.tc.hw8.steps.BoardSteps.deleteAllBoards;

import org.testng.annotations.AfterClass;

public class BaseTests {

    @AfterClass
    public void tearDown() {
        deleteAllBoards();
    }
}
