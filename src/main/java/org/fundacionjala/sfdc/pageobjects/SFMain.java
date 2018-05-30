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
     * istWebElementPresentOnList.
     *
     * @param elementOnList This is element on list.
     * @return getAccountHomePage.
     */

    public boolean istWebElementPresentOnList(final String elementOnList) {
        return CommonActions.istWebElementPresentOnList(this.elementOnList, elementOnList);
    }

}
