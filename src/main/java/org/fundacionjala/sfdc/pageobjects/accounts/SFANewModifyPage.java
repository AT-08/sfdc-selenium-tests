package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends SFNewModify {

    // Account Information.
    @FindAll({
            @FindBy(how = How.ID, using = "acc2"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='6']")
    })
    private WebElement accountNameTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc3"),
            @FindBy(how = How.CSS, using = "input[title='Search Accounts']")
    })
    private WebElement parentAccountTextField;
    @FindAll({
            @FindBy(how = How.ID, using = "acc5"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='10']")
    })
    private WebElement accountNumberTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc23"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='12']")
    })

    private WebElement accountSiteTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc6"),
            @FindBy(how = How.CSS, using = "a[data-interactive-lib-uid='14']")
    })
    private WebElement typeList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc7"),
            @FindBy(how = How.CSS, using = "a[data-interactive-lib-uid='16']")
    })
    private WebElement industryList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc8"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='18']")
    })
    private WebElement annualRevenueTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "acc9"),
            @FindBy(how = How.CSS, using = "a[data-interactive-lib-uid='5']")
    })
    private WebElement ratingList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc10"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='7']")
    })
    private WebElement accountPhone;

    @FindAll({
            @FindBy(how = How.ID, using = "acc11"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='9']")
    })
    private WebElement accountFax;

    @FindAll({
            @FindBy(how = How.ID, using = "acc12"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='11']")
    })
    private WebElement accountWebsite;

    @FindAll({
            @FindBy(how = How.ID, using = "acc13"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='13']")
    })
    private WebElement accountTickerSymbol;

    @FindAll({
            @FindBy(how = How.ID, using = "acc14"),
            @FindBy(how = How.CSS, using = "a[data-interactive-lib-uid='15']")
    })
    private WebElement ownershipList;

    @FindAll({
            @FindBy(how = How.ID, using = "acc15"),
            @FindBy(how = How.CSS, using = "input[data-interactive-lib-uid='17']")
    })
    private WebElement accountEmployee;

    @FindAll({
            @FindBy(how = How.ID, using = "acc16"),
            @FindBy(how = How.CSS, using = "data-interactive-lib-uid='19'")
    })
    private WebElement accountSICCode;

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountSICCode string value.
     */
    public void setAccountSICCodeTextField(final String accountSICCode) {
        this.accountSICCode.clear();
        this.accountSICCode.sendKeys(accountSICCode);
    }

    /**
     * Method to set accountEmployee attribute.
     *
     * @param accountEmployee string value.
     */
    public void setAccountEmployeeTextField(final String accountEmployee) {
        this.accountEmployee.clear();
        this.accountEmployee.sendKeys(accountEmployee);
    }

    /**
     * Method to set accountOwnershipList attribute.
     *
     * @param accountOwnershipList string value.
     */
    public void setAccountOwnershipList(final String accountOwnershipList) {
        this.ownershipList.clear();
        this.ownershipList.sendKeys(accountOwnershipList);
    }

    /**
     * Method to set accountTickerSymbol attribute.
     *
     * @param accountTickerSymbol string value.
     */
    public void setAccountTickerSymbolTextField(final String accountTickerSymbol) {
        this.accountTickerSymbol.clear();
        this.accountTickerSymbol.sendKeys(accountTickerSymbol);
    }

    /**
     * Method to set accountWebsite attribute.
     *
     * @param accountWebsite string value.
     */
    public void setAccountWebsiteTextField(final String accountWebsite) {
        this.accountWebsite.clear();
        this.accountWebsite.sendKeys(accountWebsite);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountFax string value.
     */
    public void setAccountFaxTextField(final String accountFax) {
        this.accountFax.clear();
        this.accountFax.sendKeys(accountFax);
    }

    /**
     * Method to set accountPhone attribute.
     *
     * @param accountPhone string value.
     */
    public void setAccountPhoneTextField(final String accountPhone) {
        this.accountPhone.clear();
        this.accountPhone.sendKeys(accountPhone);
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
        this.typeList.sendKeys(type);
    }

    /**
     * Method to set industry attribute.
     *
     * @param industry the value.
     */
    public void setIndustryList(final String industry) {
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
