package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.net.URI;
import java.util.Currency;
import java.util.function.BiFunction;

public class BigStepHomePage extends BasePage{
    private static final String PAGE_URL = "https://bitsgap.com/sign-in/?d=app";

    @FindBy(xpath = "//*[@id=\"login-form\"]/button")
    private WebElement logInButton;

    public BigStepHomePage(WebDriver driver) {
        super(driver);
    }

    public BigStepHomePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public BigStepLoginPage openLoginWindow() {
        logInButton.click();
        return new BigStepLoginPage(driver);
    }
}
