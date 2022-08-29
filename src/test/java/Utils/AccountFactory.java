package Utils;

import com.github.javafaker.Faker;
import enums.AccountType;
import enums.Industry;
import models.Account;

public class AccountFactory {
    private static final Faker faker = new Faker();

    public static Account getMandatoryInfoOnlyAccount() {
        return Account.builder()
                .setAccountName(faker.name().username())
                .build();
    }

    public static Account getFullInfoAccount() {
        return Account.builder()
                .setAccountName(faker.name().username())
                .setPhone(faker.phoneNumber().phoneNumber())
                .setFax(faker.phoneNumber().phoneNumber())
                .setParentAccount("romaine.cole")
                .setWebsite(faker.internet().url())
                .setAccountType(AccountType.INVESTOR)
                .setEmployees(faker.numerify("1##"))
                .setIndustry(Industry.APPAREL)
                .setAnnualRevenue(faker.numerify("$1,###,###"))
                .setDescription(faker.backToTheFuture().quote())
                .setBillingAddress(new Address(faker.address().streetAddress(),
                        faker.address().city(), faker.address().state(),
                        faker.address().zipCode(), faker.address().country()))
                .setShippingAddress(new Address(faker.address().streetAddress(),
                        faker.address().city(), faker.address().state(),
                        faker.address().zipCode(), faker.address().country()))
                .setIsCopyBillingAddressToShippingAddress(false)
                .build();
    }

    public static Account getHalfInfoAccount() {
       return Account.builder()
               .setAccountName(faker.name().username())
               .setPhone(faker.phoneNumber().phoneNumber())
               .setFax(faker.phoneNumber().phoneNumber())
               .setParentAccount("romaine.cole")
               .setWebsite(faker.internet().url())
               .setAccountType(AccountType.INVESTOR)
               .setEmployees(faker.numerify("1##"))
               .setIndustry(Industry.APPAREL)
               .build();
    }
}