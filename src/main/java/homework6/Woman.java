package homework6;

import java.util.Random;

public final class Woman extends Human implements HumanCreator {
    public Woman(String name, String surname, short year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, short year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Woman(String name, String surname, short year, byte iq, String[][] schedule, Family family, Pet pet, Human mother, Human father) {
        super(name, surname, year, iq, schedule, family, pet, mother, father);
    }

    public void makeup() {
        System.out.println("Let's makeup!");
    }

    @Override
    public void greetPet() {
        System.out.println("Hey, " + getPet().getNickname() + ". How are you?");
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
        Pet pet = family.getPet();
        Human mother = family.getMother();
        Human father = family.getFather();

        if (isBoy) {
            String name = BoyName.values()[random.nextInt(BoyName.values().length)].getName();
            return new Man(name, surname, (short) 0, iq, new String[][]{}, family, pet, mother, father);
        } else {
            String name = GirlName.values()[random.nextInt(GirlName.values().length)].getName();
            return new Woman(name, surname, (short) 0, iq, new String[][]{}, family, pet, mother, father);
        }
    }
}

