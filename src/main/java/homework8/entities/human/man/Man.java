package homework8.entities.human.man;

import homework8.entities.family.Family;
import homework8.entities.human.Human;
import homework8.entities.pet.Pet;

import java.util.Map;
import java.util.Set;

public final class Man extends Human {
    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, long birthDate, Human mother, Human father) {
        super(name, surname, birthDate, mother, father);
    }

    public Man(String name, String surname, long birthDate, byte iq, Map<String, String> schedule, Family family, Set<Pet> pets, Human mother, Human father) {
        super(name, surname, birthDate, iq, schedule, family, pets, mother, father);
    }

    public Man(String name, String surname, String birthDate, byte iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", birthDate=" + getFormattedBirthDate() +
                ", iq=" + getFormattedIq() +
                ", father=" + (getFather() == null ? null : (getFather().getName() + " " + getFather().getSurname())) +
                ", mother=" + (getMother() == null ? null : (getMother().getName() + " " + getMother().getSurname())) +
                '}';
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hey, buddy %s!%n", pet.getNickname());
    }

    public void repairCar() {
        System.out.println("I'm repairing the car.");
    }
}
