package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * SFOEdit.java
 * Class that represents the page where an oppotunity could be modified.
 */
public class SFOEdit extends SalesForceConnection {
    private WebDriverWait wait;

    @FindBy(how = How.ID, using = "opp3")
    private WebElement opportunityName;

    @FindBy(how = How.ID, using = "opp9")
    private WebElement opportunityCloseDate;

    @FindBy(how = How.ID, using = "opp11")
    private WebElement opportunityStage;

    @FindBy(how = How.CSS, using = "#topButtonRow > input:nth-child(1)")
    private WebElement saveOpportunityButton;

    @FindBy(how = How.ID, using = "AllTab_Tab")
    private WebElement pagesButton;

    @FindBy(how = How.CSS, using = "a.opportunityBlock")
    private WebElement opportunitiesPage;

    /**
     * Constructor.
     */
    public SFOEdit() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Method to get "save" button.
     *
     * @return web element save button.
     */
    public WebElement getSaveOpportunityButton() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOf(this.saveOpportunityButton));
        return this.saveOpportunityButton;
    }


    /**
     * Method to set opportunityCloseDate attribute.
     *
     * @param opportunityCloseDate string value.
     */
    public void setOpportunityCloseDate(final String opportunityCloseDate) {
        this.opportunityCloseDate.clear();
        this.opportunityCloseDate.sendKeys(opportunityCloseDate);
        this.opportunityCloseDate.sendKeys(Keys.ESCAPE);
    }

    /**
     * Method to set opportunityName attribute.
     *
     * @param opportunityName string value.
     */
    public void setOpportunity(final String opportunityName) {
        this.opportunityName.sendKeys(opportunityName);
    }

    /**
     * Method to set opportunityStage attribute.
     *
     * @param opportunityStage string value.
     */
    public void setOpportunityStage(final String opportunityStage) {
        Select dropdown = new Select(this.opportunityStage);
        List<WebElement> stageOptions = dropdown.getOptions();
        WebElement opportunitySelected = null;
        for (WebElement element: stageOptions) {
            if (element.getText().matches(opportunityStage)) {
                opportunitySelected = element;
            }
        }
        opportunitySelected.click();
    }



    /**
     * Method to create or edit an opportunity.
     *
     * @param opName      the opportunity name.
     * @param opCloseDate the opportunity close date.
     * @param opStage     the opportunity stage.
     */
    public void editOpportunity(final String opName, final String opCloseDate, final String opStage) {
        setOpportunity(opName);
        setOpportunityCloseDate(opCloseDate);
        setOpportunityStage(opStage);
    }

    /**
     * Method to do click "save" button.
     */
    public void clickSaveOpportunityButton() {
        getSaveOpportunityButton().click();
    }

    /**
     * This method leads to an Opportunity Home Page.
     */
    public void goToOpportunitiesPage() {
        pagesButton.click();
        opportunitiesPage.click();
    }
}
