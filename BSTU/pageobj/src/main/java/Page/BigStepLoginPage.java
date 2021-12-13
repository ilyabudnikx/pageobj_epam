package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BigStepLoginPage extends BasePage {
    protected BigStepLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "lemail")
    private WebElement fieldForEmail;

    @FindBy(id = "lpassword")
    private WebElement fieldForPassword;

    @FindBy(xpath = "//*[@id=\"login-form\"]/button")
    private WebElement submitLogInButton;

    public BigStepLoginPage enterEmail(String email) {
        waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(email);
        return this;
    }

    public BigStepLoginPage enterPassword(String password) {
        waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(password);
        return this;
    }

    public BigStapTradePage signIn() {
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new BigStapTradePage(driver);
    }
}
