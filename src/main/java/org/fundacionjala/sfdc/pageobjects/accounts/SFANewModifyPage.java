package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.EnumMap;
import java.util.Map;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends SFNewModify {

    // Account Information.
    @FindAll({
            @FindBy(how = How.ID, using = "acc2"),
            @FindBy(how = How.CSS, using = ".witsSuggestedNameField .input")
    })
    private WebElement accountNameTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc3"),
            @FindBy(how = How.CSS, using = "input[title='Search Accounts']")
    })
    private WebElement parentAccountTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc5"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Account Number']/parent::label/following-sibling::input")
    })
    private WebElement accountNumberTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc23"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Account Site']/parent::label/following-sibling::input")
    })

    private WebElement accountSiteTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc6"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement typeList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc7"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Industry']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement industryList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc8"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Annual Revenue']/parent::label/following-sibling::input")
    })
    private WebElement annualRevenueTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc9"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Rating']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement ratingList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc10"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Phone']/parent::label/following-sibling::input")
    })
    private WebElement accountPhone;

    @FindAll({
            @FindBy(how = How.ID, using = "acc11"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Fax']/parent::label/following-sibling::input")
    })
    private WebElement accountFax;

    @FindAll({
            @FindBy(how = How.ID, using = "acc12"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Website']/parent::label/following-sibling::input")
    })
    private WebElement accountWebsite;

    @FindAll({
            @FindBy(how = How.ID, using = "acc13"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Ticker Symbol']/parent::label/following-sibling::input")
    })
    private WebElement accountTickerSymbol;

    @FindAll({
            @FindBy(how = How.ID, using = "acc14"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Ownership']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement ownershipList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc15"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='Employees']/parent::label/following-sibling::input")
    })
    private WebElement accountEmployee;

    @FindAll({
            @FindBy(how = How.ID, using = "acc16"),
            @FindBy(how = How.XPATH, using =
                    "//span[text()='SIC Code']/parent::label/following-sibling::input")
    })
    private WebElement accountSICCode;

    // Address Information

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountSICCode string value.
     */
    public void setAccountSICCodeTextField(final String accountSICCode) {
        CommonActions.clearField(this.accountSICCode);
        CommonActions.setTextElement(this.accountSICCode, accountSICCode);
    }

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountEmployee string value.
     */
    public void setAccountEmployeeTextField(final String accountEmployee) {
        CommonActions.clearField(this.accountEmployee);
        CommonActions.setTextElement(this.accountEmployee, accountEmployee);
    }

    /**
     * Method to set accountOwnershipList attribute.
     *
     * @param accountOwnershipList string value.
     */
    public void setAccountOwnershipList(final String accountOwnershipList) {
        CommonActions.clearField(this.ownershipList);
        CommonActions.setTextElement(this.ownershipList, accountOwnershipList);
    }

    /**
     * Method to set accountTickerSymbol attribute.
     *
     * @param accountTickerSymbol string value.
     */
    public void setAccountTickerSymbolTextField(final String accountTickerSymbol) {
        CommonActions.clearField(this.accountTickerSymbol);
        CommonActions.setTextElement(this.accountTickerSymbol, accountTickerSymbol);
    }

    /**
     * Method to set accountWebsite attribute.
     *
     * @param accountWebsite string value.
     */
    public void setAccountWebsiteTextField(final String accountWebsite) {
        CommonActions.clearField(this.accountWebsite);
        CommonActions.setTextElement(this.accountWebsite, accountWebsite);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountFax string value.
     */
    public void setAccountFaxTextField(final String accountFax) {
        CommonActions.clearField(this.accountFax);
        CommonActions.setTextElement(this.accountFax, accountFax);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountPhone string value.
     */
    public void setAccountPhoneTextField(final String accountPhone) {
        CommonActions.clearField(this.accountPhone);
        CommonActions.setTextElement(this.accountPhone, accountPhone);
    }

    /**
     * Method to set ratingList attribute.
     *
     * @param ratingList string value.
     */
    public void setAccountRatingList(final String ratingList) {
        this.ratingList.sendKeys(ratingList);
    }

    /**
     * Method to set accountName attribute.
     *
     * @param accountName string value.
     */
    private void setAccountNameTextField(final String accountName) {
        CommonActions.clearField(this.accountNameTextField);
        CommonActions.setTextElement(this.accountNameTextField, accountName);

    }

    /**
     * Method to set parentAccount attribute.
     *
     * @param parentAccount the value.
     */
    private void setParentAccountTextField(final String parentAccount) {
        CommonActions.clearField(this.parentAccountTextField);
        CommonActions.setTextElement(this.parentAccountTextField, parentAccount);
    }

    /**
     * Method to set accountNumber attribute.
     *
     * @param accountNumber the value.
     */
    private void setAccountNumberTextField(final String accountNumber) {
        CommonActions.clearField(this.accountNumberTextField);
        CommonActions.setTextElement(this.accountNumberTextField, accountNumber);
    }

    /**
     * Method to set accountSite attribute.
     *
     * @param accountSite the value.
     */
    private void setAccountSiteTextField(final String accountSite) {
        CommonActions.clearField(accountSiteTextField);
        CommonActions.setTextElement(this.accountSiteTextField, accountSite);
    }

    /**
     * Method to set type attribute.
     *
     * @param type the value.
     */
    private void setAccountTypeList(final String type) {
        CommonActions.setTextElement(this.typeList, type);
    }

    /**
     * Method to set industry attribute.
     *
     * @param industry the value.
     */
    private void setIndustryList(final String industry) {
        CommonActions.setTextElement(this.industryList, industry);
    }

    /**
     * Method to set annualRevenue attribute.
     *
     * @param annualRevenue the value.
     */
    private void setAnnualRevenueTextField(final String annualRevenue) {
        CommonActions.clearField(annualRevenueTextField);
        CommonActions.setTextElement(this.annualRevenueTextField, annualRevenue);
    }


    /**
     * @param values account fields.
     * @return map of account fields.
     */
    public Map<AccountInputs, Value> getStrategyStepMap(final Map<AccountInputs, String> values) {
        EnumMap<AccountInputs, Value> strategyMap = new EnumMap<>(AccountInputs.class);
        strategyMap.put(AccountInputs.ACCOUNT_NAME, () ->
                this.setAccountNameTextField(String.valueOf(values.get(AccountInputs.ACCOUNT_NAME))));
        strategyMap.put(AccountInputs.ACCOUNT_NUMBER, () ->
                this.setAccountNumberTextField(String.valueOf(values.get(AccountInputs.ACCOUNT_NUMBER))));
        strategyMap.put(AccountInputs.ACCOUNT_SITE, () ->
                this.setAccountSiteTextField(String.valueOf(values.get(AccountInputs.ACCOUNT_SITE))));
        strategyMap.put(AccountInputs.ANUAL_REVENUE, () ->
                this.setAnnualRevenueTextField(String.valueOf(values.get(AccountInputs.ANUAL_REVENUE))));
        strategyMap.put(AccountInputs.INDUSTRY, () ->
                this.setIndustryList(String.valueOf(values.get(AccountInputs.INDUSTRY))));
        strategyMap.put(AccountInputs.PARENT_ACCOUNT, () ->
                this.setParentAccountTextField(String.valueOf(values.get(AccountInputs.PARENT_ACCOUNT))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.TYPE))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.RATING))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.PHONE))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.FAX))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.WEBSITE))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.TICKER_SYMBOL))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.OWNERSHIP))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.EMPLOYEES))));
        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.SIC_CODE))));

        return strategyMap;

    }

    /**
     * getSaveNewAccountButton.
     */
    @Override
    public void getSaveNewAccountButton() {
        CommonActions.clickElement(this.saveNewAccountButton);
    }

    /**
     * Wait until the page loads.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("Construction.");
    }
}
