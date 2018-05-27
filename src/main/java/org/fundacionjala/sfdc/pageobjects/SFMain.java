package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * SFMain.
 */
public abstract class SFMain extends Base {


    @FindAll({
            @FindBy(css = "input[name='new']"),
            @FindBy(css = "div[title='New']")
    })
    protected WebElement newButton;

    @FindAll({
            @FindBy(css = "tr.dataRow.even.first.dataRow >th[scope='row'] > a"),
            @FindBy(css = "th[scope='row'] > span >a")
    })
    protected WebElement lastItemOnList;

    @FindAll({
            @FindBy(css = "h2.pageDescription"),
            @FindBy(css = ".testonly-outputNameWithHierarchyIcon .uiOutputText")
    })
    protected WebElement homeContact;

    /**
     * clickToNewButton.
     */
    public abstract void clickToNewButton();

    /**
     * clickAccountNameLink.
     */
    public abstract void clickAccountNameLink();

    /**
     * @return getAccountHomePage.
     */
    public abstract String getAccountHomePage();
}
