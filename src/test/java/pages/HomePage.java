package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage{
    private final static By USER_ICON_LOCATOR = By.cssSelector(".photoContainer");
    private final static String LOGOUT_LINK_LOCATOR =
    "//*[contains(@class, 'userProfilePanel')]//a[text() = '%s']";
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public void openTabByName(String tabName) {
        By tabLocator = By.xpath(String.format("//span[text()='%s']", tabName));
        waitForElementClickable(tabLocator);
        jsClick(driver.findElement(tabLocator));//select item in the menu
    }

    public void logout() {
        openUserMenu();
        clickLinkInUserMenu("Log Out");
    }
    private void openUserMenu() {
        log.info(driver.findElements(USER_ICON_LOCATOR).size());
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(USER_ICON_LOCATOR)).build().perform();
        waitForElementDisplayed(USER_ICON_LOCATOR);
        waitForElementClickable(USER_ICON_LOCATOR);
        log.info("Click Menu");
        driver.findElement(USER_ICON_LOCATOR).click();
        log.info("wait");
        waitForElementClickable(By.xpath(String.format(LOGOUT_LINK_LOCATOR,
                "Add Username")));
    }

    private void clickLinkInUserMenu(String linkText) {
        By locator = By.xpath(String.format(LOGOUT_LINK_LOCATOR, linkText));
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }
}
