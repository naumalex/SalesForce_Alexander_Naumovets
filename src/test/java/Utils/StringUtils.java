package Utils;

import java.util.Optional;

public class StringUtils {
    public static String buildFullName(String salutation, String firstName,
                                 String lastName) {
        StringBuilder fullName = new StringBuilder();
        Optional.ofNullable(salutation).ifPresent(fullName::append);
        Optional.ofNullable(firstName).ifPresent(s -> fullName.append(" ").append(s));
        Optional.ofNullable(lastName).ifPresent(s -> fullName.append(" ").append(s));
        return fullName.toString().trim();
    }

}

