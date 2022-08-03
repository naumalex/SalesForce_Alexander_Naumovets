package pages.enums;

public enum Salutation {
    MR("Mr."), MS("Ms."), MRS("Mrs."), DR("Dr."), PROF("Prof.");
    private String name;
    Salutation(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
