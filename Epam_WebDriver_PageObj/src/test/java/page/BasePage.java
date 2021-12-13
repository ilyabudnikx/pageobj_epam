package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
    }

    //WWM
    public void waitVisability(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click(By elementBy){
        waitVisability(elementBy);
        driver.findElement(elementBy).click();
    }

    public void inputVaribles(By elementBy){
        waitVisability(elementBy);
        driver.findElement(elementBy).sendKeys();
    }

    //Is element Displayed
    public void isElementDisplayed(By elementBy){
        waitVisability(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element is not displayed");
    }
}
