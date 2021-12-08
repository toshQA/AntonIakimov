package com.epam.tc.hw8.steps;

import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_NAME;
import static com.epam.tc.hw8.core.BasicTrelloServiceObject.goodResponseSpecification;
import static com.epam.tc.hw8.core.BoardServiceObject.BOARD_TRELLO_URI;
import static com.epam.tc.hw8.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw8.core.BoardServiceObject.getBoardObject;

import com.epam.tc.hw8.beans.Board;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class BoardSteps {

    @Step("Create Board")
    public static String createBoard(String name, String desc) {
        Response response = boardRequestBuilder()
            .setMethod(Method.POST)
            .setName(name)
            .setDesc(desc)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI);
        return getBoardObject(response).getId();
    }


    @Step("Get Board")
    public static Board getBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + id);
        return getBoardObject(response);
    }

    @Step("Delete Board")
    public static void deleteBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + id);
    }

    @Step("Update Board Name")
    public static void updateBoardName(String name, String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.PUT)
            .setName(name)
            .buildRequest()
            .sendRequest(BOARD_TRELLO_URI + id);
    }
}
