package com.epam.tc.hw8.tests;

import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_DESC;
import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_NAME;
import static com.epam.tc.hw8.conatants.BoardConstants.NEW_BOARD_NAME;
import static com.epam.tc.hw8.steps.BoardSteps.createBoard;
import static com.epam.tc.hw8.steps.BoardSteps.getBoard;
import static com.epam.tc.hw8.steps.BoardSteps.updateBoardName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.testng.annotations.Test;

public class BoardTests extends BaseTests {

    @Test
    public void verifyBoardNameTest() {
        assertThat(getBoard(id).getName(), equalToIgnoringCase(BOARD_NAME));
    }

    @Test
    public void verifyBoardDescriptionTest() {
        assertThat(getBoard(id).getDesc(), equalToIgnoringCase(BOARD_DESC));
    }

    @Test
    public void verifyBoardNameUpdateTest() {
        updateBoardName(NEW_BOARD_NAME, id);
        assertThat(getBoard(id).getName(), equalToIgnoringCase(NEW_BOARD_NAME));
    }

}
