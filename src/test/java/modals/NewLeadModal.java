package modals;


import Utils.Address;
import enums.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import elements.LightningCheckbox;
import elements.LightningCombobox;
import elements.LightningInput;
import elements.LightningTextArea;
import models.Lead;

@Log4j2
public class NewLeadModal extends BaseModal {

    public NewLeadModal(WebDriver driver) {
        super(driver);
    }

    public void clickSave() {
        waitForElementClickable(SAVE_BUTTON_LOCATOR);
        log.info("Click Save");
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }

    public void fillForm(Lead inputLead) {
        log.info("Fill the form");
        new LightningCombobox(driver, "Lead Status").
                selectByVisibleText(inputLead.getLeadStatus().map(LeadStatus::getName).orElse(null));
        new LightningCombobox(driver, "Salutation").
                selectByVisibleText(inputLead.getSalutation().map(Salutation::getName).orElse(null));
        new LightningInput(driver, "First Name").setValue(inputLead.getFirstName());
        new LightningInput(driver, "Last Name").setValue(inputLead.getLastName());
        new LightningInput(driver, "Website").setValue(inputLead.getWebsite());
        new LightningInput(driver, "Title").setValue(inputLead.getTitle());
        new LightningCheckbox(driver, "Follow Up?").setValue(inputLead.isFollowUp());
        new LightningInput(driver, "Company").setValue(inputLead.getCompany());
        new LightningInput(driver, "Email").setValue(inputLead.getEmail());
        new LightningCombobox(driver, "Industry").
                selectByVisibleText(inputLead.getIndustry().map(Industry::getName).orElse(null));
        new LightningInput(driver, "Phone").setValue(inputLead.getPhone());
        new LightningInput(driver, "No. of Employees").setValue(inputLead.getNoOfEmployees());
        new LightningCombobox(driver, "Lead Source").
                    selectByVisibleText(inputLead.getLeadSource().map(LeadSource::getName).orElse(null));
        new LightningCombobox(driver, "Rating").
                    selectByVisibleText(inputLead.getRating().map(Rating::getName).orElse(null));
        new LightningInput(driver, "Annual Revenue").setValue(inputLead.getAnnualRevenue());
        new LightningTextArea(driver, "Street").setValue(
                inputLead.getAddress().map(Address::getStreet).orElse(null));
        new LightningInput(driver, "City").setValue(
                inputLead.getAddress().map(Address::getCity).orElse(null));
        new LightningInput(driver, "State/Province").setValue(
                inputLead.getAddress().map(Address::getStateProvince).orElse(null));
        new LightningInput(driver, "Zip/Postal Code").setValue(
                inputLead.getAddress().map(Address::getZipPostalCode).orElse(null));
        new LightningInput(driver, "Country").setValue(
                inputLead.getAddress().map(Address::getCountry).orElse(null));
    }
}
