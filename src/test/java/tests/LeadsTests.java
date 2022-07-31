package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadsPage;
import pages.NewLeadPage;

public class LeadsTests extends BaseTest {

    private final String LEAD_STATUS = "Working";
    private final String SALUTATION = "Mr.";
    private final String LAST_NAME = "Hopkins";
    private final String COMPANY = "Apple";
    private LeadsPage leadsPage;
    private NewLeadPage newLeadPage;

    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
        newLeadPage = new NewLeadPage(driver);
    }

    @Test
    public void createLeadTest()  {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        newLeadPage.waitForPageLoaded();
        String itemDescription =
                newLeadPage.fillAndSaveNewLeadForm(LEAD_STATUS, SALUTATION, LAST_NAME,
                COMPANY);
        String actualAlertMessage = homePage.getAlertMessage();
        homePage.closeAlert();
        String expectedAlertMessage = String.format("success\nLead \"%s %s\" was created.\nClose",
                SALUTATION, LAST_NAME);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert text about successful " +
                "lead creating is incorrect");
        homePage.closeTabByName(itemDescription);
    }
}
