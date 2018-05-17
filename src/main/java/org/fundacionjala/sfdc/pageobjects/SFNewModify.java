package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SFNewModify.
 */
public abstract class SFNewModify extends Base {

    @FindBy(how = How.CSS, using = ".pbButton > input[name='save']")
    protected WebElement saveNewAccountButton;

    /**
     * getSaveNewAccountButton.
     */
    public abstract void getSaveNewAccountButton();
}
