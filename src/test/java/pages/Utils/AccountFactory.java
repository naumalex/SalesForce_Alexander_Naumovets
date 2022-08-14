package pages.Utils;

import com.github.javafaker.Faker;
import pages.enums.*;
import pages.models.Account;

import java.util.Optional;

public class AccountFactory {
    protected static Faker faker = new Faker();

    public AccountFactory() {
        //this.faker = new Faker();
    }

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
                .setParentAccount("a")
                .setWebsite(faker.internet().url())
                .setAccountType(AccountType.INVESTOR)
                .setEmployees(faker.numerify("###"))
                .setIndustry(Industry.APPAREL)
                .setAnnualRevenue(faker.numerify("#######"))
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
               .setParentAccount("a")
               .setWebsite(faker.internet().url())
               .setAccountType(AccountType.INVESTOR)
               .setEmployees(faker.numerify("###"))
               .setIndustry(Industry.APPAREL)
               .build();
    }
}