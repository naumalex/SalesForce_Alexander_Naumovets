package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadDetailsPage;
import pages.LeadsPage;
import dataproviders.LeadDataProvider;
import modals.NewLeadModal;
import models.Lead;

@Log4j2
public class LeadsTests extends BaseTest {

    private LeadsPage leadsPage;
    private NewLeadModal newLeadPage;
    private LeadDetailsPage leadDetailsPage;
    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
        newLeadPage = new NewLeadModal(driver);
        leadDetailsPage = new LeadDetailsPage(driver);
    }

    @Test(dataProvider = "leadDataProvider", dataProviderClass = LeadDataProvider.class)
    public void createLeadTest(Lead testLead)  {
        log.atDebug();
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openTabByName("Leads");
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        newLeadPage.fillForm(testLead);
        newLeadPage.clickSave();
        String actualAlertMessage = leadsPage.getAlertMessage();
        leadsPage.closeAlert();
        String expectedAlertMessage = String.format("success\nLead \"%s\" was created.\nClose",
                testLead.getFullName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage,
                "Alert text about successful lead creating is incorrect");
        leadDetailsPage.waitForPageLoaded();
        Assert.assertEquals(leadDetailsPage.getLeadInfo(), testLead ,
                "Saved data is different from the entered ones");
    }
}
