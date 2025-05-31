package homework8.entities.pet.dog;

import homework8.entities.pet.Pet;
import homework8.enums.Species;
import homework8.interfaces.Foulable;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    public Dog() {}

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        species = Species.DOG;
    }

    @Override
    public void respond() {
        System.out.println("Woof! I'm your dog " + getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }
}
