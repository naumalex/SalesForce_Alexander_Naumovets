package models;

import Utils.Address;
import Utils.StringUtils;
import enums.LeadSource;
import enums.Salutation;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.Optional;

@Builder(setterPrefix = "set")
@Data
public class Contact {
    private String phone;
    private String mobile;
    private Salutation salutation;
    private String firstName;
    private String lastName;
    private String accountName;
    private String email;
    private String title;
    private String reportsTo;
    @Builder.Default
    private Address mailingAddress = new Address();
    @Builder.Default
    private Address otherAddress = new Address();
    private String fax;
    private String department;
    private String homePhone;
    @Builder.Default
    private LeadSource leadSource = LeadSource.ADVERTISEMENT;
    private String otherPhone;
    private String birthdate;
    private String asstPhone;
    private String assistant;
    private String description;
    private String fullName;

    public Optional<Salutation> getSalutation() {
        return Optional.ofNullable(salutation);
    }
    public Optional<LeadSource> getLeadSource() {
        return Optional.ofNullable(leadSource);
    }

    public Optional<Address> getMailingAddress() {
        return Optional.ofNullable(mailingAddress);
    }
    public Optional<Address> getOtherAddress() {
        return Optional.ofNullable(otherAddress);
    }

    public String getFullName() {
        return Optional.ofNullable(fullName).orElse(
                StringUtils.buildFullName(getSalutation().map(Salutation::getName).orElse(null),
                        firstName, lastName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phone, contact.phone) && Objects.equals(mobile, contact.mobile) && Objects.equals(getFullName(), contact.getFullName())
                && Objects.equals(accountName, contact.accountName) && Objects.equals(email, contact.email) && Objects.equals(title, contact.title) && Objects.equals(reportsTo, contact.reportsTo)
                && Objects.equals(getMailingAddress(),
                contact.getMailingAddress())
                && Objects.equals(getOtherAddress(),
                contact.getOtherAddress())
                && Objects.equals(fax, contact.fax) && Objects.equals(department, contact.department) && Objects.equals(homePhone, contact.homePhone) && leadSource == contact.leadSource && Objects.equals(otherPhone, contact.otherPhone) && Objects.equals(birthdate, contact.birthdate) && Objects.equals(asstPhone, contact.asstPhone) && Objects.equals(assistant, contact.assistant) && Objects.equals(description, contact.description) && Objects.equals(fullName, contact.fullName);

    }

}
