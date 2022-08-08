package pages.dataproviders;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import pages.enums.*;
import pages.models.Lead;

public class LeadDataProvider {
    @DataProvider(name = "leadDataProvider")
    public static Object[][] testData() {
        Faker faker = new Faker();
        return new Object[][] {
                {
                    new Lead.LeadBuilder(faker.name().lastName(),
                            LeadStatus.WORKING, faker.company().name())
                .build()
                },
                {
                    new Lead.LeadBuilder(faker.name().lastName(),
                            LeadStatus.WORKING, faker.company().name())
                            .setSalutation(Salutation.MR)
                            .setFirstName(faker.name().firstName())
                            .setMiddleName(faker.name().firstName())
                            .setSuffix(faker.name().suffix())
                            .setWebsite(faker.internet().url())
                            .setTitle(faker.name().title())
                            .setEmail(faker.internet().emailAddress())
                            .setIndustry(Industry.APPAREL)
                            .setPhone(faker.phoneNumber().phoneNumber())
                            .setNoOfEmployees(faker.numerify("###"))
                            .setMobile(faker.phoneNumber().cellPhone())
                            .setLeadSource(LeadSource.GOOGLE_ADWORDS)
                            .setRating(Rating.COLD)
                            .setStreet(faker.address().streetAddress())
                            .setCity(faker.address().city())
                            .setStateProvince(faker.address().state())
                            .setZipPostalCode(faker.address().zipCode())
                            .setCountry(faker.address().country())
                            .build()
                },
                {
                        new Lead.LeadBuilder(faker.name().lastName(),
                                LeadStatus.WORKING, faker.company().name())
                                .setSalutation(Salutation.MR)
                                .setFirstName(faker.name().firstName())
                                .setMiddleName(faker.name().firstName())
                                .setSuffix(faker.name().suffix())
                                .setWebsite(faker.regexify("www.[a-z]{5}.[a-z]{3}"))
                                .setTitle(faker.name().title())
                                .setEmail(faker.internet().emailAddress())
                                .setIndustry(Industry.APPAREL)
                                .build()
                }
        };
    }
}
