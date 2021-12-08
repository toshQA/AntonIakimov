package com.epam.tc.hw8.steps;

import static com.epam.tc.hw8.conatants.BoardConstants.BOARD_NAME;
import static com.epam.tc.hw8.core.BasicTrelloServiceObject.goodResponseSpecification;
import static com.epam.tc.hw8.core.BoardServiceObject.boardRequestBuilder;
import static com.epam.tc.hw8.core.BoardServiceObject.getBoardObject;

import com.epam.tc.hw8.beans.Board;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class BoardSteps {

    @Step("Create Board")
    public static String createBoard(String name) {
        Response response = boardRequestBuilder()
            .setMethod(Method.POST)
            .setName(name)
            .buildRequest()
            .sendRequest();
        return getBoardObject(response).getId();
    }

    @Step("Get Board")
    public static Board getBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.GET)
            .setName(id)
            .buildRequest()
            .sendRequest();
        return getBoardObject(response);
    }

    @Step("Delete Board")
    public static void deleteBoard(String id) {
        Response response = boardRequestBuilder()
            .setMethod(Method.DELETE)
            .setName(id)
            .buildRequest()
            .sendRequest();
    }
}
