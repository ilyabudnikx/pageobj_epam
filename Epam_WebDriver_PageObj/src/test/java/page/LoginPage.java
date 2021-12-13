package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    String SITE_URL = "https://bitsgap.com/sign-in/?d=app";
    By usernameLocator = By.id("lemail");
    By passwordLocator = By.id("lpassword");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public LoginPage typeUsername(String username){
        driver.findElement(usernameLocator).
    }
}
