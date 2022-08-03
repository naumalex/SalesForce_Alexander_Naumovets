package pages.models;

import pages.enums.*;

import java.util.Objects;

public class Lead {
    private LeadStatus leadStatus;
    private Salutation salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String website;
    private String title;
    private String company;
    private String email;
    private Industry industry;
    private String phone;
    private String noOfEmployees;
    private String mobile;
    private LeadSource leadSource;
    private Rating rating;
    private String address;
    private String street;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;
    private String fullName;
    private String fullAddress;

    public Lead(LeadStatus leadStatus, Salutation salutation, String firstName, String middleName,
                String lastName, String suffix, String website, String title, String company,
                String email, Industry industry, String phone, String noOfEmployees, String mobile,
                LeadSource leadSource, Rating rating, String address, String street, String city,
                String stateProvince, String zipPostalCode, String country) {
        this.leadStatus = leadStatus;
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.website = website;
        this.title = title;
        this.company = company;
        this.email = email;
        this.industry = industry;
        this.phone = phone;
        this.noOfEmployees = noOfEmployees;
        this.mobile = mobile;
        this.leadSource = leadSource;
        this.rating = rating;
        this.address = address;
        this.street = street;
        this.city = city;
        this.stateProvince = stateProvince;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
        this.fullName = buildFullName(salutation.getName(), firstName, middleName, lastName, suffix);
        this.fullAddress = buildFullAddress(street, city, stateProvince, zipPostalCode, country);
    }

    public Lead(LeadStatus leadStatus, String fullName, String website, String title, String company, String email, Industry industry, String phone, String noOfEmployees, String mobile, LeadSource leadSource, Rating rating, String fullAddress) {
        this.leadStatus = leadStatus;
        this.website = website;
        this.title = title;
        this.company = company;
        this.email = email;
        this.industry = industry;
        this.phone = phone;
        this.noOfEmployees = noOfEmployees;
        this.mobile = mobile;
        this.leadSource = leadSource;
        this.rating = rating;
        this.fullName = fullName;
        this.fullAddress = fullAddress;
    }

    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getWebsite() {
        return website;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public Industry getIndustry() {
        return industry;
    }

    public String getPhone() {
        return phone;
    }

    public String getNoOfEmployees() {
        return noOfEmployees;
    }

    public String getMobile() {
        return mobile;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public Rating getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return leadStatus == lead.leadStatus && Objects.equals(fullName, lead.fullName) && Objects.equals(website, lead.website) && Objects.equals(title, lead.title) && Objects.equals(company, lead.company) && Objects.equals(email, lead.email) && industry == lead.industry && Objects.equals(phone, lead.phone) && Objects.equals(noOfEmployees, lead.noOfEmployees) && Objects.equals(mobile, lead.mobile) && leadSource == lead.leadSource && rating == lead.rating && Objects.equals(fullAddress, lead.fullAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadStatus, fullName, website, title, company, email, industry, phone, noOfEmployees, mobile, leadSource, rating, fullAddress);
    }

    @Override
    public String toString() {
        return "Lead{" +
                "leadStatus=" + leadStatus +
                ", salutation=" + salutation +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", website='" + website + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", industry=" + industry +
                ", phone='" + phone + '\'' +
                ", noOfEmployees='" + noOfEmployees + '\'' +
                ", mobile='" + mobile + '\'' +
                ", leadSource=" + leadSource +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", street ='" + street + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", zipPostalCode='" + zipPostalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    private String buildFullName(String salutation, String firstName, String middleName,
                                 String lastName, String suffix) {
        return (new StringBuilder("")).append(salutation)
                .append(" ").append(firstName)
                .append(" ").append(middleName)
                .append(" ").append(lastName)
                .append(" ").append(suffix).toString();
    }

    private String buildFullAddress(String street, String city, String stateProvince,
                                    String zipPostalCode, String country) {
        return (new StringBuilder("")).append(street).append(city)
                .append(", ").append(stateProvince).append(" ")
                .append(zipPostalCode).append(country).toString();
    }
}
