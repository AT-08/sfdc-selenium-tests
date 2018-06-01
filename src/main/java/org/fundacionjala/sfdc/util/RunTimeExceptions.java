package org.fundacionjala.sfdc.util;

/**
 * RunTimeExceptions.java
 * Class that extends RuntimeException to get exceptions.
 */
public class RunTimeExceptions extends RuntimeException {

    /**
     * Constructor that receives a message and the exception cause.
     *
     * @param message that should be displayed.
     * @param cause   the cause of the exception.
     */
    public RunTimeExceptions(final String message, final Throwable cause) {
        super(message, cause);
    }
}
