package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BigStapTradePage extends BasePage{

    @FindBy(css = ".modal__close-button")
    private WebElement closeMenuBotButton; //1

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/div/div/header/div/div[2]/div[4]/div[2]/div/button")
    private WebElement rollProfileMenu; //1

    @FindBy(css = ".switch__switch")
    private WebElement demoSlider; //1

    @FindBy(css = "#root > main > div > div > div > div > div > header > div > div:nth-child(1) > div > div > div > div > a:nth-child(1)")
    private WebElement sellersPageTrans;

    protected BigStapTradePage(WebDriver driver) {
        super(driver);
    }

    public BigStapTradePage closeMenuButtonOnDisplay() {
        waitForElementToBeClickable(driver, closeMenuBotButton);
        closeMenuBotButton.click();
        return this;
    }

    public BigStapTradePage clickRollMenu() {
        waitForElementToBeClickable(driver, rollProfileMenu);
        rollProfileMenu.click();
        waitForVisibilityOfElement(driver, demoSlider);
        return this;
    }

    public BigStapTradePage clickDemoSlider() {
        waitForElementToBeClickable(driver, demoSlider);
        demoSlider.click();
        return this;
    }

    public BigStapSellersPage clickSellersPageTrans() {
        waitForElementToBeClickable(driver, sellersPageTrans);
        sellersPageTrans.click();
        return new BigStapSellersPage(driver);
    }

}
