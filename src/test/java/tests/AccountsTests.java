package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.NewAccountPage;

public class AccountsTests extends BaseTest {

    private final String ACCOUNT_NAME = "Account1";
    private AccountsPage accountsPage;
    private NewAccountPage newAccountPage;

    @BeforeClass
    public void initialise() {
        accountsPage = new AccountsPage(driver);
        newAccountPage = new NewAccountPage(driver);
    }

    @Test
    public void createAccountTest()  {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openTabByName("Accounts");
        accountsPage.waitForPageLoaded();
        accountsPage.clickNewButton();
        newAccountPage.waitForPageLoaded();
        String itemDescription =
                newAccountPage.fillAndSaveNewAccountForm(ACCOUNT_NAME);
        String actualAlertMessage = homePage.getAlertMessage();
        homePage.closeAlert();
        String expectedAlertMessage = String.format("success\nAccount \"%s\" was created.\nClose",
                ACCOUNT_NAME);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert text about successful " +
                "account creating is incorrect");
        homePage.closeTabByName(itemDescription);
    }
}