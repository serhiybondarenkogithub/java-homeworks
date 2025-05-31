package homework7.entities.human;

import homework7.entities.pet.Pet;
import homework7.entities.family.Family;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Human {
    private String name;
    private String surname;
    private short year;
    private byte iq;
    private Map<String, String> schedule;
    private Family family;
    private Human mother;
    private Human father;
    private Set<Pet> pets;

    static {
        System.out.printf("%s class is loading...%n", Human.class.getSimpleName());
    }

    public Human(String name, String surname, short year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, short year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, short year, byte iq,
                 Map<String, String> schedule, Family family, Set<Pet> pets, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
        this.pets = pets;
        this.mother = mother;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public short getYear() {
        return year;
    }

    public byte getIq() {
        return iq;
    }

    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }

    public Set<Pet> getPet() {
        return pets;
    }
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public boolean feedPet(boolean isTime, Pet pet) {
        if (pet == null) return false;
        if(isTime) {
            System.out.printf("Hmm... I'll feed %s.%n", pet.getNickname());
            return true;
        }
        System.out.printf("I don't think %s is hungry.%n", pet.getNickname());
        return false;
    }

    public void greetPet(Pet pet) {
        System.out.printf("Hello, %s!\n", pet.getNickname());
    }

    public void describePet(Pet pet) {
        System.out.printf("I have a %s, it's %d years old, it's %s\n", pet.getSpecies().getPetSpecies(), pet.getAge(), pet.getTrick());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", year=" + getYear() +
                ", iq=" + getIq() +
                ", father=" + (getFather() == null ? null : (getFather().getName() + " " + getFather().getSurname())) +
                ", mother=" + (getMother() == null ? null : (getMother().getName() + " " + getMother().getSurname())) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, mother, father);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize - " + this);
    }
}
