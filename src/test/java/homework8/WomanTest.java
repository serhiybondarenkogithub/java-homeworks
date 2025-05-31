package homework8;

import homework7.entities.family.Family;
import homework7.entities.human.Human;
import homework7.entities.human.man.Man;
import homework7.entities.human.woman.Woman;
import homework7.entities.pet.Pet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class WomanTest {
    Man simpleFather;
    Woman simpleMother;
    Family simpleFamily;
    Woman karen;
    Man hank;
    Family moodies;
    Set<Pet> pets;

    @BeforeEach
    void setUp() {
        simpleFather = new Man("", "", (short) 0);
        simpleMother = new Woman("", "", (short) 0);
        simpleFamily = new Family(simpleMother, simpleFather);
        pets = new HashSet<>();
        karen = new Woman("Karen", "Van der Beek",
                (short) 1981, (byte) 127,
                new HashMap<>(), simpleFamily, pets, simpleMother, simpleFather);
        hank = new Man("Hank", "Moody", (short) 1980, (byte) 27,
                new HashMap<>(), simpleFamily, pets, simpleMother, simpleFather);
        moodies = new Family(karen, hank);
    }

    @AfterEach
    void tearDown() {
        simpleFather = null;
        simpleMother = null;
        simpleFamily = null;
        karen = null;
        hank = null;
        moodies = null;
    }

    @DisplayName("bornChild() should return non-null child of correct type")
    @Test
    void bornChildReturnsManOrWoman() {
        Human child = karen.bornChild();
        assertNotNull(child);
        assertTrue(child instanceof Man || child instanceof Woman);
    }

    @Test
    void bornChildHasCorrectSurnameAndIq() {
        Human child = karen.bornChild();

        assertNotNull(child);
        assertEquals(hank.getSurname(), child.getSurname());
        assertEquals((byte) ((karen.getIq() + hank.getIq()) / 2), child.getIq());
    }
}
