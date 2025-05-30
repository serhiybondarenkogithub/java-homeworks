package homework6;

public final class Man extends Human {
    public Man(String name, String surname, short year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, short year, Human mother, Human father) {
        super(name, surname, year, mother, father);
    }

    public Man(String name, String surname, short year, byte iq, String[][] schedule, Family family, Pet pet, Human mother, Human father) {
        super(name, surname, year, iq, schedule, family, pet, mother, father);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hey, buddy %s!%n", getPet().getNickname());
    }

    public void repairCar() {
        System.out.println("I'm repairing the car.");
    }
}
