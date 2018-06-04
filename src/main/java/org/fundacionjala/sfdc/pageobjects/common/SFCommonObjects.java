package org.fundacionjala.sfdc.pageobjects.common;

import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.PropertiesManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Class with common objects for the other page objects.
 */
public class SFCommonObjects extends Base {

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

    @FindBy(xpath = "//span[@class=' label bBody truncate' and text()='Delete']")
    private WebElement confirmDelete;

    @FindBy(xpath = "//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center "
            + "sldsButtonHeightFix' and not(@title='Show one more action')]")
    private WebElement dropDownMenuInside;

    @FindBy(css = "[class='slds-icon_container slds-icon-utility-down']")
    private WebElement dropDownMenuLightInList;

    @FindAll({
            @FindBy(css = "input[name='new']"),
            @FindBy(css = "div[title='New']")
    })
    private WebElement newButton;

    @FindAll({
            @FindBy(xpath = "//tr[@class='headerRow']/following-sibling::tr/descendant::a"),
            @FindBy(xpath = "//td[contains(@class,'slds-cell-edit')]/following-sibling::th/descendant::a")
    })
    private List<WebElement> elementOnList;

    /**
     * clickToNewButton.
     */
    public void clickToNewButton() {
        CommonActions.jsClickElement(this.newButton);
    }

    /**
     * clickElementOnList.
     *
     * @param elementOnList This is element on list.
     */

    public void clickElementOnList(final String elementOnList) {
        WebElement webElement = CommonActions.getWebElementFromAList(this.elementOnList, elementOnList);
        CommonActions.jsClickElement(webElement);
    }

    /**
     * isWebElementPresentOnList.
     *
     * @param elementOnList This is element on list.
     * @return getAccountHomePage.
     */

    public boolean isWebElementPresentOnList(final String elementOnList) {
        return CommonActions.istWebElementPresentOnList(this.elementOnList, elementOnList);
    }

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
            CommonActions.setImplicitTime(PropertiesManager.getInstance().getImplicitTime());
            this.setDropDownMenuInsideTheObject();
            this.setEditButton();
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
     *
     * @param objectName object name.
     */
    public void clickDeleteSecondWay(final String objectName) {
        if (IS_CLASSIC) {
            this.clickElementOnList(objectName);
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
     *
     * @param objectName object name.
     */
    public void clickEditSecondWay(final String objectName) {
        if (IS_CLASSIC) {
            this.clickElementOnList(objectName);
            this.setEditButton();
        } else {
            this.setDropDownMenuInList();
            this.setEditButton();
        }
    }
}
