package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends EntityBasePage{

    private static final By TABLE_LOCATOR = By.cssSelector("table[role='grid']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementClickable(TABLE_LOCATOR);
    }
}
