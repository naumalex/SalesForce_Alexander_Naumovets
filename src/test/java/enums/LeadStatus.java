package enums;

import java.util.Arrays;

public enum LeadStatus {
    NONE("--None--"), UNQUALIFIED("Unqualified"), NEW("New"),
    WORKING("Working"), NURTURING("Nurturing"), QUALIFIED("Qualified");

    private final String name;

    LeadStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static LeadStatus fromString(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        return Arrays.stream(LeadStatus.values())
                .filter(p -> p.name.equals(stringValue)).findFirst().orElse(null);
    }
}
