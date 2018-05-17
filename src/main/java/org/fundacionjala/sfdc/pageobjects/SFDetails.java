package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SFDetails.
 */
public abstract class SFDetails extends Base {

    @FindBy(how = How.CSS, using = "#topButtonRow.pbButton > input[name='edit']")
    protected WebElement editButton;

    @FindBy(how = How.CSS, using = "#topButtonRow > input:nth-child(4).btn")
    protected WebElement deleteButton;

    @FindBy(how = How.CLASS_NAME, using = "topName")
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
