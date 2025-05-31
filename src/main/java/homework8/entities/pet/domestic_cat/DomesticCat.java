package homework8.entities.pet.domestic_cat;

import homework8.entities.pet.Pet;
import homework8.enums.Species;
import homework8.interfaces.Foulable;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    Species species = Species.CAT;

    public DomesticCat() {}
    public DomesticCat(String nickname) {
        super(nickname);
    }
    public DomesticCat(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }
    @Override
    public void respond() {
        System.out.println("Meow! I'm your cat " + getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I scratched the couch again...");
    }
}
