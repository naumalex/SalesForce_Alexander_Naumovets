package pages;

import Utils.Address;
import elements.LightningFormattedElement;
import elements.LightningFormattedLinkElement;
import enums.LeadSource;
import models.Contact;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends HomePage{

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        new LightningFormattedElement(driver, "Name").waitUntilDisplayed();
    }

    public Contact getContactInfo() {
        String lastName = new LightningFormattedElement(driver, "Name").getText();
        String phone =
                new LightningFormattedLinkElement(driver, "Phone").getText();
        String mobile = new LightningFormattedLinkElement(driver, "Mobile").getText();
        String email = new LightningFormattedLinkElement(driver, "Email").getText();
        String accountName = new LightningFormattedLinkElement(driver, "Account Name").getText();
        String title = new LightningFormattedElement(driver, "Title").getText();
        String reportsTo = new LightningFormattedLinkElement(driver, "Reports To").getText();
        String fullMailingAddress = new LightningFormattedLinkElement(
                driver, "Mailing Address")
                .getText();
        String fullOtherAddress = new LightningFormattedLinkElement(
                driver, "Other Address")
                .getText();
        String fax = new LightningFormattedLinkElement(driver, "Fax").getText();
        String department = new LightningFormattedElement(driver, "Department").getText();
        String homePhone = new LightningFormattedLinkElement(driver, "Home Phone")
                .getText();
        String leadSource = new LightningFormattedElement(driver, "Lead Source")
                .getText();
        String otherPhone = new LightningFormattedLinkElement(driver, "Other Phone").getText();
        String asstPhone = new LightningFormattedLinkElement(driver, "Asst. Phone").getText();
        String assistant = new LightningFormattedElement(driver, "Assistant").getText();
        String birthdate = new LightningFormattedElement(driver, "Birthdate").getText();
        String description = new LightningFormattedElement(driver, "Description").getText();
        return Contact.builder()
                .setLastName(lastName)
                .setPhone(phone)
                .setMobile(mobile)
                .setEmail(email)
                .setAccountName(accountName)
                .setTitle(title)
                .setReportsTo(reportsTo)
                .setMailingAddress(new Address(fullMailingAddress))
                .setOtherAddress(new Address(fullOtherAddress))
                .setFax(fax)
                .setDepartment(department)
                .setHomePhone(homePhone)
                .setLeadSource(LeadSource.fromString(leadSource))
                .setOtherPhone(otherPhone)
                .setAsstPhone(asstPhone)
                .setAssistant(assistant)
                .setBirthdate(birthdate)
                .setDescription(description)
                .build();
    }
}
