package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * SFMain.
 */
public class SFMain extends Base {


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

    @FindBy(xpath = "//span[contains(@class, 'toastMessage')]//child::text()")
    private WebElement greeConfirmMessage;

    /**
     * clickToNewButton.
     */
    public void clickToNewButton() {
        CommonActions.clickElement(this.newButton);
    }

    /**
     * clickElementOnList.
     *
     * @param elementOnList This is element on list.
     */
    public void clickElementOnList(final String elementOnList) {
        WebElement webElement = CommonActions.getWebElementFromAList(this.elementOnList, elementOnList);
        CommonActions.clickElement(webElement);
    }

    /**
     * istWebElementPresentOnList.
     *
     * @param elementOnList This is element on list.
     * @return getAccountHomePage.
     */
    public boolean istWebElementPresentOnList(final String elementOnList) {

        return CommonActions.istWebElementPresentOnList(this.elementOnList, elementOnList);
    }

    /**
     * @param elementOnList This is element on list.
     * @return getAccountHomePage.
     */
    public String getConfirmMessageShowed(final String elementOnList) {
        return CommonActions.getConfirmMessageShowed(this.greeConfirmMessage);
    }
}
