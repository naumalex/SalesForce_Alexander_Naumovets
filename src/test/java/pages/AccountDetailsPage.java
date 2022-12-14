package pages;

import enums.AccountType;
import enums.Industry;
import org.openqa.selenium.WebDriver;
import Utils.Address;
import elements.LightningCheckbox;
import elements.LightningFormattedElement;
import elements.LightningFormattedLinkElement;
import models.Account;

public class AccountDetailsPage extends HomePage{

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        new LightningFormattedElement(driver, "Account Name").waitUntilDisplayed();
    }

    public Account getAccountInfo() {
        String accountName =
                new LightningFormattedElement(driver, "Account Name").getText();
        String parentAccount = new LightningFormattedLinkElement(driver, "Parent Account").getText();
        String phone = new LightningFormattedLinkElement(driver, "Phone").getText();
        String fax = new LightningFormattedLinkElement(driver, "Fax").getText();
        String website = new LightningFormattedLinkElement(driver, "Website").getText();
        String accountType = new LightningFormattedElement(driver, "Type").getText();
        String employees = new LightningFormattedElement(driver, "Employees").getText();
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        String annualRevenue = new LightningFormattedElement(driver, "Annual Revenue")
                .getText();
        String description = new LightningFormattedElement(driver, "Description").getText();
        String fullBillingAddress = new LightningFormattedLinkElement(
                driver, "Billing Address")
                .getText();
        String fullShippingAddress = new LightningFormattedLinkElement(
                driver, "Shipping Address").getText();
        boolean isCopyBillingAddressToShippingAddress = new LightningCheckbox(driver,
                "Copy Billing Address to Shipping Address").getValue();
        return Account.builder()
                .setAccountName(accountName)
                .setParentAccount(parentAccount)
                .setPhone(phone)
                .setFax(fax)
                .setWebsite(website)
                .setAccountType(AccountType.fromString(accountType))
                .setEmployees(employees)
                .setIndustry(Industry.fromString(industry))
                .setAnnualRevenue(annualRevenue)
                .setDescription(description)
                .setBillingAddress(new Address(fullBillingAddress))
                .setShippingAddress(new Address(fullShippingAddress))
                .setIsCopyBillingAddressToShippingAddress(isCopyBillingAddressToShippingAddress)
                .build();
    }
}
