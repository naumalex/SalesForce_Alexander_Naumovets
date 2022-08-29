 package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {
    protected final static String DEFAULT_USER_NAME = "naum1979alex-8hvs@force.com";
    protected final static String DEFAULT_PASSWORD = "Password1*";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass (alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
    public void logOut() {
        homePage.logout();
        loginPage.waitForPageLoaded();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException exc)
        {
            log.info("Interrupted Exception occurred during sleep");}
      }
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
