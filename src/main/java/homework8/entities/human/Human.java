    package homework8.entities.human;

    import homework8.entities.family.Family;
    import homework8.entities.pet.Pet;

    import java.time.LocalDate;
    import java.time.Period;
    import java.time.format.DateTimeFormatter;
    import java.util.Map;
    import java.util.Objects;
    import java.util.Set;

    public class Human {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/MM/yyyy");

        private String name;
        private String surname;
        private long birthDate;
        private byte iq = -1;
        private Map<String, String> schedule;
        private Family family;
        private Human mother;
        private Human father;
        private Set<Pet> pets;

        static {
            System.out.printf("%s class is loading...%n", Human.class.getSimpleName());
        }

        public static long parseDate(String date) {
            return LocalDate.parse(date, FORMATTER).toEpochDay();
        }

        public Human(String name, String surname, long birthDate) {
            this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
        }

        public Human(String name, String surname, long birthDate, Human mother, Human father) {
            this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String surname, String birthDate, byte iq) {
            this(name, surname, parseDate(birthDate), iq, null, null, null, null, null);
        }

        public Human(String name, String surname, long birthDate, byte iq,
                     Map<String, String> schedule, Family family, Set<Pet> pets, Human mother, Human father) {
            this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
            this.iq = (byte) Math.max(0, Math.min(iq, 100));
            this.schedule = schedule;
            this.family = family;
            this.pets = pets;
            this.mother = mother;
            this.father = father;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }

        public long getBirthDate() {
            return birthDate;
        }

        public byte getIq() {
            return iq;
        }

        public Family getFamily() {
            return family;
        }
        public void setFamily(Family family) {
            this.family = family;
        }

        public Human getMother() {
            return mother;
        }
        public void setMother(Human mother) {
            this.mother = mother;
        }

        public Human getFather() {
            return father;
        }
        public void setFather(Human father) {
            this.father = father;
        }

        public Set<Pet> getPets() {
            return pets == null ? null : Set.copyOf(pets);
        }

        public void setPets(Set<Pet> pets) {
            this.pets = pets;
        }

        public Map<String, String> getSchedule() {
            return schedule == null ? null : Map.copyOf(schedule);
        }
        public boolean feedPet(boolean isTime, Pet pet) {
            if (pet == null) return false;
            if(isTime) {
                System.out.printf("Hmm... I'll feed %s.%n", pet.getNickname());
                return true;
            }
            System.out.printf("I don't think %s is hungry.%n", pet.getNickname());
            return false;
        }

        public void greetPet(Pet pet) {
            System.out.printf("Hello, %s!\n", pet.getNickname());
        }

        public void describePet(Pet pet) {
            System.out.printf("I have a %s, it's %d years old, it's %s\n", pet.getSpecies().getPetSpecies(), pet.getAge(), pet.getTrick());
        }

        public String getFormattedBirthDate() {
            return birthDate > 0 ? LocalDate.ofEpochDay(birthDate).format(FORMATTER) : "unknown";
        }

        public String getFormattedIq() {
            return iq >= 0 ? Byte.toString(iq) : "unknown";
        }

        public String describeAge() {
            if (birthDate <= 0) return "Birth date unknown";
            Period period = Period.between(LocalDate.ofEpochDay(birthDate), LocalDate.now());
            return  "Years: " + period.getYears() +
                    " months: " + period.getMonths() +
                    " days: "+period.getDays();
        }

        public static long getStamp(String date, String format) {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(format)).toEpochDay();
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + getName() + '\'' +
                    ", surname='" + getSurname() + '\'' +
                    ", birthDate=" + getFormattedBirthDate() +
                    ", iq=" + getFormattedIq() +
                    ", father=" + (getFather() == null ? null : (getFather().getName() + " " + getFather().getSurname())) +
                    ", mother=" + (getMother() == null ? null : (getMother().getName() + " " + getMother().getSurname())) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            return birthDate == human.birthDate &&
                    Objects.equals(name, human.name) &&
                    Objects.equals(surname, human.surname) &&
                    Objects.equals(mother, human.mother) &&
                    Objects.equals(father, human.father);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, birthDate, mother, father);
        }

    //    @Override
    //    protected void finalize() throws Throwable {
    //        System.out.println("finalize - " + this);
    //    }
    }
