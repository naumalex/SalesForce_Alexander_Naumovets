package Utils;

import java.util.Objects;
import java.util.Optional;

public class Address {
    private String street;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;
    private String fullAddress;

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

    public Address() {
    }
    public Address(String street, String city, String stateProvince,
                   String zipPostalCode, String country) {
        this.street = street;
        this.city = city;
        this.stateProvince = stateProvince;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
    }

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getFullAddress() {
        return (fullAddress != null) ? fullAddress : buildFullAddress();
    }

    private String buildFullAddress() {
        final StringBuilder fullAddress = new StringBuilder();
        Optional.ofNullable(street).ifPresent(fullAddress::append);
        Optional.ofNullable(city).ifPresent(s -> fullAddress.append("\n").append(s));
        Optional.ofNullable(stateProvince).ifPresent(s -> fullAddress.append(", ").append(s));
        Optional.ofNullable(zipPostalCode).ifPresent(s -> fullAddress.append(" ").append(s));
        Optional.ofNullable(country).ifPresent(s -> fullAddress.append("\n").append(s));
        return fullAddress.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        //return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(stateProvince, address.stateProvince) && Objects.equals(zipPostalCode, address.zipPostalCode) && Objects.equals(country, address.country) && Objects.equals(fullAddress, address.fullAddress);
        return Objects.equals(getFullAddress(),
                getFullAddress());
    }
}
