package org.fundacionjala.sfdc.util;

/**
 * Value.java
 * Interface to apply strategy pattern to a map using lambda.
 */
public interface Value {

    /**
     * Method to set values to fields.
     * @param valueForField the value set in feature data table.
     */
    public void fillField(String valueForField);
}
