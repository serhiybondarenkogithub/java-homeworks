package homework8.entities.pet.robo_cat;

import homework8.entities.pet.Pet;
import homework8.enums.Species;
import homework8.interfaces.Foulable;

import java.util.Set;

public class RoboCat extends Pet implements Foulable {
    Species species = Species.CAT;
    public RoboCat() {}

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
