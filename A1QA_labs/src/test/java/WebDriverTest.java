import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class WebDriverTest {
    protected WebDriver driver;
    @BeforeMethod (alwaysRun = true)
    public void beforeTestSetupClass(){
        WebDriverManager.chromedriver().setup();
        Dimension dimension = new Dimension(1920, 1080);
        driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
    }

    @Test (description = "Open Steam Url", priority = 1)
    public void main() throws InterruptedException{
    driver.get("https://store.steampowered.com/");
    WebElement findAboutHad = driver.findElement(By.cssSelector("a.menuitem:nth-child(5)"));
    findAboutHad.click();
    WebElement findStatsOnline = driver.findElement(By.cssSelector("div.online_stat:nth-child(1)"));
    WebElement findStatsInGame = driver.findElement(By.cssSelector("div.online_stat:nth-child(2)"));
    String numberOnlineStr = findStatsOnline.getText().replaceAll("[^0-9]", "");
    String numberStatsInGameStr = findStatsInGame.getText().replaceAll("[^0-9]", "");
    int numberOnlineInt = Integer.parseInt(numberOnlineStr);
    int numberStatsInGameInt = Integer.parseInt(numberStatsInGameStr);
        Assert.assertTrue(numberOnlineInt>numberStatsInGameInt,"Gamers in online < gamers in game");
    WebElement findShopButton = driver.findElement(By.cssSelector("a.supernav:nth-child(1)"));
    findShopButton.click();
    }

    @Test (priority = 2)
    public void TwoTest() throws InterruptedException {
        driver.get("https://store.steampowered.com");
        Actions builder = new Actions(driver);
        WebElement buttonNewAndPrim  = driver.findElement(By.cssSelector("#noteworthy_tab"));
        builder.moveToElement(buttonNewAndPrim).build().perform();
        Thread.sleep(1000); //todo явыне ожидания
        WebElement buttonLeadSales = driver.findElement(By.cssSelector("#noteworthy_flyout > div:nth-child(1) > a:nth-child(1)"));
        buttonLeadSales.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scrollBy(0,400)");
        WebElement checkBoxSteamOs = driver.findElement(By.cssSelector("div.block:nth-child(9) > div:nth-child(2) > div:nth-child(4) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
        checkBoxSteamOs.click();
        WebElement buttonPopupMenuGamers = driver.findElement(By.cssSelector("div.block:nth-child(6) > div:nth-child(1)"));
        buttonPopupMenuGamers.click();
        WebElement checkboxCoopLan = driver.findElement(By.cssSelector("div.block:nth-child(6) > div:nth-child(2) > div:nth-child(10) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
        checkboxCoopLan.click();
        WebElement labelSeeMore = driver.findElement(By.cssSelector("div.block:nth-child(3) > a:nth-child(3)"));
        labelSeeMore.click();
        Thread.sleep(1000); //todo явыне ожидания
        WebElement labelActionValue = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[5]/form/div[1]/div/div[2]/div[3]/div[2]/div/div[8]/span[1]/span/span[3]"));
        int actionValueInt = Integer.parseInt(labelActionValue.getText().replaceAll("[^0-9]",""));
        System.out.println(String.format("Action: %s", actionValueInt));
        WebElement checkboxActionGame = driver.findElement(By.cssSelector("#TagFilter_Container > div:nth-child(9) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
        checkboxActionGame.click();
        Thread.sleep(1000); //todo явыне ожидания
        WebElement labelValueActionGames = driver.findElement(By.cssSelector(".search_results_count"));
        int labelValueActionGamesInt = Integer.parseInt(labelValueActionGames.getText().replaceAll("[^0-9]", ""));
        System.out.println(String.format("Before press: %s. After press: %s",actionValueInt, labelValueActionGamesInt));
        WebElement labelNameFirstGame = driver.findElement(By.cssSelector("a.search_result_row:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)"));
        WebElement labelDateRelease = driver.findElement(By.cssSelector("a.search_result_row:nth-child(1) > div:nth-child(2) > div:nth-child(2)"));
        WebElement labelPriceFirstGame = driver.findElement(By.cssSelector("a.search_result_row:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2)"));
        String p1 = labelNameFirstGame.getText();
        String p2 = labelDateRelease.getText();
        String p3 = labelPriceFirstGame.getText().replaceAll("[^0-9,$,.]","");;
        System.out.println(String.format("First game: %s, %s, %s", labelNameFirstGame.getText(), labelDateRelease.getText(), labelPriceFirstGame.getText()));
        WebElement buttonListFirstGame = driver.findElement(By.cssSelector("a.search_result_row:nth-child(1)"));
        buttonListFirstGame.click();
        WebElement labelNameGameOnPage = driver.findElement(By.cssSelector("#appHubAppName"));
        WebElement labelDateReleaseOnPage = driver.findElement(By.cssSelector(".date"));
        WebElement labelPriceGameOnPage = driver.findElement(By.cssSelector(".game_purchase_price"));
        String i1 = labelNameGameOnPage.getText();
        String i2 = labelDateReleaseOnPage.getText();
        String i3 = labelPriceGameOnPage.getText().replaceAll("[^0-9,$,.]","");
        System.out.println(String.format("First game on your main page: %s, %s, %s", labelNameGameOnPage.getText(), labelDateReleaseOnPage.getText(), i3));
        Assert.assertTrue(p1.equals(i1) & p2.equals(i2) & p3.equals(i3), "ERROR: Check prices(:()");
    }

    @Test (priority = 3)
    public void ThreeTest() throws InterruptedException {
    driver.get("https://store.steampowered.com");
    Thread.sleep(1000);
    Actions builder = new Actions(driver);
        WebElement buttonCommunity = driver.findElement(By.xpath("//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_community']"));
    builder.moveToElement(buttonCommunity).build().perform();
    Thread.sleep(500); //todo явыне ожидания
    WebElement buttonMarketPlace = driver.findElement(By.cssSelector("div.submenu_community:nth-child(1) > a:nth-child(4)"));
    buttonMarketPlace.click();
    WebElement buttonDopElements = driver.findElement(By.cssSelector("#market_search_advanced_show"));
    buttonDopElements.click();
    WebElement dropdownMenu = driver.findElement(By.cssSelector("#app_option_0_selected"));
    dropdownMenu.click();
    WebElement buttonDota2 = driver.findElement(By.id("app_option_570"));
        Coordinates coordinates = ((Locatable)buttonDota2).getCoordinates();
        coordinates.inViewPort();
        buttonDota2.click();
        WebElement selectHero = driver.findElement(By.name("category_570_Hero[]"));
        selectHero.click();
        Select select = new Select(selectHero);
        select.selectByValue("tag_npc_dota_hero_life_stealer");
        WebElement selectRarityImmortal = driver.findElement(By.cssSelector("div.econ_tag_filter_category:nth-child(6) > div:nth-child(6)"));
        selectRarityImmortal.click();
        WebElement inputSearch = driver.findElement(By.cssSelector("#advancedSearchBox"));
        inputSearch.sendKeys("golden");
        WebElement buttonSearch = driver.findElement(By.cssSelector("div.btn_medium:nth-child(2)"));
        buttonSearch.click();
        WebElement buttonDop2 = driver.findElement(By.id("market_search_advanced_show"));
        buttonDop2.click();
        WebElement inputDropGolden = driver.findElement(By.id("advancedSearchBox"));
        inputDropGolden.clear();
        WebElement buttonOpenDropDownMenu = driver.findElement(By.id("market_advancedsearch_appselect_activeapp"));
        buttonOpenDropDownMenu.click();
        WebElement buttonAllGames = driver.findElement(By.id("app_option_0"));
        Coordinates coordinates2 = ((Locatable)buttonAllGames).getCoordinates();
        coordinates2.inViewPort();
        buttonAllGames.click();
        WebElement buttonAccept = driver.findElement(By.cssSelector("div.btn_medium:nth-child(2)"));
        buttonAccept.click();
        WebElement informationNameList = driver.findElement(By.id("result_0_name"));
        WebElement informationPriceList = driver.findElement(By.cssSelector("#result_0 > div:nth-child(2) > div:nth-child(2) > span:nth-child(1) > span:nth-child(2)"));
        String inf1 = informationNameList.getText();
        String inf2 = informationPriceList.getText().replaceAll("[^0-9,$,.]","");
        System.out.println(String.format("Name and price on main list : %s, %s", inf1, inf2));
        WebElement buttonFirstElementOnList = driver.findElement(By.id("result_0"));
        buttonFirstElementOnList.click();
        WebElement informationNameOnPage = driver.findElement(By.id("largeiteminfo_item_name"));
        WebElement informationPriceOnPage = driver.findElement(By.cssSelector("#market_commodity_forsale > span:nth-child(3)"));
        String infOnPage1 = informationNameOnPage.getText();
        String infOnPage2 = informationPriceOnPage.getText().replaceAll("[^0-9,$,.]","");
        System.out.println(String.format("Name and price on page: %s, %s", infOnPage1, infOnPage2));
        Assert.assertTrue(inf2.equals(infOnPage2),"ERROR: The price may have changed.");
    }
    @AfterMethod (alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
