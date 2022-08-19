package pages;

import Utils.Address;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import org.openqa.selenium.WebDriver;
import elements.LightningCheckbox;
import elements.LightningFormattedLinkElement;
import elements.LightningFormattedElement;
import models.Lead;

public class LeadDetailsPage extends HomePage {
    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        new LightningFormattedElement(driver, "Name").waitUntilDisplayed();
    }

    public Lead getLeadInfo() {
        String leadStatus =
                new LightningFormattedElement(driver, "Lead Status").getText();
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        String website = new LightningFormattedElement(driver, "Website").getText();
        String title = new LightningFormattedElement(driver, "Title").getText();
        String company = new LightningFormattedElement(driver, "Company").getText();
        String email = new LightningFormattedElement(driver, "Email").getText();
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        String noOfEmployees = new LightningFormattedElement(driver, "No. of Employees").getText();
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        String rating = new LightningFormattedElement(driver, "Rating").getText();
        String fullAddress = new LightningFormattedLinkElement(driver, "Address").getText();
        String annualRevenue = new LightningFormattedElement(driver, "Annual Revenue")
                .getText();
        boolean isFollowUp = new LightningCheckbox(driver, "Follow Up?").getValue();
        return Lead.builder()
                .setLeadStatus(LeadStatus.fromString(leadStatus))
                .setCompany(company)
                .setFullName(fullName)
                .setWebsite(website)
                .setTitle(title)
                .setEmail(email)
                .setIndustry(Industry.fromString(industry))
                .setPhone(phone)
                .setNoOfEmployees(noOfEmployees)
                .setLeadSource(LeadSource.fromString(leadSource))
                .setRating(Rating.fromString(rating))
                .setAddress(new Address(fullAddress))
                .setIsFollowUp(isFollowUp)
                .setAnnualRevenue(annualRevenue)
                .build();
    }
}
