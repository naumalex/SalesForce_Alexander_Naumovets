package modals;

import Utils.Address;
import elements.LightningCombobox;
import elements.LightningInput;
import elements.LightningTextArea;
import elements.SearchableDropDown.SearchableDropDownContact;
import enums.LeadSource;
import enums.Salutation;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewContactModal extends BaseModal {
    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Contact inputContact) {
        log.info("Fill Contact form");
        new LightningInput(driver, "Phone").setValue(inputContact.getPhone());
        new LightningInput(driver, "Mobile").setValue(inputContact.getMobile());
        new LightningCombobox(driver, "Salutation").selectByVisibleText(
                inputContact.getSalutation().map(Salutation::getName).orElse(null));
        new LightningInput(driver, "First Name").setValue(inputContact.getFirstName());
        new LightningInput(driver, "Last Name").setValue(inputContact.getLastName());
        new SearchableDropDownContact(driver, "Account Name").
                setValue(inputContact.getAccountName());
        new LightningInput(driver, "Email")
                .setValue(inputContact.getEmail());
        new LightningInput(driver, "Title").setValue(inputContact.getTitle());
        new SearchableDropDownContact(driver, "Reports To").
                setValue(inputContact.getReportsTo());
        new LightningTextArea(driver, "Mailing Street").setValue(
                inputContact.getMailingAddress().map(Address::getStreet).orElse(null));
        new LightningInput(driver, "Mailing City").setValue(
                inputContact.getMailingAddress().map(Address::getCity).orElse(null));
        new LightningInput(driver, "Mailing State/Province").setValue(
                inputContact.getMailingAddress().map(Address::getStateProvince).orElse(null));
        new LightningInput(driver, "Mailing Zip/Postal Code").setValue(
                inputContact.getMailingAddress().map(Address::getZipPostalCode).orElse(null));
        new LightningInput(driver, "Mailing Country").setValue(
                inputContact.getMailingAddress().map(Address::getCountry).orElse(null));
        new LightningTextArea(driver, "Other Street").setValue(
                        inputContact.getOtherAddress().map(Address::getStreet).orElse(null));
        new LightningInput(driver, "Other City").setValue(
                inputContact.getOtherAddress().map(Address::getCity).orElse(null));
        new LightningInput(driver, "Other State/Province").setValue(
                inputContact.getOtherAddress().map(Address::getStateProvince).orElse(null));
        new LightningInput(driver, "Other Zip/Postal Code").setValue(
                inputContact.getOtherAddress().map(Address::getZipPostalCode).orElse(null));
        new LightningInput(driver, "Other Country").setValue(
                inputContact.getOtherAddress().map(Address::getCountry).orElse(null));
        new LightningInput(driver, "Fax").setValue(inputContact.getFax());
        new LightningInput(driver, "Department").setValue(inputContact.getDepartment());
        new LightningInput(driver, "Home Phone").setValue(inputContact.getHomePhone());
        new LightningCombobox(driver, "Lead Source").selectByVisibleText(
                inputContact.getLeadSource().map(LeadSource::getName).orElse(null));
        new LightningInput(driver, "Other Phone").setValue(inputContact.getOtherPhone());
        new LightningInput(driver, "Birthdate").setValue(inputContact.getBirthdate());
        new LightningInput(driver, "Asst. Phone").setValue(inputContact.getAsstPhone());
        new LightningInput(driver, "Assistant").setValue(inputContact.getAssistant());
        new LightningTextArea(driver, "Description").setValue(inputContact.getDescription());
    }
}
