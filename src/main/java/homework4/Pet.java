package homework4;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private String species;
    private String nickname;
    private int age;
    private byte trickLevel;

    private String[] habits;

    static {
        System.out.printf("%s class is loading...%n", Pet.class.getSimpleName());
    }

    public Pet() {}
    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(String species, String nickname, int age, byte trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getSpecies() {
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
        if(getTrickLevel() > 50) return "very cunning";
        if(getTrickLevel() > 0) return "not very cunning";
        return "unknown";
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
        return getSpecies() + "{" +
                "nickname='" + getNickname() + '\'' +
                ", age=" + getAge() +
                ", trickLevel=" + getTrick() +
                ", habits=" + Arrays.toString(getHabits()) +
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
        return Objects.hash(getSpecies(), getNickname(), getAge());
    }
}
