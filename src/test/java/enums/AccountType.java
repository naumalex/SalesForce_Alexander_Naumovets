package enums;

import java.util.Arrays;

public enum AccountType {
    NONE("--None--"), ANALYST("Analyst"),
    COMPETITOR("Competitor"), CUSTOMER("Customer"),
    INTEGRATOR("Integrator"), INVESTOR("Investor"),
    PARTNER("Partner"), PRESS("Press"),
    PROSPECT("Prospect"), RESELLER("Reseller"),
    OTHER("Other");

    private final String name;

    AccountType(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static AccountType fromString(String stringValue) {
        return  Arrays.stream(AccountType.values())
                .filter(p -> p.name.equals(stringValue)).findFirst().orElse(null);
    }
}
