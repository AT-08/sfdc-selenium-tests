package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SFMain.
 */
public abstract class SFMain extends Base {


    @FindAll({
    @FindBy(how = How.CSS, using = "input[name='new']"),
            @FindBy(how = How.CSS, using = "div[title='New']")
    })
    protected WebElement newButton;

    @FindAll({
    @FindBy(how = How.CSS, using = "tr.dataRow.even.first.dataRow >th[scope='row'] > a"),
            @FindBy(how = How.CSS, using = "tr:nth-child(22) > th > span > a")
    })
    protected WebElement lastItemOnList;

    @FindAll({
    @FindBy(how = How.CSS, using = "h2.pageDescription"),
            @FindBy(how = How.CSS, using = ".testonly-outputNameWithHierarchyIcon .uiOutputText")
    })
    protected WebElement homeContact;

    /**
     * getNewAccountButton.
     */
    public abstract void getNewAccountButton();

    /**
     * getAccountNameLink.
     */
    public abstract void getAccountNameLink();

    /**
     * @return getAccountHomePage.
     */
    public abstract String getAccountHomePage();
}
