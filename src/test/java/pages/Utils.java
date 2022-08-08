package pages;

import java.util.Optional;

public class Utils {
    public String buildFullAddress(String street, String city, String stateProvince,
                                    String zipPostalCode, String country) {
        StringBuilder fullAddress = new StringBuilder();
        if (!(street == null)) {
            fullAddress.append(street);
        }
        if (!(city == null)) {
            fullAddress.append("\n").append(city);
        }
        if (!(stateProvince == null)) {
            fullAddress.append(", ").append(stateProvince);
        }
        if (!(zipPostalCode == null)) {
            fullAddress.append(" ").append(zipPostalCode);
        }
        if (!(country == null)) {
            fullAddress.append("\n").append(country);
        }
        return fullAddress.toString().trim();
    }

    public String buildFullName(String salutation, String firstName, String middleName,
                                 String lastName, String suffix) {
        StringBuilder fullName = new StringBuilder();
        if (!(salutation == null)) {
            fullName.append(salutation);
        }
        if (!(firstName == null)) {
            fullName.append(" ").append(firstName);
        }
        if (!(middleName == null)) {
            fullName.append(" ").append(middleName);
        }
        if (!(lastName == null)) {
            fullName.append(" ").append(lastName);
        }
        if (!(suffix == null)) {
            fullName.append(" ").append(suffix);
        }
        return fullName.toString().trim();
    }
}

