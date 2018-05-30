package org.fundacionjala.sfdc.util;

/**
 * NoConfigPropertiesFound.java
 * Class that extends RuntimeException to get exception when config.properties is not found.
 */
public class NoConfigPropertiesFound extends RuntimeException {

    /**
     * Constructor that receives a message and the exception cause.
     *
     * @param message that should be displayed.
     * @param cause   the cause of the exception.
     */
    public NoConfigPropertiesFound(final String message, final Throwable cause) {
        super(message, cause);
    }
}
