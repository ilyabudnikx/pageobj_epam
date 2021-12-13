package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BigStapSellersPage extends BasePage {

    @FindBy(css = "#root > main > div > div > div > div > div > div > div.trading-page.trading-page_view_standard > div.trading-page__column.trading-page__column_position_right > div.place-order > div.place-order__content > div:nth-child(4) > div > button")
    private WebElement nicePrice;

    @FindBy(css = "#root > main > div > div > div > div > div > div > div.trading-page.trading-page_view_standard > div.trading-page__column.trading-page__column_position_right > div.place-order > div.place-order__content > div:nth-child(5) > div > div > div > input")
    private WebElement inputValues;

    @FindBy(css = "#root > main > div > div > div > div > div > div > div.trading-page.trading-page_view_standard > div.trading-page__column.trading-page__column_position_right > div.place-order > div.place-order__content > div.place-order__button > button")
    private WebElement acceptButton;

    @FindBy(css = "div > div > div > div > div > div > div.notification-card__card-content")
    private  WebElement notificationTrue;

    @FindBy(css = "#root > main > div > div > div > div > div > div > div.trading-page.trading-page_view_standard > div.trading-page__column.trading-page__column_position_right > div.place-order > div.place-order__content > div:nth-child(3) > div > div > div > input")
    private WebElement inputPrises;

    protected BigStapSellersPage(WebDriver driver) {
        super(driver);
    }

    public  BigStapSellersPage clickNicePrice() throws InterruptedException {
        waitForElementToBeClickable(driver, nicePrice);
        Thread.sleep(2000);
        nicePrice.click();
        return this;
    }

    public BigStapSellersPage inputPrices(String valueTokens) throws InterruptedException {
        waitForVisibilityOfElement(driver, inputValues);
        inputValues.sendKeys(valueTokens);
        return this;

    }
    public BigStapSellersPage clickAcceptButton() throws InterruptedException {
        waitForElementToBeClickable(driver, acceptButton);
        acceptButton.click();
        return this;
    }
    public boolean isVisableNotification() {
        waitForVisibilityOfElement(driver, notificationTrue);
        return notificationTrue.isDisplayed();
    }

    public BigStapSellersPage inputSellersPage(String valueBTC) {
        waitForElementToBeClickable(driver, inputPrises);
        inputPrises.sendKeys(Keys.BACK_SPACE + valueBTC);
        return this;
    }
}
