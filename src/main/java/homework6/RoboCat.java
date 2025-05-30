package homework6;

public class RoboCat extends Pet implements Foulable {
    Species species = Species.CAT;
    public RoboCat() {}

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
