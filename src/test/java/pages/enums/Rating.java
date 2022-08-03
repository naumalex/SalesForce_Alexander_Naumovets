package pages.enums;

public enum Rating {
    NONE("--None--"), HOT("Hot"), WARM("Warm"), COLD("Cold");

    private String name;

    Rating(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
