package homework8.enums;

public enum GirlName {
    MARCY("Marcy"),
    JANE("Jane"),
    KAREN("Karen"),
    MARGARET("Margaret"),
    BECCA("Becca");

    private final String name;

    GirlName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GirlName{" +
                "name='" + name + '\'' +
                '}';
    }
}
