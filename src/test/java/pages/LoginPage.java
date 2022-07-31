package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final static String URL = "https://tmsqa193.lightning.force.com/";
    private final By userNameInput = By.cssSelector("input#username");
    private final By passwordInput = By.cssSelector("input#password");
    private final By loginButton = By.cssSelector("input#Login");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(userNameInput);
    }

    public void open() {
        driver.get(URL);
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public void setUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
/*
    public boolean isErrorMessageDisplayed() {
        return errorMessageContainer.isDisplayed();
    }

    public String getErrorText() {
        return errorMessageContainer.getText();
    }

*/
}
