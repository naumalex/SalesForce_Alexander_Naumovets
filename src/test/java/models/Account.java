package models;

import enums.AccountType;
import enums.Industry;
import lombok.Builder;
import lombok.Data;
import Utils.Address;

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
    private boolean isCopyBillingAddressToShippingAddress;
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
