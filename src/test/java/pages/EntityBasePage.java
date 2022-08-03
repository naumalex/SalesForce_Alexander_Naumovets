package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class EntityBasePage extends BasePage {

    protected final static By NEW_BUTTON = By.cssSelector("div.active a[title='New']");
    private static final By TABLE_LOCATOR = By.cssSelector("table[role='grid']");
    private static final By ENTITY_LINKS_LOCATOR =
            By.cssSelector("table[role='grid'] a[data-refid='recordId']");
    private final static By ALERT_MESSAGE_LOCATOR = By.cssSelector("div[role='alertdialog']");


    public EntityBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(NEW_BUTTON);
        waitForElementClickable(NEW_BUTTON);
    }

    public void openEntityByName(String entityName) {
        List<WebElement> allLinks = getAllEntitiesList();
        allLinks.stream().filter(p->p.getText().equals(entityName))
                .findFirst().get().click();
    }

    List<WebElement> getAllEntitiesList() {
        return driver.findElements(ENTITY_LINKS_LOCATOR);
    }

    public String getAlertMessage() {
        return driver.findElement(ALERT_MESSAGE_LOCATOR).getText();
    }

    public void closeAlert() {
        driver.findElement(ALERT_MESSAGE_LOCATOR).click();
        waitForElementInvisible(ALERT_MESSAGE_LOCATOR);
    }

}