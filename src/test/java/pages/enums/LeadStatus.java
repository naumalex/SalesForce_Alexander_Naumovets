package pages.enums;

public enum LeadStatus {
    NONE("--None--"), UNQUALIFIED("Unqualified"), NEW("New"),
    WORKING("Working"), NURTURING("Nurturing"), QUALIFIED("Qualified");

    private String name;

    LeadStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
