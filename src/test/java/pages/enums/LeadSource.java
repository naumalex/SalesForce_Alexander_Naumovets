package pages.enums;

import java.util.Arrays;
import java.util.Optional;

public enum LeadSource {
    NONE("--None--"), ADVERTISEMENT("Advertisement"),
    EMPLOYEE_REFERRAL("Employee Referral"), EXTERNAL_REFERRAL("External Referral"),
    IN_STORE("In-Store"), ON_SITE("On Site"), OTHER("Other"),
    SOCIAL("Social"), TRADE_SHOW("Trade Show"), WEB("Web"),
    WORD_OF_MOUTH("Word of mouth");

    private final String name;

    LeadSource(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static LeadSource fromString(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        return Arrays.stream(LeadSource.values())
                .filter(p -> p.name.equals(stringValue)).findFirst().orElse(null);
    }
}
