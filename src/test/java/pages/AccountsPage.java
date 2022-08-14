package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends EntityBasePage{

    private static final By TABLE_LOCATOR = By.cssSelector("table[role='grid']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
      //  waitForPageLoaded("Accounts");
        waitForElementClickable(TABLE_LOCATOR);
    }
}
