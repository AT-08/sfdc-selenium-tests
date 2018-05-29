package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SFDetails.
 */
public class SFDetails extends Base {

    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");

    @FindAll({
            @FindBy(xpath = "//td[@id='topButtonRow']/child::input[@name='edit']"),
            @FindBy(how = How.CSS, using = "a[title='Edit']")
    })
    private WebElement editButton;

    @FindAll({
            @FindBy(xpath = "//td[@id='topButtonRow']/child::input[@title='Delete']"),
            @FindBy(how = How.CSS, using = "a[title='Delete']")
    })
    private WebElement deleteButton;

    @FindAll({
            @FindBy(className = "topName"),
            @FindBy(how = How.CSS, using = ".testonly-outputNameWithHierarchyIcon .uiOutputText")
    })
    private WebElement newAccountLabel;

    @FindBy(css = "a[title='Show 7 more actions']")
    private WebElement dropDownMenu;

    @FindBy(css = "[class='slds-icon_container slds-icon-utility-down']")
    private WebElement dropDownMenuLightInList;

    @FindBy(xpath = "//span[@class=' label bBody truncate' and text()='Delete']")
    private WebElement confirmDelete;

    /**
     * clickEditButton.
     */
    public void clickEditButton() {
        if (IS_CLASSIC) {
            CommonActions.clickElement(this.editButton);
        } else {
            CommonActions.clickElement(this.dropDownMenu);
            CommonActions.clickElement(this.editButton);
        }
    }

    /**
     * clickDeleteButton.
     */
    public void clickDeleteButton() {
        CommonActions.clickElement(this.deleteButton);
    }

    /**
     * clickDeleteAlert.
     */
    public void clickDeleteAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * @return getNewAccountSavedName.
     */
    public String getNewAccountSavedName() {
        return CommonActions.getTextElement(this.newAccountLabel);
    }

    /**
     * clickDeleteButton in the list(Light).
     */
    public void clickDeleteSecondWay() {
        if (IS_CLASSIC) {
            CommonActions.jsClickButton(this.deleteButton);
        } else {
            CommonActions.jsClickButton(this.dropDownMenuLightInList);
            CommonActions.jsClickButton(this.deleteButton);
            CommonActions.jsClickButton(this.confirmDelete);
        }
    }

    /**
     * clickEditButton in the list(Light).
     */
    public void clickEditSecondWay() {
        if (IS_CLASSIC) {
            CommonActions.jsClickButton(this.editButton);
        } else {
            CommonActions.jsClickButton(this.dropDownMenuLightInList);
            CommonActions.jsClickButton(this.editButton);
        }
    }
}
