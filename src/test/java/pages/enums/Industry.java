package pages.enums;

import java.util.Arrays;

public enum Industry {
    NONE("--None--"), UNQUALIFIED("Agriculture"),
    APPAREL("Apparel"), BANKING("Banking"),
    BIOTECHNOLOGY("Biotechnology"), CHEMICALS("Chemicals"),
    COMMUNICATIONS("Communications"), CONSTRUCTION("Construction"),
    CONSULTING("Consulting"), EDUCATION("Education"),
    ELECTRONICS("Electronics"), ENERGY("Energy"),
    ENGINEERING("Engineering"), ENTERTAINMENT("Entertainment"),
    ENVIRONMENTAL("Environmental"), FINANCE("Finance"),
    FOOD_AND_BEVERAGE("Food & Beverage"), GOVERNMENT("Government"),
    HEALTHCARE("Healthcare"), HOSPITALITY("Hospitality"),
    INSURANCE("Insurance"), MACHINERY("Machinery"),
    MANUFACTURING("Manufacturing"), MEDIA("Media"),
    NOT_FOR_PROFIT("Not For Profit"), OTHER("Other"),
    RECREATION("Recreation"), RETAIL("Retail"),
    SHIPPING("Shipping"), TECHNOLOGY("Technology"),
    TELECOMMUNICATIONS("Telecommunications"), TRANSPORTATION("Transportation"),
    UTILITIES("Utilities");

    private String name;

    Industry(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static Industry fromString(String stringValue) {
        if (stringValue == null) {
            return null;
        }
            else {
            return Arrays.stream(Industry.values())
                    .filter(p -> p.name.equals(stringValue)).findFirst().get();
        }
    }
}
