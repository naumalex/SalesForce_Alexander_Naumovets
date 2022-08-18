package Utils;

import java.util.Optional;

public class StringUtils {
    public static String buildFullAddress(String street, String city, String stateProvince,
            String zipPostalCode, String country) {

        final StringBuilder fullAddress = new StringBuilder();
        Optional.ofNullable(street).ifPresent(fullAddress::append);
        Optional.ofNullable(city).ifPresent(s -> fullAddress.append("\n").append(s));
        Optional.ofNullable(stateProvince).ifPresent(s -> fullAddress.append(", ").append(s));
        Optional.ofNullable(zipPostalCode).ifPresent(s -> fullAddress.append(" ").append(s));
        Optional.ofNullable(country).ifPresent(s -> fullAddress.append("\n").append(s));
        return fullAddress.toString().trim();
    }

    public static String buildFullName(String salutation, String firstName,
                                 String lastName) {
        StringBuilder fullName = new StringBuilder();
        Optional.ofNullable(salutation).ifPresent(fullName::append);
        Optional.ofNullable(firstName).ifPresent(s -> fullName.append(" ").append(s));
        Optional.ofNullable(lastName).ifPresent(s -> fullName.append(" ").append(s));
        return fullName.toString().trim();
    }

}

