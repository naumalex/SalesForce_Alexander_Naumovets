package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final static By USER_ICON_LOCATOR = By.cssSelector(".photoContainer");
    private final static By SHOW_NAVIGATION_MENU_BUTTON_LOCATOR =
            By.cssSelector("button[title= 'Show Navigation Menu']");
    private final static String NAVIGATION_MENU_ITEM_LOCATOR = "a[data-label= '%s']";
    private final static String CLOSE_TAB_BUTTON_LOCATOR = "button[title= 'Close %s']";
    private final static String LOGOUT_LINK_LOCATOR =
          //  By.cssSelector("*[class~='userProfilePanel'] a[class~='logout']");
    "//*[contains(@class, 'userProfilePanel')]//a[text() = '%s']";
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public void openTabByName(String tabName) {
        By tabLocator = By.cssSelector(String.format(NAVIGATION_MENU_ITEM_LOCATOR, tabName));
        driver.findElement(SHOW_NAVIGATION_MENU_BUTTON_LOCATOR).click(); //open menu
        driver.findElement(tabLocator).click();//select item in the menu
    }

    public void closeTabByName(String tabName) {
        By locator = By.cssSelector(String.format(CLOSE_TAB_BUTTON_LOCATOR, tabName));
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }

    public void waitForTabLoaded(String tabName) {
        By tabTitleLocator = By.cssSelector(String.format(TAB_TITLE_LOCATOR, tabName));
        waitForElementClickable(tabTitleLocator);
        driver.findElement(tabTitleLocator).click();
    }
    public void logout() {
        openUserMenu();
        clickLinkInUserMenu("Log Out");
    }
    private void openUserMenu() {
        waitForElementClickable(USER_ICON_LOCATOR);
        driver.findElement(USER_ICON_LOCATOR).click();
        waitForElementClickable(By.xpath(String.format(LOGOUT_LINK_LOCATOR,
                "Add Username")));
    }

    private void clickLinkInUserMenu(String linkText) {
        By locator = By.xpath(String.format(LOGOUT_LINK_LOCATOR, linkText));
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }

}
