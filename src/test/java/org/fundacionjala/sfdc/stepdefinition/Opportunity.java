package org.fundacionjala.sfdc.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class Opportunity {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCreateOpportunities() {
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("daniel@fundacion-jala.org");
        driver.findElement(By.id("password")).sendKeys("Ness2020");
        driver.findElement(By.id("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='All Tabs']")));
        driver.findElement(By.xpath("//img[@alt='All Tabs']")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        closeMessageLighting();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.id("opp3")).sendKeys("OpportunityHH");
        driver.findElement(By.id("opp9")).sendKeys("11/05/2018");
        driver.findElement(By.id("opp9")).sendKeys(Keys.ESCAPE);
        new Select(driver.findElement(By.id("opp11"))).selectByVisibleText("Id. Decision Makers");
        driver.findElement(By.xpath("//option[@value='Id. Decision Makers']")).click();
        driver.findElement(By.name("save")).click();
        driver.findElement(By.id("userNavButton")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void testModifyOpportunities() {
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("daniel@fundacion-jala.org");
        driver.findElement(By.id("password")).sendKeys("Ness2020");
        driver.findElement(By.id("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='All Tabs']")));
        driver.findElement(By.xpath("//img[@alt='All Tabs']")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        closeMessageLighting();
        driver.findElement(By.xpath("//a[contains(text(),'OpportunityHH')]")).click();
        driver.findElement(By.xpath("(//input[@name='edit'])[2]")).click();
        driver.findElement(By.id("opp11")).click();
        new Select(driver.findElement(By.id("opp11"))).selectByVisibleText("Prospecting");
        driver.findElement(By.id("opp9")).clear();
        driver.findElement(By.id("opp9")).sendKeys("14/05/2018");
        driver.findElement(By.id("opp9")).sendKeys(Keys.ESCAPE);
        driver.findElement(By.xpath("(//input[@name='save'])[2]")).click();
        driver.findElement(By.id("userNavButton")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void testDeleteOpportunities() {
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("daniel@fundacion-jala.org");
        driver.findElement(By.id("password")).sendKeys("Ness2020");
        driver.findElement(By.id("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='All Tabs']")));
        driver.findElement(By.xpath("//img[@alt='All Tabs']")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        closeMessageLighting();
        driver.findElement(By.xpath("//a[contains(text(),'OpportunityHH')]")).click();
        acceptNextAlert = true;
        driver.findElement(By.name("del")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
        driver.findElement(By.id("userNavButton")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    public void closeMessageLighting() {
        if (driver.findElement(By.id("lexNoThanks")).isDisplayed()) {
            driver.findElement(By.id("lexNoThanks")).click();
            driver.findElement(By.id("tryLexDialogX")).click();
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}