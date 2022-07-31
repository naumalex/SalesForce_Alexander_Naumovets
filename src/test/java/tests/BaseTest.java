 package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected final static String DEFAULT_USER_NAME = "naum_1979_alex-1ne0@force.com";
    protected final static String DEFAULT_PASSWORD = "Password1*";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass (alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void ClearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
