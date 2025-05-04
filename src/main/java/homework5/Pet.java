package homework5;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private Species species;
    private String nickname;
    private int age;
    private byte trickLevel = -1;

    private String[] habits;

    static {
        System.out.printf("%s class is loading...%n", Human.class.getSimpleName());
    }

    public Pet() {}
    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(Species species, String nickname, int age, byte trickLevel, String[] habits) {
        this.species = species;
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

    public String[] getHabits() {
        return habits;
    }

    public void eat() {
        System.out.println("I'm eating!");
    }
    public void respond() {
        System.out.printf("Hello, host. I'm - %s. I missed!%n", getNickname());
    }
    public void foul() {
        System.out.println("It is necessary to replace traces well...");
    }

    @Override
    public String toString() {
        String speciesName = (getSpecies() != null) ? getSpecies().toString() : getClass().getSimpleName();
        String nicknameValue = (getNickname() != null && !getNickname().isBlank()) ? getNickname() : "doesn't have nickname yet";
        String trickLevelText = getTrick();
        String habitsText = (getHabits() != null) ? Arrays.toString(getHabits()) : "[]";

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
        return getAge() == pet.getAge() && getSpecies().equals(pet.getSpecies()) && getNickname().equals(pet.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNickname());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize - " + this);
    }
}
