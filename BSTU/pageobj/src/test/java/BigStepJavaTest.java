import Page.BigStapSellersPage;
import Page.BigStapTradePage;
import Page.BigStepHomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class BigStepJavaTest {

    private WebDriver driver;

    private BigStapTradePage tradePage;
    private BigStapSellersPage sellersPage;

    private String eMail = "ilyabudnikuttest@mail.ru";
    private String pass = "Bulka2002";
    private String valueTokens = "0.01";
    private String valueBTC = "40000";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        Dimension d = new Dimension(1920, 1080);
        driver.manage().window().setSize(d);
        tradePage = new BigStepHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(eMail)
                .enterPassword(pass)
                .signIn();
    }

    @Test
    public void firstBigStapTest() throws InterruptedException {
        sellersPage = tradePage.closeMenuButtonOnDisplay()
                .clickRollMenu()
                .clickDemoSlider()
                .closeMenuButtonOnDisplay()
                .clickSellersPageTrans()
                .inputPrices(valueTokens)
                .clickNicePrice()
                .clickAcceptButton();
        Assert.assertTrue(sellersPage.isVisableNotification());
    }

    @Test
    public void secondBigStapTest() throws InterruptedException {
        sellersPage = tradePage.closeMenuButtonOnDisplay()
                .clickRollMenu()
                .clickDemoSlider()
                .closeMenuButtonOnDisplay()
                .clickSellersPageTrans()
                .inputPrices(valueTokens)
                .inputSellersPage(valueBTC)
                .clickAcceptButton();
        Assert.assertTrue(sellersPage.isVisableNotification());
    }

    @AfterMethod(alwaysRun = true)
    public void brClose() {
        driver.quit();
        driver = null;
    }
}
