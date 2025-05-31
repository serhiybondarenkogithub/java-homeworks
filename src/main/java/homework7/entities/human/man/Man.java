package homework7.entities.human.man;

import homework7.entities.human.Human;
import homework7.entities.pet.Pet;
import homework7.entities.family.Family;

import java.util.Map;
import java.util.Set;

public final class Man extends Human {
    public Man(String name, String surname, short year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, short year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Man(String name, String surname, short year, byte iq, Map<String, String> schedule, Family family, Set<Pet> pets, Human mother, Human father) {
        super(name, surname, year, iq, schedule, family, pets, mother, father);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hey, buddy %s!%n", pet.getNickname());
    }

    public void repairCar() {
        System.out.println("I'm repairing the car.");
    }
}
