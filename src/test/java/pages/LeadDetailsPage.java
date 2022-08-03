package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.elements.LightningCombobox;
import pages.elements.LightningFormattedAddressElement;
import pages.elements.LightningFormattedElement;
import pages.elements.LightningInput;
import pages.enums.*;
import pages.models.Lead;

public class LeadDetailsPage extends BasePage {

    private static final String TAB_LOCATOR = ".slds-tabs_default__item a[data-label='%s']";
    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public void openTabByName(String tabName) {
        By tabLocator = By.cssSelector(String.format(TAB_LOCATOR, tabName));
        driver.findElement(tabLocator).click();
        waitForAttributeToBe(tabLocator, "aria-selected", "true");
    }

    public Lead getLeadInfo() {
        String leadStatus = new LightningFormattedElement(driver, "Lead Status").getText();
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        String website = new LightningFormattedElement(driver, "Website").getText();
        String title = new LightningFormattedElement(driver, "Title").getText();
        String company = new LightningFormattedElement(driver, "Company").getText();
        String email = new LightningFormattedElement(driver, "Email").getText();
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        String noOfEmployees = new LightningFormattedElement(driver, "No. of Employees").getText();
        String mobile = new LightningFormattedElement(driver, "Mobile").getText();
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        String rating = new LightningFormattedElement(driver, "Rating").getText();
        String fullAddress = new LightningFormattedAddressElement(driver, "Address").getText();
        return new Lead(LeadStatus.valueOf(leadStatus), fullName, website, title, company, email,
                Industry.valueOf(industry), phone, noOfEmployees, mobile, LeadSource.valueOf(leadSource),
                Rating.valueOf(rating), fullAddress);
    }
}
