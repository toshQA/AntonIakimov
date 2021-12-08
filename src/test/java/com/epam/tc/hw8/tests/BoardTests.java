package com.epam.tc.hw8.tests;

import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_NAME;
import static com.epam.tc.hw8.steps.BoardSteps.createBoard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.testng.annotations.Test;

public class BoardTests {

    @Test
    public void verifyBoardNameTest() {
        assertThat(createBoard(BOARD_NAME), equalToIgnoringCase(BOARD_NAME));
    }
}
