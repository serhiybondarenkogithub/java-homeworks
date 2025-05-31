package homework7.entities.human.woman;

import homework7.entities.family.Family;
import homework7.entities.human.Human;
import homework7.entities.human.man.Man;
import homework7.entities.pet.Pet;
import homework7.enums.BoyName;
import homework7.enums.GirlName;
import homework7.interfaces.HumanCreator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class Woman extends Human implements HumanCreator {
    public Woman(String name, String surname, short year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, short year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Woman(String name, String surname, short year, byte iq, Map<String, String> schedule, Family family, Set<Pet> pets, Human mother, Human father) {
        super(name, surname, year, iq, schedule, family, pets, mother, father);
    }

    public void makeup() {
        System.out.println("Let's makeup!");
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.println("Hey, " + pet.getNickname() + ". How are you?");
    }

    @Override
    public Human bornChild() {
        if (getFamily() == null || getFamily().getFather() == null) {
            return null;
        }

        Random random = new Random();
        boolean isBoy = random.nextBoolean();

        String surname = getFamily().getFather().getSurname();
        byte iq = (byte) ((getFamily().getFather().getIq() + getIq()) / 2);
        Family family = getFamily();
        Set<Pet> pets = family.getPets();
        Human mother = family.getMother();
        Human father = family.getFather();

        if (isBoy) {
            String name = BoyName.values()[random.nextInt(BoyName.values().length)].getName();
            return new Man(name, surname, (short) 0, iq, new HashMap<>(), family, pets, mother, father);
        } else {
            String name = GirlName.values()[random.nextInt(GirlName.values().length)].getName();
            return new Woman(name, surname, (short) 0, iq, new HashMap<>(), family, pets, mother, father);
        }
    }
}

