package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.elements.LightningCombobox;
import pages.elements.LightningInput;
import pages.elements.LightningTextArea;
import pages.models.Lead;

public class NewLeadModal extends BaseModal {

    public static final By LAST_NAME_LOCATOR = By.xpath("//input[@name='lastName']");
    public static final By COMPANY_LOCATOR = By.xpath("//input[@name='Company']");
   // public static final By BUTTON_SAVE_LOCATOR = By.xpath("//button[@name='SaveEdit']");

    private Actions actions;
    public NewLeadModal(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public void clickSave() {
        waitForElementClickable(SAVE_BUTTON_LOCATOR);
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }

    public void fillForm(Lead inputLead) {
        new LightningCombobox(driver, "Lead Status").
                selectByVisibleText(inputLead.getLeadStatus().getName());
        new LightningCombobox(driver, "Salutation").
                selectByVisibleText(inputLead.getSalutation().getName());
        new LightningInput(driver, "First Name").setValue(inputLead.getFirstName());
        new LightningInput(driver, "Middle Name").setValue(inputLead.getMiddleName());
        new LightningInput(driver, "Last Name").setValue(inputLead.getLastName());
        new LightningInput(driver, "Suffix").setValue(inputLead.getSuffix());
        new LightningInput(driver, "Website").setValue(inputLead.getWebsite());
        new LightningInput(driver, "Title").setValue(inputLead.getTitle());
        new LightningInput(driver, "Company").setValue(inputLead.getCompany());
        new LightningInput(driver, "Email").setValue(inputLead.getEmail());
        new LightningCombobox(driver, "Industry").
                selectByVisibleText(inputLead.getIndustry().getName());
        new LightningInput(driver, "Phone").setValue(inputLead.getPhone());
        new LightningInput(driver, "No. of Employees").setValue(inputLead.getNoOfEmployees());
        new LightningInput(driver, "Mobile").setValue(inputLead.getMobile());
        new LightningCombobox(driver, "Lead Source").
                selectByVisibleText(inputLead.getLeadSource().getName());
        new LightningCombobox(driver, "Rating").
                selectByVisibleText(inputLead.getRating().getName());
        //new LightningInput(driver, "").setValue(inputLead.getAddress());
        new LightningTextArea(driver, "Street").setValue(inputLead.getStreet());
        new LightningInput(driver, "City").setValue(inputLead.getCity());
        new LightningInput(driver, "State/Province").setValue(inputLead.getStateProvince());
        new LightningInput(driver, "Zip/Postal Code").setValue(inputLead.getZipPostalCode());
        new LightningInput(driver, "Country").setValue(inputLead.getCountry());
        //clickSave();
        /*wait.until((p) -> {
            return !(getActiveTabTitle().equals("New Lead"));
        });
        //return getActiveTabTitle();*/
    }
}
