package org.fundacionjala.sfdc.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Opportunity {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOpportunities() {
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("daniel@fundacion-jala.org");
        driver.findElement(By.id("password")).sendKeys("Ness2020");
        driver.findElement(By.id("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='All Tabs']")));
        driver.findElement(By.xpath("//img[@alt='All Tabs']")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        closeMessageLighting();
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.elementToBeClickable(By.name("new")));
        driver.findElement(By.name("new")).click();
        driver.findElement(By.id("opp3")).sendKeys("OpportunityHH");
        driver.findElement(By.xpath("(//td[@onclick='DatePicker.datePicker.selectDate(this);'])[25]")).click();
        driver.findElement(By.id("opp11")).click();
        new Select(driver.findElement(By.id("opp11"))).selectByVisibleText("Needs Analysis");
        driver.findElement(By.xpath("//option[@value='Needs Analysis']")).click();
        driver.findElement(By.name("save")).click();
        driver.findElement(By.id("userNavLabel")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    public void closeMessageLighting() {
        if (driver.findElement(By.id("lexNoThanks")).isDisplayed()) {
            driver.findElement(By.id("lexNoThanks")).click();
            driver.findElement(By.id("tryLexDialogX")).click();
        }
    }
}
