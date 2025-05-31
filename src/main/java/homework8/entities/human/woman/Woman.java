package homework8.entities.human.woman;

import homework8.entities.family.Family;
import homework8.entities.human.Human;
import homework8.entities.human.man.Man;
import homework8.entities.pet.Pet;
import homework8.enums.BoyName;
import homework8.enums.GirlName;
import homework8.interfaces.HumanCreator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class Woman extends Human implements HumanCreator {
    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, long birthDate, Human mother, Human father) {
        super(name, surname, birthDate, mother, father);
    }

    public Woman(String name, String surname, long birthDate, byte iq, Map<String, String> schedule, Family family, Set<Pet> pets, Human mother, Human father) {
        super(name, surname, birthDate, iq, schedule, family, pets, mother, father);
    }

    public Woman(String name, String surname, String birthDate, byte iq) {
        super(name, surname, birthDate, iq);
    }

    public void makeup() {
        System.out.println("Let's makeup!");
    }

    @Override
    public String toString() {
        return "Woman{" +
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

