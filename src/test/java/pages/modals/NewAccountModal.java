package pages.modals;

import org.openqa.selenium.WebDriver;
import pages.Utils.Address;
import pages.elements.*;
import pages.enums.AccountType;
import pages.enums.Industry;
import pages.models.Account;

public class NewAccountModal extends BaseModal {

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Account inputAccount) {
        new LightningInput(driver, "Account Name")
                .setValue(inputAccount.getAccountName());
        new LightningSearchableDropDown(driver, "Parent Account").
                setValue(inputAccount.getParentAccount());
        new LightningInput(driver, "Phone")
                .setValue(inputAccount.getPhone());
        new LightningInput(driver, "Fax").setValue(inputAccount.getFax());
        new LightningInput(driver, "Website").setValue(inputAccount.getWebsite());
        new LightningCombobox(driver, "Type").selectByVisibleText(
                inputAccount.getAccountType().map(AccountType::getName).orElse(null));
        new LightningInput(driver, "Employees").setValue(inputAccount.getEmployees());
        new LightningCombobox(driver, "Industry").selectByVisibleText(
                inputAccount.getIndustry().map(Industry::getName).orElse(null));
        new LightningInput(driver, "Annual Revenue").setValue(inputAccount.getAnnualRevenue());
        new LightningTextArea(driver, "Description").setValue(inputAccount.getDescription());
        new LightningTextArea(driver, "Billing Street").setValue(
                inputAccount.getBillingAddress().map(Address::getStreet).orElse(null));
        new LightningInput(driver, "Billing City").setValue(
                inputAccount.getBillingAddress().map(Address::getCity).orElse(null));
        new LightningInput(driver, "Billing State/Province").setValue(
                inputAccount.getBillingAddress().map(Address::getStateProvince).orElse(null));
        new LightningInput(driver, "Billing Zip/Postal Code").setValue(
                inputAccount.getBillingAddress().map(Address::getZipPostalCode).orElse(null));
        new LightningInput(driver, "Billing Country").setValue(
                inputAccount.getBillingAddress().map(Address::getCountry).orElse(null));
        new LightningTextArea(driver, "Shipping Street").setValue(
                inputAccount.getShippingAddress().map(Address::getStreet).orElse(null));
        new LightningInput(driver, "Shipping City").setValue(
                inputAccount.getShippingAddress().map(Address::getCity).orElse(null));
        new LightningInput(driver, "Shipping State/Province").setValue(
                inputAccount.getShippingAddress().map(Address::getStateProvince).orElse(null));
        new LightningInput(driver, "Shipping Zip/Postal Code").setValue(
                inputAccount.getShippingAddress().map(Address::getZipPostalCode).orElse(null));
        new LightningInput(driver, "Shipping Country").setValue(
                inputAccount.getShippingAddress().map(Address::getCountry).orElse(null));
        new LightningCheckbox(driver, "Copy Billing Address to Shipping Address")
                .setValue(inputAccount.isCopyBillingAddressToShippingAddress());
    }
    public void clickSave() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
