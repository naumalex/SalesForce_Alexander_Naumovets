package pages.Utils;

import com.github.javafaker.Faker;
import pages.enums.*;
import pages.models.Lead;

public class LeadFactory {
    public static Lead getMandatoryInfoOnlyLead() {
        Faker faker = new Faker();
        return Lead.builder()
                .setLastName(faker.name().lastName())
                .setLeadStatus(LeadStatus.WORKING)
                .setCompany(faker.company().name())
                .build();
    }

    public static Lead getFullInfoLead() {
        Faker faker = new Faker();
        return Lead.builder()
                .setLastName(faker.name().lastName())
                .setLeadStatus(LeadStatus.WORKING)
                .setCompany(faker.company().name())
                .setSalutation(Salutation.MR)
                .setFirstName(faker.name().firstName())
                .setWebsite(faker.internet().url())
                .setTitle(faker.name().title())
                .setEmail(faker.internet().emailAddress())
                .setIndustry(Industry.APPAREL)
                .setPhone(faker.phoneNumber().phoneNumber())
                .setNoOfEmployees(faker.numerify("###"))
                .setLeadSource(LeadSource.TRADE_SHOW)
                .setRating(Rating.COLD)
                .setStreet(faker.address().streetAddress())
                .setCity(faker.address().city())
                .setStateProvince(faker.address().state())
                .setZipPostalCode(faker.address().zipCode())
                .setCountry(faker.address().country())
                .setIsFollowUp(true)
                .setAnnualRevenue(faker.numerify("$#,###"))
                .build();
    }

    public static Lead getHalfInfoLead() {
        Faker faker = new Faker();
        return Lead.builder()
                .setLastName(faker.name().lastName())
                .setLeadStatus(LeadStatus.WORKING)
                .setCompany(faker.company().name())
                .setSalutation(Salutation.MR)
                .setFirstName(faker.name().firstName())
                .setWebsite(faker.internet().url())
                .setTitle(faker.name().title())
                .setEmail(faker.internet().emailAddress())
                .setIndustry(Industry.APPAREL)
                .build();
    }
}
