package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.dataproviders.AccountDataProvider;
import pages.modals.NewAccountModal;
import pages.models.Account;

public class AccountsTests extends BaseTest {

    private AccountsPage accountsPage;
    private NewAccountModal newAccountPage;
    private AccountDetailsPage accountDetailsPage;
    @BeforeClass
    public void initialise() {
        accountsPage = new AccountsPage(driver);
        newAccountPage = new NewAccountModal(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
    }

    @Test(dataProvider = "accountDataProvider", dataProviderClass = AccountDataProvider.class)
    public void createAccountTest(Account testAccount)  {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openTabByName("Accounts");
        accountsPage.waitForPageLoaded();
        accountsPage.clickNewButton();
        newAccountPage.waitForPageLoaded();
        newAccountPage.fillForm(testAccount);
        newAccountPage.clickSave();
        String actualAlertMessage = accountsPage.getAlertMessage();
        accountsPage.closeAlert();
        String expectedAlertMessage = String.format("success\nAccount \"%s\" was created.\nClose",
                testAccount.getAccountName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert text about successful " +
                "account creating is incorrect");
        accountDetailsPage.waitForPageLoaded();
        Assert.assertEquals(accountDetailsPage.getAccountInfo(), testAccount ,
                "Saved data is different from the entered ones");
    }
}