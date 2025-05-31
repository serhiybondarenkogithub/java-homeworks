package homework7.entities.pet;

import homework7.enums.Species;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {

    protected Species species = Species.UNKNOWN;
    private String nickname;
    private int age;
    private byte trickLevel = -1;

    private Set<String> habits;

    static {
        System.out.printf("%s class is loading...%n", Pet.class.getSimpleName());
    }

    public Pet() {}
    public Pet(String nickname) {
        this.nickname = nickname;
    }
    public Pet(String nickname, int age, byte trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = (trickLevel < 0 ? 0 : (byte)(Math.min(trickLevel, 100)));
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }
    public String getNickname() {
        return nickname;
    }
    public int getAge() {
        return age;
    }
    public byte getTrickLevel() {
        return trickLevel;
    }

    public String getTrick() {
        if(getTrickLevel() < 0) return "unknown";
        if(getTrickLevel() > 50) return "very cunning";
        else return "not very cunning";
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void eat() {
        System.out.println("I'm eating!");
    }
    public abstract void respond();

    @Override
    public String toString() {
        String speciesName = (getSpecies() != null) ? getSpecies().toString() : getClass().getSimpleName();
        String nicknameValue = (getNickname() != null && !getNickname().isBlank()) ? getNickname() : "doesn't have nickname yet";
        String trickLevelText = getTrick();
        String habitsText = (getHabits() != null) ? Arrays.toString(getHabits().toArray()) : "[]";

        return speciesName + "{" +
                "nickname='" + nicknameValue + '\'' +
                ", age=" + Math.max(age, 0) +
                ", trickLevel=" + trickLevelText +
                ", habits=" + habitsText +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize - " + this);
    }
}
