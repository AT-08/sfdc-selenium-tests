package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * CreateContactSteps.java.
 * Class for steps createContact.feature.
 */
public class CreateContactSteps {

    /**
     * Given step.
     */
    @Given("^I am going to app launcher page$")
    public void iAmGoingToAppLauncherPage() {
        System.out.println("I go to app launcher button.");


    }

    /**
     * Given step.
     */
    @Given("^I am on the new contact page$")
    public void iAmOnTheNewContactPage() {
        System.out.println("This Step open the Firefox and go to login page of the application.");
    }

    /**
     * When step.
     */
    @When("^I fill in First name with Ariel$")
    public void iFillInFirstNameWithAriel() {
        System.out.println("This step enter the Username and Password on the login page.");
    }

    /**
     * And step.
     */
    @And("^I fill in Last Name with Gonzales$")
    public void iFillInLastNameWithGonzales() {
        System.out.println("Fill in laste name");
    }

    /**
     * And step.
     */
    @And("^I press Save$")
    public void iPressSave() {
        System.out.println("Click save button");
    }

    /**
     * Then step.
     */
    @Then("^I should see a contact called Ariel Gonzales$")
    public void iShouldSeeAContactCalledArielGonzales() {
        System.out.println("Verify it was saved");

    }
}
