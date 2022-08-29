package models;

import Utils.Address;
import enums.*;
import lombok.Builder;
import lombok.Data;
import Utils.StringUtils;
import java.util.Objects;
import java.util.Optional;

@Data
@Builder(setterPrefix = "set")

public class Lead {
    private LeadStatus leadStatus;
    private Salutation salutation;
    private  String firstName;
    private  String lastName;
    private  String phone;
    private  String company;
    private  String email;
    private  String title;
    private Rating rating;
    private  String website;
    private  boolean isFollowUp;
    private  String noOfEmployees;
    private Industry industry;
    private LeadSource leadSource;
    private  String annualRevenue;
    private  String description;
    private  String fullName;

    @Builder.Default
    private Address address = new Address();

    public Optional<Salutation> getSalutation() {
        return Optional.ofNullable(salutation);
    }

    public Optional<Industry> getIndustry() {
        return Optional.ofNullable(industry);
    }

    public Optional<LeadSource> getLeadSource() {
        return Optional.ofNullable(leadSource);
    }

    public Optional<LeadStatus> getLeadStatus() {
        return Optional.ofNullable(leadStatus);
    }

    public Optional<Rating> getRating() {
        return Optional.ofNullable(rating);
    }
    public String getFullName() {
        return Optional.ofNullable(fullName).orElse(
                StringUtils.buildFullName(getSalutation().map(Salutation::getName).orElse(null),
                        firstName, lastName));
    }
    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);/*.orElse(
                StringUtils.buildFullAddress(street, city, stateProvince, zipPostalCode, country));
   */ }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return isFollowUp == lead.isFollowUp && Objects.equals(leadStatus, lead.leadStatus)   && Objects.equals(phone, lead.phone) && Objects.equals(company, lead.company) && Objects.equals(email, lead.email) && Objects.equals(title, lead.title) && Objects.equals(rating, lead.rating) && Objects.equals(website, lead.website) && Objects.equals(noOfEmployees, lead.noOfEmployees) && Objects.equals(industry, lead.industry)
                && (getLeadSource().orElse(LeadSource.ADVERTISEMENT) ==
                lead.getLeadSource().orElse(LeadSource.ADVERTISEMENT))
                && Objects.equals(annualRevenue, lead.annualRevenue) && Objects.equals(description, lead.description) && Objects.equals(getFullName(), lead.getFullName()) && Objects.equals(getAddress(), lead.getAddress());
    }
}

