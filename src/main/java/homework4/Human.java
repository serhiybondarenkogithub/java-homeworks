package homework4;

import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private short year;
    private byte iq;
    private String[][] schedule;
    private Family family;
    private Human mother;
    private Human father;
    private Pet pet;

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
                 String[][] schedule, Family family, Pet pet, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
        this.pet = pet;
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

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }
    public void setSchedule(String[][] schedule) { this.schedule = schedule; }

    public boolean feedPet(boolean isTime) {
        if (getPet() == null) return false;

        String nickname = getPet().getNickname();

        if(isTime) {
            System.out.printf("Hmm... I'll feed %s.%n", nickname);
            return true;
        }
        System.out.printf("I don't think %s is hungry.%n", nickname);
        return false;
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
        return getYear() == human.getYear() &&
                            getName().equals(human.getName()) &&
                            Objects.equals(getMother(), human.getMother()) &&
                            Objects.equals(getFather(), human.getFather());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYear(), getMother(), getFather());
    }
}
