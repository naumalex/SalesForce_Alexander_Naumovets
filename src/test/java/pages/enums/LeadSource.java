package pages.enums;

import java.util.Arrays;

public enum LeadSource {
    NONE("--None--"), ADVERTISEMENT("Advertisement"),
    CUSTOMER_EVENT("Customer Event"), EMPLOYEE_REFERRAL("Employee Referral"),
    EXTERNAL_REFERRAL("External Referral"), GOOGLE_ADWORDS("Google AdWords"),
    OTHER("Other"), PARTNER("Partner"), PURCHASED_LIST("Purchased List"),
    TRADE_SHOW("Trade Show"), WEBINAR("Webinar"), WEBSITE("Website");

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
        else {
            return Arrays.stream(LeadSource.values())
                    .filter(p -> p.name.equals(stringValue)).findFirst().get();
        }
    }
}
