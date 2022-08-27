package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public abstract class EntityBasePage extends HomePage {

    protected final static By NEW_BUTTON = By.cssSelector("div.active a[title='New']");
    private final static By ALERT_MESSAGE_LOCATOR = By.cssSelector(
            "div[role='alertdialog']");

    public EntityBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(NEW_BUTTON);
        waitForElementClickable(NEW_BUTTON);
    }

    public void clickNewButton() {
        log.info("Click New");
        driver.findElement(NEW_BUTTON).click();
    }

    public String getAlertMessage() {
        waitForElementDisplayed(ALERT_MESSAGE_LOCATOR);
        return driver.findElement(ALERT_MESSAGE_LOCATOR).getText();
    }

    public void closeAlert() {
        log.info("Click Alert window");
        driver.findElement(ALERT_MESSAGE_LOCATOR).click();
        waitForElementInvisible(ALERT_MESSAGE_LOCATOR);
    }
}
