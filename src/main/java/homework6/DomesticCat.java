package homework6;

public class DomesticCat extends Pet implements Foulable {
    Species species = Species.CAT;

    public DomesticCat() {}
    public DomesticCat(String nickname) {
        super(nickname);
    }
    public DomesticCat(String nickname, int age, byte trickLevel, String[] habits) {
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
