package homework6;

public class Fish extends Pet {
    final Species species = Species.FISH;

    public Fish() {}
    public Fish(String nickname) {
        super(nickname);
    }
    public Fish(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
    @Override
    public void respond() {
        System.out.println("...swimming silently...");
    }
}
