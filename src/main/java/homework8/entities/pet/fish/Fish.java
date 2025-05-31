package homework8.entities.pet.fish;

import homework8.entities.pet.Pet;
import homework8.enums.Species;

import java.util.Set;

public class Fish extends Pet {
    final Species species = Species.FISH;

    public Fish() {}
    public Fish(String nickname) {
        super(nickname);
    }
    public Fish(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }
    @Override
    public void respond() {
        System.out.println("...swimming silently...");
    }
}
