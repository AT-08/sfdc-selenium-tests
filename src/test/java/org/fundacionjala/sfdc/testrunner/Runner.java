package org.fundacionjala.sfdc.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Initial configurations.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala.sfdc"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
/**
 * Runner.java
 * Class to run tests.
 */
public class Runner extends AbstractTestNGCucumberTests {

}
