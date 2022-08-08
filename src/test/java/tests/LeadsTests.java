package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pages.LeadDetailsPage;
import pages.LeadsPage;
import pages.Utils;
import pages.dataproviders.LeadDataProvider;
import pages.enums.*;
import pages.modals.NewLeadModal;
import pages.models.Lead;
import static java.util.Optional.ofNullable;
public class LeadsTests extends BaseTest {

    private final String LEAD_STATUS = "Working";
    private final String SALUTATION = "Mr.";
    private final String LAST_NAME = "Hopkins";
    private final String COMPANY = "Apple";
    private LeadsPage leadsPage;
    private NewLeadModal newLeadPage;
    private LeadDetailsPage leadDetailsPage;
    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
        newLeadPage = new NewLeadModal(driver);
        leadDetailsPage = new LeadDetailsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void logout() {
        leadDetailsPage.logout();
        loginPage.waitForPageLoaded();
    }

    @Test(dataProvider = "leadDataProvider", dataProviderClass = LeadDataProvider.class)
    public void createLeadTest(Lead testLead)  {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openTabByName("Leads");
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        leadsPage.waitForTabLoaded("New Lead" );
        newLeadPage.fillForm(testLead);
        newLeadPage.clickSave();
        String actualAlertMessage = leadsPage.getAlertMessage();
        leadsPage.closeAlert();
        String expectedAlertMessage = String.format("success\nLead \"%s\" was created.\nClose",
                testLead.getFullName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert text about successful " +
                "lead creating is incorrect");
        leadDetailsPage.openSldsTabByName("Details"); //old version of site. Details are not shown
        leadDetailsPage.waitForPageLoaded();
        Assert.assertEquals(testLead, leadDetailsPage.getLeadInfo(), "Saved data is different from " +
                "the entered ones");
        leadDetailsPage.closeTabByName(new Utils().buildFullName(null,
                testLead.getFirstName(), testLead.getMiddleName(), testLead.getLastName(),
                testLead.getSuffix()));
    }
}
