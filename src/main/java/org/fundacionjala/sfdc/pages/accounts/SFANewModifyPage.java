package org.fundacionjala.sfdc.pages.accounts;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.pages.common.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends SFNewModify {

    // Account Information.
    @FindAll({
            @FindBy(id = "acc2"),
            @FindBy(css = ".witsSuggestedNameField .input")
    })
    private WebElement accountNameTextField;

    @FindAll({
            @FindBy(id = "acc3"),
            @FindBy(css = "input[title='Search Accounts']")
    })
    private WebElement parentAccountTextField;

    @FindAll({
            @FindBy(id = "acc5"),
            @FindBy(xpath =
                    "//span[text()='Account Number']/parent::label/following-sibling::input")
    })
    private WebElement accountNumberTextField;

    @FindAll({
            @FindBy(id = "acc23"),
            @FindBy(xpath =
                    "//span[text()='Account Site']/parent::label/following-sibling::input")
    })

    private WebElement accountSiteTextField;

    @FindAll({
            @FindBy(id = "acc6"),
            @FindBy(xpath =
                    "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement typeList;

    @FindAll({
            @FindBy(id = "acc7"),
            @FindBy(xpath =
                    "//span[text()='Industry']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement industryList;

    @FindAll({
            @FindBy(id = "acc8"),
            @FindBy(xpath =
                    "//span[text()='Annual Revenue']/parent::label/following-sibling::input")
    })
    private WebElement annualRevenueTextField;

    @FindAll({
            @FindBy(id = "acc9"),
            @FindBy(xpath =
                    "//span[text()='Rating']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement ratingList;

    @FindAll({
            @FindBy(id = "acc10"),
            @FindBy(xpath =
                    "//span[text()='Phone']/parent::label/following-sibling::input")
    })
    private WebElement accountPhone;

    @FindAll({
            @FindBy(id = "acc11"),
            @FindBy(xpath =
                    "//span[text()='Fax']/parent::label/following-sibling::input")
    })
    private WebElement accountFax;

    @FindAll({
            @FindBy(id = "acc12"),
            @FindBy(xpath =
                    "//span[text()='Website']/parent::label/following-sibling::input")
    })
    private WebElement accountWebsite;

    @FindAll({
            @FindBy(id = "acc13"),
            @FindBy(xpath =
                    "//span[text()='Ticker Symbol']/parent::label/following-sibling::input")
    })
    private WebElement accountTickerSymbol;

    @FindAll({
            @FindBy(id = "acc14"),
            @FindBy(xpath =
                    "//span[text()='Ownership']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement ownershipList;

    @FindAll({
            @FindBy(id = "acc15"),
            @FindBy(xpath =
                    "//span[text()='Employees']/parent::label/following-sibling::input")
    })
    private WebElement accountEmployee;

    @FindAll({
            @FindBy(id = "acc16"),
            @FindBy(xpath =
                    "//span[text()='SIC Code']/parent::label/following-sibling::input")
    })
    private WebElement accountSICCode;

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountSICCode string value.
     */
    public void setAccountSICCodeTextField(final String accountSICCode) {
        action.setValue(this.accountSICCode, accountSICCode);
    }

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountEmployee string value.
     */
    public void setAccountEmployeeTextField(final String accountEmployee) {
        action.setValue(this.accountEmployee, accountEmployee);
    }

    /**
     * Method to set accountOwnershipList attribute.
     *
     * @param accountOwnershipList string value.
     */
    public void setAccountOwnershipList(final String accountOwnershipList) {
        CommonActions.selectOnComboBox(this.ownershipList, accountOwnershipList);
    }

    /**
     * Method to set accountTickerSymbol attribute.
     *
     * @param accountTickerSymbol string value.
     */
    public void setAccountTickerSymbolTextField(final String accountTickerSymbol) {
        action.setValue(this.accountTickerSymbol, accountTickerSymbol);
    }

    /**
     * Method to set accountWebsite attribute.
     *
     * @param accountWebsite string value.
     */
    public void setAccountWebsiteTextField(final String accountWebsite) {
        action.setValue(this.accountWebsite, accountWebsite);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountFax string value.
     */
    public void setAccountFaxTextField(final String accountFax) {
        action.setValue(this.accountFax, accountFax);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountPhone string value.
     */
    public void setAccountPhoneTextField(final String accountPhone) {
        action.setValue(this.accountPhone, accountPhone);
    }

    /**
     * Method to set ratingList attribute.
     *
     * @param ratingList string value.
     */
    public void setAccountRatingList(final String ratingList) {
        CommonActions.selectOnComboBox(this.ratingList, ratingList);
    }

    /**
     * Method to set accountName attribute.
     *
     * @param accountName string value.
     */
    private void setAccountNameTextField(final String accountName) {
        action.setValue(this.accountNameTextField, accountName);
    }

    /**
     * Method to set parentAccount attribute.
     *
     * @param parentAccount the value.
     */
    private void setParentAccountTextField(final String parentAccount) {
        action.setValue(this.parentAccountTextField, parentAccount);
        CommonActions.selectOnAutoCompleterTextField(this.parentAccountTextField, parentAccount);
    }

    /**
     * Method to set accountNumber attribute.
     *
     * @param accountNumber the value.
     */
    private void setAccountNumberTextField(final String accountNumber) {
        action.setValue(this.accountNumberTextField, accountNumber);
    }

    /**
     * Method to set accountSite attribute.
     *
     * @param accountSite the value.
     */
    private void setAccountSiteTextField(final String accountSite) {
        action.setValue(this.accountSiteTextField, accountSite);
    }

    /**
     * Method to set type attribute.
     *
     * @param type the value.
     */
    private void setAccountTypeList(final String type) {
        CommonActions.selectOnComboBox(this.typeList, type);
    }

    /**
     * Method to set industry attribute.
     *
     * @param industry the value.
     */
    private void setIndustryList(final String industry) {
        CommonActions.selectOnComboBox(this.industryList, industry);
    }

    /**
     * Method to set annualRevenue attribute.
     *
     * @param annualRevenue the value.
     */
    private void setAnnualRevenueTextField(final String annualRevenue) {
        action.setValue(this.annualRevenueTextField, annualRevenue);
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

        strategyMap.put(AccountInputs.ANNUAL_REVENUE, () ->
                this.setAnnualRevenueTextField(String.valueOf(values.get(AccountInputs.ANNUAL_REVENUE))));

        strategyMap.put(AccountInputs.INDUSTRY, () ->
                this.setIndustryList(String.valueOf(values.get(AccountInputs.INDUSTRY))));

        strategyMap.put(AccountInputs.PARENT_ACCOUNT, () ->
                this.setParentAccountTextField(String.valueOf(values.get(AccountInputs.PARENT_ACCOUNT))));

        strategyMap.put(AccountInputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(AccountInputs.TYPE))));

        strategyMap.put(AccountInputs.RATING, () ->
                this.setAccountRatingList(String.valueOf(values.get(AccountInputs.RATING))));

        strategyMap.put(AccountInputs.PHONE, () ->
                this.setAccountPhoneTextField(String.valueOf(values.get(AccountInputs.PHONE))));

        strategyMap.put(AccountInputs.FAX, () ->
                this.setAccountFaxTextField(String.valueOf(values.get(AccountInputs.FAX))));

        strategyMap.put(AccountInputs.WEBSITE, () ->
                this.setAccountWebsiteTextField(String.valueOf(values.get(AccountInputs.WEBSITE))));

        strategyMap.put(AccountInputs.TICKER_SYMBOL, () ->
                this.setAccountTickerSymbolTextField(String.valueOf(values.get(AccountInputs.TICKER_SYMBOL))));

        strategyMap.put(AccountInputs.OWNERSHIP, () ->
                this.setAccountOwnershipList(String.valueOf(values.get(AccountInputs.OWNERSHIP))));

        strategyMap.put(AccountInputs.EMPLOYEES, () ->
                this.setAccountEmployeeTextField(String.valueOf(values.get(AccountInputs.EMPLOYEES))));

        strategyMap.put(AccountInputs.SIC_CODE, () ->
                this.setAccountSICCodeTextField(String.valueOf(values.get(AccountInputs.SIC_CODE))));
        return strategyMap;
    }

    /**
     * getSaveNewAccountButton.
     */
    @Override
    public void getSaveNewAccountButton() {
        action.click(this.saveNewAccountButton);
    }
}
