package homework8;

import homework8.entities.family.Family;
import homework8.entities.human.Human;
import homework8.entities.human.man.Man;
import homework8.entities.human.woman.Woman;
import homework8.entities.pet.Pet;
import homework8.entities.pet.dog.Dog;
import homework8.entities.pet.domestic_cat.DomesticCat;
import homework8.enums.DayOfWeek;

import java.util.*;

public class HappyFamily {
    static {
        System.out.printf("%s class is loading...%n", HappyFamily.class.getSimpleName());
    }
    public static void main(String[] args) {

        Human charlie = new Man("Charlie", "Runkle", Human.parseDate("05/07/1983"));
        Human marcy = new Woman("Marcy", "Runkle", Human.parseDate("05/07/1984"));
        Family runkles = new Family(marcy, charlie);
        Set<Pet> somePets = new HashSet<>();
        somePets.add(new DomesticCat());
        runkles.setPets(somePets);
        System.out.println(runkles);

        Human andrew = new Man("Andrew", "Van der Beek", Human.parseDate("30/01/1953"));
        Human jane = new Woman("Jane", "Van der Beek", Human.parseDate("10/11/1957"));
        new Family(jane, andrew);


        Human karen = new Woman("Karen", "Van der Beek", Human.parseDate("25/03/1981"), jane, andrew);

        Human al = new Man("Al", "Moody", Human.parseDate("05/07/1950"));
        Human margaret = new Woman("Margaret", "Moody", Human.parseDate("05/07/1951"));
        Family moodiesOlder = new Family(margaret, al);

        Dog catStevens = new Dog("Cat Stevens",
                3, (byte) 30, new HashSet<>(Arrays.asList("watch films", "eat shoes")));
        Set<Pet> moodiesPets = new HashSet<>();
        moodiesPets.add(catStevens);

        Human hank = new Man("Hank", "Moody", Human.parseDate("19/03/1980"), (byte) 27,
                createSchedule(), moodiesOlder, moodiesPets, margaret, al);

        Family moodies = new Family(karen, hank);


        moodies.setPets(moodiesPets);

        Human becca = new Woman("Becca", "Moody", Human.parseDate("05/07/1995"), (byte) 110, createSchedule(), moodies, moodiesPets, karen, hank);
        moodies.addChild(becca);

        Human levon = new Man("Levon", "Moody", Human.parseDate("05/07/1999"));
        moodies.addChild(levon);

        System.out.println("Name: " + becca.getName());
        System.out.println("Surname: " + becca.getSurname());
        System.out.println("IQ: " + becca.getIq());
        System.out.println("Birth Date: " + becca.getFormattedBirthDate());
        System.out.println("Schedule: " + Arrays.deepToString(becca.getSchedule().entrySet().toArray()));
        System.out.println("Mother: " + becca.getMother());
        System.out.println("Father: " + becca.getFather());
        System.out.println("Pet: " + becca.getFamily().getPets());
        System.out.println("Family: " + becca.getFamily());
        System.out.println("Becca: " + becca);
        System.out.println();

        System.out.println("Pet's nickname: " + catStevens.getNickname());
        System.out.println("Pet's species: " + catStevens.getSpecies());
        System.out.println("Pet's age: " + catStevens.getAge());
        System.out.println("Pet's level: " + catStevens.getTrick());
        System.out.println("Pet: " + catStevens.toString());
        catStevens.eat();
        catStevens.foul();
        catStevens.respond();
        System.out.println();

        becca.feedPet(new Random().nextLong(100 + 1) > catStevens.getTrickLevel(), catStevens);
        System.out.println();

        System.out.println("Count family: " + moodies.countFamily());
        System.out.println("Becca has married!");
        Human becca1 = new Woman("Becca", "Moody", Human.parseDate("05/07/1999"), karen, hank);
        moodies.deleteChild(becca1);

        System.out.println("Count family: " + moodies.countFamily());

//        for (int i = 0; i < 10_000_000; i++) {
//            new Human("Agent", "Smith", (short) 1111 );
//        }
    }
    public static Map<String, String> createSchedule() {
        Map<String, String> schedule = new HashMap<>();

        for (DayOfWeek day: DayOfWeek.values()) {
            schedule.put(day.toString(), "");
        }

        return schedule;
    }
}
