package com.epam.tc.hw8.tests;

import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_NAME;
import static com.epam.tc.hw8.steps.BoardSteps.createBoard;
import static com.epam.tc.hw8.steps.BoardSteps.deleteBoard;

import com.epam.tc.hw8.beans.Board;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    protected static String id;

    @BeforeMethod
    public void setUp() {
        id = createBoard(BOARD_NAME);
    }

    @BeforeMethod
    public void tearDown() {
        deleteBoard(id);
    }
}
