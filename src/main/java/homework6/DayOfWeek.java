package homework6;

public enum DayOfWeek {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    SATURDAY("Saturday"),
    FRIDAY("Friday");

    private String day;
    DayOfWeek(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day;
    }
}
