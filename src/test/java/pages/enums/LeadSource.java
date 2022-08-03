package pages.enums;

public enum LeadSource {
    NONE("--None--"), ADVERTISEMENT("Advertisement"),
    CUSTOMER_EVENT("Customer Event"), EMPLOYEE_REFERRAL("Employee Referral"),
    EXTERNAL_REFERRAL("External Referral"), GOOGLE_ADWORDS("Google AdWords"),
    OTHER("Other"), PARTNER("Partner"), PURCHASED_LIST("Purchased List"),
    TRADE_SHOW("Trade Show"), WEBINAR("Webinar"), WEBSITE("Website");

    private String name;

    LeadSource(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
