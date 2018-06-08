package org.fundacionjala.sfdc.api;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Class for the request manager.
 */
public final class APIRequestManager {
    /**
     * Constructor method.
     */
    private APIRequestManager() {
    }

    /**
     * Response attribute to get request.
     */
    private static Response response;

    /**
     * Method to post a request.
     *
     * @param values   map.
     * @param endpoint to request to.
     */
    public static void post(final Map<String, String> values, final String endpoint) {
        response = given()
                .spec(APIManager.getInstance().getRequestSpecification())
                .params(values)
                .when()
                .post(endpoint);
    }

    /**
     * Gets the response.
     *
     * @return the response.
     */
    public static Response getResponse() {
        return response;
    }
}
