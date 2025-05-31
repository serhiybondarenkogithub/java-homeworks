package homework7.enums;

public enum BoyName {
    CHARLIE("Charlie"),
    ANDREW("Andrew"),
    ALL("Al"),
    HANK("Hank"),
    LEVON("Levon");

    private final String name;


    BoyName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BoyName{" +
                "name='" + name + '\'' +
                '}';
    }
}
