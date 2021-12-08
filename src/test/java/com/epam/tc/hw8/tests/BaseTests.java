package com.epam.tc.hw8.tests;

import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_DESC;
import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_NAME;
import static com.epam.tc.hw8.steps.BoardSteps.createBoard;
import static com.epam.tc.hw8.steps.BoardSteps.deleteBoard;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    protected static String id;

    @BeforeClass
    public void setUp() {
        id = createBoard(BOARD_NAME, BOARD_DESC);
    }

    @AfterClass
    public void tearDown() {
        deleteBoard(id);
    }
}
