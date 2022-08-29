package tests;

import dataproviders.ContactDataProvider;
import modals.NewContactModal;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactsPage;

public class ContactsTests extends BaseTest {

    private ContactsPage contactsPage;
    private NewContactModal newContactPage;
    private ContactDetailsPage contactDetailsPage;

    @BeforeClass
    public void initialise() {
        contactsPage = new ContactsPage(driver);
        newContactPage = new NewContactModal(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
    }

    @Test(dataProvider = "contactDataProvider", dataProviderClass = ContactDataProvider.class)
    public void createContactTest(Contact testContact)  {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openTabByName("Contacts");
        contactsPage.waitForPageLoaded();
        contactsPage.clickNewButton();
        newContactPage.waitForPageLoaded();
        newContactPage.fillForm(testContact);
        newContactPage.clickSave();
        String actualAlertMessage = contactsPage.getAlertMessage();
        contactsPage.closeAlert();
        String expectedAlertMessage = String.format("success\nContact \"%s\" was created.\nClose",
                testContact.getFullName());
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Alert text about successful " +
                "account creating is incorrect");
        contactDetailsPage.waitForPageLoaded();
        Assert.assertEquals(contactDetailsPage.getContactInfo(), testContact ,
                "Saved data is different from the entered ones");
    }
}