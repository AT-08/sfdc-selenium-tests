package org.fundacionjala.sfdc.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.sfdc.util.PropertiesManager;

/**
 * Java class created to manage SalesForce API.
 */
public final class APIManager {

    private static APIManager apiManager;
    private RequestSpecification requestSpecification;
    private String baseUri = "https://na59.salesforce.com/services/data/v32.0";
    private PropertiesManager propertiesManager = PropertiesManager.getInstance();

    /**
     * Constructor method.
     */
    private APIManager() {
        init();
    }

    /**
     * APIManager Singleton method.
     *
     * @return the instance of the apiManager.
     */
    public static APIManager getInstance() {
        if (apiManager == null) {
            apiManager = new APIManager();
        }
        return apiManager;
    }

    /**
     * Initializes the API connection and build the request specification.
     */
    private void init() {
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(baseUri)
                .addHeader("authorization", "oauth".concat(getAccessTokenHeader()))
                .build();
    }


    /**
     * Gets the token.
     *
     * @return the token header.
     */
    public String getAccessTokenHeader() {
        Response authenticationResponse = RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(baseUri)
                .param("grant_type", propertiesManager.getGrantType())
                .param("client_id", propertiesManager.getClientId())
                .param("client_secret", propertiesManager.getClientSecret())
                .param("username", propertiesManager.getUsername())
                .param("password", propertiesManager.getPassword().concat(propertiesManager.getUserSecurityToken()))
                .post();
        return authenticationResponse.jsonPath().get("access_token");
    }

    /**
     * Gets the request specification.
     *
     * @return the request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
