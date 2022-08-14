package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginPage extends BasePage {
    //private final static String URL = "https://tmsqa193.lightning.force.com/";
    private final static String URL = "https://testih.my.salesforce.com/";
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
        waitForPageLoaded();
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public void setUserName(String userName) {
        log.info("Fill user name");
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        log.info("Fill password");
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        log.info("Click Login button");
        driver.findElement(loginButton).click();
    }
}
