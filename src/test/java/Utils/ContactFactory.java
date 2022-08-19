package Utils;

import com.github.javafaker.Faker;
import enums.LeadSource;
import enums.Salutation;
import models.Contact;

import java.text.SimpleDateFormat;

public class ContactFactory {
    private static final Faker faker = new Faker();
    private final static String EXISTING_ACCOUNT = "aaaa";
    private final static String EXISTING_NAME_LINKED_TO_ACCOUNT = "McDermott";
    public ContactFactory() {
    }

    public static Contact getMandatoryInfoOnlyAccount() {
        return Contact.builder()
                .setLastName(faker.name().lastName())
                .setAccountName(EXISTING_ACCOUNT)
                .build();
    }

    public static Contact getFullInfoAccount() {
        return Contact.builder()
                .setPhone(faker.phoneNumber().phoneNumber())
                .setMobile(faker.phoneNumber().cellPhone())
                .setSalutation(Salutation.MS)
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setAccountName(EXISTING_ACCOUNT)
                .setEmail(faker.internet().emailAddress())
                .setTitle(faker.name().title())
                .setReportsTo(EXISTING_NAME_LINKED_TO_ACCOUNT)
                .setMailingAddress(new Address(faker.address().streetAddress(),
                        faker.address().city(), faker.address().state(),
                        faker.address().zipCode(), faker.address().country()))
                .setOtherAddress(new Address(faker.address().streetAddress(),
                        faker.address().city(), faker.address().state(),
                        faker.address().zipCode(), faker.address().country()))
                .setFax(faker.phoneNumber().phoneNumber())
                .setDepartment(faker.commerce().department())
                .setHomePhone(faker.phoneNumber().phoneNumber())
                .setLeadSource(LeadSource.EMPLOYEE_REFERRAL)
                .setOtherPhone(faker.phoneNumber().phoneNumber())
                .setAsstPhone(faker.phoneNumber().phoneNumber())
                .setAssistant(faker.name().fullName())
                .setBirthdate(new SimpleDateFormat("M/d/yyyy")
                        .format(faker.date().birthday()))
                .setDescription(faker.backToTheFuture().quote())
                .build();
    }

    public static Contact getHalfInfoAccount() {
       return Contact.builder()
               .setPhone(faker.phoneNumber().phoneNumber())
               .setMobile(faker.phoneNumber().cellPhone())
               .setSalutation(Salutation.MS)
               .setFirstName(faker.name().firstName())
               .setLastName(faker.name().lastName())
               .setAccountName(EXISTING_ACCOUNT)
               .setEmail(faker.internet().emailAddress())
               .setTitle(faker.name().title())
               .setReportsTo(EXISTING_NAME_LINKED_TO_ACCOUNT)
               .setMailingAddress(new Address(faker.address().streetAddress(),
                       faker.address().city(), faker.address().state(),
                       faker.address().zipCode(), faker.address().country()))
               .build();
    }
}