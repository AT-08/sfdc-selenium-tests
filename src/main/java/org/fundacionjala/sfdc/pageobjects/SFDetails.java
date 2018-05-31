package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.util.PropertiesManager;
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

    @FindBy(xpath = "//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center "
            + "sldsButtonHeightFix' and not(@title='Show one more action')]")
    private WebElement dropDownMenuInside;
    @FindBy(css = "[class='slds-icon_container slds-icon-utility-down']")
    private WebElement dropDownMenuLightInList;
    @FindBy(xpath = "//span[@class=' label bBody truncate' and text()='Delete']")
    private WebElement confirmDelete;

    /**
     * setEditButton.
     */
    public void setEditButton() {
        CommonActions.jsClickElement(this.editButton);
    }

    /**
     * setDeleteButton.
     */
    public void setDeleteButton() {
        CommonActions.jsClickElement(this.deleteButton);
    }

    /**
     * setDropDownMenuInsideTheObject.
     */
    public void setDropDownMenuInsideTheObject() {
        CommonActions.jsClickElement(this.dropDownMenuInside);
    }

    /**
     * setDropDownMenuInList.
     */
    public void setDropDownMenuInList() {
        CommonActions.jsClickElement(this.dropDownMenuLightInList);
    }

    /**
     * confirmDeleteInLight.
     */
    public void confirmDeleteInLight() {
        CommonActions.jsClickElement(this.confirmDelete);
    }

    /**
     * confirmDeleteInClassic.
     */
    public void confirmDeleteInClassic() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * clickEditButton.
     */
    public void clickEditButton() {
        if (IS_CLASSIC) {
            this.setEditButton();
        } else {
            CommonActions.waitTime(2);
            this.setDropDownMenuInsideTheObject();
            this.setEditButton();
            CommonActions.resetWaitTime();
        }
    }

    /**
     * clickDeleteButton.
     */
    public void clickDeleteButton() {
        if (IS_CLASSIC) {
            this.setDeleteButton();
            this.confirmDeleteInClassic();
        } else {
            this.setDropDownMenuInsideTheObject();
            this.setDeleteButton();
            this.confirmDeleteInLight();
        }
    }

    /**
     * clickDeleteButton in the list(Light).
     */
    public void clickDeleteSecondWay() {
        if (IS_CLASSIC) {
            this.setDeleteButton();
            this.confirmDeleteInClassic();
        } else {
            this.setDropDownMenuInList();
            this.setDeleteButton();
            this.confirmDeleteInLight();
        }
    }

    /**
     * clickEditButton in the list(Light).
     */
    public void clickEditSecondWay() {
        if (IS_CLASSIC) {
            this.setEditButton();
        } else {
            this.setDropDownMenuInList();
            this.setEditButton();
        }
    }
}
