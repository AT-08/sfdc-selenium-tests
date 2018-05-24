package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * SFDetails.
 */
public abstract class SFDetails extends Base {

    @FindAll({
            @FindBy(css = "#topButtonRow input[name='edit']"),
            @FindBy(css = "a[title='Edit']")
    })
    protected WebElement editButton;

    @FindAll({
            @FindBy(css = "topButtonRow > input[value='Delete']"),
            @FindBy(css = "a[title='Delete']")
    })
    protected WebElement deleteButton;

    @FindAll({
            @FindBy(className = "topName"),
            @FindBy(css = ".testonly-outputNameWithHierarchyIcon .uiOutputText")
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
