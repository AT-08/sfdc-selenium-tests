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

    public static final String SOBJECTS = "/sobjects/";
    private static final String GRANT_TYPE = "grant_type";
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String USERNAME = "username";
    private static final String PASS = "password";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String SERVICE_BASE_URI = "https://na59.salesforce.com/services/data/v42.0";
    private static APIManager apiManager;
    private RequestSpecification requestSpecification;
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
                .setBaseUri(SERVICE_BASE_URI)
                .addHeader("Authorization", "Bearer ".concat(getAccessTokenHeader()))
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
                .baseUri("https://na59.salesforce.com/services/oauth2/token")
                .param(GRANT_TYPE, propertiesManager.getGrantType())
                .param(CLIENT_ID, propertiesManager.getClientId())
                .param(CLIENT_SECRET, propertiesManager.getClientSecret())
                .param(USERNAME, propertiesManager.getUsername())
                .param(PASS, propertiesManager.getPassword().concat(propertiesManager.getUserSecurityToken()))
                .post();
        return authenticationResponse.jsonPath().get(ACCESS_TOKEN).toString();
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
