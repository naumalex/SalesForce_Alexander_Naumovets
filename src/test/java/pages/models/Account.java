package pages.models;

import lombok.Builder;
import lombok.Data;
import pages.Utils.Address;

import pages.enums.*;

import java.util.Objects;
import java.util.Optional;

@Builder(setterPrefix = "set")
@Data
public class Account {
    private String phone;
    private String fax;
    private String accountName;
    private String parentAccount;
    private String website;
    private AccountType accountType;
    private String employees;
    private Industry industry;
    private String AnnualRevenue;
    private String description;
    private String fullBillingAddress;
    private String fullShippingAddress;
    /*private String billingStreet;
    private String billingCity;
    private String billingStateProvince;
    private String billingZipPostalCode;
    private String billingCountry;
    private String shippingStreet;
    private String shippingCity;
    private String shippingStateProvince;
    private String shippingZipPostalCode;
    private String shippingCountry;*/
    private boolean isCopyBillingAddressToShippingAddress;
   /* private String fullBillingAddress;
    private String fullShippingAddress;*/
    private Address billingAddress;
    private Address shippingAddress;

    public Optional<AccountType> getAccountType() {
        return Optional.ofNullable(accountType);
    }
    public Optional<Industry> getIndustry() {
        return Optional.ofNullable(industry);
    }

    public Optional<Address> getBillingAddress() {
        return Optional.ofNullable(billingAddress);
    }
    public Optional<Address> getShippingAddress() {
        return Optional.ofNullable(billingAddress);
    }


/*    public String getFullBillingAddress() {
        return Optional.ofNullable(fullBillingAddress).orElse(
                Utils.buildFullAddress(street, city, stateProvince, zipPostalCode, country));
    }*/

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return isCopyBillingAddressToShippingAddress == account.isCopyBillingAddressToShippingAddress && Objects.equals(phone, account.phone) && Objects.equals(fax, account.fax) && Objects.equals(accountName, account.accountName) && Objects.equals(parentAccount, account.parentAccount) && Objects.equals(website, account.website) && accountType == account.accountType && Objects.equals(employees, account.employees) && industry == account.industry && Objects.equals(AnnualRevenue, account.AnnualRevenue)
                && Objects.equals(description, account.description)
                && Objects.equals(billingAddress.map(Address::getFullAddress).orElse(""),
                account.billingAddress.map(Address::getFullAddress).orElse(""))
                && Objects.equals(shippingAddress.map(Address::getFullAddress).orElse(""),
                account.shippingAddress.map(Address::getFullAddress).orElse(""));
    }

    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return isCopyBillingAddressToShippingAddress == account.isCopyBillingAddressToShippingAddress && Objects.equals(phone, account.phone) && Objects.equals(fax, account.fax) && Objects.equals(accountName, account.accountName) && Objects.equals(parentAccount, account.parentAccount) && Objects.equals(website, account.website) && accountType == account.accountType && Objects.equals(employees, account.employees) && industry == account.industry && Objects.equals(AnnualRevenue, account.AnnualRevenue) && Objects.equals(description, account.description)
                && Objects.equals(getBillingAddress().map(Address::getFullAddress).orElse(""),
                account.getBillingAddress().map(Address::getFullAddress).orElse(""))
                && Objects.equals(getShippingAddress().map(Address::getFullAddress).orElse(""),
                account.getShippingAddress().map(Address::getFullAddress).orElse(""));
    }
}
