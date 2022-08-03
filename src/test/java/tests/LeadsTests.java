package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadDetailsPage;
import pages.LeadsPage;
import pages.enums.*;
import pages.modals.NewLeadModal;
import pages.models.Lead;

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

    @Test
    public void createLeadTest()  {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        Lead testLead = new Lead(LeadStatus.WORKING,Salutation.MR,"Alex",
                "Jenny", "Johnson", "Junior", "www.onliner.by",
                "Title", "Apple", "test@gmail.com", Industry.COMMUNICATIONS,
                "+375171234567", "5", "+375291111111",
                LeadSource.GOOGLE_ADWORDS, Rating.COLD, "Address", "Nezavisimosty",
                "Minsk", "TEST", "210009", "Belarus");

        newLeadPage.waitForPageLoaded();
        //String itemDescription =
        newLeadPage.fillForm(testLead);
        newLeadPage.clickSave();
        String actualAlertMessage = leadsPage.getAlertMessage();
        leadsPage.closeAlert();
        String expectedAlertMessage = String.format("success\nLead \"%s %s\" was created.\nClose",
                SALUTATION, LAST_NAME);
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert text about successful " +
                "lead creating is incorrect");
        leadDetailsPage.openTabByName("Details"); //old version of site. Details are not shown
        Assert.assertEquals(testLead, leadDetailsPage.getLeadInfo(), "Safed data is different from " +
                "the entered ones");
        //homePage.closeTabByName(itemDescription);
    }
}
