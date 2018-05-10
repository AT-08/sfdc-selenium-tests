package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

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

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceAccounts(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.newAccountButton = By.cssSelector(".pbButton > input[title='New']");
        this.accountNameTextField = By.cssSelector(".requiredInput > input[name='acc2']");
        this.saveNewAccountButton = By.cssSelector(".pbButton > input[name='save']");
        this.newAccountLabel = By.cssSelector(".topName");
        this.accountsViewList = By.id("fcf");
        this.goButton = By.cssSelector(".fBody > input[class='btn']");
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
        WebDriverWait wait = new WebDriverWait(this.webDriver, waitSeconds);
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
        final int waitSeconds = 90;
        WebDriverWait wait = new WebDriverWait(this.webDriver, waitSeconds);
        WebElement searchOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Select select = new Select(searchOnDashboard);
        return select.getFirstSelectedOption().getText().toString();
    }

    /**
     * Method to click edit link.
     */
    public void editAccount() {
        WebElement editCustTable = webDriver.findElement(By.className("x-grid3-scroller"));
        List<WebElement> tableRows = editCustTable.findElements(By.className("x-grid3-row-table"));
        for (Iterator iterator = tableRows.iterator(); iterator.hasNext();) {
            System.out.println("4");
            WebElement row = (WebElement) iterator.next();
            String x = ".x-grid3-row-table > tbody > tr > td >div[id='001f400000MSHJ7_ACTION_COLUMN']";
            System.out.println("elements:" + row.findElement(By.cssSelector(x)).getText());
            /*
            if(row.getAttribute("id").contains("1010294")){
                List<WebElement> tds = row.findElements(By.tagName("td"));
                tds.get(8).click();
                break;
            }*/
        }
    }
}

