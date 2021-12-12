package com.epam.tc.hw8.core;

import static com.epam.tc.hw8.conatants.AuthConstants.KEY;
import static com.epam.tc.hw8.conatants.AuthConstants.TOKEN;
import static com.epam.tc.hw8.utils.TestProperties.getProperty;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpStatus;

public class BasicTrelloServiceObject {

    public static final URI BASE_TRELLO_URI = URI.create(getProperty("baseURL"));

    protected Method requestMethod;
    protected Map<String, String> queryParams;

    public BasicTrelloServiceObject(Method requestMethod, Map<String, String> queryParams) {
        this.requestMethod = requestMethod;
        this.queryParams = queryParams;
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .addQueryParam(KEY, getProperty("key"))
            .addQueryParam(TOKEN, getProperty("token"))
            .setBaseUri(BASE_TRELLO_URI)
            .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification badRequestResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();
    }



}
