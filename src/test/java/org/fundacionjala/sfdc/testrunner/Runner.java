package org.fundacionjala.sfdc.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Initial configurations.
 */
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.sfdc"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"
        })
/**
 * Runner.java
 * Class to run tests.
 */
public class Runner extends AbstractTestNGCucumberTests {

}
