package org.fundacionjala.sfdc.api;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Class for the request manager.
 */
public final class APIRequestManager {
    private static APIRequestManager apiRequestManager;

    /**
     * Constructor method.
     */
    private APIRequestManager() {
    }

    /**
     * Gets API request manager instance.
     *
     * @return the singleton instance.
     */
    public static APIRequestManager getInstance() {
        if (apiRequestManager == null) {
            apiRequestManager = new APIRequestManager();
        }
        return apiRequestManager;
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
                .post(APIManager.SOBJECTS + endpoint);
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
