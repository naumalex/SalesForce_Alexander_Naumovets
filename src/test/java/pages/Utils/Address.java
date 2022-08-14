package pages.Utils;

import java.util.Optional;

public class Address {
    private String street;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;

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

    public Address(String street, String city, String stateProvince,
                   String zipPostalCode, String country) {
        this.street = street;
        this.city = city;
        this.stateProvince = stateProvince;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
    }

    public String getFullAddress() {
        final StringBuilder fullAddress = new StringBuilder();
        Optional.ofNullable(street).ifPresent(fullAddress::append);
        Optional.ofNullable(city).ifPresent(s -> fullAddress.append("\n").append(s));
        Optional.ofNullable(stateProvince).ifPresent(s -> fullAddress.append(", ").append(s));
        Optional.ofNullable(zipPostalCode).ifPresent(s -> fullAddress.append(" ").append(s));
        Optional.ofNullable(country).ifPresent(s -> fullAddress.append("\n").append(s));
        return fullAddress.toString().trim();
    }

}
