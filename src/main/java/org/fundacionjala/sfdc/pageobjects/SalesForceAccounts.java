package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.fundacionjala.sfdc.commons.DriverManager;

/**
 * SalesForceAccounts.java
 * Class that represents Accounts page in SalesForce.
 */
public class SalesForceAccounts {
    private WebDriver webDriver;
    private By newAccountButton;
    private By accountNameTextField;
    private By saveNewAccountButton;
    private By newAccountLabel;
    private By accountsViewList;
    private By goButton;
    private By lastAccountLink;
    private By deleteButton;
    private By editButton;
    private By homeContact;
    private WebDriverWait wait;

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceAccounts(final WebDriver webDriver) {
        this.homeContact = By.cssSelector("h2.pageDescription");
        this.webDriver = webDriver;
        this.newAccountButton = By.cssSelector(".pbButton > input[title='New']");
        this.accountNameTextField = By.cssSelector(".requiredInput > input[name='acc2']");
        this.saveNewAccountButton = By.cssSelector(".pbButton > input[name='save']");
        this.newAccountLabel = By.className("topName");
        this.accountsViewList = By.id("fcf");
        this.goButton = By.cssSelector(".fBody > input[class='btn']");
        this.lastAccountLink = By.cssSelector("tr.dataRow.even.first.dataRow >th[scope='row'] > a");
        this.deleteButton = By.cssSelector("#topButtonRow.pbButton > input[name='delete']");
        this.editButton = By.cssSelector("#topButtonRow.pbButton > input[name='edit']");
    }

    /**
     * Getter of newAccountButton.
     * @return button.
     */
    public WebElement getNewAccountButton() {
        return this.webDriver.findElement(this.newAccountButton);
    }

    /**
     * Getter of saveNewAccountButton.
     * @return button.
     */
    public WebElement getSaveNewAccountButton() {
        return this.webDriver.findElement(this.saveNewAccountButton);
    }

    /**
     * Method to click button.
     * @param button to click.
     */
    public void clickNewAccountButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to click button.
     * @param button to click.
     */
    public void clickSaveNewAccountButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to set accountName attribute.
     * @param accountName string value.
     */
    public void setAccountNameTextField(final String accountName) {
        webDriver.findElement(this.accountNameTextField).sendKeys(accountName);
    }

    /**
     * Method to know if the page of new account is displayed.
     * @return true or false.
     */
    public boolean isNewAccountButtonDisplayed() {
        return this.webDriver.findElement(this.newAccountButton).isDisplayed();
    }

    /**
     * Method to create a new account.
     * @param accountName the account name.
     */
    public void createNewAccount(final String accountName) {
        WebElement button = getNewAccountButton();
        clickNewAccountButton(button);
        setAccountNameTextField(accountName);
    }

    /**
     * Method to know if an account is saved.
     * @return the new account name displayed in label.
     */
    public String newAccountSavedName() {
        return this.webDriver.findElement(this.newAccountLabel).getText();
    }

    /**
     * Method to set view in accounts list.
     * @param accountView view list.
     */
    public void setAccountsViewList(final String accountView) {
        Select select = new Select(this.webDriver.findElement(this.accountsViewList));
        select.selectByValue(accountView);
    }

    /**
     * Method to choose accounts view, if it is all accounts then press button go.
     * @param accountView view.
     * @param button to click.
     */
    public void chooseAccounts(final String accountView, final WebElement button) {
        final int waitSeconds = 90;
        WebDriverWait wait = DriverManager.getInstance().getWaiter();
        WebElement searchOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(this.accountsViewList));
        Select select = new Select(searchOnDashboard);
        if ("All Accounts".equalsIgnoreCase(select.getFirstSelectedOption().getText().toString())) {
            clickGoButton(button);
        } else {
            setAccountsViewList(accountView);
        }
    }

    /**
     * Method to get go button.
     * @return button.
     */
    public WebElement getGoButton() {
        return this.webDriver.findElement(this.goButton);
    }

    /**
     * Method to click go button.
     * @param button to click.
     */
    public void clickGoButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to verify all accounts was selected.
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
    public void editAccount(String accountName) {
        setAccountNameTextField(accountName);
    }

    public WebElement getAccountNameLink() {
        return this.webDriver.findElement(this.lastAccountLink);
    }

    public void clickAccountNameLink() {
        getAccountNameLink().click();
    }

    public WebElement getDeleteButton() {
        return this.webDriver.findElement(this.deleteButton);
    }

    public void clickDeleteAccount() {
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

    public void clickEditAccount() {
        getEditButton().click();
    }
    public String accountHomePage() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.homeContact));

        return this.webDriver.findElement(this.homeContact).getText();
    }


}

