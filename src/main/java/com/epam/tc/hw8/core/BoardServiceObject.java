package com.epam.tc.hw8.core;

import static com.epam.tc.hw8.conatants.BoardConstants.CLOSED;
import static com.epam.tc.hw8.conatants.BoardConstants.DESC;
import static com.epam.tc.hw8.conatants.BoardConstants.DESC_DATA;
import static com.epam.tc.hw8.conatants.BoardConstants.ID;
import static com.epam.tc.hw8.conatants.BoardConstants.ID_ENTERPRISE;
import static com.epam.tc.hw8.conatants.BoardConstants.ID_ORGANIZATION;
import static com.epam.tc.hw8.conatants.BoardConstants.NAME;

import com.epam.tc.hw8.beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class BoardServiceObject extends BasicTrelloServiceObject {

    public static final String BOARD_TRELLO_URI = "boards/";

    public BoardServiceObject(Method method, Map<String, String> queryParams) {
        super(method, queryParams);
    }

    public static BoardRequestBuilder boardRequestBuilder() {
        return new BoardRequestBuilder();
    }

    public static class BoardRequestBuilder {
        private Method requestMethod = Method.GET;
        private Map<String, String> queryParams = new HashMap<>();

        public BoardRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public BoardRequestBuilder setId(String id) {
            queryParams.put(ID, id);
            return this;
        }

        public BoardRequestBuilder setName(String name) {
            queryParams.put(NAME, name);
            return this;
        }

        public BoardRequestBuilder setDesc(String desc) {
            queryParams.put(DESC, desc);
            return this;
        }

        public BoardRequestBuilder setDescData(String descData) {
            queryParams.put(DESC_DATA, descData);
            return this;
        }

        public BoardRequestBuilder setClosed(String closed) {
            queryParams.put(CLOSED, closed);
            return this;
        }

        public BoardRequestBuilder setIdOrganization(String idOrganization) {
            queryParams.put(ID_ORGANIZATION, idOrganization);
            return this;
        }

        public BoardRequestBuilder setIdEnterprise(String idEnterprise) {
            queryParams.put(ID_ENTERPRISE, idEnterprise);
            return this;
        }

        public BoardServiceObject buildRequest() {
            return new BoardServiceObject(requestMethod, queryParams);
        }
    }

    public Response sendRequest(String endpoint) {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(queryParams)
            .request(requestMethod, BASE_TRELLO_URI + endpoint)
            .prettyPeek();
    }

    public static Board getBoardObject(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Board>() {}.getType());
    }
}
