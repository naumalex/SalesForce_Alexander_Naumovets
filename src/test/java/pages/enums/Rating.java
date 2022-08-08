package pages.enums;

import java.util.Arrays;

public enum Rating {
    NONE("--None--"), HOT("Hot"), WARM("Warm"), COLD("Cold");

    private final String name;

    Rating(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static Rating fromString(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        else {
            return Arrays.stream(Rating.values())
                    .filter(p -> p.name.equals(stringValue)).findFirst().get();
        }
    }
}
