package Utils;

import com.github.javafaker.Faker;
import enums.*;
import models.Lead;

public class LeadFactory {
    private static final Faker faker = new Faker();
    public static Lead getMandatoryInfoOnlyLead() {
        return Lead.builder()
                .setLastName(faker.name().lastName())
                .setLeadStatus(LeadStatus.WORKING)
                .setCompany(faker.company().name())
                .build();
    }

    public static Lead getFullInfoLead() {
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
                .setAddress(new Address(faker.address().streetAddress(),
                        faker.address().city(), faker.address().state(),
                        faker.address().zipCode(), faker.address().country()))
                .setIsFollowUp(true)
                .setAnnualRevenue(faker.numerify("$#,###"))
                .build();
    }

    public static Lead getHalfInfoLead() {
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
