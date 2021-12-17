package com.epam.tc.hw8.steps;

import static com.epam.tc.hw8.core.BoardServiceObject.BOARD_TRELLO_URI;
import static com.epam.tc.hw8.core.BoardServiceObject.ME_TRELLO_URI;
import static com.epam.tc.hw8.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw8.core.BoardServiceObject.getBoardObject;

import com.epam.tc.hw8.beans.Board;
import com.epam.tc.hw8.conatants.BoardConstants;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.List;

public class BoardSteps {

    @Step("Create Board")
    public static Board createBoard() {
        Response response = boardRequestBuilder()
            .setMethod(Method.POST)
            .setName(BoardConstants.NAME)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI);
        return getBoardObject(response);
    }

    @Step("Get Board")
    public static Board getBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + id);
        return getBoardObject(response);
    }

    @Step("Get All Boards Id")
    public static List<String> getAllBoardsId() {
        Response response = boardRequestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(ME_TRELLO_URI + BOARD_TRELLO_URI);
        return response.jsonPath().getList("id");
    }

    @Step("Delete Board")
    public static void deleteBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + id);
    }

    @Step("Delete All Boards")
    public static void deleteAllBoards() {
        getAllBoardsId().forEach(id -> deleteBoard(id));
    }

    @Step("Close the Board")
    public static void closeBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.PUT)
            .setClosed("true")
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + id);
    }
}
