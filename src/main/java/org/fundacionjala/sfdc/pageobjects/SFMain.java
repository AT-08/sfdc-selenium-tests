package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SFMain.
 */
public abstract class SFMain extends Base {

    @FindBy(how = How.CSS, using = "input[name='new']")
    protected WebElement newContactButton;

    @FindBy(how = How.CSS, using = "tr.dataRow.even.first.dataRow >th[scope='row'] > a")
    protected WebElement lastContactLink;

    @FindBy(how = How.CSS, using = "h2.pageDescription")
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
