package homework4;

import java.text.DateFormatSymbols;
import java.util.*;

public class HappyFamily {
    static {
        System.out.printf("%s class is loading...%n", HappyFamily.class.getSimpleName());
    }
    public static void main(String[] args) {

        Human charlie = new Human("Charlie", "Runkle", (short) 1983);
        Human marcy = new Human("Marcy", "Runkle", (short) 1984);
        Family runkles = new Family(marcy, charlie);
        Pet somePet = new Pet();    
        runkles.setPet(somePet);
        System.out.println(runkles);

        Human andrew = new Human("Andrew", "Van der Beek", (short) 1953);
        Human jane = new Human("Jane", "Van der Beek", (short) 1957);
        new Family(jane, andrew);


        Human karen = new Human("Karen", "Van der Beek", (short) 1981, jane, andrew);

        Human al = new Human("Al", "Moody", (short) 1950);
        Human margaret = new Human("Margaret", "Moody", (short) 1951);
        Family moodiesOlder = new Family(margaret, al);

        Pet catStevens = new Pet("dog", "Cat Stevens",
                3, (byte) 30, new String[]{"watch films", "eat shoes"});

        Human hank = new Human("Hank", "Moody", (short) 1980, (byte) 27,
                                createSchedule(), moodiesOlder, catStevens, margaret, al);

        Family moodies = new Family(karen, hank);

        moodies.setPet(catStevens);

        Human becca = new Human("Becca", "Moody", (short) 1995, (byte) 110, createSchedule(), moodies, catStevens, karen, hank);
        moodies.addChild(becca);

        Human levon = new Human("Levon", "Moody", (short) 1999);
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
        becca.getPet().foul();
        becca.getPet().respond();
        System.out.println();

        becca.feedPet(new Random().nextInt(100 + 1) > becca.getPet().getTrickLevel());
        System.out.println();

        System.out.println("Count family: " + moodies.countFamily());
        System.out.println("Becca has married!");
        Human becca1 = new Human("Becca", "Moody", (short) 1995, karen, hank);
        moodies.deleteChild(becca1);


        System.out.println("Count family: " + moodies.countFamily());
    }
    public static String[][] createSchedule() {
        String[][] schedule = new String[7][2];
        String[] weekdays = new DateFormatSymbols(Locale.US).getWeekdays();
        for (int i = 0; i < schedule.length; i++) {
            schedule[i][0] = weekdays[i + 1];
        }
        return schedule;
    }
}
