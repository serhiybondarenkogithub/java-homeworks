package homework6;

public class Dog extends Pet implements Foulable {
    final Species species = Species.DOG;;
    public Dog() {}

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
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
