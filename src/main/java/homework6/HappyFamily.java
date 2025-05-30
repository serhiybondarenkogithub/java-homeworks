package homework6;

import java.util.Arrays;
import java.util.Random;

public class HappyFamily {
    static {
        System.out.printf("%s class is loading...%n", HappyFamily.class.getSimpleName());
    }
    public static void main(String[] args) {

        Human charlie = new Man("Charlie", "Runkle", (short) 1983);
        Human marcy = new Woman("Marcy", "Runkle", (short) 1984);
        Family runkles = new Family(marcy, charlie);
        Pet somePet = new DomesticCat();
        runkles.setPet(somePet);
        System.out.println(runkles);

        Human andrew = new Man("Andrew", "Van der Beek", (short) 1953);
        Human jane = new Woman("Jane", "Van der Beek", (short) 1957);
        new Family(jane, andrew);


        Human karen = new Woman("Karen", "Van der Beek", (short) 1981, jane, andrew);

        Human al = new Man("Al", "Moody", (short) 1950);
        Human margaret = new Woman("Margaret", "Moody", (short) 1951);
        Family moodiesOlder = new Family(margaret, al);

        Dog catStevens = new Dog("Cat Stevens",
                3, (byte) 30, new String[]{"watch films", "eat shoes"});

        Human hank = new Man("Hank", "Moody", (short) 1980, (byte) 27,
                createSchedule(), moodiesOlder, catStevens, margaret, al);

        Family moodies = new Family(karen, hank);

        moodies.setPet(catStevens);

        Human becca = new Woman("Becca", "Moody", (short) 1995, (byte) 110, createSchedule(), moodies, catStevens, karen, hank);
        moodies.addChild(becca);

        Human levon = new Man("Levon", "Moody", (short) 1999);
        moodies.addChild(levon);

        System.out.println("Name: " + becca.getName());
        System.out.println("Surname: " + becca.getSurname());
        System.out.println("IQ: " + becca.getIq());
        System.out.println("Year: " + becca.getYear());
        System.out.println("Schedule: " + Arrays.deepToString(becca.getSchedule()));
        System.out.println("Mother: " + becca.getMother());
        System.out.println("Father: " + becca.getFather());
        System.out.println("Pet: " + becca.getPet());
        System.out.println("Family: " + becca.getFamily());
        System.out.println("Becca: " + becca);
        System.out.println();

        System.out.println("Pet's nickname: " + becca.getPet().getNickname());
        System.out.println("Pet's species: " + becca.getPet().getSpecies());
        System.out.println("Pet's age: " + becca.getPet().getAge());
        System.out.println("Pet's level: " + becca.getPet().getTrick());
        System.out.println("Pet: " + becca.getPet().toString());
        becca.getPet().eat();
        ((Dog) becca.getPet()).foul();
        becca.getPet().respond();
        System.out.println();

        becca.feedPet(new Random().nextLong(100 + 1) > becca.getPet().getTrickLevel());
        System.out.println();

        System.out.println("Count family: " + moodies.countFamily());
        System.out.println("Becca has married!");
        Human becca1 = new Woman("Becca", "Moody", (short) 1995, karen, hank);
        moodies.deleteChild(becca1);

        System.out.println("Count family: " + moodies.countFamily());

//        for (int i = 0; i < 10_000_000; i++) {
//            new Human("Agent", "Smith", (short) 1111 );
//        }
    }
    public static String[][] createSchedule() {
        String[][] schedule = new String[7][2];

        int count = 0;
        for (DayOfWeek day: DayOfWeek.values()) {
            System.out.println(day);
            schedule[count][0] = day.toString();
            count++;
        }

        return schedule;
    }
}
