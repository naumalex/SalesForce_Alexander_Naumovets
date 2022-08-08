package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.elements.LightningFormattedLinkElement;
import pages.elements.LightningFormattedElement;
import pages.enums.*;
import pages.models.Lead;

public class LeadDetailsPage extends HomePage {

    private static final String SLDS_TAB_LOCATOR =
            "//div[contains(@class, 'windowViewMode') and contains(@class, 'active')]//*[@class = 'slds-tabs_default__item']//a[@data-label='%s']";
    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        new LightningFormattedElement(driver, "Name").waitUntilDisplayed();
    }

    public void openSldsTabByName(String tabName) {
        By tabLocator = By.xpath(String.format(SLDS_TAB_LOCATOR, tabName));
        waitForElementClickable(tabLocator);
        driver.findElement(tabLocator).click();
        //waitForAttributeToBe(tabLocator, "aria-selected", "true");
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
        String fullAddress = new LightningFormattedLinkElement(driver, "Address").getText();
        return new Lead.LeadBuilder(LeadStatus.fromString(leadStatus), company, fullName)
                .setWebsite(website)
                .setTitle(title)
                .setEmail(email)
                .setIndustry(Industry.fromString(industry))
                .setPhone(phone)
                .setNoOfEmployees(noOfEmployees)
                .setMobile(mobile)
                .setLeadSource(LeadSource.fromString(leadSource))
                .setRating(Rating.fromString(rating))
                .setFullAddress(fullAddress)
                .build();
    }
}
