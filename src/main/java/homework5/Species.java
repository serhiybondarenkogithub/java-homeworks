package homework5;

public enum Species {
    CAT("cat", false, 4, true),
    DOG("dog", false, 4, true),
    RACCOON("raccoon", false, 4, true);

    private final String petSpecies;
    private final boolean canFly;
    private final int numberOfLegs;
    private final boolean hasFur;

    Species(String petSpecies, boolean canFly, int numberOfLegs, boolean hasFur) {
        this.petSpecies = petSpecies;
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    //PetTest.testToString:24 expected:
    // <Species{species='cat', can fly=false, number of legs=4, has fur=true}{nickname='null', age=0, trickLevel=unknown, habits=[]}> but was:
    // <CAT{nickname='doesn't have nickname yet', age=0, trickLevel=unknown, habits=[]}>

    public String getPetSpecies() {
        return petSpecies;
    }

    @Override
    public String toString() {
        return "Species{" +
                "species='" + petSpecies + '\'' +
                ", can fly=" + canFly +
                ", number of legs=" + numberOfLegs +
                ", has fur=" + hasFur +
                '}';
    }
}
