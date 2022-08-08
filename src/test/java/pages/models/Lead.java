package pages.models;

import pages.Utils;
import pages.enums.*;

import java.util.Objects;
import java.util.Optional;

public class Lead {
    private final LeadStatus leadStatus;
    private final Salutation salutation;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String suffix;
    private final String website;
    private final String title;
    private final String company;
    private final String email;
    private final Industry industry;
    private final String phone;
    private final String noOfEmployees;
    private final String mobile;
    private final LeadSource leadSource;
    private final Rating rating;
    private String address;
    private String street;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;
    private String fullName;
    private String fullAddress;

    private Lead(LeadBuilder leadBuilder) {
        this.leadStatus = leadBuilder.leadStatus;
        this.salutation = leadBuilder.salutation;
        this.firstName = leadBuilder.firstName;
        this.middleName = leadBuilder.middleName;
        this.lastName = leadBuilder.lastName;
        this.suffix = leadBuilder.suffix;
        this.website = leadBuilder.website;
        this.title = leadBuilder.title;
        this.company = leadBuilder.company;
        this.email = leadBuilder.email;
        this.industry = leadBuilder.industry;
        this.phone = leadBuilder.phone;
        this.noOfEmployees = leadBuilder.noOfEmployees;
        this.mobile = leadBuilder.mobile;
        this.leadSource = leadBuilder.leadSource;
        this.rating = leadBuilder.rating;
        this.address = leadBuilder.address;
        this.street = leadBuilder.street;
        this.city = leadBuilder.city;
        this.stateProvince = leadBuilder.stateProvince;
        this.zipPostalCode = leadBuilder.zipPostalCode;
        this.country = leadBuilder.country;
        this.fullName = leadBuilder.fullName;
        this.fullAddress = leadBuilder.fullAddress;
    }

    public static class LeadBuilder {
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

        public LeadBuilder(String lastName, LeadStatus leadStatus, String company) {
            this.company = company;
            this.leadStatus = leadStatus;
            this.lastName = lastName;
        }

        public LeadBuilder(LeadStatus leadStatus, String company, String fullName) {
            this.company = company;
            this.leadStatus = leadStatus;
            this.fullName = fullName;
        }

        public LeadBuilder setSalutation(Salutation salutation) {
            this.salutation = salutation;
            return this;
        }

        public LeadBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public LeadBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public LeadBuilder setSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public LeadBuilder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public LeadBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public LeadBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public LeadBuilder setIndustry(Industry industry) {
            this.industry = industry;
            return this;
        }

        public LeadBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public LeadBuilder setNoOfEmployees(String noOfEmployees) {
            this.noOfEmployees = noOfEmployees;
            return this;
        }

        public LeadBuilder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public LeadBuilder setLeadSource(LeadSource leadSource) {
            this.leadSource = leadSource;
            return this;
        }

        public LeadBuilder setRating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public LeadBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public LeadBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public LeadBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public LeadBuilder setStateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
            return this;
        }

        public LeadBuilder setZipPostalCode(String zipPostalCode) {
            this.zipPostalCode = zipPostalCode;
            return this;
        }

        public LeadBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public LeadBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public LeadBuilder setFullAddress(String fullAddress) {
            this.fullAddress = fullAddress;
            return this;
        }

        public Lead build() {
            if (fullName == null) {
                fullName = new Utils().buildFullName(
                        (salutation == null) ? "" : salutation.getName(),
                        firstName, middleName, lastName, suffix);
            }

            if (fullAddress == null) {
                fullAddress = new Utils().buildFullAddress(
                        street, city, stateProvince, zipPostalCode, country);
            }
            return new Lead(this);
        }
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
    }

