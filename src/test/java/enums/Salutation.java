package enums;

import java.util.Arrays;

public enum Salutation {
    MR("Mr."), MS("Ms."), MRS("Mrs."), DR("Dr."), PROF("Prof.");
    private final  String name;
    Salutation(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public static Salutation fromString(String stringValue) {
        if (stringValue == null) {
            return null;
        }
        return Arrays.stream(Salutation.values())
                .filter(p -> p.name.equals(stringValue)).findFirst().orElse(null);
    }
}
