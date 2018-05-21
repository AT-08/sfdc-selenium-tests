package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends SFNewModify {

    @FindBy(how = How.CSS, using = ".requiredInput > input[name='acc2']")
    private WebElement accountNameTextField;

    @FindBy(how = How.CSS, using = ".lookupInput > input[name='acc3']")
    private WebElement parentAccountTextField;

    @FindBy(how = How.ID, using = "acc5")
    private WebElement accountNumberTextField;

    @FindBy(how = How.ID, using = "acc23")
    private WebElement accountSiteTextField;

    @FindBy(how = How.ID, using = "acc6")
    private WebElement typeList;

    @FindBy(how = How.ID, using = "acc7")
    private WebElement industryList;

    @FindBy(how = How.ID, using = "acc8")
    private WebElement annualRevenueTextField;


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
        Map<AccountInputs, Value> strategyMap = new HashMap<>();
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
