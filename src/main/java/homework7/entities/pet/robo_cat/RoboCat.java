package homework7.entities.pet.robo_cat;

import homework7.entities.pet.Pet;
import homework7.interfaces.Foulable;
import homework7.enums.Species;

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
