package com.epam.tc.hw8.tests;

import static com.epam.tc.hw8.conatants.BoardConstants.BLANK_BOARD_NAME;
import static com.epam.tc.hw8.conatants.BoardConstants.LONG_BOARD_NAME;
import static com.epam.tc.hw8.conatants.BoardConstants.NAME;
import static com.epam.tc.hw8.core.BoardServiceObject.BOARD_TRELLO_URI;
import static com.epam.tc.hw8.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw8.core.BoardServiceObject.getBoardObject;
import static com.epam.tc.hw8.core.BoardServiceObject.randomString;
import static com.epam.tc.hw8.steps.BoardSteps.closeBoard;
import static com.epam.tc.hw8.steps.BoardSteps.createBoard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw8.beans.Board;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class BoardTests extends BaseTests {

    @Test
    public void createBoardWithBlankNameTest() {
        Response response = boardRequestBuilder()
            .setMethod(Method.POST)
            .setName(BLANK_BOARD_NAME)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    @Test
    public void createBoardWithLongNameTest() {
        Response response = boardRequestBuilder()
            .setMethod(Method.POST)
            .setName(LONG_BOARD_NAME)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    @Test
    public void createBasedBoardTest() {
        Board board = createBoard(NAME);
        String randomDesc = randomString();
        Response response = boardRequestBuilder()
            .setMethod(Method.PUT)
            .setDesc(randomDesc)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + board.getId());
        String desc = getBoardObject(response).getDesc();

        Response response2 = boardRequestBuilder()
            .setMethod(Method.POST)
            .setName(NAME)
            .setIdBoardSource(board.getId())
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI);
        Board basedBoard = getBoardObject(response2);

        assertThat(basedBoard.getDesc(), equalTo(desc));
    }

    @Test
    public void closeClosedBoardTest() {
        String boardId = createBoard(NAME).getId();
        closeBoard(boardId);
        Response response2 = boardRequestBuilder()
            .setMethod(Method.PUT)
            .setClosed("true")
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + boardId);

        assertThat(response2.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void updateClosedBoard() {
        String boardId = createBoard(NAME).getId();
        String randomName = randomString();
        closeBoard(boardId);
        Response response = boardRequestBuilder()
            .setMethod(Method.PUT)
            .setName(randomName)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + boardId);
        Board board = getBoardObject(response);
        assertThat(board.getName(), equalTo(randomName));
    }
}

