package org.fundacionjala.sfdc.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Initial configurations.
 */
@CucumberOptions(
        format = {"pretty"},
        features = {"src/test/resources/features"},
        plugin = {"io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"},
        glue = {"org.fundacionjala.sfdc"})
/**
 * Runner.java
 * Class to run tests.
 */
public class Runner extends AbstractTestNGCucumberTests {

}
