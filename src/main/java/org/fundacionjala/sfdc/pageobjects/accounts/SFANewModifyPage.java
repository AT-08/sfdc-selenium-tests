package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.fundacionjala.sfdc.util.Inputs;
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
    public void setAccountNameTextField(final String accountName) {
        this.accountNameTextField.clear();
        this.accountNameTextField.sendKeys(accountName);
    }

    /**
     * Method to set parentAccount attribute.
     *
     * @param parentAccount the value.
     */
    public void setParentAccountTextField(final String parentAccount) {
        this.parentAccountTextField.sendKeys(parentAccount);
    }

    /**
     * Method to set accountNumber attribute.
     *
     * @param accountNumber the value.
     */
    public void setAccountNumberTextField(final String accountNumber) {
        this.accountNumberTextField.clear();
        this.accountNumberTextField.sendKeys(accountNumber);
    }

    /**
     * Method to set accountSite attribute.
     *
     * @param accountSite the value.
     */
    public void setAccountSiteTextField(final String accountSite) {
        this.accountSiteTextField.clear();
        this.accountSiteTextField.sendKeys(accountSite);
    }

    /**
     * Method to set type attribute.
     *
     * @param type the value.
     */
    public void setAccountTypeList(final String type) {
        //this.typeList.clear();
        this.typeList.sendKeys(type);
    }

    /**
     * Method to set industry attribute.
     *
     * @param industry the value.
     */
    public void setIndustryList(final String industry) {
        //this.industryList.clear();
        this.industryList.sendKeys(industry);
    }

    /**
     * Method to set annualRevenue attribute.
     *
     * @param annualRevenue the value.
     */
    public void setAnnualRevenueTextField(final String annualRevenue) {
        this.annualRevenueTextField.clear();
        this.annualRevenueTextField.sendKeys(annualRevenue);
    }


    /**
     * @param values account fields.
     * @return map of account fields.
     */
    public Map<Inputs, Value> getStrategyStepMap(final Map<Inputs, String> values) {
        Map<Inputs, Value> strategyMap = new HashMap<>();
        strategyMap.put(Inputs.ACCOUNT_NAME, () ->
                this.setAccountNameTextField(String.valueOf(values.get(Inputs.ACCOUNT_NAME))));
        strategyMap.put(Inputs.ACCOUNT_NUMBER, () ->
                this.setAccountNumberTextField(String.valueOf(values.get(Inputs.ACCOUNT_NUMBER))));
        strategyMap.put(Inputs.ACCOUNT_SITE, () ->
                this.setAccountSiteTextField(String.valueOf(values.get(Inputs.ACCOUNT_SITE))));
        strategyMap.put(Inputs.ANUAL_REVENUE, () ->
                this.setAnnualRevenueTextField(String.valueOf(values.get(Inputs.ANUAL_REVENUE))));
        strategyMap.put(Inputs.INDUSTRY, () ->
                this.setIndustryList(String.valueOf(values.get(Inputs.INDUSTRY))));
        strategyMap.put(Inputs.PARENT_ACCOUNT, () ->
                this.setParentAccountTextField(String.valueOf(values.get(Inputs.PARENT_ACCOUNT))));
        strategyMap.put(Inputs.TYPE, () ->
                this.setAccountTypeList(String.valueOf(values.get(Inputs.TYPE))));

        return strategyMap;

    }

    /**
     * getSaveNewAccountButton.
     */
    @Override
    public void getSaveNewAccountButton() {
        CommonActions.clickElement(this.saveNewAccountButton);
    }
}
