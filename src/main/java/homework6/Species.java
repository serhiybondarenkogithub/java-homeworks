package homework6;

public enum Species {
    CAT("cat", false, 4, true),
    DOG("dog", false, 4, true),
    RACCOON("raccoon", false, 4, true),
    FISH("fish", false, 0, false),
    UNKNOWN("unknown", false, -1, false);

    private final String petSpecies;
    private final boolean canFly;
    private final int numberOfLegs;
    private final boolean hasFur;

    public static Species fromString(String input) {
        for (Species species : values()) {
            if (species.name().equalsIgnoreCase(input)) {
                return species;
            }
        }
        return UNKNOWN;
    }

    Species(String petSpecies, boolean canFly, int numberOfLegs, boolean hasFur) {
        this.petSpecies = petSpecies;
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public String getPetSpecies() {
        return petSpecies;
    }

    @Override
    public String toString() {
        if (this == UNKNOWN) return "Species{UNKNOWN}";
        return "Species{" +
                "species='" + petSpecies + '\'' +
                ", can fly=" + canFly +
                ", number of legs=" + numberOfLegs +
                ", has fur=" + hasFur +
                '}';
    }
}
