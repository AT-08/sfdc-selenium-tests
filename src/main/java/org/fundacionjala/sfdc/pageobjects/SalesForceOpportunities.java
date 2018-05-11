package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.commons.DriverManager;

/**
 * SalesForceOpportunities.java
 * Class that represents Opportunities page in SalesForce.
 */
public class SalesForceOpportunities {
    private WebDriver webDriver;
    private By newOpportunityButton;
    private By opportunityNameTextField;
    private By saveNewOpportunityButton;
    private By newOpportunityLabel;
    private By accountsViewList;
    private By goButton;
    private By lastOpportunityLink;
    private By deleteButton;
    private By editButton;
    private By opportunityCloseDate;

    /**
     * Constructor.
     *
     * @param webDriver instance.
     */
    public SalesForceOpportunities(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.newOpportunityButton = By.name("new");
        this.opportunityNameTextField = By.id("opp3");
        this.saveNewOpportunityButton = By.name("save");
        //this.newOpportunityLabel = By.className("topName");
        //this.accountsViewList = By.id("fcf");
        //this.goButton = By.cssSelector(".fBody > input[class='btn']");
        this.lastOpportunityLink = By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)");
        this.deleteButton = By.name("del");
        this.editButton = By.name("edit");
    }

    /**
     * Getter of newOpportunityButton.
     *
     * @return button.
     */
    public WebElement getNewOpportunityButton() {
        return this.webDriver.findElement(this.newOpportunityButton);
    }

    /**
     * Getter of saveNewAccountButton.
     *
     * @return button.
     */
    public WebElement getSaveNewOpportunityButton() {
        return this.webDriver.findElement(this.saveNewOpportunityButton);
    }

    /**
     * Method to click button.
     *
     * @param button to click.
     */
    public void clickNewOpportunityButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to click button.
     *
     * @param button to click.
     */
    public void clickSaveNewOpportunityButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to set opportunityName attribute.
     *
     * @param opportunityName string value.
     */
    public void setOpportunityNameTextField(final String opportunityName) {
        webDriver.findElement(this.opportunityNameTextField).sendKeys(opportunityName);
    }

    /**
     * Method to know if the page of new account is displayed.
     *
     * @return true or false.
     */
    public boolean isNewOpportunityButtonDisplayed() {
        return this.webDriver.findElement(this.newOpportunityButton).isDisplayed();
    }

    /**
     * Method to create a new opportunity.
     *
     * @param opportunityName the opportunity name.
     * @param opportunityCloseDate
     */
    public void createNewOpportunity(final String opportunityName, final String opportunityCloseDate, final String opportunityStage) {
        WebElement button = getNewOpportunityButton();
        WebElement saveOpportunityButton = getSaveNewOpportunityButton();
        clickNewOpportunityButton(button);
        setOpportunityNameTextField(opportunityName);
        setOpportunityCloseDate(opportunityCloseDate);
        setOpportunityStage(opportunityStage);
        clickSaveNewOpportunityButton(saveOpportunityButton);
    }

    private void setOpportunityStage(String opportunityStage) {
        new Select(webDriver.findElement(By.id("opp11"))).selectByVisibleText(opportunityStage);
        webDriver.findElement(By.xpath("//option[@value='"+opportunityStage+"']")).click();
    }

    /**
     * Method to know if an opportunity is saved.
     *
     * @return the new account name displayed in label.
     */
    public String newOpportunitySavedName() {
        return this.webDriver.findElement(this.newOpportunityLabel).getText();
    }

    /**
     * Method to set view in accounts list.
     *
     * @param accountView view list.
     */
    public void setOpportunityViewList(final String accountView) {
        Select select = new Select(this.webDriver.findElement(this.accountsViewList));
        select.selectByValue(accountView);
    }

    /**
     * Method to choose accounts view, if it is all accounts then press button go.
     *
     * @param opportunityView view.
     * @param button      to click.
     */
    public void chooseOpportunity(final String opportunityView, final WebElement button) {
        final int waitSeconds = 90;
        WebDriverWait wait = DriverManager.getInstance().getWaiter();
        WebElement searchOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(this.accountsViewList));
        Select select = new Select(searchOnDashboard);
        if ("All Accounts".equalsIgnoreCase(select.getFirstSelectedOption().getText().toString())) {
            clickGoButton(button);
        } else {
            setOpportunityViewList(opportunityView);
        }
    }

    /**
     * Method to get go button.
     *
     * @return button.
     */
    public WebElement getGoButton() {
        return this.webDriver.findElement(this.goButton);
    }

    /**
     * Method to click go button.
     *
     * @param button to click.
     */
    public void clickGoButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to verify all accounts was selected.
     *
     * @param accountView list.
     * @return list value.
     */
    public String isAllAccountsSelected(final String accountView) {
        WebDriverWait wait = DriverManager.getInstance().getWaiter();
        WebElement searchOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Select select = new Select(searchOnDashboard);
        return select.getFirstSelectedOption().getText().toString();
    }

    /**
     * Method to click edit link.
     */
    public void editOpportunity(String accountName) {
        setOpportunityNameTextField(accountName);
    }

    public WebElement getOpportunityNameLink() {
        return this.webDriver.findElement(this.lastOpportunityLink);
    }

    public void clickAccountNameLink() {
        getOpportunityNameLink().click();
    }

    public WebElement getDeleteButton() {
        return this.webDriver.findElement(this.deleteButton);
    }

    public void clickDeleteOpportunity() {
        getDeleteButton().click();
    }

    public void clickDeleteAlert() {
        WebDriverWait wait = DriverManager.getInstance().getWaiter();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public WebElement getEditButton() {
        return this.webDriver.findElement(this.editButton);
    }

    public void clickEditOpportunity() {
        getEditButton().click();
    }

    public void setOpportunityCloseDate(String opportunityCloseDate) {
        webDriver.findElement(By.id("opp9")).sendKeys(opportunityCloseDate);
        webDriver.findElement(By.id("opp9")).sendKeys(Keys.ESCAPE);
    }
}
