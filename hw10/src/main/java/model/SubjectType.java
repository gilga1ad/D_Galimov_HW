package model;


public enum SubjectType {

    PHYSICS("Физика"),
    ALGEBRA("Алгебра"),
    CHEMISTRY("Химия"),
    ASTRONOMY("Астрономия"),
    ECONOMY("Экономика");

    private String description;

    SubjectType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
