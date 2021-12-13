import Page.BigStepPlatformPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Page.BigStepHomePage;
import org.testng.annotations.Test;

public class BigStepJavaTest {

    private WebDriver driver;
    private BigStepPlatformPage bigStepPlatformPage;

    private String eMail = "ilyabudnikuttest@mail.ru";
    private String pass = "Bulka2002";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        bigStepPlatformPage = new BigStepHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(eMail)
                .enterPassword(pass)
                .signIn();
    }
    @Test

    @AfterMethod(alwaysRun = true)
    public void brClose() {
        driver.quit();
        driver = null;
    }
}