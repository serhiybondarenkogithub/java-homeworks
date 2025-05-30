package homework6;

import homework5.Pet;
import homework5.Species;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PetTest {
    Pet simplePet;
    Pet pet;
    @BeforeAll
    static void beforeAll() { System.out.println("Testing Pet class..."); }
    @BeforeEach
    void setUp() {
        simplePet = new Pet();
        pet = new Pet(Species.DOG, "1", 0, (byte) 50, new String[]{});
    }

    @Test
    void testToString() {
        assertEquals("Pet{nickname='doesn't have nickname yet', age=0, trickLevel=unknown, habits=[]}",
                simplePet.toString());

        Pet speciesNickname = new Pet(Species.CAT, null);
        assertEquals("Species{species='cat', can fly=false, number of legs=4, has fur=true}" +
                "{nickname='doesn't have nickname yet', age=0, trickLevel=unknown, habits=[]}",
                speciesNickname.toString());

        Pet emptyNameMin = new Pet(Species.DOG, null, -1, (byte) -1, new String[]{});
        assertEquals("Species{species='dog', can fly=false, number of legs=4, has fur=true}" +
                "{nickname='doesn't have nickname yet', age=0, trickLevel=not very cunning, habits=[]}",
                emptyNameMin.toString());

        Pet emptyNameMax = new Pet(Species.RACCOON, "", -1, (byte) 101, new String[]{});
        assertEquals("Species{species='raccoon', can fly=false, number of legs=4, has fur=true}" +
                "{nickname='doesn't have nickname yet', age=0, trickLevel=very cunning, habits=[]}",
                emptyNameMax.toString());
    }

    @Test
    void testEquals() {
        assertNotEquals(new Pet(Species.CAT, "1", 0, (byte) 50, new String[]{}), pet);
        assertNotEquals(new Pet(Species.DOG, "", 0, (byte) 50, new String[]{}), pet);
        assertNotEquals(new Pet(Species.DOG, "1", 1, (byte) 50, new String[]{}), pet);
        assertEquals(new Pet(Species.DOG, "1", 0, (byte) 70, new String[]{}), pet);
        assertEquals(new Pet(Species.DOG, "1", 0, (byte) 50, new String[]{"1", "2"}), pet);
    }

    @Test
    void testHashCode() {
        assertEquals(pet.hashCode(), new Pet(Species.CAT, "1", 0, (byte) 50, new String[]{}).hashCode());
        assertNotEquals(pet.hashCode(), new Pet(Species.DOG, "", 0, (byte) 50, new String[]{}).hashCode());
        assertEquals(pet.hashCode(), new Pet(Species.DOG, "1", 1, (byte) 50, new String[]{}).hashCode());
        assertEquals(pet.hashCode(), new Pet(Species.DOG, "1", 0, (byte) 70, new String[]{}).hashCode());
        assertEquals(pet.hashCode(), new Pet(Species.DOG, "1", 0, (byte) 50, new String[]{"1", "2"}).hashCode());
    }

    @AfterEach
    void tearDown() { simplePet = null; pet = null; }
    @AfterAll
    static void afterAll() { System.out.println("Finish testing Pet class!"); }
}