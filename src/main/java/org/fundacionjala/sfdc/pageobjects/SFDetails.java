package org.fundacionjala.sfdc.pageobjects;

        import org.fundacionjala.sfdc.commons.PropertiesManager;
        import org.fundacionjala.sfdc.util.CommonActions;
        import org.openqa.selenium.Alert;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindAll;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SFDetails.
 */
public class SFDetails extends Base {

    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");

    @FindAll({
            @FindBy(xpath = "//td[@id='topButtonRow']/child::input[@title='Edit']"),
            @FindBy(xpath = "//a[@title='Edit']/child::div")
    })
    private WebElement editButton;

    @FindAll({
            @FindBy(xpath = "//td[@id='topButtonRow']/child::input[@title='Delete']"),
            @FindBy(xpath = "//a[@title='Delete']/child::div")
    })
    private WebElement deleteButton;

    @FindAll({
            @FindBy(className = "topName"),
            @FindBy(css = ".testonly-outputNameWithHierarchyIcon .uiOutputText")
    })
    private WebElement newAccountLabel;

    @FindBy(css = "[class='slds-icon_container slds-icon-utility-down slds-button__icon forceIcon']")
    private WebElement dropDownMenu;

    @FindBy(xpath
            = "//div[contains(@class ,'forceModalActionContainer--footerAction')]/child::button[@title = 'Delete']")
    private WebElement deleteConfirmation;
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
            CommonActions.waitTime(2);
            CommonActions.jsClickElement(this.dropDownMenu);
            CommonActions.jsClickElement(this.editButton);
            CommonActions.resetWaitTime();
        }
    }

    /**
     * clickDeleteButton.
     */
    public void clickDeleteButton() {
        if (IS_CLASSIC) {
            CommonActions.clickElement(this.deleteButton);
        } else {
            CommonActions.jsClickElement(this.dropDownMenu);
            CommonActions.jsClickElement(this.deleteButton);
        }
    }

    /**
     * clickDeleteAlert.
     */
    public void clickDeleteAlert() {
        if (IS_CLASSIC) {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } else {
            CommonActions.jsClickElement(deleteConfirmation);
        }
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
            CommonActions.jsClickElement(this.deleteButton);
        } else {
            CommonActions.jsClickElement(this.dropDownMenuLightInList);
            CommonActions.jsClickElement(this.deleteButton);
            CommonActions.jsClickElement(this.confirmDelete);
        }
    }

    /**
     * clickEditButton in the list(Light).
     */
    public void clickEditSecondWay() {
        if (IS_CLASSIC) {
            CommonActions.jsClickElement(this.editButton);
        } else {
            CommonActions.jsClickElement(this.dropDownMenuLightInList);
            CommonActions.jsClickElement(this.editButton);
        }
    }
}
