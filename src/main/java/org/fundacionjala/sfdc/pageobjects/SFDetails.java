package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SFDetails.
 */
public abstract class SFDetails extends Base {

    @FindAll({
            @FindBy(how = How.CSS, using = "topButtonRow.pbButton > input[name='edit']"),
            @FindBy(how = How.CSS, using = "a[title='Edit']")
    })
    protected WebElement editButton;

    @FindAll({
            @FindBy(how = How.CSS, using = "topButtonRow > input[value='Delete']"),
            @FindBy(how = How.CSS, using = "a[title='Delete']")
    })
    protected WebElement deleteButton;

    @FindAll({
            @FindBy(how = How.CLASS_NAME, using = "topName"),
            @FindBy(how = How.CSS, using = "span.slds-truncate.uiOutputText")
    })
    protected WebElement newAccountLabel;

    /**
     * getEditButton.
     */
    public abstract void getEditButton();

    /**
     * getDeleteButton.
     */
    public abstract void getDeleteButton();

    /**
     * clickDeleteAlert.
     */
    public abstract void clickDeleteAlert();

    /**
     * @return getNewAccountSavedName.
     */
    public abstract String getNewAccountSavedName();
}
